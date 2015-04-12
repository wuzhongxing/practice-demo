package com.practice.thread15.demo;

import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.TimeoutException;

public class CyclicBarrierExample {
	// 多线程各自完成处理后，调用barrier.await()，准备运行CyclicBarrier中动作
	public static void main(String[] args) throws InterruptedException,
			BrokenBarrierException, TimeoutException {

		final int[] array = new int[2];
		CyclicBarrier barrier = new CyclicBarrier(2, new Runnable() {
			// 在所有线程都到达Barrier时执行
			public void run() {
				System.out.println("Total is:" + (array[0] + array[1]));
			}
		});

		// 启动线程
		new Thread(new ComponentThread(barrier, array, 0)).start();
		new Thread(new ComponentThread(barrier, array, 1)).start();
	}
}

class ComponentThread implements Runnable {

	CyclicBarrier barrier;
	int tid;
	int[] array;

	public ComponentThread(CyclicBarrier barrier, int[] array, int tid) {
		this.barrier = barrier;
		this.tid = tid;
		this.array = array;
	}

	public void run() {

		try {
			array[tid] = new Random().nextInt();
			System.out.println(tid + " generates:" + array[tid]);
			// 该线程完成了任务等在Barrier处
			barrier.await();
		} catch (BrokenBarrierException ex) {
			ex.printStackTrace();
		} catch (InterruptedException ex) {
			ex.printStackTrace();
		}
	}

}
