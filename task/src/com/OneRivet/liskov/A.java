package com.OneRivet.liskov;

public class A {


	private  double weight;

	private double height;
	
	public void setWeight(double w) {
		weight=w;
		
		System.out.println(w);
		System.out.println(weight);
	}
	
	public void setHeight(double h) {
		
		System.out.println(h);
		System.out.println(height);
		
		height=h;
		
	}
}
