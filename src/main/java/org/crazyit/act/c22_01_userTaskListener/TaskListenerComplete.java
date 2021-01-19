package org.crazyit.act.c22_01_userTaskListener;

import org.activiti.engine.delegate.DelegateTask;
import org.activiti.engine.delegate.TaskListener;

public class TaskListenerComplete implements TaskListener {

    @Override
    public void notify(DelegateTask arg0) {
        System.out.println("完成任务的时候触发的");
    }

}
