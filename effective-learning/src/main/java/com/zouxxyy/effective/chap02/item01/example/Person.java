package com.zouxxyy.effective.chap02.item01.example;


public class Person {

    private String name;

    // 主要缺点：可以发现这里我们不得不把构造器protected，否则不能有子类Student
    protected Person(String name) {
        this.name = name;
    }

    // 第一大优势：有名称
    // 同时也是第二个缺点：名字取得到天花乱坠，别人就不好发现它们
    public static Person getPerson(String name) {
        return new Person(name);
    }

    // 第三大优势：可以返回子类对象
    public static Person getStudent(String name, Integer age) {

        // 第四大优势：返回的对象取决于参数值
        // 这里如果年龄小于3岁就放回Person
        if (age < 3)
            return new Person(name);
        else
            return new Student(name, age);
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "name: " + getName();
    }
}

class Student extends Person {

    private Integer age;

    Student(String name, Integer age) {
        super(name);
        this.age = age;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "name: " + getName() + " age: " + age;
    }
}
