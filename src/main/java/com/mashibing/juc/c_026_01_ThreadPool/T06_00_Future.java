/**
 * 认识future
 * 异步
 */
package com.mashibing.juc.c_026_01_ThreadPool;

import java.util.List;
import java.util.concurrent.*;

public class T06_00_Future {
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		// FutureTask  -> Future + Runnbale;
		// Callable -> Runnable + Retrieves(返回值)
		FutureTask<Integer> task = new FutureTask<>(()->{
			TimeUnit.MILLISECONDS.sleep(500);
			return 1000;
		});
		//new Callable () { Integer call();}

		new Thread(task).start();
		//阻塞
		System.out.println(task.get());
		ExecutorService service = Executors.newFixedThreadPool(5);
		Future<Integer> f = service.submit(()->{
			return 1;
		});
		System.out.println(f.get());
		System.out.println(f.isDone());
		Thread thread = new Thread(null, task, "fgds", 0, false);
	}
}
