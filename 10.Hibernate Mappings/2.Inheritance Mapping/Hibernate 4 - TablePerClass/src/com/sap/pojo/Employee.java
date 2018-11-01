package com.sap.pojo;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@DiscriminatorValue(value = "employee")
@Table(name="Account")
public class Employee extends Account {
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

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public float getEmployeeSalary() {
		return employeeSalary;
	}

	public void setEmployeeSalary(float employeeSalary) {
		this.employeeSalary = employeeSalary;
	}

}
