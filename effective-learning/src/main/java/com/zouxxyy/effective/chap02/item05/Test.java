package com.zouxxyy.effective.chap02.item05;

/**
 * 优先考虑依赖注入的引用资源
 */

public class Test {

    public static void main(String[] args) {

        Phone phone = new Phone("mi8");
        Student zxy = new Student("zxy", phone); // 直接从构造函数中注入依赖的对象

        zxy.start();

    }
}


/*
zxy用mi8打王者荣耀...
 */