package com.rivet.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.rivet.student.Student;

public class DAOServiceImpl {
// Global variable Secure with private access specifier
	private static Configuration configuration = new Configuration().configure("hibernate.cfg.xml");
	private static SessionFactory factory = configuration.buildSessionFactory();

// Create
	public static void addStudent(Student user) {
		try {
			Session session = factory.openSession();
			Transaction transaction = session.beginTransaction();

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

		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();

		List<Student> list = session.createQuery("from Student").getResultList();
		transaction.commit();
		session.close();
		return list;

	}
// Read One Id details
	public static Student getIdDetails(int id) {

		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();

		Student student = session.get(Student.class, id);

		return student;
	}
// Update
	public static void update(Student student) {

		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();

		session.update(student);
		transaction.commit();
		session.close();

	}
// Delete
	public static void deleteById(int id) {

		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();

		Student student = session.get(Student.class, id);
		session.delete(student);

		transaction.commit();
		session.close();
	}
}
