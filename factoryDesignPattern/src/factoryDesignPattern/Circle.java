package factoryDesignPattern;

import singletonDesignPattern.SingleObject;

public class Circle implements Shape {

	@Override
	public void draw() {
		System.out.println("Draw Circle");
		
	}
//
//	public static void main(String[] args) {
//		SingleObject object = new SingleObject();
//		object.massage();
//		SingleObject instance = object.getInstance();
//		
//		System.out.println(instance);
//	}
}
