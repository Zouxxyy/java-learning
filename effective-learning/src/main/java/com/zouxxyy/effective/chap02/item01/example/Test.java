package com.zouxxyy.effective.chap02.item01.example;

/**
 * 用静态工厂方法代替构造器测试
 */

public class Test {
    public static void main(String[] args) {

        // 第一大优势：有名称
        Person person = Person.getPerson("zxy");
        System.out.println(person.getName());

        // 第二大优势：可用于单例
        System.out.println(Single.getInstance().hashCode());
        System.out.println(Single.getInstance().hashCode());

        // 第三大优势：可以返回子类对象
        System.out.println(Person.getStudent("zxy", 22).toString());

        // 第四大优势：返回的对象取决于参数值
        System.out.println(Person.getStudent("zxy", 2).toString());


    }
}

/*
zxy
1956725890
1956725890
name: zxy age: 22
name: zxy
 */
