package singletonDesignPattern;

public class SingleObject {

	private static SingleObject singleObject = new SingleObject();
	
	public SingleObject(){
	}
	
	public static SingleObject getInstance() {
		return singleObject;
	}
	
	public void massage() {
		System.out.println("hello world");
	}
}
