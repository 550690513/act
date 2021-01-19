package org.crazyit.act.c15_startEvent;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.repository.Deployment;

/**
 * <p>
 *  所有开始时间都是“捕获型”事件
 *
 * </p>
 */
public class T01_01_TimerStartEvent {

    public static void main(String[] args) throws Exception {
        ProcessEngine engine = ProcessEngines.getDefaultProcessEngine();
        // 存储服务
        RepositoryService rs = engine.getRepositoryService();
        // 运行时服务
        RuntimeService runService = engine.getRuntimeService();

        Deployment dep = rs.createDeployment().addClasspathResource("timer-start.bpmn").deploy();
        System.out.println(dep.getId());

        long dataCount = runService.createProcessInstanceQuery().count();
        System.out.println("sleep前流程实例数量：" + dataCount);

        for (int i = 0; i < 10; i++) {
            Thread.sleep(1000);
            dataCount = runService.createProcessInstanceQuery().count();
            System.out.println("sleep后流程实例数量：" + dataCount);
        }
    }

}
