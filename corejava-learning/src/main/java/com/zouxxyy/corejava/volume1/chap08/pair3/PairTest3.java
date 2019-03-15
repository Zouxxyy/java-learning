package com.zouxxyy.corejava.volume1.chap08.pair3;

/**
 * 程序8-3
 * 通配符示例
 * @version 1.00 2019-03-05
 * @author zouxxyy
 */
public class PairTest3 {
    public static void main(String[] args) {
        Manager ceo = new Manager("Gus", 8000);
        Manager cfo = new Manager("Sid", 6000);
        Pair<Manager> buddies = new Pair<>(ceo, cfo);
        printBuddies(buddies);

        ceo.setSalary(100000);
        cfo.setSalary(50000);

        Manager[] managers = { ceo, cfo };

        Pair<Employee> result = new Pair<>();
        minmaxSalary(managers, result);
        System.out.println("first: " + result.getFirst().getName()
         + ", second: " + result.getSecond().getName());
        maxminSalary(managers, result);
        System.out.println("first: " + result.getFirst().getName()
                + ", second: " + result.getSecond().getName());
    }

    public static void printBuddies(Pair<? extends Employee> p) {
        Employee first = p.getFirst(); //安全的访问器
        Employee second = p.getSecond();
        System.out.println(first.getName() + " and " + second.getName() + " are buddies.");
    }

    public static void minmaxSalary(Manager[] a, Pair<? super Manager> result) {
        if(a.length == 0) return;
        Manager min = a[0];
        Manager max = a[0];
        for (int i = 1; i < a.length; i++) {
            if(min.getSalary() > a[i].getSalary()) min = a[i];
            if(max.getSalary() < a[i].getSalary()) max = a[i];
        }
        result.setFirst(min); // 安全的设置器
        result.setSecond(max);
    }

    public static void maxminSalary(Manager[] a, Pair<? super Manager> result) {
        minmaxSalary(a, result);
        PairAlg.swapHelper(result); //采用通配符捕获
    }

}

class PairAlg {
    public static boolean hasNulls(Pair<?> p) {
        return p.getFirst() == null || p.getSecond() == null;
    }

    public static <T> void swapHelper(Pair<T> p) {
        T t = p.getFirst();
        p.setFirst(p.getSecond());
        p.setSecond(t);
    }
}

class Employee {
    private String name;

    public Employee(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

class Manager extends Employee {
    private double salary;

    public Manager(String name, double salary) {
        super(name);
        this.salary = salary;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}

//泛型类
class Pair<T> {
    private T first;
    private T second;

    public Pair() {first = null; second = null;}
    public Pair(T first, T second) {this.first = first; this.second = second; }

    public T getFirst() {
        return first;
    }

    public T getSecond() {
        return second;
    }

    public void setFirst(T first) {
        this.first = first;
    }

    public void setSecond(T second) {
        this.second = second;
    }
}


/* 输出：
Gus and Sid are buddies.
first: Sid, second: Gus
first: Gus, second: Sid
 */