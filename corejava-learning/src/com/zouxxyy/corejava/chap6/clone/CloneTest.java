package com.zouxxyy.corejava.chap6.clone;

/**
 * 程序6-4
 * clone示例
 * @version 1.00 2019-03-04
 * @author zouxxyy
 */
public class CloneTest {
    public static void main(String[] args) {
        try {
            Employee original = new Employee("zxy", 50000);
            original.setHireDay(2019, 1, 1);
            Employee copy = original.clone();
            copy.raiseSalary(10);
            copy.setHireDay(2019, 12, 31);
            System.out.println("original=" + original);
            System.out.println("copy=" + copy);
        }
        catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
    }
}

/*输出：
original=Employee[name=zxy,salary=50000.0,hireDay=Tue Jan 01 00:00:00 CST 2019]
copy=Employee[name=zxy,salary=55000.0,hireDay=Tue Dec 31 00:00:00 CST 2019]
 */