package com.zouxxyy.effective.chap02.item03.singleton3;

/**
 * 实现单例方法三：声明一个包含单个元素的枚举类型
 */

public enum Elvis {

    INSTANCE;

    public void fun1() {
        System.out.println("啦啦啦");
    }

}
