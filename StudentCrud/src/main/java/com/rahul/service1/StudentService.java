package com.rahul.service1;

import java.util.List;

import org.springframework.stereotype.Service;

import com.rahul.aop.TrackTime;
import com.rahul.model.Student;
import com.rahul.repository.StudentRepository;

@Service
public class StudentService {

	private StudentRepository repository;

	public StudentService(StudentRepository repository) {
		super();
		this.repository = repository;
		repository.save(new Student(101, "Rahul", "rahul@gmail.com"));
		repository.save(new Student(102, "Shikha", "shikha@gmail.com"));
		repository.save(new Student(103, "Atul", "atul@gmail.com"));
		repository.save(new Student(104, "Janvi", "janvi@gmail.com"));
	}
	@TrackTime
	public List<Student> getAllStudent() {

		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		List<Student> students = repository.findAll();

		return students;
	}

	public void saveStudent(Student student) {
		repository.save(student);
	}

	
	public Student getStudentById(int id) {

		return repository.findById(id).get();
	}

	public void deleteStudentById(int id) {
		// TODO Auto-generated method stub
		repository.deleteById(id);
	}
}
