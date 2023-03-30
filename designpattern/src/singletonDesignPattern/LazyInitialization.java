package singletonDesignPattern;

public class LazyInitialization {

	private static LazyInitialization lazyInitialization;
	
	private LazyInitialization() {
	}
	public static LazyInitialization getInstance() {
		if(lazyInitialization==null) {
			lazyInitialization = new LazyInitialization();
		}
		return lazyInitialization;
	}// Here first class loaded and than method call by client than check that instance is null, if yes than it should be initialize
	// It is ok for only one thread but not working for multiple thread
}
