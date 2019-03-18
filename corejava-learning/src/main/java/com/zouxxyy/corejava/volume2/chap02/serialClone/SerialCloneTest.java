package com.zouxxyy.corejava.volume2.chap02.serialClone;

import java.io.*;

/**
 * 程序2-4
 * 用系列化的方法克隆
 * @version 1.00 2019-03-18
 * @author zouxxyy
 */
public class SerialCloneTest {
    public static void main(String[] args) throws CloneNotSupportedException {
        Employee harry = new Employee("Harry", 5000);
        Employee harry2 = (Employee)harry.clone();

        harry.raiseSalary(10);

        System.out.println(harry);
        System.out.println(harry2);
    }
}

class SerialCloneable implements Cloneable, Serializable {
    public Object clone() throws CloneNotSupportedException {
        try{
            ByteArrayOutputStream bout = new ByteArrayOutputStream();
            try(ObjectOutputStream out = new ObjectOutputStream(bout)) {
                out.writeObject(this);
            }

            try (InputStream bin = new ByteArrayInputStream(bout.toByteArray())) {
                ObjectInputStream in = new ObjectInputStream(bin);
                return in.readObject();
            }
        }
        catch (IOException | ClassNotFoundException e) {
            CloneNotSupportedException e2 = new CloneNotSupportedException();
            e2.initCause(e);
            throw e2;
        }
    }
}

class Employee extends SerialCloneable {
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

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public void raiseSalary(double byPencent) {
        double raise = salary * byPencent / 100;
        salary += raise;
    }

    @Override
    public String toString() {
        return getClass().getName()
                + "[name=" + name
                + ",salary=" + salary
                +"]";
    }
}

/*
com.zouxxyy.corejava.volume2.chap02.serialClone.Employee[name=Harry,salary=5500.0]
com.zouxxyy.corejava.volume2.chap02.serialClone.Employee[name=Harry,salary=5000.0]
 */