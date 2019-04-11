package com.zl.thread.threadmethod.join;

/** 
* join(long) join 2 秒，sleep 5 秒，结果主线程等待2秒
 * join 具有释放锁功能
 * @author tzxx
 */
public class JoinTest2 extends Thread{
    public JoinTest2(String name) {
    	super(name);
    }
    @Override
    public  void run() {
        System.out.println("beginTime="+System.currentTimeMillis());
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    } 

    public static void main(String[] args) throws InterruptedException { 
        Thread t1 = new JoinTest2("阿三");
        t1.start();
        t1.join(2000);
        System.out.println("endTme="+System.currentTimeMillis());
    } 
}