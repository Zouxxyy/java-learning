package com.zouxxyy.effective.chap04.item20;

import java.util.Map;
import java.util.Objects;

/**
 * 骨架实现类
 * 个人理解，它就是稍微实现了点接口，相当于在接口和实现类中封装了一层，让我们后续可以少写点代码
 */

public abstract class AbstractMapEntry<K, V> implements Map.Entry<K, V> {

    @Override public V setValue(V value) {
        throw new UnsupportedOperationException();
    }


    @Override public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Map.Entry))
            return false;
        Map.Entry<?,?> e = (Map.Entry) o;
        return Objects.equals(e.getKey(),   getKey())
                && Objects.equals(e.getValue(), getValue());
    }


    @Override public int hashCode() {
        return Objects.hashCode(getKey())
                ^ Objects.hashCode(getValue());
    }

    @Override public String toString() {
        return getKey() + "=" + getValue();
    }

}
