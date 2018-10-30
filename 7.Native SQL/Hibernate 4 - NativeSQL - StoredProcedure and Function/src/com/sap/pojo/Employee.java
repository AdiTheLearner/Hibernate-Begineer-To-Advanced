package com.sap.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.NamedNativeQueries;
import org.hibernate.annotations.NamedNativeQuery;

@Entity
@Table(name = "Employee")
//stored Procedure
@NamedNativeQueries({
@NamedNativeQuery(name = "HQL_GET_ALL_EMPLOYEES",callable=true,query="{call getEmployees(?,:sal)}",resultClass = Employee.class),
//function
@NamedNativeQuery(name = "HQL_GET_ALL_EMPLOYEEDETAILS",callable=true,query="{?=call getEmployeeDetails}",resultClass = Employee.class)
//callable= true , tell Hibernate that this query calls a database function or stored procedure
})
public class Employee {

	@Id
	@Column(name = "employeeId")
	private int employeeId;
	@Column(name = "employeeName")
	private String employeeName;
	@Column(name = "employeeSalary")
	private float employeeSalary;

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String empName) {
		this.employeeName = empName;
	}

	public float getEmployeeSalary() {
		return employeeSalary;
	}

	public void setEmployeeSalary(float employeeSalary) {
		this.employeeSalary = employeeSalary;
	}

}
