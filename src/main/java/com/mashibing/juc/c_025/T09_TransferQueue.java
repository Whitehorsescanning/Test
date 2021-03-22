package com.mashibing.juc.c_025;

import java.util.concurrent.LinkedTransferQueue;
import java.util.concurrent.TimeUnit;

public class T09_TransferQueue {
	public static void main(String[] args) throws InterruptedException {
		LinkedTransferQueue<String> strs = new LinkedTransferQueue<>();



		Thread t1 = new Thread(() -> {

			try {
				for (int i = 0; i < 10; i++) {
					System.out.println("take  "+i);;
					System.out.println(strs.take());

				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}


		},"t1");
		t1.start();

		for (int i = 0; i < 10; i++) {
			System.out.println(i);
			strs.transfer("aaa"+i);
			strs.transfer("aaa"+i);


		}



		//strs.put("aaa");


		/*new Thread(() -> {
			try {
				System.out.println(strs.take());
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}).start();*/


	}
}
