package com.sap.main;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.sap.pojo.Department;
import com.sap.pojo.Employee;
import com.sap.util.HibernateUtil;

public class Application {

	public static void main(String[] args) {

		SessionFactory mysql_sf = null;
		Session mysql_s = null;
		Transaction mysql_tx = null;

		try {

			mysql_sf = HibernateUtil.getSessionFactory();
			mysql_s = mysql_sf.openSession();

			Employee e1 = new Employee(111, "aditya", 5000.0f);
			Employee e2 = new Employee(222, "aditya", 5000.0f);
			Employee e3 = new Employee(333, "aditya", 5000.0f);
			Set<Employee> emps = new HashSet();
			emps.add(e1);
			emps.add(e2);
			emps.add(e3);

			Department dep = new Department();
			dep.setDid("111");
			dep.setDname("DEV");
			dep.setEmps(emps);

			mysql_tx = mysql_s.beginTransaction();
			mysql_s.save(dep);
			mysql_tx.commit();
			System.out.println("Data Inserted");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			mysql_s.close();
			mysql_sf.close();

		}
	}

}
