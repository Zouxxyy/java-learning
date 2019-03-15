package com.zouxxyy.corejava.volume1.chap09.shuffle;

import java.util.*;

/**
 * 程序9-7
 * 随机打乱算法与排序算法
 * @version 1.00 2019-03-06
 * @author zouxxyy
 */
public class ShuffleTest {
    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>();
        for(int i = 0; i < 50; i++)
            numbers.add(i);
        Collections.shuffle(numbers);
        List<Integer> sub = numbers.subList(0, 6);
        System.out.println(sub);
        Collections.sort(sub);
        System.out.println(sub);
    }
}

/*输出
[11, 26, 16, 1, 35, 30]
[1, 11, 16, 26, 30, 35]
 */