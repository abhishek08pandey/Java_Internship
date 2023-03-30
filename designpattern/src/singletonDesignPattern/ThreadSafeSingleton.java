package singletonDesignPattern;

public class ThreadSafeSingleton {

	private static ThreadSafeSingleton threadSafeSingleton;
	
	private ThreadSafeSingleton() {}
	
	public static  ThreadSafeSingleton getInstance() {
		if(threadSafeSingleton==null) {
			threadSafeSingleton= new ThreadSafeSingleton();
			

			for (int i = 0; i < 100; i++) {
				System.out.println("synchronized");
			}
		}
		return threadSafeSingleton;
	}// synchronied method through only one instance will created
	//and we archived thread safe single ton class

	public static ThreadSafeSingleton getInstance2() {
		if(threadSafeSingleton==null) {
			threadSafeSingleton= new ThreadSafeSingleton();
			
			for (int i = 0; i < 100; i++) {
				System.out.println("without synchronized");
			}
		}
		return threadSafeSingleton;
	}
	
//	public static ThreadSafeSingleton getInstanceDoubleCheck() {
//	    if (threadSafeSingleton == null) {
//	        synchronized (ThreadSafeSingleton.class) {
//	            if (threadSafeSingleton == null) {
//	            	threadSafeSingleton = new ThreadSafeSingleton();
//	            }
//	        }
//	    }
//	    return threadSafeSingleton;
//	}

}
