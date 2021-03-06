package org.crazyit.act.c16_endEvent;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.runtime.ProcessInstance;

public class T01_01_ErrorEndEvent {

    public static void main(String[] args) {
        ProcessEngine engine = ProcessEngines.getDefaultProcessEngine();
        // 存储服务
        RepositoryService rs = engine.getRepositoryService();
        // 运行时服务
        RuntimeService runService = engine.getRuntimeService();

        Deployment dep = rs.createDeployment().addClasspathResource("error-end.bpmn").deploy();
        ProcessDefinition pd = rs.createProcessDefinitionQuery().deploymentId(dep.getId()).singleResult();

        ProcessInstance pi = runService.startProcessInstanceById(pd.getId());

    }

}
