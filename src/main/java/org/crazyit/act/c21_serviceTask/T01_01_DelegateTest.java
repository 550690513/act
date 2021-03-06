package org.crazyit.act.c21_serviceTask;

import java.util.HashMap;
import java.util.Map;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.runtime.ProcessInstance;

public class T01_01_DelegateTest {

    public static void main(String[] args) {
        ProcessEngine engine = ProcessEngines.getDefaultProcessEngine();
        // 存储服务
        RepositoryService rs = engine.getRepositoryService();
        // 运行时服务
        RuntimeService runService = engine.getRuntimeService();


        Deployment dep = rs.createDeployment().addClasspathResource("delegate.bpmn").deploy();
        ProcessDefinition pd = rs.createProcessDefinitionQuery().deploymentId(dep.getId()).singleResult();

        MyDelegate de = new MyDelegate();
        Map<String, Object> vars = new HashMap<String, Object>();
        vars.put("myDelegate", de);

        // 启动流程
        ProcessInstance pi = runService.startProcessInstanceById(pd.getId(), vars);

    }

}
