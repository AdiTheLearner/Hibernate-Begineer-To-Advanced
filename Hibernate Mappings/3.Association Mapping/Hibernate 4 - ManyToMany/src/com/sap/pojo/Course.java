package com.sap.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Course")
public class Course {
	@Id
	@Column(name="courseId")
	private int courseId;
	@Column(name="courseName")
	private String courseName;
	@Column(name="Coursecost")
	private float courseCost;
	public int getCourseId() {
		return courseId;
	}
	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public float getCourseCost() {
		return courseCost;
	}
	public void setCourseCost(float courseCost) {
		this.courseCost = courseCost;
	}

}
