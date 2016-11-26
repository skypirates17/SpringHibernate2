package com.acss.service;

import java.util.List;

import com.acss.model.Student;

public interface IStudentService {
	List<Student> listAllHQL();
	
	void saveHQL (Student student);
	
	void updateHQL (Student student);
	
	void deleteHQL (Student student);
	
	Student getByIdHQL (Student student);
	
	
	List<Student> listAllNQL();
	
	void saveNQL (Student student);
	
	void updateNQL (Student student);
	
	void deleteNQL (Student student);
	
	Student getByIdNQL (Student student);
}
