package com.zouxxyy.corejava.volume1.chap06.interfaces;

import java.util.*;

/**
 * 程序6-1
 * 接口使用例子
 * @version 1.00 2019-03-04
 * @author zouxxyy
 */
public class EmployeeSortTest {
    public static void main(String[] args) {
        Employee[] staff = new Employee[3];

        staff[0] = new Employee("Harry", 35000);
        staff[1] = new Employee("Carl", 75000);
        staff[2] = new Employee("Tony", 38000);

        Arrays.sort(staff);

        for(Employee e : staff) {
            System.out.println("name= " + e.getName() + ",salary=" + e.getSalary());
        }
    }
}

/*输出：
name= Harry,salary=35000.0
name= Tony,salary=38000.0
name= Carl,salary=75000.0
*/
