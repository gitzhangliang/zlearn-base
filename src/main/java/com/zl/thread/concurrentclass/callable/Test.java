package com.zl.thread.concurrentclass.callable;
import java.util.concurrent.*; 

/** 
* Java线程：有返回值的线程
* @author Administrator 2009-11-5 0:41:50 
*/ 
public class Test { 
        public static void main(String[] args) throws ExecutionException, InterruptedException { 
            int sum = Runtime.getRuntime().availableProcessors();
    
        	//创建一个线程池 
                ExecutorService pool = Executors.newFixedThreadPool(sum); 
                //创建两个有返回值的任务 
                Callable<?> c1 = new MyCallable("A"); 
                Callable<?> c2 = new MyCallable("B"); 
                //执行任务并获取Future对象
                Future<?> f1 = pool.submit(c1); 
                Future<?> f2 = pool.submit(c2); 

                //从Future对象上获取任务的返回值，并输出到控制台 
                System.out.println(">>>"+f1.get().toString()); 
                System.out.println(">>>"+f2.get().toString()); 
                //关闭线程池 
                pool.shutdown(); 
        } 
} 

class MyCallable implements Callable<Object>{ 
        private String oid; 

        MyCallable(String oid) { 
                this.oid = oid; 
        } 

        @Override 
        public Object call() throws Exception {
            if("A".equals(oid)){
                Thread.sleep(2000);
            }
            return oid+"任务返回的内容";
        } 
}