package com.onerivet.subject.annotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Hindi implements Subject{

	@Autowired
	private Example example;

	public void setExample(Example example) {
		this.example=example;
	}
	
	
	public Hindi(Example example) {
		super();
		this.example = example;
	}


	public void subject() {
		System.out.println("\nHindi: "+ example);
	}
}
