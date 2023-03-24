package com.onerivet;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.onerivet.student.Student;

public class App {

	public static void main(String[] args) {
		System.out.println("Hello World!");

		ApplicationContext appContext = new ClassPathXmlApplicationContext(
				"/com/onerivet/configuration/configuration.xml");
// Setter method through
		Student bean = appContext.getBean("student", Student.class);
		try {
			System.out.println("\n From Setter Methods: ");
			System.out.println("Id: " + bean.getId());
			System.out.println("Name: " + bean.getName() + "\nEmail:  " + bean.getEmail() + "\nPassword: "
					+ bean.getPassword() + "\nAddress:  " + bean.getAdress());
		} catch (Throwable e) {
			e.printStackTrace();
		}
// Constructor through		
		Student conbean = appContext.getBean("constudent", Student.class);
		try {
			System.out.println("\n From Constructor: ");
			System.out.println("Id: " + conbean.getId());
			System.out.println("Name: " + conbean.getName() + "\nEmail:  " + conbean.getEmail() + "\nPassword: "
					+ conbean.getPassword() + "\nAddress:  " + conbean.getAdress());
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}
}
