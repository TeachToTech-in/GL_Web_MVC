package com.gl.rahul;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {
	@Autowired
	private StudentJpaRepository repository;

	public List<Student> allStudents() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}

	public Student retrieveById(int id) {
		// TODO Auto-generated method stub
		return repository.findById(id).get();
	}

	public List<Student> retrieveByBranch(String branch) {
		return repository.findAllByBranch(branch);
	}

	public Student createStudent(Student student) {
		// TODO Auto-generated method stub
		return repository.save(student);
	}

	public void deleteById(int id) {
		repository.deleteById(id);
		
	}


	
	
}
