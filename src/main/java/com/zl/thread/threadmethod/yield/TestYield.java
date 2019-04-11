package com.zl.thread.threadmethod.yield;

/**yield放弃当前CPU资源，但放弃时间不确定，有可能刚刚放弃，马上又获得CPU时间片
 * @author tzxx
 */
public class TestYield {
    public static void main(String[] args) {
        Thread t1 = new MyThread1();
        Thread t2 = new Thread(new MyRunnable1());

        t2.start();
        t1.start();
    }
}

class MyThread1 extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("线程1第" + i + "次执行开始！");
            Thread.yield();
            System.out.println("线程1第" + i + "次执行结束！");
        }
    }
}

class MyRunnable1 implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("线程2第" + i + "次执行！");
            Thread.yield();
            System.out.println("线程2第" + i + "次执行结束！");
        }
    }
}