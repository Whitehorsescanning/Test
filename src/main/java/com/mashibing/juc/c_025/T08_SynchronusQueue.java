package com.mashibing.juc.c_025;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TimeUnit;

public class T08_SynchronusQueue { //容量为0
	public static void main(String[] args) throws InterruptedException {
		BlockingQueue<String> strs = new SynchronousQueue<>();

	 	Thread t = new Thread(()->{
			try {
				TimeUnit.SECONDS.sleep(1);

				System.out.println(strs.take());
				strs.put("bbb");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
	 	});
	 	t.start();
		strs.put("aaa"); //阻塞等待消费者消费

		System.out.println(strs.take()+"---");
		//strs.put("bbb");
		//strs.add("aaa");
		System.out.println(strs.size());
	}
}
