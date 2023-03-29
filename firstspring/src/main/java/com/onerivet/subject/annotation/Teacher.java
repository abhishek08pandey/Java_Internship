package com.onerivet.subject.annotation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Teacher {

	public static void main(String[] args) {
		
		ApplicationContext appContext = new ClassPathXmlApplicationContext(
				"/com/onerivet/configuration/configuration.xml");
		
		Subject subject = (Subject)appContext.getBean("hindi");
		System.out.print(subject);
		subject.subject();
	}
}
