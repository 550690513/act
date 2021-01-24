package org.crazyit.act.c32_activitiSpring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class T02_ServiceBTest {

    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext(new String[]{"spring.activiti.cfg.xml"});

        ServiceB serviceB = (ServiceB) ctx.getBean("serviceB");
        serviceB.print();
    }

}
