package com.zouxxyy.multithread.chap5.t1;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Timer;
import java.util.TimerTask;
import java.util.Date;

/**
 * 程序5-1
 * Timer类初探
 * @version 1.00 2019-03-13
 * @author zouxxyy
 */
public class Run {
    private static Timer timer = new Timer(); // 注意 该线程没有停止，若想停止，可改为Timer(true)： 守护线程

    static public class MyTask extends TimerTask {
        public void run() {
            System.out.println("运行了，时间为：" + new Date());
        }
    }

    public static void main(String[] args) {
        try {
            MyTask task = new MyTask();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String dateString = "2019-03-13 15:16:00";
            Date dateRef = sdf.parse(dateString);
            System.out.println("字符串时间：" +dateRef + " 当前时间：" + new Date());
            timer.schedule(task, dateRef);
        }
        catch (ParseException e) {
            e.printStackTrace();
        }
    }
}

/*
字符串时间：Wed Mar 13 15:16:00 CST 2019 当前时间：Wed Mar 13 15:15:44 CST 2019
运行了，时间为：Wed Mar 13 15:16:00 CST 2019
 */
