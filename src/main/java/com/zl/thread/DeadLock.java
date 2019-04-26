package com.zl.thread;

/**
 * @author tzxx
 * @date 2019/4/8.
 */
public class DeadLock {
    public static Object lock1 = new Object();
    public static Object lock2 = new Object();

    public static void main(String[] args) {
//        new Thread(DeadLock::m1).start();
//        new Thread(DeadLock::m2).start();
        Thread a = new Thread(){

                @Override
                public void run(){
                    System.out.println("11");

                }
        };
        a.start();

    }
    public static void m1()  {
        synchronized (lock1){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (lock2){

            }
        }
    }

    public static void m2() {
        synchronized (lock2){
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (lock1){

            }
        }
    }
}
