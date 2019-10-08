package com.zl.effectivejava.v3.minimizemutability;

/**最小化可变性
 * @author tzxx
 */
public class Complex {
    private final double re;
    private final double im;

    private Complex(double re, double im) {
        this.re = re;
        this.im = im;
    }

    public static Complex valueOf(double re, double im) {
        return new Complex(re, im);
    }

}


