package com.zouxxyy.effective.chap02.item06;

/**
 * 避免创建不必要的对象
 * 例二：优先使用基本类型，避免自动装箱
 */

public class Sum {

    private static long sumSlow() {
        Long sum = 0L; // 使用了装箱基本类型
        for (long i = 0; i <= Integer.MAX_VALUE; i++)
            sum += i;
        return sum;
    }

    private static long sumFast() {
        long sum = 0L; // 使用了基本类型
        for (long i = 0; i <= Integer.MAX_VALUE; i++)
            sum += i;
        return sum;
    }

    public static void main(String[] args) {

        int numSets = 5;

        for (int i = 0; i < numSets; i++) {
            long start = System.nanoTime();
            sumSlow();
            long end = System.nanoTime();
            System.out.print("方式一：" + (end - start) / 1_000_000. + " ms.  ");

            start = System.nanoTime();
            sumFast();
            end = System.nanoTime();
            System.out.println("方式二：" + (end - start) / 1_000_000. + " ms.");
        }
    }
}


/*
方式一：7125.242092 ms.  方式二：649.716974 ms.
方式一：6128.351025 ms.  方式二：651.900336 ms.
方式一：5805.846686 ms.  方式二：902.019063 ms.
方式一：5790.244206 ms.  方式二：899.54951 ms.
方式一：5825.860928 ms.  方式二：884.735619 ms.
 */