package com.sap.main;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.sap.pojo.Course;
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

			Course c1 = new Course();
		    c1.setCourseCost(100.0f);
		    c1.setCourseName("JAVA");
		    c1.setCourseId(123);
		    
		    Course c2 = new Course();
		    c2.setCourseCost(1000.0f);
		    c2.setCourseName(".NET");
		    c2.setCourseId(223);
		    
		    Set<Course> course = new HashSet<>();
		    course.add(c1);
		    course.add(c2);
		    
		    Student s1= new Student();
		    s1.setCourse(course);
		    s1.setStudentId(1);
		    s1.setStudentName("Aditya");

			mysql_tx = mysql_s.beginTransaction();
			mysql_s.save(s1);
			mysql_tx.commit();
			System.out.println("Data Inserted check select * from student_course");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			mysql_s.close();
			mysql_sf.close();

		}
	}

}
