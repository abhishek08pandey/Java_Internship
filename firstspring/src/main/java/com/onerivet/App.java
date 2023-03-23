package com.onerivet;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.onerivet.student.Student;

public class App {

	public static void main(String[] args) {
		System.out.println("Hello World!");

		ApplicationContext appContext = new ClassPathXmlApplicationContext(
				"/com/onerivet/configuration/configuration.xml");

		Student bean = appContext.getBean("student", Student.class);

		System.out.println(bean.getId());
		System.out.println(bean.getName() + " " + bean.getEmail() + " " + bean.getPassword() + " " + bean.getAdress());

		//Rambo08 abhi@gmail.com 1223 Adress [adress=valsad]
	}
}
