package singletonDesignPattern;

public class MainClass {
	
	
	public static void main(String[] args) {
// EgerSingleton initialization	
		EgerSingleton egerSingleton1 = EgerSingleton.getInstance();
		System.out.println("1st Instance: "+egerSingleton1);
		
		EgerSingleton egerSingleton2 = EgerSingleton.getInstance();
		System.out.println("2nd Instance: "+egerSingleton2);

// LazyInitializationb 
		LazyInitialization lazyInitialization1 = LazyInitialization.getInstance();
		System.out.println("1st Instance: "+lazyInitialization1);
		
		LazyInitialization lazyInitialization2 = LazyInitialization.getInstance();
		System.out.println("2nd Instance: "+lazyInitialization2);
		
// StaticBlockInitialization
		StaticBlockInitialization staticBlockInitialization1 = StaticBlockInitialization.getInstance();
		System.out.println("1st Instance: "+staticBlockInitialization1);
		
		StaticBlockInitialization staticBlockInitialization2 = StaticBlockInitialization.getInstance();
		System.out.println("2nd Instance: "+staticBlockInitialization2);

//ThreadSafeSingleton
		ThreadSafeSingleton threadSafeSingleton = ThreadSafeSingleton.getInstance();
		System.out.println("1st Instance: "+threadSafeSingleton);
		
		ThreadSafeSingleton threadSafeSingleton2 = ThreadSafeSingleton.getInstance2();
		System.out.println("1st Instance: "+threadSafeSingleton2);
		
//		ThreadSafeSingleton threadSafeSingletonDoubleCheck = ThreadSafeSingleton.getInstanceDoubleCheck();
//		System.out.println("1st Instance: "+lthreadSafeSingletonDoubleCheck);
		
	}
}
