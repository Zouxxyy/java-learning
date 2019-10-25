package com.zouxxyy.effective.chap04.item17;

/**
 * 不可变类例子：复数
 */

// 禁止子类化方式1：加final修饰
public final class Complex {

    // final
    private final double re;
    private final double im;

    // 对频繁用的值提供静态final常量
    public static final Complex ZERO = new Complex(0, 0);
    public static final Complex ONE  = new Complex(1, 0);
    public static final Complex I    = new Complex(0, 1);

    public Complex(double re, double im) {
        this.re = re;
        this.im = im;
    }

    // 只提供get，不提供set
    public double realPart()      { return re; }
    public double imaginaryPart() { return im; }


    // 返回新的实例
    public Complex plus(Complex c) {
        return new Complex(re + c.re, im + c.im);
    }

    // 方式2：静态工厂方法创建实例，参考item1，再将构造器私有化，不加 final 也可以禁止子类化类
    public static Complex valueOf(double re, double im) {
        return new Complex(re, im);
    }

    public Complex minus(Complex c) {
        return new Complex(re - c.re, im - c.im);
    }

    public Complex times(Complex c) {
        return new Complex(re * c.re - im * c.im,
                re * c.im + im * c.re);
    }

    public Complex dividedBy(Complex c) {
        double tmp = c.re * c.re + c.im * c.im;
        return new Complex((re * c.re + im * c.im) / tmp,
                (im * c.re - re * c.im) / tmp);
    }

    @Override public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Complex))
            return false;
        Complex c = (Complex) o;

        return Double.compare(c.re, re) == 0
                && Double.compare(c.im, im) == 0;
    }
    @Override public int hashCode() {
        return 31 * Double.hashCode(re) + Double.hashCode(im);
    }

    @Override public String toString() {
        return "(" + re + " + " + im + "i)";
    }
}
