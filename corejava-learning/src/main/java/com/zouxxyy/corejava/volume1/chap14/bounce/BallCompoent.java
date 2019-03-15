package com.zouxxyy.corejava.volume1.chap14.bounce;

import java.awt.*;
import java.util.*;
import javax.swing.*;

/**
 * 程序14-3
 * 一个跳动的球
 * @version 1.00 2019-03-08
 * @author zouxxyy
 */
public class BallCompoent extends JPanel{
    private static final int DEFAULT_WIDTH = 450;
    private static final int DEFAULT_HEIGHT = 350;

    private java.util.List<Ball> balls = new ArrayList<>();

    public void add(Ball b) {
        balls.add(b);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        for(Ball b : balls) {
            g2.fill(b.getShape());
        }
    }

    public Dimension getPreferredSize() {
        return new Dimension(DEFAULT_WIDTH, DEFAULT_HEIGHT);
    }
}