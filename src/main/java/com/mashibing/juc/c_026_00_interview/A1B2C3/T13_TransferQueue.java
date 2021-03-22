package com.mashibing.juc.c_026_00_interview.A1B2C3;

import java.util.concurrent.LinkedTransferQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TransferQueue;

public class T13_TransferQueue {
    public static void main(String[] args) {
        char[] aI = "1234567".toCharArray();
        char[] aC = "ABCDEFG".toCharArray();

        SynchronousQueue<Character> queue = new SynchronousQueue<Character>();
        new Thread(()->{
            try {
                for (char c : aI) {
                    System.out.print(queue.take());
                    queue.put(c);
                }

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "t1").start();

        new Thread(()->{
            try {
                for (char c : aC) {
                    queue.put(c);
                    System.out.print(queue.take());
                }

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "t2").start();
    }
}
