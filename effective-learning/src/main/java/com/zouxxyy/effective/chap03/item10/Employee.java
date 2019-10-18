package com.zouxxyy.effective.chap03.item10;

public class Employee {

    private int id;
    private String name;

    public Employee(int id, String name) {
        this.id = id;
        this.name = name;
    }

    // final
    @Override
    public boolean equals(Object obj) {

        if(this == obj) return true;

        if(obj == null) return false;

        if(!(obj instanceof Employee)) return false;

        // getClass写法
        // if(getClass() != obj.getClass()) return false;

        Employee o = (Employee) obj;

        return id == o.id;

    }
}
