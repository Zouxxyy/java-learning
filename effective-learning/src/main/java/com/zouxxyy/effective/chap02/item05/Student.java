package com.zouxxyy.effective.chap02.item05;

public class Student {

    private String name;

    private Phone phone;

    public Student(String name, Phone phone) {
        this.name = name;
        this.phone = phone;
    }

    public void start() {
        System.out.print(this.name);
        phone.play();
    }

}
