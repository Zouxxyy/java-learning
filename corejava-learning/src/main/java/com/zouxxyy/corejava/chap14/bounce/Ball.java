package com.zouxxyy.corejava.chap14.bounce;

import java.awt.geom.*;

/**
 * 程序14-2
 * 一个跳动的球
 * @version 1.00 2019-03-08
 * @author zouxxyy
 */
public class Ball {
    private static final int XSIZE = 15;
    private static final int YSIZE = 15;
    private double x = 0;
    private double y = 0;
    private double dx = 1;
    private double dy = 1;

    // 移动到墙壁，就转换方向
    public void move(Rectangle2D bounds) {
        x += dx;
        y += dy;
        if(x < bounds.getMinX()) {
            x = bounds.getMinX();
            dx = -dx;
        }
        if(x + XSIZE >= bounds.getMaxX()) {
            x = bounds.getMaxX() - XSIZE;
            dx = -dx;
        }
        if(y < bounds.getMinY()) {
            y = bounds.getMinY();
            dy = -dy;
        }
        if(y + YSIZE >= bounds.getMaxY()) {
            y = bounds.getMaxY() - YSIZE;
            dy = -dy;
        }
    }

    public Ellipse2D getShape() {
        return new Ellipse2D.Double(x, y, XSIZE, YSIZE);
    }
}
