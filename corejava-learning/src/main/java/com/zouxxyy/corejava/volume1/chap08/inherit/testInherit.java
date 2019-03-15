package com.zouxxyy.corejava.volume1.chap08.inherit;


/**
 * 程序8-2-1
 * 泛型继承测试
 * @version 1.00 2019-03-05
 * @author zouxxyy
 */
public class testInherit {
    public static void main(String[] args) {
        Pair<Employee> employeePair= new Pair<>(new Employee("员工1"), new Employee("员工2"));
        Pair<Manager> managerPair= new Pair<>(new Manager("经理1", 100), new Manager("经理2", 200));

        //测试1
        //employeePair = managerPair; //错误， `Pair<S>`和`Pair<T>`没有什么联系。
        //managerPair = employeePair // 错误， `Pair<S>`和`Pair<T>`没有什么联系。


        //测试2
        Pair pair = employeePair; // 泛型与原始内容兼容，但是，看下面
        //pair.getFirst().getName(); // error, 是Employee类，但是不能调用方法!

        //测试3
        employeePair.setFirst(new Manager("经理3", 300)); // employeePair里经理竟然和员工组成一对！
        System.out.println(employeePair.getFirst().getName()); // 经理3
        System.out.println(employeePair.getSecond().getName()); // 员工2
        // System.out.println(((employeePair.getFirst())).getSalary()); // error
        System.out.println(((Manager)(employeePair.getFirst())).getSalary()); // 300.0 ，添加类强制类型转换后可以调用，这与普通类继承规则一样
    }
}



class Employee {
    private String name;

    public Employee(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

class Manager extends Employee {
    private double salary;

    public Manager(String name, double salary) {
        super(name);
        this.salary = salary;
    }

    public double getSalary() {
        return salary;
    }
}

//泛型类
class Pair<T> {
    private T first;
    private T second;

    public Pair() {first = null; second = null;}
    public Pair(T first, T second) {this.first = first; this.second = second; }

    public T getFirst() {
        return first;
    }

    public T getSecond() {
        return second;
    }

    public void setFirst(T first) {
        this.first = first;
    }

    public void setSecond(T second) {
        this.second = second;
    }
}

/*输出：
经理3
员工2
300.0
 */