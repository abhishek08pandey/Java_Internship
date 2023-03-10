package com.OneRivet.thread;

class Yields extends Thread{// public static void yield() 
	public void run() {
	for (int j = 0; j < 5; ++j) {
        Thread.yield();// By calling this method, MyThread stop its execution and giving a chance to a main thread
        System.out.println("Thread started:" + Thread.currentThread().getName());
     }
     System.out.println("Thread ended:" + Thread.currentThread().getName());
}
}

public class ThreadYieldMethod1 {

	public static void main(String[] args) throws InterruptedException {
		
		Yields yield = new Yields();
		yield.yield();//
		yield.start();
		
		
		//System.out.println("main Method Thread: " + Thread.getAllStackTraces());
		System.out.println(Thread.currentThread().getState());
		//Thread.sleep(5000);
		
		for (int i = 0; i < 5; ++i) {
			System.out.println("For loop Main thread : "+Thread.currentThread().getName());
		}
		System.out.println(Thread.currentThread().getName() + " :Method");
	}

}

