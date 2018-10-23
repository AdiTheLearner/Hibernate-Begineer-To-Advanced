package com.sap.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.sap.pojo.Employee;
import com.sap.util.EmployeeUtil;

public class ApplicationRetrieve {

	public static void main(String[] args) {
		try {
			SessionFactory sf=EmployeeUtil.getSessionFactory();
			Session s=sf.openSession();
			Transaction ts=s.beginTransaction();
			Employee emp=(Employee)s.get(com.sap.pojo.Employee.class, 111);
			if(emp==null) {
				System.out.println("Employee Doesnot Exists");
			}
			else {
				System.out.println("Employee Details");
				System.out.println("--------------------");
				System.out.println("Employee Id:"+emp.getEmployeeId());
				System.out.println("Employee Name:"+emp.getEmployeeName());
				System.out.println("Employee Salary:"+emp.getEmployeeSalary());
			}
			ts.commit();	
				
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}

}
