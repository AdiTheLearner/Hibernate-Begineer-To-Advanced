package com.sap.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import com.sap.pojo.Employee;

public class Application {

	public static void main(String[] args) {
		SessionFactory sessionFactory=null;
		Session session = null ;
		Transaction transaction = null;
		try {
			Configuration config = new Configuration(); 
			config.addAnnotatedClass(com.sap.pojo.Employee.class);
			
			StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder();
			builder = builder.applySettings(config.getProperties());
			StandardServiceRegistry registry = builder.build();
			sessionFactory=config.buildSessionFactory(registry);
			session=sessionFactory.openSession();
			
			Employee emp = new Employee();
			emp.setEmployeeId(111);
			emp.setEmployeeName("Aditya");
			emp.setEmployeeSalary(25000.0f);
			
			transaction = session.beginTransaction();
			session.save(emp);
			transaction.commit();
			
			System.out.println("Employee Data Inserted");
		}
		catch(Exception e) {
			e.printStackTrace();
			transaction.rollback();
			System.out.println("Employee Data Insertion failure");
		}
		finally {
			session.close();
			sessionFactory.close();
		}

	}

}
