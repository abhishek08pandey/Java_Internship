package singletonDesignPattern;

public class EgerSingleton {

	private static final EgerSingleton egerSingleton = new EgerSingleton();
	
	private EgerSingleton() {
	}
	
	public static EgerSingleton getInstance() {
		return egerSingleton;
	}
	//ingleton classes are created for resources such as File System, Database connections, etc
	// Disadvantage : multiple thread can access
}
