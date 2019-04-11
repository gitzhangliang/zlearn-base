package com.zl.thread.concurrentclass.countdownlatch;

import java.util.concurrent.CountDownLatch;

/**CountDownLatch 线程调用CountDownLatch.await(),则该线程阻塞。直到其它线程调用CountDownLatch.countDown()将计数器
 * 置为0，则该线程继续执行【CountDownLatch.countDown()最好放在finally中，以免出现异常阻塞】
 * SingleModel中也有事例
 * @author tzxx
 */
public class CountDownLatchDemo {


    public static void main(String[] args) throws InterruptedException {


        CountDownLatch countDownLatch = new CountDownLatch(2) {
            @Override
            public void await() throws InterruptedException {
                System.out.println(Thread.currentThread().getName() + " count down is await");
                super.await();

            }

            @Override
            public void countDown() {
                System.out.println(Thread.currentThread().getName() + " count down is countDown");
                super.countDown();

            }
        };

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
					countDownLatch.await();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
                System.out.println(Thread.currentThread().getName() + " is done");
            }
        }, "thread1");


        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
					countDownLatch.await();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
                System.out.println(Thread.currentThread().getName() + " is done");
            }
        }, "thread2");

        thread1.start();
        Thread.sleep(1000);
        countDownLatch.countDown();
        thread2.start();
        countDownLatch.countDown();
       System.out.println("===");
    }


}
