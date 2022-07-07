package com.mthree.restfulwebservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mthree.restfulwebservice.dao.IDAO;
import com.mthree.restfulwebservice.model.Student;

@Service
public class StudentService implements IService {
	@Autowired
	private IDAO dao;
	
	public StudentService() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public List<Student> findAll() {
		return dao.findAll();
	}

	@Override
	public Student findById(int id) {
		return dao.findById(id);
	}

	@Override
	public Student save(Student student) {
		return dao.save(student);
	}

	@Override
	public Student deleteById(int id) {
		return dao.deleteById(id);
	}

}
