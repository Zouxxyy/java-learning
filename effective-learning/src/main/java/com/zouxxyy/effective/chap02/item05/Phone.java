package com.zouxxyy.effective.chap02.item05;

public class Phone {

    private String name;

    public Phone(String name) {
        this.name = name;
    }

    public void play() {
        System.out.println("用" + this.name + "打王者荣耀...");
    }
}
