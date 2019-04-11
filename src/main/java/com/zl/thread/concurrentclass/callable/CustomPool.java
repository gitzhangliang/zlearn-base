package com.zl.thread.concurrentclass.callable;

import java.util.concurrent.*;

/**
 * @author tzxx
 */
public class CustomPool {
	public static void main(String[] args) {
		// 创建等待队列
		BlockingQueue<Runnable> bqueue = new ArrayBlockingQueue<Runnable>(20);
		// 创建一个单线程执行程序，它可安排在给定延迟后运行命令或者定期地执行。
		ThreadPoolExecutor pool = new ThreadPoolExecutor(10, 20, 2, TimeUnit.MILLISECONDS, bqueue);
		// 创建实现了Runnable接口对象，Thread对象当然也实现了Runnable接口
		MyThread2 t1 = new MyThread2("1");
		MyThread2 t2 = new MyThread2("2");
		MyThread2 t3 = new MyThread2("3");

		FutureTask<String> futureTask1 = new FutureTask<String>(t1);
		FutureTask<String> futureTask2 = new FutureTask<String>(t2);
		FutureTask<String> futureTask3 = new FutureTask<String>(t3);
		FutureTask<String> futureTask4 = new FutureTask<String>(()->{return "";});


		// 将线程放入池中进行执行
		pool.execute(futureTask1);
		pool.execute(futureTask2);
		pool.execute(futureTask3);
		try {
			String r1 = futureTask1.get();
			String r2 = futureTask2.get();
			String r3 = futureTask3.get();
			System.out.println(r1+"---"+r2+"---"+r3);
		} catch (Exception e) {
			e.printStackTrace();
		}

		// 关闭线程池
		pool.shutdown();
	}
}

class MyThread2 implements Callable<String> {
	private String name;
	public MyThread2(String name){this.name = name;}
	@Override
	public String call() {
		try {
			Thread.sleep(3000);
			int i = 5/0;
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return name;
	}
}
