package com.sap.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import com.sap.pojo.Employee;
import com.sap.util.HibernateUtil;

public class Application {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SessionFactory sessionFactory = null;
		Session session = null;
		try {
			sessionFactory = HibernateUtil.getSessionFactory();
			session = sessionFactory.openSession();
			Employee emp = (Employee)session.get(com.sap.pojo.Employee.class, 222);
			if (emp == null) {
				System.out.println("Employee Doesn't exists");
			} else {
				System.out.println("Employee details");
				System.out.println("-----------------");
				System.out.println("Employee Id:" + emp.getEmployeeId());
				System.out.println("Employee Id:" + emp.getEmployeeName());
				System.out.println("Employee Id:" + emp.getEmployeeSalary());
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
			sessionFactory.close();
		}

	}

}
