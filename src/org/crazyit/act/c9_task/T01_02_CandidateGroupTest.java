package org.crazyit.act.c9_task;

import org.activiti.engine.IdentityService;
import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.TaskService;
import org.activiti.engine.identity.Group;
import org.activiti.engine.task.Task;

import java.util.List;
import java.util.UUID;

public class T01_02_CandidateGroupTest {

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
        String groupId = UUID.randomUUID().toString();
        Group group = is.newGroup(groupId);
        group.setName("测试用户组");
        is.saveGroup(group);

        // 设置任务的候选用户组
        ts.addCandidateGroup(taskId, groupId);

        List<Task> tasks = ts.createTaskQuery().taskCandidateGroup(groupId).list();
        System.out.println(groupId + " 这个用户组有权限处理的任务有：");
        for (Task t : tasks) {
            System.out.println(t.getId() + "-" + t.getName());
        }
    }

}
