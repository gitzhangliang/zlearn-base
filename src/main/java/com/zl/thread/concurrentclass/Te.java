package com.zl.thread.concurrentclass;

import sun.applet.Main;

import java.util.concurrent.CountDownLatch;

/**
 * @author zhangliang
 * @date 2019/9/17.
 */
public class Te {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(1);
        countDownLatch.countDown();
        countDownLatch.await();
        System.out.println(222222222);
    }
}
