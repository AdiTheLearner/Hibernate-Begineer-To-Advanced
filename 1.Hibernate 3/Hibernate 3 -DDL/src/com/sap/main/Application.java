package com.sap.main;

import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;

import com.sap.pojo.Student;

public class Application {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Configuration configuration = new Configuration();
		configuration.addAnnotatedClass(com.sap.pojo.Student.class);
		SessionFactory sessionFactory = configuration.buildSessionFactory();
		Session session = sessionFactory.openSession();
		Student student = new Student();
		student.setStudentId(111);
		student.setStudentName("Aditya");
		Transaction transaction = session.beginTransaction();
		session.save(student);
		System.out.println("Table created and Inserted");
		transaction.commit();
		session.close();
		sessionFactory.close();

	}

}
