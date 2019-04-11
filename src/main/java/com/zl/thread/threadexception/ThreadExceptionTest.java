package com.zl.thread.threadexception;

/**
 * @author tzxx
 * @date 2019/4/9.
 */
public class ThreadExceptionTest {


    public static void main(String[] args) {
        Thread.setDefaultUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
            @Override
            public void uncaughtException(Thread t, Throwable e){
                System.out.println(t.getName()+"---"+e.getMessage());
            }
        });

        new Thread(()->{
            throw new RuntimeException("出错了1");

        },"异常线程1").start();
        new Thread(()->{
            throw new RuntimeException("出错了2");

        },"异常线程2").start();
    }
}
