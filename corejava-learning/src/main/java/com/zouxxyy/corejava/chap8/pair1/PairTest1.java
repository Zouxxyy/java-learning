package com.zouxxyy.corejava.chap8.pair1;

/**
 * 程序8-1
 * 泛型使用示例
 * @version 1.00 2019-03-04
 * @author zouxxyy
 */
public class PairTest1 {
    public static void main(String[] args) {
        String[] words = {"Mary", "had", "a", "little", "lamb"};
        Pair<String> mm = ArrayAlg.minmax(words);
        System.out.println("min=" + mm.getFirst());
        System.out.println("max=" + mm.getSecond());
        System.out.println("A".compareTo("a"));
    }
}

class ArrayAlg {
    public static Pair<String> minmax(String[] a) {
        if (a == null || a.length == 0) return null;
        String min = a[0];
        String max = a[0];
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

/*输出：
min=Mary
max=little
-32
 */

/*解释：
因为 compareTo 比较字符时大写字母比小写字母小，所以 Mary 比 a 小
 */