package com.zouxxyy.corejava.chap9.priorityQueue;

import java.util.*;
import java.time.*;

/**
 * 程序9-5
 * 优先队列使用示例
 * @version 1.00 2019-03-06
 * @author zouxxyy
 */
public class PriorityQueueTest {
    public static void main(String[] args) {
        PriorityQueue<LocalDate> pq = new PriorityQueue<>(); //可以看出它不是接口，是类
        pq.add(LocalDate.of(1906, 12, 9));
        pq.add(LocalDate.of(1816, 3, 5));
        pq.add(LocalDate.of(1946, 4, 12));
        pq.add(LocalDate.of(1926, 6, 21));

        System.out.println("遍历...");
        for(LocalDate date : pq)
            System.out.println(date);
        System.out.println("删除...");
        while (!pq.isEmpty())
            System.out.println(pq.remove());
    }
}

/*输出：
遍历...
1816-03-05
1906-12-09
1946-04-12
1926-06-21
删除...
1816-03-05
1906-12-09
1926-06-21
1946-04-12
 */
