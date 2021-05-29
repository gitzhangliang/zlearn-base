package com.zl.arithmetic.currentlimiting;

import com.google.common.util.concurrent.RateLimiter;


import java.time.LocalDateTime;

import java.util.concurrent.ExecutorService;

import java.util.concurrent.Executors;

import java.util.concurrent.TimeUnit;

/**令牌桶算法

 令牌桶算法的原理是系统会以一个恒定的速度往桶里放入令牌，而如果请求需要被处理，则需要先从桶里获取一个令牌，当桶里没有令牌可取时，则拒绝服务。 当桶满时，新添加的令牌被丢弃或拒绝。

*/

public class RateLimiterTest {

 /**

  * 令牌桶算法

  * 每秒生成 2 個令牌

  */

 private static final RateLimiter limiter = RateLimiter.create(5);

 private void rateLimiter() {

   // 默认就是 1

   final double acquire = limiter.acquire(1);


   System.out.println("当前时间 - "+LocalDateTime.now() +" - " +Thread.currentThread().getName() +" - 阻塞 - " +acquire+ " 通过...");

 }


 public static void main(String[] args) throws InterruptedException {

   final ExecutorService service = Executors.newFixedThreadPool(90);

   for (int i = 0; i < 50; i++ ) {
     service.execute(new RateLimiterTest()::rateLimiter);

   }
service.shutdown();


}

}