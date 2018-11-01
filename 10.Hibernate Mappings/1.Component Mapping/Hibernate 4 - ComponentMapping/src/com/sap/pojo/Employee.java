package com.sap.pojo;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.NamedNativeQueries;
import org.hibernate.annotations.NamedNativeQuery;

@Entity
@Table(name = "Employee")
public class Employee {

	@Id
	@Column(name = "employeeId")
	private int employeeId;
	@Column(name = "employeeName")
	private String employeeName;
	@Column(name = "employeeSalary")
	private float employeeSalary;
	@Embedded
	private Account account;

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

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
