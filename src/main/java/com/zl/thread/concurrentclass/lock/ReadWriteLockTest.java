package com.zl.thread.concurrentclass.lock;

import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.util.concurrent.*;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**ReentrantReadWriteLock 只有“读读”不互斥，“读写、写读、写写”都互斥
 * @author tzxx
 */
public class ReadWriteLockTest {
	public static void main(String[] args) {


        // 创建并发访问的账户
		MyCount1 myCount = new MyCount1("95599200901215522", 10000);
		// 创建一个锁对象
		ReadWriteLock lock = new ReentrantReadWriteLock(false);
		// 创建一个线程池
        ThreadFactory namedThreadFactory = new ThreadFactoryBuilder()
                .setNameFormat("demo-pool-%d").build();
        ExecutorService pool = new ThreadPoolExecutor(5, 200,
                0L, TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<>(1024), namedThreadFactory, new ThreadPoolExecutor.AbortPolicy());
		// 创建一些并发访问用户，一个信用卡，存的存，取的取
		User1 u1 = new User1("张三", myCount, -4000, lock, false);
		User1 u2 = new User1("张三他爹", myCount, 6000, lock, false);
		User1 u3 = new User1("张三他弟", myCount, -8000, lock, false);
		User1 u4 = new User1("张三", myCount, 800, lock, false);
		User1 u5 = new User1("张三他爹", myCount, 0, lock, true);
		// 在线程池中执行各个用户的操作
		pool.execute(u1);
		pool.execute(u2);
		pool.execute(u3);
		pool.execute(u4);
		pool.execute(u5);
		// 关闭线程池
		pool.shutdown();
	}
}

/**
 * 信用卡的用户
 */
class User1 implements Runnable {
	/**
	*用户名
	*/
	private String name;
	/**
	 * 所要操作的账户
	 */
	private MyCount1 myCount;
	/**
	 * 操作的金额，当然有正负之分了
	 */
	private int ioCash;
	/**
	 * 执行操作所需的锁对象
	 */
	private ReadWriteLock myLock;
	/**
	 * 是否查询
	 */
	private boolean isCheck;

	User1(String name, MyCount1 myCount, int ioCash, ReadWriteLock myLock, boolean isCheck) {
		this.name = name;
		this.myCount = myCount;
		this.ioCash = ioCash;
		this.myLock = myLock;
		this.isCheck = isCheck;
	}
	@Override
	public void run() {
		if (isCheck) {
			// 获取读锁
			myLock.readLock().lock();
			System.out.println(Thread.currentThread().getName()+"读：" + name + "正在查询" + myCount + "账户，当前金额为" + myCount.getCash());
			// 释放读锁
			myLock.readLock().unlock();
		} else {
			// 获取写锁
			myLock.writeLock().lock();
			// 执行现金业务
			System.out.println(Thread.currentThread().getName()+"写：" + name + "正在操作" + myCount + "账户，金额为" + ioCash + "，当前金额为" + myCount.getCash());
			myCount.setCash(myCount.getCash() + ioCash);
			System.out.println(Thread.currentThread().getName()+"写：" + name + "操作" + myCount + "账户成功，金额为" + ioCash + "，当前金额为" + myCount.getCash());
			// 释放写锁
			myLock.writeLock().unlock();
		}
	}
}

/**
 * 信用卡账户，可随意透支
 */
class MyCount1 {
	/**
	 * 账号
	 */
	private String oid;
	/**
	 * 账户余额
	 */
	private int cash;

	MyCount1(String oid, int cash) {
		this.oid = oid;
		this.cash = cash;
	}

	public String getOid() {
		return oid;
	}

	public void setOid(String oid) {
		this.oid = oid;
	}

	public int getCash() {
		return cash;
	}

	public void setCash(int cash) {
		this.cash = cash;
	}

	@Override
	public String toString() {
		return "MyCount1{" + "oid='" + oid + '\'' + ", cash=" + cash + '}';
	}
}
