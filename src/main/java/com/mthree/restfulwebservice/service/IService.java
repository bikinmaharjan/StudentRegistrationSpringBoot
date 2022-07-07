package com.mthree.restfulwebservice.service;

import java.util.List;

import com.mthree.restfulwebservice.model.Student;

public interface IService {
	public List<Student> findAll();
	Student findById(int id);
	public Student save(Student student);
	public Student deleteById(int id);
}
