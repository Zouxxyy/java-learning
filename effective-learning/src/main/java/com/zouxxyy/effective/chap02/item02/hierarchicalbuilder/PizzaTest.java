package com.zouxxyy.effective.chap02.item02.hierarchicalbuilder;

import static com.zouxxyy.effective.chap02.item02.hierarchicalbuilder.NyPizza.Size.*;
import static com.zouxxyy.effective.chap02.item02.hierarchicalbuilder.Pizza.Topping.*;

/**
 * 有类层次结构的Builder测试
 * 这里是继承抽象类的抽象Builder
 */

public class PizzaTest {

    public static void main(String[] args) {

        // 步骤还是一样的
        NyPizza pizza = new NyPizza.Builder(SMALL)
                .addTopping(SAUSAGE).addTopping(ONION)
                .build();

        Calzone calzone = new Calzone.Builder()
                .addTopping(HAM).sauceInside()
                .build();

        System.out.println(pizza);
        System.out.println(calzone);
    }
}


/*
New York Pizza with [ONION, SAUSAGE]
Calzone with [HAM] and sauce on the inside
 */