package com.zouxxyy.jvm.chap2;

/**
 * 程序2-3
 * 字符串内存空间测试
 * @version 1.00 2019-03-21
 * @author zouxxyy
 */
public class RuntimeConstantPoolOOMTest {
    public static void main(String[] args) {

        /*String s1 = new String("zxy");
        System.out.println(System.identityHashCode(s1));
        String s2 = "zxy";
        //System.out.println(System.identityHashCode(s1.intern()));

        //System.out.println(s1 == s1.intern());


        System.out.println(System.identityHashCode(s2));*/

//        String a2 = new String("z") + new String("xy");
//        System.out.println(System.identityHashCode(a2));
//
//        System.out.println(System.identityHashCode(a2.intern()));
//        System.out.println(a2 == a2.intern());
//        String s1 = new String("zxy");
//        System.out.println(System.identityHashCode(s1.intern()));


        String s1 = "zxy"; // 加到常量池
        String s2 = new String("zxy"); // 加到堆，常量池有东西所以啥也不干
        System.out.println(s1 == s2); // false
        System.out.println(s1 == s2.intern()); // true 常量池非空，intern返回常量池里的内容

    }
}
