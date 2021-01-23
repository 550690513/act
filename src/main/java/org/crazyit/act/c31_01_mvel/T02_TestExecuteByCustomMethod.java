package org.crazyit.act.c31_01_mvel;

import java.io.Serializable;
import java.lang.reflect.Method;

import org.mvel2.MVEL;
import org.mvel2.ParserContext;

public class T02_TestExecuteByCustomMethod {

    public static void main(String[] args) {
        // 通过反射，获取指定Method对象
        Method m = getMethod(T02_TestExecuteByCustomMethod.class, "testMethod", String.class, Integer.class);
        
        // 创建解析上下文对象
        ParserContext parserContext = new ParserContext();
        // 添加方法导入
        parserContext.addImport("fn_abc", m);

        // 编译
        Serializable compiledExpression = MVEL.compileExpression("fn_abc('angus', 33)", parserContext);
        // 执行
        String result = MVEL.executeExpression(compiledExpression, null, String.class);

        System.out.println(result);
    }

    public static String testMethod(String name, Integer age) {
        return "名称：" + name + ", 年龄：" + age;
    }

    public static Method getMethod(Class classRef, String methodName, Class... methodParam) {
        try {
            return classRef.getMethod(methodName, methodParam);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        return null;
    }

}
