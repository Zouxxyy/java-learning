package com.zouxxyy.corejava.volume1.chap06.innerClass;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import javax.swing.Timer;

/**
 * 程序6-7
 * 内部类使用示例
 * @version 1.00 2019-03-04
 * @author zouxxyy
 */
public class InnerClassTest {
    public static void main(String[] args) {
        TalkingClock clock = new TalkingClock(1000, true);
        clock.start();

        JOptionPane.showMessageDialog(null, "Quit program?");
        System.exit(0);
    }
}

class TalkingClock{
    private int interval;
    private boolean beep;

    /**
     *
     * @param interval
     * @param beep
     */
    public TalkingClock(int interval, boolean beep) {
        this.interval = interval;
        this.beep = beep;
    }

    public void start(){
        ActionListener listener = new TimePrinter();
        Timer t = new Timer(interval, listener);
        t.start();
    }

    //内部类，它是由 TalkingClock 类的方法构造的 ，它可以使用 beep 变量
    public class TimePrinter implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            System.out.println("At the tone, the time is " + new Date());
            //beep 等价于 TalkingClock.this.beep
            if(beep) Toolkit.getDefaultToolkit().beep();
        }
    }
}


/*输出：
At the tone, the time is Mon Mar 04 16:11:52 CST 2019
At the tone, the time is Mon Mar 04 16:11:53 CST 2019
At the tone, the time is Mon Mar 04 16:11:54 CST 2019
At the tone, the time is Mon Mar 04 16:11:55 CST 2019
At the tone, the time is Mon Mar 04 16:11:56 CST 2019
At the tone, the time is Mon Mar 04 16:11:57 CST 2019
At the tone, the time is Mon Mar 04 16:11:58 CST 2019
At the tone, the time is Mon Mar 04 16:11:59 CST 2019
 */