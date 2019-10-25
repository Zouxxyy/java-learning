package com.zouxxyy.effective.chap04.item19;

import java.time.Instant;


public final class Sub extends Super {

    private final Instant instant;

    Sub() {
        // 因为父类是无参构造函数，所以可以不写super()
        // super();
        // 调用父类构造器时 instant 还没初始化，所以第一次打印 null
        instant = Instant.now();
    }


    @Override public void overrideMe() {
        System.out.println(instant);
    }

    public static void main(String[] args) {
        Sub sub = new Sub();
        sub.overrideMe();
    }
}


/*
null
2019-10-22T03:21:49.723Z
 */