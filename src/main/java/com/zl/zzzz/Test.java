package com.zl.zzzz;


import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author tzxx
 * @date 2019/4/3.
 */
public class Test {
    String name = "12";
     String getName(){
        return name;
    }

    synchronized void setName(String name){
        this.name = name;
    }

    public static void main(String[] args) throws InterruptedException {
        Test t = new Test();
        CountDownLatch countDownLatch = new CountDownLatch(1);
        ThreadPoolExecutor executor = new ThreadPoolExecutor(100,200,3000, TimeUnit.MILLISECONDS,new LinkedBlockingDeque());

        for (int i = 0;i<99;i++){
            executor.execute(new Task(t,countDownLatch));
        }
        countDownLatch.countDown();
        Thread.sleep(1000);
        t.setName("123");

    }
}
    class Task implements Runnable{
        Task(Test test,CountDownLatch latch){
            this.latch = latch;
            this.test = test;
        }
        Test test;
        CountDownLatch latch;
        @Override
        public void run() {

            for (;;){
                if("123".equals(test.getName())){
                    break;
                }
                System.out.println(test.getName()+"--"+Thread.currentThread().getId());
            }

        }
    }



