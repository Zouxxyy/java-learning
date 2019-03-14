package com.zouxxyy.multithread.chap5.t2;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 * 程序5-2
 * cancer()测试
 * @version 1.00 2019-03-13
 * @author zouxxyy
 */
public class Run {
    static int i = 0;

    static public class MyTask extends TimerTask {
        public void run() {
            System.out.println(" 正常执行 " + i);
        }
    }

    public static void main(String[] args) {
        while (true) {
            try {
                i++;
                Timer timer = new Timer();
                MyTask task = new MyTask();
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                String dateString = "2019-03-12 15:30:00";
                Date dateRef = sdf.parse(dateString);
                timer.schedule(task, dateRef);
                timer.cancel(); // 有时没有抢到锁

            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
    }
}

/*
...
 正常执行 21978
 正常执行 22009
 正常执行 22188
 正常执行 22190
 正常执行 22194
 正常执行 22196
 正常执行 22202
 ...
 */
