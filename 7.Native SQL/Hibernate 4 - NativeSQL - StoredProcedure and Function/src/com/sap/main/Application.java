package com.sap.main;

import java.util.List;

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
			System.out.println();
			System.out.println("Function Result");
			System.out.println("-------------------------");
			System.out.println();
			Query queryFunction = session.getNamedQuery("HQL_GET_ALL_EMPLOYEEDETAILS");
			List<Employee> list = queryFunction.list();
			for (Employee obj : list) {
				System.out.println("Employee details");
				System.out.println("-----------------");
				System.out.println("Employee Id:" + obj.getEmployeeId());
				System.out.println("Employee Name:" + obj.getEmployeeName());
				System.out.println("Employee Salary:" + obj.getEmployeeSalary());
			}

			System.out.println();
			System.out.println("Stored procedure Result");
			System.out.println("-------------------------");
			System.out.println();

			Query queryProcedure = session.getNamedQuery("HQL_GET_ALL_EMPLOYEES");
			queryProcedure.setFloat("sal", 100000000);
			List<Employee> list1 = queryProcedure.list();
			for (Employee obj : list1) {
				System.out.println("Employee details");
				System.out.println("-----------------");
				System.out.println("Employee Id:" + obj.getEmployeeId());
				System.out.println("Employee Name:" + obj.getEmployeeName());
				System.out.println("Employee Salary:" + obj.getEmployeeSalary());
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
			sessionFactory.close();
		}

	}

}
