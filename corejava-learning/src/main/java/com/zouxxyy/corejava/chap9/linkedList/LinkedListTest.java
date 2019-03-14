package com.zouxxyy.corejava.chap9.linkedList;

import java.util.*;

/**
 * 程序9-1
 * 链表使用示例
 * @version 1.00 2019-03-06
 * @author zouxxyy
 */
public class LinkedListTest {
    public static void main(String[] args) {
        List<String> a = new LinkedList<>();
        a.add("Cat");
        a.add("Dog");
        a.add("Apple");

        List<String> b = new LinkedList<>();
        b.add("Table");
        b.add("Book");
        b.add("Pen");
        b.add("Cup");

        ListIterator<String> aIter = a.listIterator(); // a执行添加操作，所有用listIterator
        Iterator<String> bIter = b.iterator();

        // 把b加到a中
        while(bIter.hasNext()) {
            if(aIter.hasNext()) aIter.next();
            aIter.add(bIter.next());
        }

        System.out.println(a); // [Cat, Table, Dog, Book, Apple, Pen, Cup]

        // 每隔一个删除b中的元素
        bIter = b.iterator();
        while (bIter.hasNext()) {
            bIter.next();
            if(bIter.hasNext()) {
                bIter.next();
                bIter.remove();
            }
        }

        System.out.println(b); // [Table, Pen]

        // 删除a中所有b的元素
        a.removeAll(b);

        System.out.println(a); // [Cat, Dog, Book, Apple, Cup]

        // 测试previous
        aIter = a.listIterator();
        if(aIter.hasNext()) aIter.next();
        if(aIter.hasNext()) aIter.next();
        aIter.previous();
        aIter.remove();
        System.out.println(a); // [Cat, Book, Apple, Cup]
        aIter.add("New"); // 在当前位置前添加元素，注意是 前
        System.out.println(a); // [Cat, New, Book, Apple, Cup]
        System.out.println(aIter.previousIndex()); // 1
        System.out.println(aIter.nextIndex()); // 2

        // 测试List的方法 以下方法最好别在链表中使用
        System.out.println(a.get(3)); // Apple
        a.set(3, "newApple");
        System.out.println(a); // [Cat, New, Book, newApple, Cup]
    }
}

/*输出：
[Cat, Table, Dog, Book, Apple, Pen, Cup]
[Table, Pen]
[Cat, Dog, Book, Apple, Cup]
[Cat, Book, Apple, Cup]
[Cat, New, Book, Apple, Cup]
1
2
Apple
[Cat, New, Book, newApple, Cup]
 */
