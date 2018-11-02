package com.sap.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.sap.pojo.Account;
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

			Account acc = new Account();
			acc.setAccountBalance(1000.0f);
			acc.setAccountName("Aditya");
			acc.setAccountNo(1111);

			Employee emp = new Employee();
			emp.setEmployeeId(123);
			emp.setEmployeeName("Aditya");
			emp.setEmployeeSalary(25000.0f);
			emp.setAcc(acc);

			mysql_tx = mysql_s.beginTransaction();
			mysql_s.save(emp);
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
