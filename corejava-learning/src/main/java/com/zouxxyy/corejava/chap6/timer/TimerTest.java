package com.zouxxyy.corejava.chap6.timer;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import javax.swing.*;
import javax.swing.Timer; //消除与 java.util.Timer 的二义性

/**
 * 程序6-3
 * 定时器示例
 * @version 1.00 2019-03-04
 * @author zouxxyy
 */
public class TimerTest {
    public static void main(String[] args) {
        ActionListener listener = new TimePrinter(); //注意这是一个接口变量，引用实现类该接口的类对象

        Timer t = new Timer(10000, listener); //把接口传给定时器,第一个参数是时间间隔 10s
        t.start();
        JOptionPane.showMessageDialog(null, "Quit program?");
        System.exit(0);
    }
}

class TimePrinter implements ActionListener {
    public void actionPerformed(ActionEvent event) {
        System.out.println("At this tone, the time is " + new Date());
        Toolkit.getDefaultToolkit().beep();
    }
}


/*输出：
At this tone, the time is Mon Mar 04 10:39:51 CST 2019
At this tone, the time is Mon Mar 04 10:40:01 CST 2019
At this tone, the time is Mon Mar 04 10:40:11 CST 2019
*/