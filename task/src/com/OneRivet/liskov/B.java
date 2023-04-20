package com.OneRivet.liskov;

public class B extends A{

	public static void main(String[] args) {
		B b = new B();
		b.setHeight(2);
	}
	public void setWeight(double w) {
		super.setWeight(w);
		super.setHeight(w);
	}
	
	public void setHeight(double h) {
		super.setWeight(h);
		super.setHeight(h);
	}
}
