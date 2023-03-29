package singletonDesignPattern;

public class MainClass {
	
	
	public static void main(String[] args) {
		
		SingleObject object = SingleObject.getInstance();
		
		System.out.println("1st object: "+object);
		
		object.massage();
		
		SingleObject object2 = SingleObject.getInstance();
		System.out.println("2nd object: "+object2);
}
}
