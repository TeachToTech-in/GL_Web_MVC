package com.rahul;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties("course-service")
public class CourseConfiguration {
	private int id;
	private String course;
	private String department;

	public CourseConfiguration() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CourseConfiguration(int id, String course, String department) {
		super();
		this.id = id;
		this.course = course;
		this.department = department;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCourse() {
		return course;
	}

	public void setCourse(String course) {
		this.course = course;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	@Override
	public String toString() {
		return "Course [id=" + id + ", course=" + course + ", department=" + department + "]";
	}

}
