package com.zl.arithmetic;

import java.util.Scanner;

/**
 * @author zhangliang
 * @date 2020/6/5.
 */
public class Face {


    public static void main(String[] args) {
        System.out.println(zxgbs(15, 10));
        System.out.println(zxgbs2(15, 10));
        System.out.println(zdgys(15, 10));
        System.out.println(revers("i am zhang liang"));
    }
    public static int zxgbs(int m,int n){
        int max = Math.max(m, n);
        int c= max;
        int min = Math.min(m, n);
        if (max%min==0) {
           return max;
        }else{
            do {
                max+= c;
            }while (max%min!=0);
        }
        return max;
    }
    public static int zdgys(int m,int n){
        if(n==0){return m;}
        return zdgys(n,m%n);
    }
    public static int zxgbs2(int m,int n){
        return m*n/zdgys(m,n);
    }

    public static String revers(String s){
        char[] chars = s.toCharArray();
        char[] newc = new char[chars.length];
        for (int i = 0; i < chars.length; i++) {
            newc[i] = chars[chars.length-1-i];
        }
        return new String(newc);
    }
}
