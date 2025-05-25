package com.rahul;

public class Course {
	private int id;
	private String course;
	private String department;

	public Course() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Course(int id, String course, String department) {
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

}
