package com.mthree.restfulwebservice.dao;
import org.springframework.data.jpa.repository.JpaRepository;

import com.mthree.restfulwebservice.model.Student;

public interface StudentJPARepository extends JpaRepository<Student, Integer>, IDAO{

}
