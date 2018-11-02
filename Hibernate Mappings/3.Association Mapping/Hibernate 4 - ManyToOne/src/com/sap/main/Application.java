package com.sap.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import com.sap.pojo.Branch;
import com.sap.pojo.Student;
import com.sap.util.HibernateUtil;

public class Application {

	public static void main(String[] args) {

		SessionFactory mysql_sf = null;
		Session mysql_s = null;
		Transaction mysql_tx = null;

		try {

			mysql_sf = HibernateUtil.getSessionFactory();
			mysql_s = mysql_sf.openSession();

			Branch branch = new Branch();
			branch.setBranchId(111);
			branch.setBranchName("MS");
			Student student = new Student();
			student.setStudentId(1);
			student.setStudentName("Aditya");
			student.setBranch(branch);

			mysql_tx = mysql_s.beginTransaction();
			mysql_s.save(student);
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
