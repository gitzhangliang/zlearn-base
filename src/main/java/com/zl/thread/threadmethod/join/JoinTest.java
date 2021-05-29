package com.zl.thread.threadmethod.join;

/**join作用是时所属的线程x对象正常执行run(),而时当前线程z进行无限期的阻塞，
 * 等待线程x销毁后再继续执行线程z后面的代码
 * join具有使线程排队运行的作用
 * @author tzxx
 */
public class JoinTest implements Runnable{
      
    public static int a = 0;  
  
    @Override
    public void run() {
        for (int k = 0; k < 5; k++) {  
            a = a + 1;  
        }  
    }  
  
    public static void main(String[] args) throws Exception {  
        Runnable r = new JoinTest();  
        Thread t = new Thread(r);  
        t.start(); 
        t.join();
        System.out.println(a);  
    }         
}  