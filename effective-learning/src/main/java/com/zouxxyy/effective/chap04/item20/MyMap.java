package com.zouxxyy.effective.chap04.item20;

public final class MyMap<K, V> extends AbstractMapEntry<K, V> {

    final private K key;
    final private V value;

    // 可以发现我们的骨架实现类中没有实现getKey()和getValue()，所以这里需要实现
    @Override
    public K getKey() {
        return key;
    }

    @Override
    public V getValue() {
        return value;
    }

    public MyMap(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public static void main(String[] args) {

        MyMap<String, String> myMap1 = new MyMap<>("zxy", "啦啦啦");
        MyMap<String, String> myMap2 = new MyMap<>("zxy", "啦啦啦");

        System.out.println(myMap1);

        System.out.println(myMap1.equals(myMap2));

    }
}

/*
zxy=啦啦啦
true
 */