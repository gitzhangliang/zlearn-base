package com.zl.thread.threadLocal;

public class Helper {
    // ①通过匿名内部类覆盖ThreadLocal的initialValue()方法，指定初始值  
    public static ThreadLocal<Integer> seqNum = new ThreadLocal<Integer>() {  
        public Integer initialValue() {  
            return 0;  
        }  
    };  
    // ②获取下一个序列值  
    public void getNextNum(int a) { 
    	System.out.println(Thread.currentThread().getName() + "正在执行。。。a="+a); 
        seqNum.set(seqNum.get()+a);  
    } 
}
