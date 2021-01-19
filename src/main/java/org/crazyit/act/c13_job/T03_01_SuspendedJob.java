package org.crazyit.act.c13_job;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.runtime.ProcessInstance;

public class T03_01_SuspendedJob {

    public static void main(String[] args) throws Exception {
        ProcessEngine engine = ProcessEngines.getDefaultProcessEngine();
        // 存储服务
        RepositoryService rs = engine.getRepositoryService();
        // 运行时服务
        RuntimeService runService = engine.getRuntimeService();

        Deployment dep = rs.createDeployment().addClasspathResource("suspend_test.bpmn").deploy();
        ProcessDefinition pd = rs.createProcessDefinitionQuery().deploymentId(dep.getId()).singleResult();

        ProcessInstance pi = runService.startProcessInstanceById(pd.getId());
        System.out.println(pi.getId());

        // 10秒后暂停
        Thread.sleep(10000);
        runService.suspendProcessInstanceById(pi.getId());

        // 10秒后激活
        Thread.sleep(10000);
        runService.activateProcessInstanceById(pi.getId());
    }

}