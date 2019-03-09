package com.zouxxyy.corejava.chap14.bounce;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * 程序14-1
 * 一个跳动的球
 * @version 1.00 2019-03-08
 * @author zouxxyy
 */
public class Bounce {
    public static void main(String[] args) {
        EventQueue.invokeLater(() ->{
            JFrame frame = new BounceFrame();
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        });
    }
}

class BounceFrame extends JFrame {
    private BallCompoent comp;
    public static final int STEPS = 1000;
    public static final int DELAY = 3;

    public BounceFrame() {
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
        try {
            Ball ball = new Ball();
            comp.add(ball);

            for (int i = 1; i <= STEPS; i++) { // 循环
                ball.move(comp.getBounds());
                comp.paint(comp.getGraphics());
                Thread.sleep(DELAY); // 静态方法，不会创建线程
            }
        } catch (InterruptedException e) {
        }
    }
}