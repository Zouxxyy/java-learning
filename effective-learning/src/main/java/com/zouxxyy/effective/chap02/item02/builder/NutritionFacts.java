package com.zouxxyy.effective.chap02.item02.builder;

// 建造者(Builder）模式
public class NutritionFacts {

    private final int servingSize;
    private final int servings;
    private final int calories;
    private final int fat;
    private final int sodium;
    private final int carbohydrate;

    public static class Builder {

        private final int servingSize;
        private final int servings;


        private int calories      = 0;
        private int fat           = 0;
        private int sodium        = 0;
        private int carbohydrate  = 0;


        public Builder(int servingSize, int servings) {
            this.servingSize = servingSize;
            this.servings    = servings;
        }

        public Builder calories(int val)
        { calories = val;      return this; }
        public Builder fat(int val)
        { fat = val;           return this; }
        public Builder sodium(int val)
        { sodium = val;        return this; }
        public Builder carbohydrate(int val)
        { carbohydrate = val;  return this; }

        public NutritionFacts build() {
            return new NutritionFacts(this);
        }
    }

    private NutritionFacts(Builder builder) {
        servingSize  = builder.servingSize;
        servings     = builder.servings;
        calories     = builder.calories;
        fat          = builder.fat;
        sodium       = builder.sodium;
        carbohydrate = builder.carbohydrate;
    }

    @Override
    public String toString() {
        return "NutritionFacts{" +
                "servingSize=" + servingSize +
                ", servings=" + servings +
                ", calories=" + calories +
                ", fat=" + fat +
                ", sodium=" + sodium +
                ", carbohydrate=" + carbohydrate +
                '}';
    }

    public static void main(String[] args) {

        // 1. 用必要参数构建 Builder对象
        NutritionFacts cocaCola = new NutritionFacts.Builder(240, 8)
                // 2. Builder对象 调用方法设置属性
                .calories(100).sodium(35).carbohydrate(27)
                // 3. 调用无参的build()方法生成对象
                .build();

        System.out.println(cocaCola);
    }
}


/*
NutritionFacts{servingSize=240, servings=8, calories=100, fat=0, sodium=35, carbohydrate=27}
 */
