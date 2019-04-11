package com.zl.thread.concurrentclass.semaphore;

import lombok.Getter;
import lombok.Setter;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * Java线程：新特征-信号量 Semaphore可以控同时访问的线程个数 （如mysql同时支持3个连接，则可以使用Semaphore（3）去控制同时访问）
 *
 * @author leizhimin 2009-11-5 13:44:45
 */
public class Test {
    public static void main(String[] args) {
        MyPool myPool = new MyPool(20);
        //创建线程池
        ExecutorService threadPool = Executors.newFixedThreadPool(10);
        MyThread t1 = new MyThread("任务A", myPool, 3);
        MyThread t2 = new MyThread("任务B", myPool, 12);
        MyThread t3 = new MyThread("任务C", myPool, 8);
        MyThread t4 = new MyThread("任务D", myPool, 8);

        //在线程池中执行任务
        threadPool.execute(t1);
        threadPool.execute(t2);
        threadPool.execute(t3);
        threadPool.execute(t4);

        //关闭池
        threadPool.shutdown();
    }
}

/**
 * 一个池
 */
class MyPool {
    /**
     * 池相关的信号量
     */
    @Setter@Getter
    private Semaphore sp;

    /**
     * 池的大小，这个大小会传递给信号量
     * @param size 池的大小
     */
    MyPool(int size) {
        this.sp = new Semaphore(size);
    }

}

class MyThread extends Thread {
    /**
     * 线程的名称
     */
    private String threadName;
    /**
     * 自定义池
     */
    private MyPool pool;
    /**
     * 申请信号量的大小
     */
    private int x;

    MyThread(String threadname, MyPool pool, int x) {
        this.threadName = threadname;
        this.pool = pool;
        this.x = x;
    }

    @Override
    public void run() {
        try {
            //从此信号量获取给定数目的许可
            pool.getSp().acquire(x);
            //todo：也许这里可以做更复杂的业务
            System.out.println(threadName + "成功获取了" + x + "个许可！");
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            //释放给定数目的许可，将其返回到信号量。
            pool.getSp().release(x);
            System.out.println(threadName + "释放了" + x + "个许可！");
        }
    }
}