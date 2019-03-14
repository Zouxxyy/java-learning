package com.zouxxyy.corejava.chap9.sieve;

import java.util.*;

/**
 * 程序9-8
 * 使用"Eratosthenes筛子"算法查出2000000以内的素数
 * @version 1.00 2019-03-06
 * @author zouxxyy
 */
public class Sieve {
    public static void main(String[] args) {
        int n = 2000000;
        long start = System.currentTimeMillis();
        BitSet b = new BitSet(n + 1);
        int count = 0;
        int i;
        for(i = 2; i <= n; i++)
            b.set(i); // 都设为开
        i = 2;
        while (i * i <= n) {
            if(b.get(i)) {
                count++;
                int k = 2 * i;
                while (k <= n) { //将已知素数的倍数的位置设为关
                    b.clear(k);
                    k += i;
                }
            }
            i++;
        }
        while (i <= n) {
            if (b.get(i)) count++;
            i++;
        }
        long end = System.currentTimeMillis();
        System.out.println(count + " primes");
        System.out.println((end - start) + "ms");
    }
}

/*输出：
148933 primes
48ms
 */
