package com.zouxxyy.corejava.volume1.chap05.arrays;

import java.lang.reflect.*;
import java.util.*;

/**
 * 程序5-16
 * 使用反射动态创建泛型数组
 * @version 1.00 2019-03-02
 * @author zouxxyy
 */
public class CopyOfTest {
    public static void main(String [] args) {
        int[] a = {1, 2, 3};
        a = (int[]) CopyOf(a, 10);
        System.out.println(Arrays.toString(a));

        String[] b = {"Tom", "Dick", "Harry"};
        b = (String[]) CopyOf(b, 10);
        System.out.println(Arrays.toString(b));

    }

    public static Object CopyOf(Object a, int newLength) {
        Class cl = a.getClass();
        if(!cl.isArray()) return null;
        Class componenType = cl.getComponentType(); // 获得数组对应的类型
        int length = Array.getLength(a); //获取长度
        Object newArray = Array.newInstance(componenType, newLength); //调用newInstance创建新数组
        /*解释：
        * 之所以要绕一圈，是因为object[]是不能变成String[]的，只能通过反射创建与原数组相同的类型
        * */
        System.arraycopy(a, 0, newArray, 0, Math.min(length, newLength));
        return newArray;
    }
}

/*输出：
[1, 2, 3, 0, 0, 0, 0, 0, 0, 0]
[Tom, Dick, Harry, null, null, null, null, null, null, null]
 */