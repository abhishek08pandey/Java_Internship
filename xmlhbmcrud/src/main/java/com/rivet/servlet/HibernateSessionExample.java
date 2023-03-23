package com.rivet.servlet;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.StatelessSession;

import com.rivet.dao.SingleObject;

public class HibernateSessionExample  {

public static void main(String[] args) {
	SessionFactory sessionFactory = SingleObject.singalObject();
		
		//Current Session - no need to close
		Session currentSession = sessionFactory.getCurrentSession();
		System.out.println("from addmethod: " + currentSession);
		
		//open new session
		Session newSession = sessionFactory.openSession();
		//perform db operations
		System.out.println("from addmethod: " + newSession);
		//close session
		newSession.close();
		
		//open stateless session
		StatelessSession statelessSession = sessionFactory.openStatelessSession();
		//perform stateless db operations
		System.out.println("from addmethod: " + statelessSession);
		//close session
		statelessSession.close();
		
		//close session factory
		sessionFactory.close();
		
	}
}
