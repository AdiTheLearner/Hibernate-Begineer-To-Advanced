package com.sap.main;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Filter;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
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
			Query query = session.createQuery("from Employee");
			Filter filter = session.enableFilter("employeeFilter");
			Scanner sc = new Scanner(System.in);
			System.out.println("Enter Employee Type");
			System.out.println("Enter Any of one option in CAPS ");
			System.out.println("1.PERM");
			System.out.println("2.TEMP");
			String etype =  sc.next();
			filter.setParameter("type", etype);
			List<Employee> list = query.list();
			for (Employee emp : list) {
				System.out.println("Employee details");
				System.out.println("-----------------");
				System.out.println("Employee Id:" + emp.getEmployeeId());
				System.out.println("Employee Name:" + emp.getEmployeeName());
				System.out.println("Employee Salary:" + emp.getEmployeeSalary());
				System.out.println("Employee type:" + emp.getEtype());
			}
			session.disableFilter("employeeFilter");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
			sessionFactory.close();
		}

	}

}
