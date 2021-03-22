package com.mashibing.juc.c_020;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;

public class T13_TestLockSupport {
    public static void main(String[] args) {
        Thread t = new Thread(()->{
            for (int i = 0; i < 10; i++) {
                System.out.println(i);
                if(i == 5) {
//                  暂停当前线程
                    LockSupport.park();
                }
                try {
                    TimeUnit.MILLISECONDS.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        t.start();
        LockSupport.unpark(t);


//        LockSupport.unpark(t);
/*
        try {
//            t.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
*/


        /*try {
            TimeUnit.SECONDS.sleep(8);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("after 8 senconds!");

        LockSupport.unpark(t);*/

    }
}
