package com.acss.dao;

import java.util.List;

import com.acss.model.Student;

public interface StudentDAO {

	List<Student> listAll();
	
	Student getById(Student student);
	
	void save (Student student);
	
	void update (Student student);
	
	void delete (Student student);
	
}
