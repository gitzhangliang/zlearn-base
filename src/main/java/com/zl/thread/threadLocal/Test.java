package com.zl.thread.threadLocal;

import java.util.ArrayList;
import java.util.List;

public class Test {
	public  List<Integer> list=null;
	public static void main(String[] args) {
		Test t = new Test();
		Thread thread1 = new MyThread2(t);
		Thread thread2 = new MyThread3(t);
		thread1.start();
		thread2.start();
	}
}
class MyThread2 extends Thread { 
	private Test t;
	
    public MyThread2(Test t) {
		super();
		this.t = t;
	}

	@Override 
    public void run() { 
    	t.list = new ArrayList<>();
    	for (int i = 0; i < 3; i++) {
    		t.list.add(i);
		}
    	try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        System.out.println(Thread.currentThread().getName() + "正在执行。。。"+t.list.size()); 
    } 
}
class MyThread3 extends Thread {
	private Test t;
	
    public MyThread3(Test t) {
		super();
		this.t = t;
	}

	@Override 
    public void run() { 
    	t.list = new ArrayList<>();
    	  System.out.println(Thread.currentThread().getName() + "正在执行。。。"+t.list.size()); 
    } 
}
