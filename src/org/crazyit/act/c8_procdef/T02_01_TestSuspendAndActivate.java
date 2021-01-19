package org.crazyit.act.c8_procdef;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.repository.DeploymentBuilder;
import org.activiti.engine.repository.ProcessDefinition;

public class T02_01_TestSuspendAndActivate {

    public static void main(String[] args) {
        ProcessEngine engine = ProcessEngines.getDefaultProcessEngine();
        // 存储服务
        RepositoryService rs = engine.getRepositoryService();
        
        DeploymentBuilder builder = rs.createDeployment();
        builder.addClasspathResource("test3.bpmn");
        Deployment dep = builder.deploy();
        
        ProcessDefinition def = rs.createProcessDefinitionQuery().deploymentId(dep.getId()).singleResult();
        String key = def.getKey();
        System.out.println("id: " + def.getId());

        rs.suspendProcessDefinitionByKey(key);// 终止

        // 将会抛出异常，因为流程定义被中止了
        RuntimeService runService = engine.getRuntimeService();
        runService.startProcessInstanceByKey(key);

        rs.activateProcessDefinitionByKey(key);// 激活
        runService.startProcessInstanceByKey(key);
    }

}
