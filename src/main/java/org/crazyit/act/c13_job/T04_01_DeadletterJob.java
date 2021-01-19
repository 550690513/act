package org.crazyit.act.c13_job;

import org.activiti.engine.ManagementService;
import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.runtime.Job;
import org.activiti.engine.runtime.ProcessInstance;

public class T04_01_DeadletterJob {

    public static void main(String[] args) {
        ProcessEngine engine = ProcessEngines.getDefaultProcessEngine();
        // 存储服务
        RepositoryService rs = engine.getRepositoryService();
        // 运行时服务
        RuntimeService runService = engine.getRuntimeService();

        ManagementService managementService = engine.getManagementService();

        Deployment dep = rs.createDeployment().addClasspathResource("error_task.bpmn").deploy();
        ProcessDefinition pd = rs.createProcessDefinitionQuery().deploymentId(dep.getId()).singleResult();

        ProcessInstance pi = runService.startProcessInstanceById(pd.getId());
        System.out.println(pi.getId());

        Job job = managementService.createJobQuery().singleResult();
        managementService.setJobRetries(job.getId(), 1);
        // managementService.executeJob(job.getId());// 手动执行
    }

}