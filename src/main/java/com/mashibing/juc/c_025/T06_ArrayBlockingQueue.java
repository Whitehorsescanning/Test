package com.mashibing.juc.c_025;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

public class T06_ArrayBlockingQueue {
	// 相当于生产者消费者  ReentrantLock
	static BlockingQueue<String> strs = new ArrayBlockingQueue<>(10);

	static Random r = new Random();

	public static void main(String[] args) throws InterruptedException {
		for (int i = 0; i < 10; i++) {
			strs.put("a" + i);
		}
		
//		strs.put("aaa"); //满了就会等待，程序阻塞
		strs.add("aaa"); //满了会报错IllegalStateException: Queue full
//		boolean aaa = strs.offer("aaa");
//		strs.offer("aaa", 1, TimeUnit.SECONDS);
		
		System.out.println(strs);
	}
}
