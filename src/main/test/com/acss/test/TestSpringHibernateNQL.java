package com.acss.test;

import java.util.List;

import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.acss.model.Student;
import com.acss.service.IStudentService;

/**
 * JUNIT Testing for Hibernate Native Query Language
 * 
 * @author Johnrey Angolluan
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:dispatcher-servlet.xml")
public class TestSpringHibernateNQL {
	private final Logger logger = Logger.getLogger(TestSpringHibernateNQL.class);
	
	@Autowired
	private IStudentService studentService;
	
	@After
	public void destroy() {
		studentService = null;
	}
	
	@Test
	public void testListNQL() {
		List<Student> list = studentService.listAllNQL();
		
		for(Student std : list){
			logger.debug("Student List::" + std);
		}
	}
	
	
	public void testGetByIdNQL() {
		Student student = new Student();
		student.setId(1);
		
		Student studInfo = studentService.getByIdNQL(student);
		logger.debug("STUDENT ==> " + studInfo);
	}
	
	
	public void testSaveNQL() {
		Student student = new Student();
		student.setName("DO KYUNG SOO"); 
		student.setAddress("KOREA");
		student.setAge("25");
		
		studentService.saveNQL(student);
		
		this.testListNQL();
	}
	
	
	public void testUpdateNQL() {
		Student student = new Student();
		student.setId(23);
		student.setName("KIM JONG DAE"); 
		student.setAddress("SEOUL");
		student.setAge("55");
		
		studentService.updateNQL(student);
		
		this.testListNQL();
	}
	
	
	public void testDeleteNQL() {
		Student student = new Student();
		student.setId(23);
		
		studentService.deleteNQL(student);
		
		this.testListNQL();
	}
}
