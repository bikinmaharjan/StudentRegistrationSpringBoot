package com.mthree.restfulwebservice.dao;

import java.util.List;

import com.mthree.restfulwebservice.model.Student;

public interface IDAO {

	public List<Student> findAll();
	public Student findById(int id);
	public Student save(Student student);
	public Student deleteById(int id);

}
