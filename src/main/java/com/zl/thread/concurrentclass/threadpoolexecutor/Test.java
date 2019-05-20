package com.zl.thread.concurrentclass.threadpoolexecutor;

import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

/**
 * @author tzxx
 * @date 2019/3/1.
 */
public class Test {
    public static void main(String[] args) {
        BlockingQueue queue = new LinkedBlockingDeque(220);
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        UserThreadFactory f1 = new UserThreadFactory("第1机房");
        UserThreadFactory f2 = new UserThreadFactory("第2机房");

        UserRejectHandler handler = new UserRejectHandler();

        ThreadPoolExecutor executor1 = new ThreadPoolExecutor(10,11,0L,
                TimeUnit.SECONDS,queue,f1,handler);
        ThreadPoolExecutor executor2 = new ThreadPoolExecutor(1,2,0L,
                TimeUnit.SECONDS,queue,f2,handler);

        Runnable task = new Task();
        for (int i = 0; i < 200; i++){
            executor1.execute(task);
            //executor2.execute(task);
        }
        executor1.shutdown();
        //executor2.shutdown();

    }

}
class UserThreadFactory implements ThreadFactory{
    private final String namePrefix;
    private final AtomicInteger nextId = new AtomicInteger(1);
    public UserThreadFactory(String whatFeatureOfGroup) {
        namePrefix = "UserThreadFactory's "+whatFeatureOfGroup+"-Worker-";
    }

    @Override
    public Thread newThread(Runnable task) {
        String name = namePrefix + nextId.getAndIncrement();
        Thread thread = new Thread(null,task,name,0);
        System.out.println(thread.getName());
        return thread;
    }
}

class Task implements Runnable{
    private final AtomicLong count = new AtomicLong(0L);
    @Override
    public void run() {
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName()+"_running_"+count.getAndIncrement());
    }
}

class UserRejectHandler implements RejectedExecutionHandler {
    @Override
    public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
        System.out.println("task rejected. "+executor.toString());
    }
}
