package com.acss.service.impl;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.acss.dao.StudentDAO;
import com.acss.model.Student;
import com.acss.service.IStudentService;

@Service
@Transactional
public class StudentService implements IStudentService {

	@Resource(name="StudentDAOHQLImpl")
	private StudentDAO studentDAOHQLImpl;
	
	@Resource(name="StudentDAONQLImpl")
	private StudentDAO studentDAONQLImpl;
	
	@Override
	public List<Student> listAllHQL() {
		return studentDAOHQLImpl.listAll();
	}

	@Override
	public void saveHQL(Student student) {
		studentDAOHQLImpl.save(student);
	}

	@Override
	public void updateHQL(Student student) {
		studentDAOHQLImpl.update(student);
	}

	@Override
	public void deleteHQL(Student student) {
		studentDAOHQLImpl.delete(student);
	}
	
	@Override
	public Student getByIdHQL(Student student) {
		return studentDAOHQLImpl.getById(student);
	}

	@Override
	public List<Student> listAllNQL() {
		return studentDAONQLImpl.listAll();
	}

	@Override
	public void saveNQL(Student student) {
		studentDAONQLImpl.save(student);
	}

	@Override
	public void updateNQL(Student student) {
		studentDAONQLImpl.update(student);
	}

	@Override
	public void deleteNQL(Student student) {
		studentDAONQLImpl.delete(student);
	}

	@Override
	public Student getByIdNQL(Student student) {
		return studentDAONQLImpl.getById(student);
	}

}
