package com.zl.thread.Inheritablethreadlocal;

/**
 * @author zhangliang
 * @date 2020/9/14.
 */
public class Test {
    public static InheritableThreadLocal<Integer> local = new InheritableThreadLocal<Integer>(){
        @Override
        protected Integer initialValue() {
            return 0;
        }

        @Override
        protected Integer childValue(Integer parentValue) {
            return parentValue+1;
        }
    };

    public static void main(String[] args) {
        for (int i = 0;i<10 ;i++){
            System.out.println("main线程值为"+local.get());
        }
        A a = new A();
        a.start();
        local.set(2);
        System.out.println("main结束");
    }
}

class A extends Thread{
    @Override
    public void run()  {
        System.out.println("线程A开始");
        for (int i = 0;i<10 ;i++){
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("线程A得到的值是"+Test.local.get());
        }
    }
}
