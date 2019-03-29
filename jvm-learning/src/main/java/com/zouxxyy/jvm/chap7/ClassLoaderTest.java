package com.zouxxyy.jvm.chap7;

import java.io.IOException;
import java.io.InputStream;

/**
 * 程序6-7
 * 不同类加载器的影响
 * @version 1.00 2019-03-28
 * @author zouxxyy
 */
public class ClassLoaderTest {
    public static void main(String[] args) throws Exception{
        ClassLoader myLoader = new ClassLoader() {
            @Override
            public Class<?> loadClass(String name) throws ClassNotFoundException {
                try{
                    String filename = name.substring(name.lastIndexOf(".") + 1) + ".class"; // 类的简单名称
                    InputStream is = getClass().getResourceAsStream(filename);
                    if(is == null) return super.loadClass(name);
                    byte[] b = new byte[is.available()];
                    is.read(b);
                    return defineClass(name, b, 0, b.length);
                }catch (IOException e) {
                    throw new ClassNotFoundException(name);
                }
            }
        };

        Object obj = myLoader.loadClass("com.zouxxyy.jvm.chap7.FieldResolutionTest").newInstance(); // 实例化
        System.out.println(obj.getClass());
        Object obj2 = new FieldResolutionTest();
        System.out.println(obj2.getClass());
        System.out.println(obj instanceof com.zouxxyy.jvm.chap7.FieldResolutionTest);

    }
}

/*
class com.zouxxyy.jvm.chap7.FieldResolutionTest
class com.zouxxyy.jvm.chap7.FieldResolutionTest
false
 */