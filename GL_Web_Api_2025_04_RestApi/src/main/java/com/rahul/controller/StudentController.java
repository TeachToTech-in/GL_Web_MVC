package com.rahul.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.rahul.aop.annotation.TrackTime;
import com.rahul.model.Student;
import com.rahul.service.StudentService;

@Controller
//it Allow the request from all the urls
//Local Configuration By Using annotation
//@CrossOrigin
//@CrossOrigin(originPatterns = "https://www.google.com")
public class StudentController {
	//@Autowired
	private StudentService service;
	
	public StudentController(StudentService service) {
		super();
		this.service = service;
	}

	@TrackTime
	@GetMapping(path = {"/allstudents","/"})
	public String getAllStudent(Model model) {
		List<Student> students = service.getAllStudents(); 
		model.addAttribute("list_of_students",students);
		return "index";
	}
	@GetMapping(path = {"/addNew"})
	public String addStudent(Model model) {
		Student student = new Student();
		model.addAttribute("student",student);
		return "update";
	}	
	@PostMapping(path = {"/save"})
	public String saveStudent(@ModelAttribute("student") Student student,Model model) {
		service.saveStudent(student);
		return "redirect:/";
	}
	
	
	@TrackTime
	@GetMapping(path = {"/updateStudent/{id}"})
	public String updateStudent(@PathVariable int id,Model model) {
		Student student = service.getStudentByID(id);
		model.addAttribute("student",student);
		return "update";
	}
	@TrackTime
	@GetMapping(path = {"/deleteStudent/{id}"})
	public String deleteStudent(@PathVariable int id,Model model) {
		service.removeStudent(id);
		return "redirect:/";
	}
	
}
