package com.sap.service;

import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;

import com.sap.pojo.Employee;
import com.sap.util.EmployeeUtil;

public class EmployeeService {
	Employee employee;
	public Employee search(int eid) {
		try {
			SessionFactory sfg=EmployeeUtil.getSessionFactory();
			Session session=sfg.openSession();
			System.out.println(eid);
			employee=(Employee)session.get("com.sap.pojo.Employee",eid);	
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return employee;
	}
}
