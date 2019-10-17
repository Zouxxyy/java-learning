package com.zouxxyy.effective.chap02.item02.hierarchicalbuilder;

public class Calzone extends Pizza {

    private final boolean sauceInside; // 新属性：酱汁内置还是外置

    public static class Builder extends Pizza.Builder<Builder> {

        private boolean sauceInside = false; // Default

        public Builder sauceInside() {
            sauceInside = true;
            return this;
        }

        @Override public Calzone build() {
            return new Calzone(this); // 协变返回类型
        }

        @Override protected Builder self() { return this; }
    }

    private Calzone(Builder builder) {
        super(builder);
        sauceInside = builder.sauceInside;
    }

    @Override public String toString() {
        return String.format("Calzone with %s and sauce on the %s",
                toppings, sauceInside ? "inside" : "outside");
    }
}
