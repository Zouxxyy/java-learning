package com.zouxxyy.corejava.volume2.chap02.objectStream;

import java.io.*;

/**
 * 程序2-3
 * 对象输入输出流
 * @version 1.00 2019-03-18
 * @author zouxxyy
 */
public class ObjectStreamTest {
    public static void main(String[] args) throws IOException{
        Employee harry = new Employee("Harry" , 1000);
        Manager carl = new Manager("Carl", 5000);
        carl.setSecretary(harry);
        Manager tony = new Manager("Tony", 6000);
        tony.setSecretary(harry); // 共用一个秘书

        Employee[] staff = new Employee[3];
        staff[0] = carl;
        staff[1] = harry;
        staff[2] = tony;

        try(ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("corejava-learning/src/main/java/com/zouxxyy/corejava/volume2/chap02/objectStream/employee.dat"))) {
            out.writeObject(staff);
        }

        try(ObjectInputStream in = new ObjectInputStream(new FileInputStream("corejava-learning/src/main/java/com/zouxxyy/corejava/volume2/chap02/objectStream/employee.dat"))) {
            Employee[] newStaff = (Employee[]) in.readObject();

            newStaff[1].raiseSalary(50);

            for(Employee e : newStaff)
                System.out.println(e.getName() + " 的薪水为 " + e.getSalary());
        }
        catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}

class Employee implements Serializable{ // 注意要加这个
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
}
class Manager extends Employee {

    private Employee secretary = new Employee("", 0);

    public Manager(String name, double salary) {
        super(name, salary);
    }

    public void setSecretary(Employee secretary) {
        this.secretary = secretary;
    }
}

/*
Carl 的薪水为 5000.0
Harry 的薪水为 1500.0
Tony 的薪水为 6000.0
 */