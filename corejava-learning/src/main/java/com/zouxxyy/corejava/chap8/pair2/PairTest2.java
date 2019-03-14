package com.zouxxyy.corejava.chap8.pair2;

import java.time.*;

/**
 * 程序8-2
 * 泛型添加限定
 * @version 1.00 2019-03-04
 * @author zouxxyy
 */
public class PairTest2 {
    public static void main(String[] args) {
        LocalDate[] birthdays =
                {
                        LocalDate.of(1906, 12, 9),
                        LocalDate.of(1886, 12, 3),
                        LocalDate.of(1936, 12, 2),
                        LocalDate.of(1926, 1, 9),
                };
        Pair<LocalDate> mm = ArrayAlg.minmax(birthdays);
        System.out.println("min= " + mm.getFirst());
        System.out.println("max= " + mm.getSecond());
    }
}

class ArrayAlg {
    //加限定的泛型方法
    public static <T extends Comparable> Pair<T> minmax(T[] a) {
        if (a == null || a.length == 0) return null;
        T min = a[0];
        T max = a[0];
        for(int i = 1; i < a.length; i++) {
            if(min.compareTo(a[i]) > 0) min = a[i];
            if(max.compareTo(a[i]) < 0) max = a[i];
        }
        return new Pair<>(min, max);
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

/*输出
min= 1886-12-03
max= 1936-12-02
 */