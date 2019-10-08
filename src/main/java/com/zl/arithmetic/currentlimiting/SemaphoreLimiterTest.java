package com.zl.arithmetic.currentlimiting;


import java.time.LocalDateTime;

import java.util.concurrent.ExecutorService;

import java.util.concurrent.Executors;

import java.util.concurrent.Semaphore;

import java.util.concurrent.TimeUnit;

/**
* 漏桶算法
*
* 其主要目的是控制数据注入到网络的速率，平滑网络上的突发流量，数据可以以任意速度流入到漏桶中。 漏桶算法提供了一种机制，通过它，突发流量可以被整形以便为网络提供一个稳定的流量。 漏桶可以看作是一个带有常量服务时间的单服务器队列，如果漏桶为空，则不需要流出水滴，如果漏桶（包缓存）溢出，那么水滴会被溢出丢弃。
*
* 如图所示
*
* 漏铜算法可以通过 信号量（Semaphore） 的方式实现，很好的达到消峰的目的，如果下文中的代码，队列中任务存活个数就如同是水桶最多能盛装的水量，当超出这个阀值就会丢弃任务....
*
* Semaphore 是 JDK1.5 提供用于限制获取某种资源的线程数量，拥有有 公平、非公平 两种模式。公平则是顺序获取信号，遵循（FIFO）先进先出，而非公平模式则是凭本事抢资源，想先进先出？不存在的。默认是非公平的

*/

public class SemaphoreLimiterTest {

 /**

  * 计数器限流算法（允许将任务放入到缓冲队列）

  * 信号量，用来达到削峰的目的

  */

 private static final Semaphore semaphore = new Semaphore(3);

 private void semaphoreLimiter() {

   // 队列中允许存活的任务个数不能超过 5 个

   if (semaphore.getQueueLength() > 5) {

     System.out.println(LocalDateTime.now() +" - " +Thread.currentThread().getName() +" - 拒絕...");

   } else {

     try {

       semaphore.acquire();

       System.out.println(LocalDateTime.now()+ " - "+ Thread.currentThread().getName() +" - 通过...");

       //处理核心逻辑

       TimeUnit.SECONDS.sleep(2);

     } catch (InterruptedException e) {

       e.printStackTrace();

     } finally {

       semaphore.release();

     }

   }

 }


 public static void main(String[] args) throws InterruptedException {

   final ExecutorService service = Executors.newFixedThreadPool(10);

   for (int i = 0; i < 10; i++ ) {

     service.execute(new SemaphoreLimiterTest()::semaphoreLimiter);

   }

   TimeUnit.SECONDS.sleep(5);

 }

}