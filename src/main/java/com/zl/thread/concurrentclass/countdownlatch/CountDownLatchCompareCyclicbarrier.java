package com.zl.thread.concurrentclass.countdownlatch;


import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;

/**CountDownLatch闭锁用于等待事件，Cyclicbarrier 用于等待线程(相当于多人约好都到达地点之后，在进行下一步动作，
 *                                                          能否进行下一步，只需要有这些人自己决定，而闭锁则需要其它事件
 *                                                            去触发)
 * 1.CountDownLatch await() countDown() 需要通过countDown为0之后，为非阻塞
 *   Cyclicbarrier await() 当所有线程都调用await()之后，所有线程才可以继续执行。
 * 2 Cyclicbarrier可以用来进行新一轮的使用。而CountDownLatch无法进行重复使用。
 * @author tzxx
 * @date 2019/3/29.
 */
public class CountDownLatchCompareCyclicbarrier {

}
 class SingleModel {
    private volatile static SingleModel singleModel = new SingleModel();
    private SingleModel(){
    }
    public static SingleModel getInstance(){
        return singleModel;
    }

    public static void main(String[] args) {
        List<MyThread> list = new ArrayList<>();
        CountDownLatch downLatch1 = new CountDownLatch(1);
        CountDownLatch downLatch2 = new CountDownLatch(5000);

        for (int i = 0;i<5000;i++){
            MyThread thread = new MyThread(downLatch1,downLatch2);
            thread.start();
        }
        downLatch1.countDown();
        try {
            downLatch2.await();
            System.out.println("主线程over");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class MyThread extends Thread{
    CountDownLatch latch1 = null;
    CountDownLatch latch2 = null;
    public MyThread(CountDownLatch latch1,CountDownLatch latch2){
        this.latch1 = latch1;
        this.latch2 = latch2;
    }
    @Override
    public void run() {
        try {
            latch1.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
            Thread.currentThread().interrupt();
        }
        System.out.println(com.zl.designmodel.single.SingleModel.getInstance());
        latch2.countDown();
    }
}


