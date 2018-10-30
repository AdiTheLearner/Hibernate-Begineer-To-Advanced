package com.sap.main;

import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import com.sap.pojo.Employee;

public class Application {

	public static void main(String[] args) throws Exception {
		Configuration cfg = new Configuration();
		cfg.addResource("Employee.hbm.xml");
		StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder();
		builder = builder.applySettings(cfg.getProperties());
		StandardServiceRegistry registry = builder.build();
		SessionFactory sessionFactory = cfg.buildSessionFactory(registry);
		org.hibernate.Session session = sessionFactory.openSession();
		Employee emp = new Employee();
		emp.setEmployeeName("aditya");
		emp.setEmployeeSalary(25333.3f);
		Transaction tx = session.beginTransaction();
		session.save(emp);
		tx.commit();
		System.out.println("Inserted");

	}

}
