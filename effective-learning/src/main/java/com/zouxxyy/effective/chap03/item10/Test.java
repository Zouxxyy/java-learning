package com.zouxxyy.effective.chap03.item10;

/**
 * 覆盖equals时请遵守通用约定
 *
 * 个人觉得corejava中，介绍的 equals的写法 更清晰准确点
 * 而effective中，介绍 equals的特性 的例子不错，都结合看看吧
 */



public class Test {


    public static void main(String[] args) {

        Employee e1 = new Employee(1, "zxy");
        Manager m1 = new Manager(1, "zxy", 100.);

        System.out.println(e1.equals(m1));  // true
        System.out.println(m1.equals(e1));  // false

        /*
        很明显这里不满足对称性，为什么呢？

        我们原意是用id来唯一确认员工和管理者，只要ID一样它们就相同。 e1.equals(m1) 为true
        但是，Manager中重写了equals，添加了新的字段比较，这导致 m1.equals(e1) 必为false。

        可见不能重写用instanceof 写的 equals，即需用 final 修饰 Manager 里的 equals
         */



        /*
        什么时候用 getClass，什么时候用 instanceof 的方式写equals？

        首先明确用 getClass 写的，不可能实现这种需求：ID相等的 Manager 和 Employee 相等，因为它限定死了类必须相同。
        但正由于它限定的死，也就更规范。所以，当我们需要严格相等时就用它。


        用 instanceof 写时，更多考虑的是"超类决定相等概念"，比如我们想扩充一个类（简单加了几个工具方法），但我们仍然希望它和父类仍然相等。
        很明显，起比较作用的东西都是父类中，从逻辑上，我们也明白必须给 equals 加 final。
        虽然不能继承equals，但是effective作者提出了一种扩展的方法，就是建个新对象，把要扩展的作为它的属性，再写equals～（P36）

        所以，不能一概说必须用哪个，只有合不合适罢了～希望我解释清楚了
         */

    }

}
