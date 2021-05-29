package com.zl.thread.concurrentclass;

import sun.applet.Main;

import java.util.concurrent.*;

/**
 * @author zhangliang
 * @date 2019/9/17.
 */
public class Te {
    public static void main(String[] args) throws InterruptedException {
        ScheduledExecutorService scheduledService = Executors.newScheduledThreadPool(1);
        scheduledService.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                System.out.println(System.currentTimeMillis());
            }
        }, 0, 300, TimeUnit.MILLISECONDS);
    }
}
