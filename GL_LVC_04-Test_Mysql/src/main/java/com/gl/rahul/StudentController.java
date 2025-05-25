package com.gl.rahul;

import java.net.URI;
import java.util.List;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
//@Controller
public class StudentController {
	@Autowired
	private StudentService service;
	
	//Client Intention is to retrieve
	//Which tells retrieve all
	@GetMapping("/students")
	public List<Student> getAllStudent() {
		return service.allStudents();
	}
	//https://localhost:8080/students/1
	@GetMapping("/students/{id}")
	public Student getStudentById(@PathVariable int id) {
		return service.retrieveById(id);
	}
	//https://localhost:8080/students/{branch}
	@GetMapping("/student/{branch}")
	public List<Student> getStudentBybranch(@PathVariable String branch) {
		return service.retrieveByBranch(branch);
	}
	
	@PostMapping("/students")
	public ResponseEntity<Object> insertStudent(@RequestBody Student student) {
		Student stud = service.createStudent(student);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(stud.getId())
				.toUri();
		return ResponseEntity.created(location ).build();
	}
	
	//https://localhost:8080/students/1
	@DeleteMapping("/students/{id}")
	public void deleteStudentById(@PathVariable int id) {
		service.deleteById(id);
	}
}
