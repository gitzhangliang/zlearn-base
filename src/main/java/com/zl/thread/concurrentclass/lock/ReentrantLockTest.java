package com.zl.thread.concurrentclass.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**ReentrantLock 调用lock.lock()的线程就持有了“对象监视器”，其它线程只有等待释放锁时再次争抢，
 * 效果和synchronized一样
 * !hasQueuedPredecessors() && compareAndSetState(0, acquires) 公平锁
 * compareAndSetState(0, acquires) 非公平锁
 * 公平性可以通过构造函数设置
 * @author tzxx
 * @date 2019/3/22.
 */
public class ReentrantLockTest{
    Lock lock = new ReentrantLock();

    public void print() {
        lock.lock();
        for (int i=0; i<5; i++){
            System.out.println(Thread.currentThread().getName()+"--"+i);
        }
        lock.unlock();
    }

    public void print1() {
        lock.lock();
        for (int i=0; i<5; i++){
            System.out.println(Thread.currentThread().getName()+"--"+i+"--");
        }
        lock.unlock();
    }

    public static void main(String[] args) {
        ReentrantLockTest test = new ReentrantLockTest();
        MyService service1 = new MyService(test);
        MyService service2 = new MyService(test);
        MyService1 service11 = new MyService1(test);

        service1.start();
        service2.start();
        service11.start();
    }
}

class MyService extends Thread{
    private ReentrantLockTest reentrantLockTest;
    MyService(ReentrantLockTest reentrantLockTest){
        this.reentrantLockTest = reentrantLockTest;
    }

    @Override
    public void run() {
        reentrantLockTest.print();
    }
}

class MyService1 extends Thread{
    private ReentrantLockTest reentrantLockTest;
    MyService1(ReentrantLockTest reentrantLockTest){
        this.reentrantLockTest = reentrantLockTest;
    }

    @Override
    public void run() {
        reentrantLockTest.print1();
    }
}
