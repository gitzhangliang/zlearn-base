package com.zl.thread.concurrentclass.condition;

import lombok.Setter;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Java线程：条件变量
 */
public class Test {
    public static void main(String[] args) {
        //创建并发访问的账户
        MyCount myCount = new MyCount("95599200901215522", 0);
        //创建一个线程池
        ExecutorService pool = Executors.newFixedThreadPool(2);
        Thread t1 = new SaveThread("张三1", myCount, 2000);
        Thread t2 = new SaveThread("李四", myCount, 3600);
        Thread t3 = new DrawThread("王五", myCount, 2700);
        Thread t4 = new SaveThread("老张", myCount, 600);
        Thread t5 = new DrawThread("老牛", myCount, 1300);
        Thread t6 = new DrawThread("胖子", myCount, 800);
        //执行各个线程
        pool.execute(t1);
        pool.execute(t2);
        pool.execute(t3);
        pool.execute(t4);
        pool.execute(t5);
        pool.execute(t6);
        //关闭线程池
        pool.shutdown();
    }
}

/**
 * 存款线程类
 */
class SaveThread extends Thread {
    /**
     * 操作人
     */
    private String name;
    /**
     * 账户
     */
    private MyCount myCount;
    /**
     * 存款金额
     */
    private int x;

    SaveThread(String name, MyCount myCount, int x) {
        this.name = name;
        this.myCount = myCount;
        this.x = x;
    }

    @Override
    public void run() {
        myCount.saving(x, name);
    }
}

/**
 * 取款线程类
 */
class DrawThread extends Thread {
    private String name;
    private MyCount myCount;
    private int x;

    DrawThread(String name, MyCount myCount, int x) {
        this.name = name;
        this.myCount = myCount;
        this.x = x;
    }

    @Override
    public void run() {
        myCount.drawing(x, name);
    }
}


/**
 * 普通银行账户，不可透支
 */
class MyCount {
    /**
     * 账号
     */
    private String oid;
    /**
     * 账户余额
     */
    private int cash;
    /**
     * 账户锁
     */
    private Lock lock = new ReentrantLock();
    /**
     * 存款条件
     */
    private Condition _save = lock.newCondition();
    /**
     * 取款条件
     */
    private Condition _draw = lock.newCondition();

    MyCount(String oid, int cash) {
        this.oid = oid;
        this.cash = cash;
    }

    /**
     * 存款
     *
     * @param x    操作金额
     * @param name 操作人
     */
    public void saving(int x, String name) {
        //获取锁
        lock.lock();
        if (x > 0) {
            //存款
            cash += x;
            System.out.println(name + "存款" + x + "，当前余额为" + cash);
        }
        _draw.signalAll();            //唤醒所有等待线程。
        lock.unlock();                    //释放锁
    }

    /**
     * 取款
     *
     * @param x    操作金额
     * @param name 操作人
     */
    public void drawing(int x, String name) {
        lock.lock();                                 //获取锁
        try {
            if (cash - x < 0) {
                _draw.await();             //阻塞取款操作
            } else {
                //取款
                cash -= x;
                System.out.println(name + "取款" + x + "，当前余额为" + cash);
            }
            _save.signalAll();             //唤醒所有存款操作
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();                     //释放锁
        }
    }
}