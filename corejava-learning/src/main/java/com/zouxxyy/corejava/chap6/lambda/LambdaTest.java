package com.zouxxyy.corejava.chap6.lambda;

import java.util.*;
import javax.swing.Timer;
import javax.swing.*;

/**
 * 程序6-6
 * lambda表达式使用示例
 * @version 1.00 2019-03-04
 * @author zouxxyy
 */
public class LambdaTest {
    public static void main(String[] args) {
        //用lambda代替 Comparable 接口
        System.out.println("原始顺序：");
        String[] planets = new String[] {"Neptune", "Earth", "Saturn", "Mars", "Jupiter"};
        System.out.println(Arrays.toString(planets));
        System.out.println("按字典排序：");
        Arrays.sort(planets);
        System.out.println(Arrays.toString(planets));
        System.out.println("按长度排序：");
        Arrays.sort(planets, (first, second) -> first.length() - second.length());
        System.out.println(Arrays.toString(planets));

        //用lambda代替 ActionListener 接口 ,可以与程序6-3比较下
        Timer t = new Timer(1000, event ->
                System.out.println("The time is " + new Date()));
        t.start();
        JOptionPane.showMessageDialog(null, "Quit program?");
        System.exit(0);
    }
}

/*输出：
原始顺序：
[Neptune, Earth, Saturn, Mars, Jupiter]
按字典排序：
[Earth, Jupiter, Mars, Neptune, Saturn]
按长度排序：
[Mars, Earth, Saturn, Jupiter, Neptune]
The time is Mon Mar 04 11:46:49 CST 2019
The time is Mon Mar 04 11:46:50 CST 2019
The time is Mon Mar 04 11:46:51 CST 2019
The time is Mon Mar 04 11:46:52 CST 2019
The time is Mon Mar 04 11:46:53 CST 2019
The time is Mon Mar 04 11:46:54 CST 2019
The time is Mon Mar 04 11:46:55 CST 2019
 */