package com.mthree.restfulwebservice.resource;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mthree.restfulwebservice.model.Student;
import com.mthree.restfulwebservice.service.IService;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class StudentResource {
	@Autowired
	private IService service;
	

	@GetMapping(path = "/students")
//	@RequestMapping(method = RequestMethod.GET, value = "/students")
	public List<Student> findAllStudents() {
		System.out.println("findAllStudents");
		return service.findAll();
	}

	@GetMapping(path = "/students/{id}")
	public Student findStudent(@PathVariable int id) {
		Student student = service.findById(id);
		if (student == null) {
			System.out.println("No Sudent");
			return null;
		} else {
			return student;
		}
	}

	@PostMapping(path = "/students", consumes = "application/json")
	public Student createStudent(@RequestBody Student student, Model model) {
		System.out.println("createStudent");
		return service.save(student);
	}
	@CrossOrigin(methods = RequestMethod.DELETE)
	@DeleteMapping(path = "/students/{id}")
	public Student deleteStudent(@PathVariable int id) {
		System.out.println("delete");
		return service.deleteById(id);
	}

	@Transactional
	@PutMapping(path = "/students/{id}")
	public void updateStudentById(@PathVariable int id, @RequestBody Student student) {
		Student s = service.findById(id);
		s.setName(student.getName());
		service.save(s);

	}
}
