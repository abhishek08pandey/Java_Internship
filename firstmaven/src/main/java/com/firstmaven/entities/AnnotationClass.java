package com.firstmaven.entities;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class AnnotationClass {

	public static void main(String[] args) {
		
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");	 	
		
		SessionFactory factory = cfg.buildSessionFactory();
		
		Student student = new Student();
		student.setId(1);
		student.setName("Abhishek");
		
		Session session = factory.openSession();
		
		Transaction tr = session.beginTransaction();
		
		session.save(student);
		tr.commit();
		session.close();

	}

}
