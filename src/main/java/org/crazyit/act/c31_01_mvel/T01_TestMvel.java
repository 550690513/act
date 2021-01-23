package org.crazyit.act.c31_01_mvel;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import org.mvel2.MVEL;

public class T01_TestMvel {

    public static void main(String[] args) {
        // 编辑表达式
        Serializable compiledExpression = MVEL.compileExpression("person.age >= 18");

        Map<String, Object> vars = new HashMap<String, Object>();
        Person p = new Person();
        p.setAge(17);
        vars.put("person", p);

        // 执行表达式并返回结果
        Boolean result = MVEL.executeExpression(compiledExpression, vars,
                Boolean.class);

        System.out.println(result);

    }



}
