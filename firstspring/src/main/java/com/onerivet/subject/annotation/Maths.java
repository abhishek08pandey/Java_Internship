package com.onerivet.subject.annotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Maths implements Subject {

	@Autowired
	private Example example;

	public Example getExample() {
		return example;
	}
	public void setExample(Example example) {
		this.example = example;
	}

	public void subject() {
		System.out.println("\nMaths  " + example);

	}

}
