package org.crazyit.act.c7;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.repository.DeploymentBuilder;

public class Test03_BpmnError {

    public static void main(String[] args) {
        ProcessEngine engine = ProcessEngines.getDefaultProcessEngine();
        // 存储服务
        RepositoryService rs = engine.getRepositoryService();
        
        DeploymentBuilder builder = rs.createDeployment();
        builder.addClasspathResource("error/schema_error.bpmn");
        builder.disableBpmnValidation();// 禁用bpmn验证
        builder.deploy();
    }

}
