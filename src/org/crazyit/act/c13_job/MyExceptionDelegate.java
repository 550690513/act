package org.crazyit.act.c13_job;

import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.JavaDelegate;

public class MyExceptionDelegate implements JavaDelegate {

    @Override
    public void execute(DelegateExecution arg0) {
        System.out.println("这是处理类，但处理失败了...");
        throw new RuntimeException("always exception");
    }
}
