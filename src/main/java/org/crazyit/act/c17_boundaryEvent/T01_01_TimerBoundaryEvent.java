package org.crazyit.act.c17_boundaryEvent;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;

public class T01_01_TimerBoundaryEvent {

    public static void main(String[] args) throws Exception {
        ProcessEngine engine = ProcessEngines.getDefaultProcessEngine();
        // 存储服务
        RepositoryService rs = engine.getRepositoryService();
        // 运行时服务
        RuntimeService runService = engine.getRuntimeService();
        // 任务服务
        TaskService taskService = engine.getTaskService();

        Deployment dep = rs.createDeployment().addClasspathResource("timer-boundary.bpmn").deploy();
        ProcessDefinition pd = rs.createProcessDefinitionQuery().deploymentId(dep.getId()).singleResult();
        // 启动流程
        ProcessInstance pi = runService.startProcessInstanceById(pd.getId());

        Task task = taskService.createTaskQuery().processInstanceId(pi.getId()).singleResult();
        System.out.println("当前任务：" + task.getName());
        Thread.sleep(1000 * 10);

        task = taskService.createTaskQuery().processInstanceId(pi.getId()).singleResult();
        System.out.println("当前任务：" + task.getName());
    }

}
