package com.zouxxyy.effective.chap03.item14;


import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

/**
 * 考虑实现Comparable接口
 */

public final class PhoneNumber implements Comparable<PhoneNumber> {

    private final short areaCode, prefix, lineNum;

    public PhoneNumber(int areaCode, int prefix, int lineNum) {
        this.areaCode = rangeCheck(areaCode, 999, "area code");
        this.prefix   = rangeCheck(prefix,   999, "prefix");
        this.lineNum  = rangeCheck(lineNum, 9999, "line num");
    }

    private static short rangeCheck(int val, int max, String arg) {
        if (val < 0 || val > max)
            throw new IllegalArgumentException(arg + ": " + val);
        return (short) val;
    }

    @Override public String toString() {
        return String.format("%03d-%03d-%04d", areaCode, prefix, lineNum);
    }


    // 简单的3重比较，有优先级
//    public int compareTo(PhoneNumber pn) {
//        int result = Short.compare(areaCode, pn.areaCode); // 用静态装箱类的compare方法去比较
//        if (result == 0)  {
//            result = Short.compare(prefix, pn.prefix);
//            if (result == 0)
//                result = Short.compare(lineNum, pn.lineNum);
//        }
//        return result;
//    }


    // 比较器构造方法
    private static final Comparator<PhoneNumber> COMPARATOR =
            Comparator.comparingInt((PhoneNumber pn) -> pn.areaCode)
                    .thenComparingInt(pn -> pn.prefix)
                    .thenComparingInt(pn -> pn.lineNum);

    public int compareTo(PhoneNumber pn) {
        return COMPARATOR.compare(this, pn);
    }


    // 随机生成
    private static PhoneNumber randomPhoneNumber() {
        Random rnd = ThreadLocalRandom.current();
        return new PhoneNumber((short) rnd.nextInt(1000),
                (short) rnd.nextInt(1000),
                (short) rnd.nextInt(10000));
    }




    public static void main(String[] args) {

        NavigableSet<PhoneNumber> treeSet = new TreeSet<>(); // p55页写到，TreeSet是用compareTo比较的

        HashSet<PhoneNumber> hashSet = new HashSet<>(); // HashSet是用equals比较的

        // 下面就来测试一下：

        PhoneNumber jenny1 = new PhoneNumber(707, 867, 5309);
        PhoneNumber jenny2 = new PhoneNumber(707, 867, 5309);

        treeSet.add(jenny1);
        treeSet.add(jenny2);

        hashSet.add(jenny1);
        hashSet.add(jenny2);

        // 果然，treeSet只有一个元素，hashSet有两个元素。服气了

        System.out.println(treeSet); // [707-867-5309]
        System.out.println(hashSet); // [707-867-5309, 707-867-5309]

        // 所以作者建议 compareTo 等于0时的逻辑 和 equals 的一样～

    }

}

/*
[707-867-5309]
[707-867-5309, 707-867-5309]
 */