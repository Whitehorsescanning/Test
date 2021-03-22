package com.mashibing.juc.c_020;

import java.io.UnsupportedEncodingException;
import java.util.concurrent.atomic.AtomicInteger;

public class TestAu {
    public static void main(String[] args) throws InterruptedException {
      String str = "ÀîÄþ";
        try {
            byte[] bytes = str.getBytes("utf-8");
            str = new String(bytes,"utf-8");
        } catch (UnsupportedEncodingException e) {

            e.printStackTrace();
        }
        System.out.println(str);

    }
}

class Au implements Runnable {
    AtomicInteger ai = new AtomicInteger(1);
    @Override
    public void run() {
        while (ai.get() == 1){

        }
    }
}
