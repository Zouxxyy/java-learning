package com.zouxxyy.effective.chap04.item16;

/**
 * 给公开的域添加约束条件
 */

public final class Time {
    private static final int HOURS_PER_DAY    = 24;
    private static final int MINUTES_PER_HOUR = 60;

    public final int hour;
    public final int minute;

    public Time(int hour, int minute) {
        if (hour < 0 || hour >= HOURS_PER_DAY)
            throw new IllegalArgumentException("Hour: " + hour); // 个人觉得有点奇葩
        if (minute < 0 || minute >= MINUTES_PER_HOUR)
            throw new IllegalArgumentException("Min: " + minute);
        this.hour = hour;
        this.minute = minute;
    }

    public static void main(String[] args) {

        Time time = new Time(26, 50);

        System.out.println(time.hour);
    }
}


/*
Exception in thread "main" java.lang.IllegalArgumentException: Hour: 26
	at com.zouxxyy.effective.chap04.item16.Time.<init>(Time.java:16)
	at com.zouxxyy.effective.chap04.item16.Time.main(Time.java:25)
 */