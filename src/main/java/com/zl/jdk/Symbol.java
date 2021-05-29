package com.zl.jdk;

/**
 * @author zhangliang
 * @date 2020/5/9.
 */
public class Symbol {
    public static void main(String[] args) {
        System.out.println(1 | 0);
        System.out.println(3 | 0);
        System.out.println(33 | 0);
        System.out.println("------------");


        System.out.println(-1<<29);
        System.out.println(0<<29);
        System.out.println(1<<29);
        System.out.println(2<<29);
        System.out.println(3<<29);
    }
}
