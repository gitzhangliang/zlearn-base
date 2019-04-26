package com.zl.thread;

/**
 * @author tzxx
 * @date 2019/4/22.
 */
public class VolatileTest implements Runnable{
    public A a;
    private boolean b = true;

    public boolean isB() {
        return b;
    }

    public void setB(boolean b) {
        this.b = b;
    }

    public VolatileTest(A a) {
        this.a = a;
    }

    public  void stop(){
        //a.setFlag(false);
        b = false;
    }

    @Override
    public void run() {
        while (b){
            System.out.println("1");
        }
    }

    public static void main(String[] args) throws InterruptedException {
        System.out.println(System.getProperty("java.vm.name"));
        VolatileTest test = new VolatileTest(new A());
        new Thread(test).start();
        Thread.sleep(1000);
        test.stop();

    }
}

class A{
    private boolean flag = true;

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }
}
