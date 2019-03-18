package com.zouxxyy.corejava.volume2.chap02.randomAccess;

import com.zouxxyy.corejava.volume1.chap06.interfaces.Employee;

import java.io.*;

/**
 * 程序2-2
 * 二进制存储、随机访问
 * @version 1.00 2019-03-18
 * @author zouxxyy
 */
public class RandomAccessTest {
    public static void main(String[] args) throws IOException {
        Employee[] staff = new Employee[3];

        staff[0] = new Employee("Mary", 1000);
        staff[1] = new Employee("Tony", 2000);
        staff[2] = new Employee("Carl", 3000);

        //  把雇员信息顺序保存到employee.dat文件中
        try(DataOutputStream out = new DataOutputStream(new FileOutputStream("corejava-learning/src/main/java/com/zouxxyy/corejava/volume2/chap02/randomAccess/employee.dat"))) {
            for(Employee e : staff)
                writeData(out, e);
        }

        // 倒序读取
        try(RandomAccessFile in  = new RandomAccessFile("corejava-learning/src/main/java/com/zouxxyy/corejava/volume2/chap02/randomAccess/employee.dat", "r")) {
            // 只读
            int n = (int)(in.length() / 88); // 2 * 40 + 8
            Employee[] newStaff = new Employee[n];

            for(int i = n - 1; i >= 0; i--) {
               // newStaff[i] = new Employee("", 0);
                in.seek(i * 88);
                newStaff[i] = readData(in);
            }
            for(Employee e : newStaff)
                System.out.println(e.getName() + " 的薪水为 " + e.getSalary());
        }
    }

    public static void writeData(DataOutput out, Employee e) throws IOException {
        DataIO.writeFixedString(e.getName(), 40, out);
        out.writeDouble(e.getSalary());
    }

    public static Employee readData(DataInput in) throws IOException {
        String name = DataIO.readFixedString(40, in);
        double salary = in.readDouble();
        return new Employee(name, salary);
    }
}

class DataIO
{
    public static String readFixedString(int size, DataInput in)
            throws IOException
    {
        StringBuilder b = new StringBuilder(size);
        int i = 0;
        boolean more = true;
        while (more && i < size)
        {
            char ch = in.readChar();
            i++;
            if (ch == 0) more = false;
            else b.append(ch);
        }
        in.skipBytes(2 * (size - i)); // 一个字符两个字节
        return b.toString();
    }

    public static void writeFixedString(String s, int size, DataOutput out)
            throws IOException
    {
        int i;
        for (i = 0; i < size; i++)
        {
            char ch = 0;
            if (i < s.length()) ch = s.charAt(i);
            out.writeChar(ch);
        }
    }
}

/*
Mary 的薪水为 1000.0
Tony 的薪水为 2000.0
Carl 的薪水为 3000.0
 */