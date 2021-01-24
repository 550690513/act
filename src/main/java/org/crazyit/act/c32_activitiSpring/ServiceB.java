package org.crazyit.act.c32_activitiSpring;

import org.activiti.engine.TaskService;

public class ServiceB {

    private TaskService taskService;

    public void setTaskService(TaskService taskService) {
        this.taskService = taskService;
    }
    
    public void print() {
        System.out.println(taskService + "#############");
    }
}
