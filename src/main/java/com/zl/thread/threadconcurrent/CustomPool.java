package com.zl.thread.threadconcurrent;

import java.util.concurrent.*;

/**
 * @author tzxx
 */
public class CustomPool {
	public static void main(String[] args) {
		// 创建等待队列
		BlockingQueue<Runnable> bqueue = new ArrayBlockingQueue<Runnable>(20);
		// 创建一个单线程执行程序，它可安排在给定延迟后运行命令或者定期地执行。
		ThreadPoolExecutor pool = new ThreadPoolExecutor(2, 3, 2, TimeUnit.MILLISECONDS, bqueue);
		// 创建实现了Runnable接口对象，Thread对象当然也实现了Runnable接口
		Thread t1 = new MyThread2("1");
		Thread t2 = new MyThread2("2");
		Thread t3 = new MyThread2("3");
		Thread t4 = new MyThread2("4");
		Thread t5 = new MyThread2("5");
		Thread t6 = new MyThread2("6");
		Thread t7 = new MyThread2("7");
		// 将线程放入池中进行执行
		pool.execute(t1);
		pool.execute(t2);
		pool.execute(t3);
		pool.execute(t4);
		pool.execute(t5);
		pool.execute(t6);
		pool.execute(t7);
		// 关闭线程池
		pool.shutdown();
	}
}

class MyThread2 extends Thread {
	private String name;
	public MyThread2(String name){this.name = name;}
	@Override
	public void run() {
		if(name.equals("1")){
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println(Thread.currentThread().getName() + "正在执行。。。"+name);
		try {
			Thread.sleep(100L);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
