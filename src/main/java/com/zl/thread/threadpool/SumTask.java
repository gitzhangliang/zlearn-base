package com.zl.thread.threadpool;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

/**
 * @author tzxx
 */
public class SumTask extends RecursiveTask<Long> {

    private int start;
    private int end;
    private int[] arr;
    private int threshold = 5;

    public SumTask(int start, int end, int[] arr) {
        this.start = start;
        this.end = end;
        this.arr = arr;
    }

    @Override
    protected Long compute() {

        if(end - start > threshold) {
            int mid = (start + end) / 2;
            SumTask subTask1 = new SumTask(start, mid, arr);
            subTask1.fork();
            SumTask subTask2 = new SumTask(mid, end, arr);
            subTask2.fork();
            //fork
            invokeAll(subTask1, subTask2);
            long subResult1 = subTask1.join();
            long subResult2 = subTask2.join();
            System.out.println(String.format("compute1 %d~%d = %d", start, end, subResult1 + subResult2));
            return subResult1 + subResult2;

        } else {
            long sum = 0;
            for(int i = start; i < end; i++) {
                sum += arr[i];
            }
            System.out.println(String.format("compute %d~%d = %d", start, end, sum));
            return sum;
        }

    }

    public static void main(String[] args) {

        int[] arr = new int[100];
        for(int i = 0; i < 100; i++) {
            arr[i] = i;
        }
        //最大并发数
        ForkJoinPool pool = new ForkJoinPool(4);
        ForkJoinTask<Long> task = new SumTask(0, 100, arr);
        System.out.println("result:" + pool.invoke(task));
    }
}


