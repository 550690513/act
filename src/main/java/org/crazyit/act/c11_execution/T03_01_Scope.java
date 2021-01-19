package org.crazyit.act.c11_execution;

import java.util.List;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.runtime.Execution;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;

public class T03_01_Scope {

    public static void main(String[] args) {
        ProcessEngine engine = ProcessEngines.getDefaultProcessEngine();
        // 存储服务
        RepositoryService repositoryService = engine.getRepositoryService();
        // 运行时服务
        RuntimeService runtimeService = engine.getRuntimeService();
        // 任务服务
        TaskService taskService = engine.getTaskService();
        // 部署
        Deployment dep = repositoryService.createDeployment().addClasspathResource("scope.bpmn").deploy();
        ProcessDefinition pd = repositoryService.createProcessDefinitionQuery().deploymentId(dep.getId()).singleResult();
        // 启动流程
        ProcessInstance pi = runtimeService.startProcessInstanceById(pd.getId());


        List<Task> tasks = taskService.createTaskQuery().processInstanceId(pi.getId()).list();
        for (Task task : tasks) {
            Execution exe = runtimeService.createExecutionQuery().executionId(task.getExecutionId()).singleResult();
            if ("TaskA".equals(task.getName())) {
                runtimeService.setVariableLocal(exe.getId(), "taskVarA", "varA");
            } else {
                runtimeService.setVariable(exe.getId(), "taskVarB", "varB");
            }
        }


        for (Task task : tasks) {
            taskService.complete(task.getId());
        }

        System.out.println(pi.getId());

        System.out.println(runtimeService.getVariable(pi.getId(), "taskVarA"));
        System.out.println(runtimeService.getVariable(pi.getId(), "taskVarB"));
    }

}
