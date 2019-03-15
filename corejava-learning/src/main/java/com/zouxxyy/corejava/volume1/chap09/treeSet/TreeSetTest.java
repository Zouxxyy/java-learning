package com.zouxxyy.corejava.volume1.chap09.treeSet;

import java.util.Comparator;
import java.util.NavigableSet;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 * 程序9-3
 * TreeSet使用示例
 * @version 1.00 2019-03-06
 * @author zouxxyy
 */
public class TreeSetTest {
    public static void main(String[] args) {

        SortedSet<Item> parts = new TreeSet<>(); // 用用户定义的compareTo方法比较
        parts.add(new Item("Apple", 1234));
        parts.add(new Item("Widget", 4562));
        parts.add(new Item("Dog", 1000));
        parts.add(new Item("Modem", 9912));
        System.out.println(parts);

        // 按描述排序
        NavigableSet<Item> sortByDescription = new TreeSet<>(
                Comparator.comparing(Item::getDescription) // 建提取器，详细见lambda表达式部分
        );

        sortByDescription.addAll(parts);
        System.out.println(sortByDescription);
    }
}

/*输出：
[[description=Dog,partNumber=1000], [description=Apple,partNumber=1234], [description=Widget,partNumber=4562], [description=Modem,partNumber=9912]]
[[description=Apple,partNumber=1234], [description=Dog,partNumber=1000], [description=Modem,partNumber=9912], [description=Widget,partNumber=4562]]
 */