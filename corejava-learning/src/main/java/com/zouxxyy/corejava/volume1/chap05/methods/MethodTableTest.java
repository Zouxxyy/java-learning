package com.zouxxyy.corejava.volume1.chap05.methods;

import java.lang.reflect.*;

/**
 * 程序5-17
 * 通过反射调用任意方法
 * @version 1.00 2019-03-02
 * @author zouxxyy
 */
public class MethodTableTest {
    public static void main(String[] args) throws Exception {
        TestClass testClass = new TestClass("zzz");
        //获得方法
        Method getName = TestClass.class.getMethod("getName");
        Method setName = TestClass.class.getMethod("setName", String.class);
        Method sqrt = Math.class.getMethod("sqrt", double.class); //静态方法测试
        //使用方法
        try{
            setName.invoke(testClass, "zxy");
            String s = (String)getName.invoke(testClass);
            double i = (double)sqrt.invoke(null, 9); //静态方法第一个参数是null
            System.out.println("新名字为： " + s);
            System.out.println("sqrt(9)为： " + i);
        }
        catch (Exception e) {
            e.printStackTrace();
        }

    }
}

class TestClass {
    private String name;

    public TestClass(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

/*输出：
新名字为： zxy
sqrt(9)为： 3.0
*/