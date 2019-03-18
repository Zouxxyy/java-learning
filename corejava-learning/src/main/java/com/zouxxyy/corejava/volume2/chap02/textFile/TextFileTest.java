package com.zouxxyy.corejava.volume2.chap02.textFile;

import com.zouxxyy.corejava.volume1.chap06.interfaces.Employee;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * 程序2-1
 * 以文本格式存储、读取对象
 * @version 1.00 2019-03-15
 * @author zouxxyy
 */
public class TextFileTest {
    public static void main(String[] args) throws IOException {
        Employee[] staff = new Employee[3];

        staff[0] = new Employee("Tom", 1000);
        staff[1] = new Employee("Tony", 2000);
        staff[2] = new Employee("Carl", 3000);

        //  把雇员信息保存到employee.dat文件中
        try(PrintWriter out = new PrintWriter("corejava-learning/src/main/java/com/zouxxyy/corejava/volume2/chap02/textFile/employee.dat", "UTF-8")) {
            writeData(staff, out);
        }

        // 读取employee.dat文件
        try(Scanner in = new Scanner(new FileInputStream("corejava-learning/src/main/java/com/zouxxyy/corejava/volume2/chap02/textFile/employee.dat"), "UTF-8")) {
            Employee[] newStaff = readData(in);

            for(Employee e : newStaff)
                System.out.println(e.getName() + " 的薪水为 " + e.getSalary());
        }
    }

    private static void writeData(Employee[] employees, PrintWriter out) throws IOException {
        out.println(employees.length); // 第一行是人数
        for(Employee e : employees)
            writeEmployee(out, e);
    }

    public static void writeEmployee(PrintWriter out, Employee e) {
        out.println(e.getName() + "|" + e.getSalary());
    }

    private static Employee[] readData(Scanner in) {
        int n = in.nextInt();
        in.nextLine();

        Employee[] employees = new Employee[n];
        for(int i = 0; i < n; i++)
            employees[i] = readEmployee(in);
        return employees;
    }

    private static Employee readEmployee(Scanner in) {
        String line = in.nextLine();
        String[] tokens = line.split("\\|");
        String name = tokens[0];
        double salary = Double.parseDouble(tokens[1]);
        return new Employee(name, salary);
    }
}

/*
Tom 的薪水为 1000.0
Tony 的薪水为 2000.0
Carl 的薪水为 3000.0
 */