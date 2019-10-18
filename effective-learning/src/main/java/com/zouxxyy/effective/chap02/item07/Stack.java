package com.zouxxyy.effective.chap02.item07;

import java.util.Arrays;
import java.util.EmptyStackException;

/**
 * 清除过期的对象引用
 */

public class Stack {


    private Object[] elements;
    private int size = 0;
    private static final int DEFAULT_INITIAL_CAPACITY = 16;

    public Stack() {
        elements = new Object[DEFAULT_INITIAL_CAPACITY];
    }

    // 入
    public void push(Object e) {
        ensureCapacity();
        elements[size++] = e;
    }

    // 出
    public Object pop() {
        if (size == 0)
            throw new EmptyStackException();
        Object result = elements[--size];

        // 上面只是让size减1，这个位置的对象的引用未清除。我们都知道 有引用在，对象就不能释放，就造成了内存泄露。

        elements[size] = null; // 所以，我们应该手动将该引用擦去

        return result;
    }


    // 扩容
    private void ensureCapacity() {
        if (elements.length == size)
            elements = Arrays.copyOf(elements, 2 * size + 1);
    }

}
