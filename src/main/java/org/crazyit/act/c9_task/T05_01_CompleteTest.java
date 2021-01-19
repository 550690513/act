package org.crazyit.act.c9_task;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.TaskService;
import org.activiti.engine.task.Task;

import java.util.UUID;

public class T05_01_CompleteTest {

    public static void main(String[] args) {
        ProcessEngine engine = ProcessEngines.getDefaultProcessEngine();
        TaskService ts = engine.getTaskService();

        // 创建任务
        String taskId = UUID.randomUUID().toString();
        Task task = ts.newTask(taskId);
        task.setName("测试任务");
        ts.saveTask(task);

        // 完成任务
        ts.complete(taskId);

    }

}
