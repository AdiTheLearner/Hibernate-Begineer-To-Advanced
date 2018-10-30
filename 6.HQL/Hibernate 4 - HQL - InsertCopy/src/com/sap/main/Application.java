package com.sap.main;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;


public class Application {

	public static void main(String[] args) {
		Configuration cfg = new Configuration();
		cfg.addAnnotatedClass(com.sap.pojo.Employee1.class);
		cfg.addAnnotatedClass(com.sap.pojo.Employee2.class);
		StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder();
		builder = builder.applySettings(cfg.getProperties());
		StandardServiceRegistry registry = builder.build();
		SessionFactory sessionFactory = cfg.buildSessionFactory(registry);
		org.hibernate.Session session = sessionFactory.openSession();
		
		Query query = session.createQuery("insert into Employee1(employeeId,employeeName,employeeSalary)select e.employeeId,e.employeeName,e.employeeSalary from Employee2 as e ");
		Transaction tx=session.beginTransaction();
		int rowcount=query.executeUpdate();
		tx.commit();
		System.out.println("Employee Details are tarsnafered from Employee 2 to Employee1");
		session.close();
		sessionFactory.close();
	}

}
