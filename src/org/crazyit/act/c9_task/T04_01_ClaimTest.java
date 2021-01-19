package org.crazyit.act.c9_task;

import java.util.List;
import java.util.UUID;

import org.activiti.engine.IdentityService;
import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.TaskService;
import org.activiti.engine.identity.User;
import org.activiti.engine.task.Task;

public class T04_01_ClaimTest {

    public static void main(String[] args) {
        ProcessEngine engine = ProcessEngines.getDefaultProcessEngine();
        TaskService ts = engine.getTaskService();
        IdentityService is = engine.getIdentityService();
        // 创建任务
        String taskId = UUID.randomUUID().toString();
        Task task = ts.newTask(taskId);
        task.setName("测试任务");
        ts.saveTask(task);
        //  创建用户
        String userId = UUID.randomUUID().toString();
        User user = is.newUser(userId);
        user.setFirstName("angus");
        is.saveUser(user);

        ts.claim(taskId, userId);
        ts.claim(taskId, "100");// org.activiti.engine.ActivitiTaskAlreadyClaimedException: Task '4df35a57-33cc-4493-aafa-891f42761052' is already claimed by someone else.

        List<Task> tasks = ts.createTaskQuery().taskAssignee(userId).list();
        for (Task t : tasks) {
            System.out.println(t.getId() + "-" + t.getName());
        }
    }

}
