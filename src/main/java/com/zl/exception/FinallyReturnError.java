package com.zl.exception;

/**
 * @author tzxx
 * @date 2019/4/18.
 */
public class FinallyReturnError {
    public static void main(String[] args) {
        System.out.println(re());
    }

    public static int re(){
        int i = 0;
        try{

             throw new RuntimeException("");

        }finally {
            return i;
        }
    }
}
