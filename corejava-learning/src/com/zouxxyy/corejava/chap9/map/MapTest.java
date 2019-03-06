package com.zouxxyy.corejava.chap9.map;

import java.util.*;

/**
 * 程序9-6
 * map使用示例
 * @version 1.00 2019-03-06
 * @author zouxxyy
 */
public class MapTest {
    public static void main(String[] args) {
        Map<String, Integer> scores = new HashMap<>();
        scores.put("Kid", 95);
        scores.put("Tom", 67);
        scores.put("Jack", 34);
        scores.put("Vincent", 99);

        System.out.println(scores);

        scores.remove("Kid");

        scores.put("Jack", 88); // 用新值替换

        System.out.println(scores.get("Jack"));

        scores.forEach((k, v) -> // 访问 k, v 的最快方法
                System.out.println("key=" + k + ", value" + v));

        // 计数Map的put方法
        scores.put("Jack", scores.getOrDefault("Jack", 0) + 1); // 方法1
        scores.merge("Jack", 1, Integer::sum); // 方法2
    }
}

/*输出：
{Vincent=99, Tom=67, Kid=95, Jack=34}
88
key=Vincent, value99
key=Tom, value67
key=Jack, value88
 */