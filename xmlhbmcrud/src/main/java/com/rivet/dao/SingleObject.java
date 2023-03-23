package com.rivet.dao;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class SingleObject {

	private static Configuration configuration = new Configuration().configure("hibernate.cfg.xml");
	private static SessionFactory factory;
	
	private SingleObject() {
	}
	
	public static SessionFactory singalObject() {
		
		if(factory==null) {
			factory = configuration.buildSessionFactory();
		}else {
			
		}
		
		return factory;
	}
}
