package org.crazyit.act.c10_variable;

import java.io.Serializable;
import java.util.UUID;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.TaskService;
import org.activiti.engine.task.Task;

public class T01_02_SerVarTest {

    public static void main(String[] args) {
        ProcessEngine engine = ProcessEngines.getDefaultProcessEngine();
        TaskService ts = engine.getTaskService();

        Task task = ts.newTask(UUID.randomUUID().toString());
        task.setName("测试任务");
        ts.saveTask(task);

        Person p = new Person(1, "angus");
        ts.setVariable(task.getId(), "person1", p);

        Person pr = ts.getVariable(task.getId(), "person1", Person.class);
        System.out.println(pr);
    }

}

class Person implements Serializable {

    private Integer id;
    private String name;

    public Person(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
