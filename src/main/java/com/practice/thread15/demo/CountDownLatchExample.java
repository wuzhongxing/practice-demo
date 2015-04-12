package com.practice.thread15.demo;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CountDownLatchExample {
	public static void main(String[] args) throws InterruptedException {
		// 初始化一个初始值为3的CountDownLatch,3次countDown后运行
		CountDownLatch latch = new CountDownLatch(3);

		// 起3个线程分别去启动3个组件
		ExecutorService service = Executors.newCachedThreadPool();
		service.submit(new ComponentThreadDemo(latch, 1));
		service.submit(new ComponentThreadDemo(latch, 2));
		service.submit(new ComponentThreadDemo(latch, 3));

		// 进入等待状态
		latch.await();
		// 当所需的三个组件都完成时，go on
		System.out.println("CountDownLatch finish.starting...");
		Thread.sleep(5000);
		// shut down
		service.shutdown();
	}
}

class ComponentThreadDemo implements Runnable {
	CountDownLatch latch;
	int tid;

	public ComponentThreadDemo(CountDownLatch latch, int tid) {
		this.latch = latch;
		this.tid = tid;
	}

	public void run() {
		System.out.println("thread " + tid + " initialized!");
		// 已完成初始化， 将计数减一，准备运行
		latch.countDown();
		System.out.println("Component " + tid + " processing...");
	}
}
