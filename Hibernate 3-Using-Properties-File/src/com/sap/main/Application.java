package com.sap.main;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;

import com.sap.pojo.Employee;

public class Application {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SessionFactory sessionFactory = null;
		Session session = null;
		try {
			Configuration cfg = new Configuration();
			cfg.addAnnotatedClass(com.sap.pojo.Employee.class);
			sessionFactory = cfg.buildSessionFactory();
			session = sessionFactory.openSession();
			Employee emp = (Employee)session.get("com.sap.pojo.Employee", 111);
			if (emp == null) {
				System.out.println("Employee not existed");

			} else {
				System.out.println("Employee details");
				System.out.println("-----------------");
				System.out.println("Employee Id:" + emp.getEmployeeId());
				System.out.println("Employee Name:" + emp.getEmployeeName());
				System.out.println("Employee Salary:" + emp.getEmployeeSalary());
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			
			session.close();
			sessionFactory.close();
		}

	}

}
