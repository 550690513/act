package org.crazyit.act.c15_startEvent;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.runtime.ProcessInstance;

public class T02_01_MessageStartEvent {

    public static void main(String[] args) throws Exception {
        ProcessEngine engine = ProcessEngines.getDefaultProcessEngine();
        // 存储服务
        RepositoryService rs = engine.getRepositoryService();
        // 运行时服务
        RuntimeService runService = engine.getRuntimeService();

        Deployment dep = rs.createDeployment().addClasspathResource("message.bpmn").deploy();


        ProcessInstance pi = runService.startProcessInstanceByMessage("msgName");
        System.out.println(pi.getId());
    }

}
