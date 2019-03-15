package com.zouxxyy.corejava.volume1.chap06.clone;

import java.util.Date;
import java.util.GregorianCalendar;

/**
 * 程序6-5
 * clone示例
 * @version 1.00 2019-03-04
 * @author zouxxyy
 */
public class Employee implements Cloneable{
    private String name;
    private double salary;
    private Date hireDay;

    public Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
        hireDay = new Date();
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }

    public Employee clone() throws CloneNotSupportedException {
        //第一步：调用Object.clone()
        Employee cloned = (Employee) super.clone();
        //第二步：克隆不可变的域hireDay,  域String是不可变的，因此不需要clone
        cloned.hireDay = (Date) hireDay.clone();
        return cloned;
    }

    public void setHireDay(int year, int month, int day) {
        Date newHireDay = new GregorianCalendar(year, month - 1, day).getTime();
        hireDay.setTime(newHireDay.getTime());
    }

    public void raiseSalary(double byPencent) {
        double raise = salary * byPencent / 100;
        salary += raise;
    }

    public String toString(){
        return "Employee[name=" + name + ",salary=" + salary +",hireDay=" + hireDay + "]";
    }
}
