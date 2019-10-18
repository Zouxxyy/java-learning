package com.zouxxyy.effective.chap02.item06;

import java.util.regex.Pattern;

/**
 * 避免创建不必要的对象
 * 例一
 */

public class RomanNumerals {


    // 判断一个字符是否为一个有效的罗马数字

    // 方式一：
    // 如果反复使用该方法，会一直创建Pattern实例，使性能下降
    static boolean isRomanNumeralSlow(String s) {
        return s.matches("^(?=.)M*(C[MD]|D?C{0,3})"
                + "(X[CL]|L?X{0,3})(I[XV]|V?I{0,3})$");
    }


    // 方式二：
    // 再将Pattern实例变成属性，后面一直被重用
    private static final Pattern ROMAN = Pattern.compile(
            "^(?=.)M*(C[MD]|D?C{0,3})"
                    + "(X[CL]|L?X{0,3})(I[XV]|V?I{0,3})$");

    // 再调用 Patten.match()
    static boolean isRomanNumeralFast(String s) {
        return ROMAN.matcher(s).matches();
    }


    public static void main(String[] args) {

        int numSets = 10;
        int numReps = 20;
        boolean b = false;

        for (int i = 0; i < numSets; i++) {

            long start = System.nanoTime();
            for (int j = 0; j < numReps; j++) {
                b ^= isRomanNumeralSlow("MCMLXXVI");
            }
            long end = System.nanoTime();
            System.out.print("方式一：" + ((end - start) / (1_000. * numReps)) + " μs.   ");


            start = System.nanoTime();
            for (int j = 0; j < numReps; j++) {
                b ^= isRomanNumeralFast("MCMLXXVI");
            }
            end = System.nanoTime();
            System.out.println("方式二：" + ((end - start) / (1_000. * numReps)) + " μs.");

        }

    }
}


/*
方式一：96.2878 μs.   方式二：9.7694 μs.
方式一：49.0838 μs.   方式二：6.83535 μs.
方式一：134.3538 μs.   方式二：5.0843 μs.
方式一：30.81465 μs.   方式二：4.6349 μs.
方式一：31.36015 μs.   方式二：5.04135 μs.
方式一：30.99285 μs.   方式二：4.55915 μs.
方式一：29.39555 μs.   方式二：4.71085 μs.
方式一：28.18375 μs.   方式二：4.6028 μs.
方式一：33.0156 μs.   方式二：4.81115 μs.
方式一：27.7516 μs.   方式二：5.65485 μs.
 */

