package org.crazyit.act.c11_execution;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.runtime.ProcessInstance;

public class T02_01_Start {

    public static void main(String[] args) {
        ProcessEngine engine = ProcessEngines.getDefaultProcessEngine();
        // 存储服务
        RepositoryService rs = engine.getRepositoryService();
        // 运行时服务
        RuntimeService runService = engine.getRuntimeService();
        // 部署
        Deployment dep = rs.createDeployment().addClasspathResource("start.bpmn").deploy();
        ProcessDefinition pd = rs.createProcessDefinitionQuery().deploymentId(dep.getId()).singleResult();

        // 启动流程
        ProcessInstance pi = runService.startProcessInstanceById(pd.getId(), "abc");// BUSINESS_KEY
        // ProcessInstance pi = runService.startProcessInstanceById(pd.getId());

        // ProcessInstance pi = runService.startProcessInstanceByKey(pd.getKey());
        // ProcessInstance pi = runService.startProcessInstanceByMessage("hello");

        System.out.println(pi.getId());
    }

}
