package com.firstmaven.firstmaven;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.firstmaven.entities.Student;

public class App {
	public static void main(String[] args) {
		System.out.println("Hello World!");
	
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");	 	
		
		SessionFactory factory = cfg.buildSessionFactory();
		
//		Student student = new Student();
//		student.setId(1);
//		student.setName("Abhishek");
		
		Session session = factory.openSession();
		
		Transaction tr = session.beginTransaction();
		
		//session.save(student);
		tr.commit();
		session.close();
	}
}	
