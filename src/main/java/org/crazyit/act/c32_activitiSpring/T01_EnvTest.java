package org.crazyit.act.c32_activitiSpring;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class T01_EnvTest {

    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext(new String[]{"spring.activiti.cfg.xml"});

        // ProcessEngine engine = (ProcessEngine) ctx.getBean("processEngine");
        // RepositoryService repositoryService = engine.getRepositoryService();
        // RuntimeService runtimeService = engine.getRuntimeService();
        // TaskService taskService = engine.getTaskService();

        RepositoryService repositoryService = (RepositoryService) ctx.getBean("repositoryService");
        RuntimeService runtimeService = (RuntimeService) ctx.getBean("runtimeService");
        TaskService taskService = (TaskService) ctx.getBean("taskService");

        Deployment dep = repositoryService.createDeployment().addClasspathResource("test2.bpmn").deploy();
        ProcessDefinition pd = repositoryService.createProcessDefinitionQuery().deploymentId(dep.getId()).singleResult();
        ProcessInstance pi = runtimeService.startProcessInstanceById(pd.getId());

        Task task = taskService.createTaskQuery().processInstanceId(pi.getId()).singleResult();
        System.out.println("当前流程节点：" + task.getName());
    }

}
