package com.zouxxyy.effective.chap03.item10;

public class Manager extends Employee {

    private Double salary;

    @Override
    public boolean equals(Object obj) {

        if (obj instanceof Manager) {
            Manager o = (Manager) obj;
            return super.equals(obj) && salary.equals(o.salary);
        }
        return false;
    }

    public Manager(int id, String name, Double salary) {

        super(id, name);

        this.salary = salary;
    }
}
