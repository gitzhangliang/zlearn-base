package com.zl.thread.concurrentclass.countdownlatch;

import java.util.concurrent.CountDownLatch;

/**
 * @author tzxx
 * @date 2019/2/28.
 */
public class OneThreadWaitOtherThreadDone {
    public static void main(String[] args) {
        CountDownLatch latch = new CountDownLatch(2);
        Thread thread1 = new Thread(new Thread1(latch));
        Thread thread2 = new Thread(new Thread1(latch));
        thread1.start();
        thread2.start();
        try {
            latch.await();
            System.out.println("主线程执行完成");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}

class Thread1 implements Runnable{

    private CountDownLatch latch;

    public Thread1() {
    }

    public Thread1(CountDownLatch latch) {
        this.latch = latch;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
        latch.countDown();
    }

}
