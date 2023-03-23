package com.rivet.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.StatelessSession;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.rivet.student.Student;

public class DAOServiceImpl {
// Global variable Secure with private access specifier
// It will follow the hibernate.cfg.xml  file
	// private static Configuration configuration = new
	// Configuration().configure("hibernate.cfg.xml");

//it is global variable and & only one which is used in all method
	// private static SessionFactory factory = configuration.buildSessionFactory();

// Create
	public static void addStudent(Student user) {
		try {
// Call singleObject class and get single SessionFactory Object		
			SessionFactory factory = SingleObject.singalObject();
			System.out.println("from addmethod: " + factory);
			
			Session currentSession = factory.getCurrentSession();
			System.out.println("from currentSession: "+ currentSession);
			
			Session session = factory.openSession();
			System.out.println("from openSession: "+ session);
			
			StatelessSession openStatelessSession = factory.openStatelessSession();
			System.out.println(" from openStatelessSession:  "+openStatelessSession);
			
			Transaction transaction = session.beginTransaction();
			SessionFactory sessionFactory = session.getSessionFactory();
			

			session.save(user);
			transaction.commit();
			session.close();

		} catch (Exception e) {
			System.out.println("exception in addStudent method");
			e.printStackTrace();
		}
	}

// Read 
	public static List getList() {
		try {
			SessionFactory factory = SingleObject.singalObject();
			System.out.println("from list method: " + factory);
			Session session = factory.openSession();
			Transaction transaction = session.beginTransaction();

			List<Student> list = session.createQuery("from Student").getResultList();
			transaction.commit();
			session.close();
			return list;
		} catch (Exception e) {
			System.out.println("exception in getList method");
			e.printStackTrace();
			return null;
		}
	}

// Read One Id details
	public static Student getIdDetails(int id) {
		try {
			SessionFactory factory = SingleObject.singalObject();
			System.out.println("from getIdDetails method: " + factory);
			Session session = factory.openSession();
			Transaction transaction = session.beginTransaction();

			Student student = session.get(Student.class, id);
			return student;
		} catch (Exception e) {
			System.out.println("exception in getIdDetails method");
			e.printStackTrace();
			return null;
		}
	}

// Update
	public static void update(Student student) {
		try {
			SessionFactory factory = SingleObject.singalObject();
			System.out.println("from update method: " + factory);
			Session session = factory.openSession();
			Transaction transaction = session.beginTransaction();

			session.update(student);
			transaction.commit();
			session.close();
			
		} catch (Exception e) {
			System.out.println("exception in update method");
			e.printStackTrace();
		}
	}

// Delete
	public static void deleteById(int id) {
		try {
			SessionFactory factory = SingleObject.singalObject();
			System.out.println("from deleteById method: " + factory);
			Session session = factory.openSession();
			Transaction transaction = session.beginTransaction();

			Student student = session.get(Student.class, id);
			session.delete(student);

			transaction.commit();
			session.close();
		} catch (Exception e) {
			System.out.println("exception in update method");
			e.printStackTrace();
		}
	}
}
