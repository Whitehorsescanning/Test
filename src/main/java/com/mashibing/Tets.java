package com.mashibing;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class Tets {
    synchronized void get(int i) {
        i++;
        AtomicInteger a = new AtomicInteger();
        a.set(1);
        a.getAndIncrement();

        System.out.println("ll");
    }
    public static void main(String[] args) {
        int i = 0;
        i=i++;
        System.out.println(i);
        i=++i;
        System.out.println(i);
        ConcurrentHashMap map = new ConcurrentHashMap();
        map.put("1", "msb");
    }
}
