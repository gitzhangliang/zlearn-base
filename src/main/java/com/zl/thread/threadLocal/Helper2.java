package com.zl.thread.threadLocal;

public class Helper2 extends Thread {
	static Helper h = new Helper();
	
	public static void main(String[] args) {
		Thread thread1 = new Helper2();
		Thread thread2 = new Helper2();
		thread1.start();
		thread2.start();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	  	System.out.println(Thread.currentThread().getName() + "正在执行。。。"+Helper.seqNum.get());;

	}
	@Override 
    public void run() { 
		String name = Thread.currentThread().getName();

		if(name.contains("0")){
			h.getNextNum(2);
		}else{
			h.getNextNum(1);
		}

	  	System.out.println(Thread.currentThread().getName() + "正在执行。。。"+Helper.seqNum.get());;
    } 
	
}
