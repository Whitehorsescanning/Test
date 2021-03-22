package com.mashibing.juc.c_020;

import java.awt.*;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;

public class TowThread {
    static ArrayList<String> list = new ArrayList<String>();

    public static void main(String[] args) {
        Thread t = new Thread(()->{
            for (int i = 0; i < 10; i++) {
                list.add(""+i);
                System.out.println(i);
                LockSupport.park();
            }
        });
        t.start();
        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                System.out.println("t2  "+i);
                if (i == 5){
                    System.out.println("Ìí¼ÓÁË5¸ö");
                }
                LockSupport.unpark(t);

                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
