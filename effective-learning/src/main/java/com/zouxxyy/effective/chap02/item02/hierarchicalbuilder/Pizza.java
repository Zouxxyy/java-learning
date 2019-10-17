package com.zouxxyy.effective.chap02.item02.hierarchicalbuilder;

import java.util.*;

public abstract class Pizza {

    public enum Topping { HAM, MUSHROOM, ONION, PEPPER, SAUSAGE } // 各种调料
    final Set<Topping> toppings;

    abstract static class Builder<T extends Builder<T>> {

        EnumSet<Topping> toppings = EnumSet.noneOf(Topping.class);

        public T addTopping(Topping topping) {

            toppings.add(Objects.requireNonNull(topping));

            return self(); // 这里没有直接返回this，而是借助self()函数
        }

        abstract Pizza build();

        // Subclasses must override this method to return "this"
        protected abstract T self();
    }

    Pizza(Builder<?> builder) {
        toppings = builder.toppings.clone(); // See Item 50，进行保护性拷贝
    }
}
