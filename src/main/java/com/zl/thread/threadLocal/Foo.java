package com.zl.thread.threadLocal;

public class Foo extends Thread {
	/**
	 * If perThreadInstance.get() returns a non-null value, this thread has done
	 * synchronization needed to see initialization of helper
	 */
	@SuppressWarnings("rawtypes")
	private final ThreadLocal<ThreadLocal> perThreadInstance = new ThreadLocal<ThreadLocal>();
	private static Helper helper = null;

	public Helper getHelper() {
		if (perThreadInstance.get() == null){
			createHelper();
			System.out.println("ssdd");

		}
		return helper;
	}

	private final void createHelper() {
		synchronized (this) {
			if (helper == null){
				helper = new Helper();
				System.out.println("sssssssss");

			}
		}
		// Any non-null value would do as the argument here
		perThreadInstance.set(perThreadInstance);
	}
	public static void main(String[] args) throws InterruptedException {
		Thread foo1 = new Foo();
		Thread foo2 = new Foo();
		foo1.start();
		foo2.start();
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		getHelper();
	}
}