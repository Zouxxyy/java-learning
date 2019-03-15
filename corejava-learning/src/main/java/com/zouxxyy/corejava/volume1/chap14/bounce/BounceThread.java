package com.zouxxyy.corejava.volume1.chap14.bounce;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * 程序14-4
 * 一个跳动的球(线程版)
 * @version 1.00 2019-03-08
 * @author zouxxyy
 */
public class BounceThread {
    public static void main(String[] args) {
        EventQueue.invokeLater(() ->{
            JFrame frame = new BounceFrame();
            frame.setTitle("BounceThread");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        });
    }
}

class BounceFrame2 extends JFrame {
    private BallCompoent comp;
    public static final int STEPS = 1000;
    public static final int DELAY = 5;

    public BounceFrame2() {
        setTitle("Bounce");
        comp = new BallCompoent();
        add(comp, BorderLayout.CENTER);
        JPanel buttonPanel = new JPanel();
        addButton(buttonPanel, "Start", event -> addBall());
        addButton(buttonPanel, "Close", event -> System.exit(0));
        add(buttonPanel, BorderLayout.SOUTH);
        pack();
    }

    public void addButton(Container c, String title, ActionListener listener) {
        JButton button = new JButton(title);
        c.add(button);
        button.addActionListener(listener);
    }

    public void addBall() {
        Ball ball = new Ball();
        comp.add(ball);
        // 1)将任务移到Runnable接口的类的run方法中
        Runnable r = () -> {
            try {
                for (int i = 1; i <= STEPS; i++) { // 循环
                    ball.move(comp.getBounds());
                    comp.repaint();
                    Thread.sleep(DELAY); // 静态方法，不会创建线程
                }
            }
            catch (InterruptedException e) {

            }
        };
        Thread t = new Thread(r); // 2）创建一个Thread对象
        t.start(); // 3）启动线程
    }
}