package com.zl.thread.concurrentclass.lock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author tzxx
 * @date 2019/3/29.
 * tryLock()
 * 当获取锁时，只有当该锁资源没有被其他线程持有才可以获取到，并且返回true，同时设置持有count为1；
 * 当获取锁时，当前线程已持有该锁，那么锁可用时，返回true，同时设置持有count加1；
 * 当获取锁时，如果其他线程持有该锁，无可用锁资源，直接返回false，这时候线程不用阻塞等待，可以先去做其他事情；
 * 即使该锁是公平锁fairLock，使用tryLock()的方式获取锁也会是非公平的方式，只要获取锁时该锁可用那么就会直接获取并返回true。这种直接插入的特性在一些特定场景是很有用的。但是如果就是想使用公平的方式的话，可以试一试tryLock(0, TimeUnit.SECONDS)，几乎跟公平锁没区别，只是会监测中断事件。
 */

/**tryLock(long timeout, TimeUnit unit)
    当获取锁时，锁资源在超时时间之内变为可用，并且在等待时没有被中断，那么当前线程成功获取锁，返回true，同时当前线程持有锁的count设置为1.
    当获取锁时，在超时时间之内没有锁资源可用，那么当前线程获取失败，不再继续等待，返回false.
    当获取锁时，在超时等待时间之内，被中断了，那么抛出InterruptedException，不再继续等待.
    当获取锁时，在超时时间之内锁可用，并且当前线程之前已持有该锁，那么成功获取锁，同时持有count加1.
    */

public class TryLockTest {
}

 class TestLockAndTryLock {
    private ReentrantLock rlock = new ReentrantLock();

    private void lockTest(){
        try {
            rlock.lock();
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("lockTest----current thread get the lock: " + Thread.currentThread().getName());
        } finally {
            rlock.unlock();
            System.out.println("lockTest----current thread release the lock:  " + Thread.currentThread().getName());
        }
    }

    private void tryLockTest(){

        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        if (rlock.tryLock()) {
            try {
                System.out.println("tryLockTest----current thread get the lock: " + Thread.currentThread().getName());

            } finally {
                rlock.unlock();
                System.out.println("tryLockTest----current thread release the lock: " + Thread.currentThread().getName());
            }

        } else {
            System.out.println("tryLockTest----current thread CAN NOT get the lock: " + Thread.currentThread().getName());
        }
    }

     private void tryLockInterruptTest() {

         try {
             Thread.sleep(100);

         } catch (InterruptedException e) {
             e.printStackTrace();
         }         Thread.currentThread().interrupt();


         try {
             System.out.println("Begin time: " + System.currentTimeMillis());
             if (rlock.tryLock(1, TimeUnit.SECONDS)) {
                 try {
                     System.out.println("tryLockInterruptTest----current thread get the lock: " + Thread.currentThread().getName());

                 } finally {
                     rlock.unlock();
                     System.out.println("tryLockInterruptTest----current thread release the lock: " + Thread.currentThread().getName());
                 }

             } else {
                 System.out.println("End time: " + System.currentTimeMillis());
                 System.out.println("tryLockInterruptTest----current thread CAN NOT get the lock: " + Thread.currentThread().getName());
             }
         } catch (InterruptedException e) {
             Thread.currentThread().interrupt();
             System.out.println(Thread.currentThread().isInterrupted());
             System.out.println("tryLockInterruptTest Interrupt----current thread is interrupted: " + Thread.currentThread().getName());
         }
     }

    public static void main(String[] args) {

        TestLockAndTryLock lockAndTryLock = new TestLockAndTryLock();

        Thread lockThread = new Thread(() -> lockAndTryLock.lockTest(), "Lock-Thread");

       // Thread tryLockThread = new Thread(() -> lockAndTryLock.tryLockTest(), "TryLock-Thread");

        Thread tryLockInterruptThread = new Thread(() -> lockAndTryLock.tryLockInterruptTest(), "TryLockInterrupt-Thread");

        lockThread.start();
//        tryLockThread.start();
        tryLockInterruptThread.start();

        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        tryLockInterruptThread.interrupt();
        Thread.currentThread().interrupt();



    }
}

