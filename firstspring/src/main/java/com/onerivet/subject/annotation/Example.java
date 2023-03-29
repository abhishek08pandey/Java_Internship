package com.onerivet.subject.annotation;

import org.springframework.stereotype.Component;

@Component
public class Example {

	private String example;

	public String getExample() {
		return example;
	}

	public void setExample(String example) {
		this.example = example;
	}

	@Override
	public String toString() {
		return "Example [example=" + "jitendra" + "]";
	}

	 

	 
	
	
}
