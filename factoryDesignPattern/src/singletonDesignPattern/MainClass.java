package singletonDesignPattern;

public class MainClass {
	
	
	public static void main(String[] args) {
		
		SingleObject object = SingleObject.getInstance();
		
		System.out.println(object);
		
		object.massage();
		
		SingleObject object2 = SingleObject.getInstance();
		System.out.println(object2);
}
}
