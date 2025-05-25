package com.rahul.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.rahul.model.Student;
import com.rahul.repository.StudentRepository;

@Service
public class StudentService {
	
	private StudentRepository repository;

	public StudentService(StudentRepository repository) {
		super();
		this.repository = repository;
		repository.save(new Student(0,"Rahul","CSE","9876543210"));
		repository.save(new Student(0,"Shikha","Mechanical","9876543210"));
		repository.save(new Student(0,"Amit","IT","9876543210"));
		
	}

	public List<Student> getAllStudents() {
		//throw new ArithmeticException("This Is The Arithmetic Exception");
		return repository.findAll();
	}

	public void saveStudent(Student student) {
		repository.save(student);		
	}

	public Student getStudentByID(int id) {
		// TODO Auto-generated method stub
		return repository.findById(id).get();
	}

	
	public void removeStudent(int id) {
		repository.deleteById(id);
		
	}

}
