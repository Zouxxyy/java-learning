package com.zouxxyy.effective.chap04.item19;

/**
 * 如果想继承，构造器绝不能调用可被覆盖的方法
 */

public class Super {

    public Super() {
        overrideMe(); // 构造器中调用了可以被覆盖的方法
    }

    public void overrideMe() {
    }
}
