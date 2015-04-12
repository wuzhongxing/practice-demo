package com.practice.thread15.demo;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

public class SemaphoreExample {

	List<String> pool = null;
	Semaphore pass = null;

	public SemaphoreExample(int size) {
		// 初始化资源池
		pool = new ArrayList<String>();
		for (int i = 0; i < size; i++) {
			pool.add("Resource " + i);
		}

		// Semaphore的大小和资源池的大小一致
		pass = new Semaphore(size);
	}

	public String get() throws InterruptedException {
		// 获取通行证,只有得到通行证后才能得到资源
		pass.acquire();
		return getResource();

	}

	public void put(String resource) {
		// 归还通行证，并归还资源
		pass.release();
		releaseResource(resource);

	}

	private synchronized String getResource() {
		String result = pool.get(0);
		pool.remove(0);
		System.out.println("Give out " + result);
		return result;
	}

	private synchronized void releaseResource(String resource) {
		System.out.println("return " + resource);
		pool.add(resource);
	}

	public static void main(String[] args) {
		final SemaphoreExample aPool = new SemaphoreExample(2);
		Runnable worker = new Runnable() {
			public void run() {
				String resource = null;
				try {
					// 取得resource
					resource = aPool.get();
				} catch (InterruptedException ex) {
					ex.printStackTrace();
				}

				try {
					// 用resource做工作
					System.out.println("I worked on " + resource);
					System.out.println("doing sth");
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}

				// 归还resource
				aPool.put(resource);
			}
		};

		ExecutorService service = Executors.newCachedThreadPool();
		for (int i = 0; i < 20; i++) {
			service.submit(worker);
		}
		service.shutdown();
	}
}