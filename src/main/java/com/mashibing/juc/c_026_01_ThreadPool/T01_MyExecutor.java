/**
 * 认识Executor
 */
package com.mashibing.juc.c_026_01_ThreadPool;

import java.util.TimerTask;
import java.util.concurrent.Executor;

public class T01_MyExecutor implements Executor{

	public static void main(String[] args) {
		new T01_MyExecutor().execute(()->System.out.println("hello executor"));
		TimerTask task = new TimerTask() {
			@Override
			public void run() {
				System.out.println("nihaoya!");
			}
		};
		Thread t = new Thread(task);
		t.start();

	}

	@Override
	public void execute(Runnable command) {
		//new Thread(command).run();
		command.run();
		
	}

}

