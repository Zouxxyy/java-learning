package com.zouxxyy.effective.chap02.item01;

// 第二大优势：可用于单例
public class Single {

    private static Single instance;

    public static Single getInstance() {
        if (instance == null) {
            instance = new Single();
        }
        return instance;
    }

}
