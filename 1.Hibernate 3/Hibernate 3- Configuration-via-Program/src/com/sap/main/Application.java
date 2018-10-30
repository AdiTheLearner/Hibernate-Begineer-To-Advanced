package com.sap.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.sap.pojo.Employee;

public class Application {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Configuration cfg = new Configuration();
		cfg.setProperty("hibernate.connection.driver_class", "com.mysql.cj.jdbc.Driver");
		cfg.setProperty("hibernate.connection.url", "jdbc:mysql://localhost:3307/db1");
		cfg.setProperty("hibernate.connection.user", "root");
		cfg.setProperty("hibernate.connection.password", "root");
		cfg.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
		cfg.addAnnotatedClass(com.sap.pojo.Employee.class);
		SessionFactory sf = null;
		Session s = null;
		try {
			sf = cfg.buildSessionFactory();
			s = sf.openSession();
			Transaction t = s.beginTransaction();
			Employee emp = new Employee();
			emp.setEmployeeId(333);
			emp.setEmployeeName("Varun");
			emp.setEmployeeSalary(100000.0f);
			s.save(emp);
			t.commit();
			System.out.println("Inserted/Updated Succesfully");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			s.close();
			sf.close();
		}

	}

}
