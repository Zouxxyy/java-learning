package com.zouxxyy.effective.chap02.item02.hierarchicalbuilder;

import java.util.Objects;

public class NyPizza extends Pizza {

    public enum Size { SMALL, MEDIUM, LARGE } // 添加尺寸参数
    private final Size size;

    public static class Builder extends Pizza.Builder<Builder> {

        private final Size size;

        public Builder(Size size) {
            this.size = Objects.requireNonNull(size);
        }

        @Override public NyPizza build() {
            return new NyPizza(this);
        }

        @Override protected Builder self() { return this; }
    }

    private NyPizza(Builder builder) {
        super(builder);
        size = builder.size;
    }

    @Override public String toString() {
        return "New York Pizza with " + toppings;
    }
}
