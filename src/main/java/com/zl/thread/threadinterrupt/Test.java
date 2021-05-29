package com.zl.thread.threadinterrupt;

import java.math.BigInteger;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * @author zhangliang
 * @date 2020/9/14.
 */
public class Test {
    static BlockingQueue<BigInteger> queue = new ArrayBlockingQueue<>(5);

    public static void main(String[] args) throws InterruptedException {
        Test test = new Test();
        Producer producer = new Producer(queue);
        producer.start();
        try {
            while (test.needProducer()) {
                BigInteger take = queue.take();
                System.out.println("-" + take);
                Thread.sleep(1000);
            }
        } finally {
            producer.cancel();
        }
        //保证触发子线程异常然后重置中断
        Thread.sleep(2000);
        for (;;){
            if (producer.isInterrupted()) {
                System.out.println("发现子线程异常中断"+producer.getState().name());
            }else {
                System.out.println("子线程停止"+producer.getState().name());
                break;
            }
        }
    }

    boolean needProducer() {
        return queue.size() <= 3;
    }
}

class Producer extends Thread {
    Producer(BlockingQueue<BigInteger> queue) {
        this.queue = queue;
    }

    private BlockingQueue<BigInteger> queue;

    @Override
    public void run() {
        BigInteger p = BigInteger.ONE;
        try {
            while (!Thread.currentThread().isInterrupted()) {
                p = p.nextProbablePrime();
                System.out.println("+" + p);
                queue.put(p);
            }
        } catch (InterruptedException e) {
            System.out.println("捕获中断异常");
            interrupt();
            if (this.isInterrupted()) {
                System.out.println("子线程中断");
            }
            for(long i=0;i<20;i++){
                for(long j=0;j<1000000000;j++){
                    j++;
                }
            }
           // for(;;){}
        }
    }

    public void cancel() {
        System.out.println("中断子线程");
        interrupt();
    }

}
