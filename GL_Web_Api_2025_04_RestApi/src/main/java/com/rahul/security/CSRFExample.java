package com.rahul.security;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.rahul.model.Student;
import com.rahul.service.StudentService;

import jakarta.servlet.http.HttpServletRequest;
@RestController
public class CSRFExample {

	@Autowired
	StudentService service;

	@GetMapping("/restAllStudent")
	public List<Student> getAllStudents() {
		return service.getAllStudents();
	}
	
	@GetMapping("/restgetstudent/{id}")
	public Student getByStudent(@PathVariable int id) {
		return service.getStudentByID(id);
	}

	@PostMapping("/reststudent")
	public void saveStudent(@RequestBody Student Student) {
		service.saveStudent(Student);
	}

	@GetMapping("/csrfToken")
	public CsrfToken reteriveCsrf(HttpServletRequest request) {
		return (CsrfToken) request.getAttribute("_csrf");
	}
}
