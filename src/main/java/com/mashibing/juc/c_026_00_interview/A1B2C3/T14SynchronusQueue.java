package com.mashibing.juc.c_026_00_interview.A1B2C3;

import java.util.concurrent.SynchronousQueue;

/**
 * @author Lenovo
 * @date 2021/3/24 10:30
 */
public class T14SynchronusQueue {
    public static void main(String[] args) {
        SynchronousQueue<String> queue = new SynchronousQueue<>();
        String[] strings1 = {"A", "B", "C", "D", "E"};
        String[] strings2 = {"1", "2", "3", "4", "5"};
        new Thread(() -> {
            for (int i = 0; i < strings1.length; i++) {
                try {
                    queue.put(strings1[i]);
                    System.out.println(queue.take());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
        for (int i = 0; i < strings2.length; i++) {
            try {
                System.out.println(queue.take());
                queue.put(strings2[i]);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
