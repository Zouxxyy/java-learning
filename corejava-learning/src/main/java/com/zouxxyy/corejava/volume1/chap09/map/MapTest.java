package com.zouxxyy.corejava.volume1.chap09.map;

import java.util.*;

/**
 * 程序9-6
 * map使用示例
 * @version 1.00 2019-03-06
 * @author zouxxyy
 */
public class MapTest {
    public static void main(String[] args) {
        TreeMap<String, Integer> scores = new TreeMap<>();
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

        // 子视图测试
        System.out.println(scores);
        SortedMap<String, Integer> s = scores.subMap("Jack", "Vincent");
        System.out.println(s);
        s.put("Mary", 33); // 必须在子范围内
        System.out.println(scores);

        Map<String, Integer> umMap = Collections.synchronizedSortedMap(scores); // 生成一个成不可修改的Map视图

    }
}

/*输出：
{Jack=34, Kid=95, Tom=67, Vincent=99}
88
key=Jack, value88
key=Tom, value67
key=Vincent, value99
{Jack=90, Tom=67, Vincent=99}
{Jack=90, Tom=67}
{Jack=90, Mary=33, Tom=67, Vincent=99}
 */