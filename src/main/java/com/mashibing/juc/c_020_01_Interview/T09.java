package com.mashibing.juc.c_020_01_Interview;

import java.sql.ClientInfoStatus;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class T09 {
    static/* volatile*/ List list = new ArrayList();

    public synchronized void add(Object o) {
        list.add(o);
    }

    public synchronized int getSize() {
        return list.size();
    }
    static T09 t = new T09();

    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(1);


        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    semaphore.acquire();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                t.add(new Object());
                System.out.println("t1  "+i);
                if (t.getSize() != 5) {
                   semaphore.release();
                }
            }
        }).start();
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        new Thread(() -> {
            System.out.println("55555555555555555");
            semaphore.release();

        }).start();
    }
}
