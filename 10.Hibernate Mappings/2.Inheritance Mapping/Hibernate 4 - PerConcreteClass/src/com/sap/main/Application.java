package com.sap.main;

import java.util.Scanner;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import com.sap.pojo.Customer;
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
			Scanner sc = new Scanner(System.in);
			System.out.println("Insertion");
			System.out.println("Enter Person Name");
			String name = sc.next();
			sc.nextLine();
			System.out.println("Enter Employee Id");
			int id = sc.nextInt();
			System.out.println("Enter Employee Salary");
			float sal = sc.nextFloat();
			
			System.out.println("Enter Customer Id");
			int id1= sc.nextInt();
			System.out.println("Enter Customer Mobile");
			int mobile1 = sc.nextInt();
			sc.nextLine();

			insertCustomer(name, id1, mobile1, session);
			insertEmployee(name, id, sal, session);

			System.out.println("Employee Insertion Succesfull");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
			sessionFactory.close();
		}

	}

	public static void insertEmployee(String person, int employeeId, float employeeSalary, Session session) {
		session.beginTransaction();

		Employee emp = new Employee();

		emp.setPersonName(person);
		emp.setEmployeeId(employeeId);
		emp.setEmployeeSalary(employeeSalary);
		session.save(emp);
		session.clear();

		session.getTransaction().commit();
	}

	public static void insertCustomer(String person, int customerId, int customerMobile, Session session) {

		session.beginTransaction();

		Customer customer = new Customer();
		customer.setPersonName(person);
		customer.setCustomerId(customerId);
		customer.setCustomerMobile(customerMobile);

		session.save(customer);
		session.clear();
		session.getTransaction().commit();
	}

}