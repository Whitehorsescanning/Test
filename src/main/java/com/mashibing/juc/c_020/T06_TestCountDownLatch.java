package com.mashibing.juc.c_020;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class T06_TestCountDownLatch {
    public static void main(String[] args) {
//        usingJoin();
        usingCountDownLatch();
    }

    private static void usingCountDownLatch() {
        Thread[] threads = new Thread[100+2];
        CountDownLatch latch = new CountDownLatch(threads.length-2);

        for(int i=0; i<threads.length; i++) {
            threads[i] = new Thread(()->{
                int result = 0;
                for(int j=0; j<10000; j++) result += j;
                try {
                    TimeUnit.SECONDS.sleep(5);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                latch.countDown();  //结束一个线程countDownLatch - 1 倒计时
            });
        }

        for (int i = 0; i < threads.length; i++) {
            threads[i].start();
        }

        try {
            latch.await();  //countdownLatch == 0 时拉开门栓
            CountDownLatch latch1 = new CountDownLatch(2);
            latch1.await();  //countdownLatch == 0 时拉开门栓

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("end latch");
    }

    private static void usingJoin() {
        Thread[] threads = new Thread[100];

        for(int i=0; i<threads.length; i++) {
            threads[i] = new Thread(()->{
                int result = 0;
                for(int j=0; j<10000; j++) result += j;
            });
        }

        for (int i = 0; i < threads.length; i++) {
            threads[i].start();
        }

        for (int i = 0; i < threads.length; i++) {
            try {
                threads[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("end join");
    }
}
