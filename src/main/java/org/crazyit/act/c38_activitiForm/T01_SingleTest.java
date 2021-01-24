package org.crazyit.act.c38_activitiForm;

import org.activiti.engine.*;
import org.activiti.engine.form.FormProperty;
import org.activiti.engine.form.StartFormData;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.repository.ProcessDefinition;

import java.util.List;

public class T01_SingleTest {

    public static void main(String[] args) {
        ProcessEngine engine = ProcessEngines.getDefaultProcessEngine();
        // 存储服务
        RepositoryService rs = engine.getRepositoryService();
        // 运行时服务
        RuntimeService runService = engine.getRuntimeService();
        // 任务服务
        TaskService taskService = engine.getTaskService();
        Deployment dep = rs.createDeployment().addClasspathResource("form.bpmn").deploy();
        ProcessDefinition pd = rs.createProcessDefinitionQuery().deploymentId(dep.getId()).singleResult();

        //
        FormService formService = engine.getFormService();
        StartFormData sfd = formService.getStartFormData(pd.getId());
        List<FormProperty> formProps = sfd.getFormProperties();
        for (FormProperty fp : formProps) {
            System.out.println(fp.getName() + "--" + fp.getType());
        }
    }

}
