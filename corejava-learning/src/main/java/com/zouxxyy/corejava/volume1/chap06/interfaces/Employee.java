package com.zouxxyy.corejava.volume1.chap06.interfaces;

/**
 * 程序6-2
 * 接口使用例子
 * @version 1.00 2019-03-04
 * @author zouxxyy
 */
public class Employee implements Comparable<Employee>{
    private String name;
    private double salary;

    public Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }

    public void raiseSalary(double byPencent) {
        double raise = salary * byPencent / 100;
        salary += raise;
    }

    @Override
    public int compareTo(Employee o) {
        return Double.compare(salary, o.salary);
    }
}
