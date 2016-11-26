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
 * JUNIT Testing for Hibernate Query Language
 * 
 * @author Johnrey Angolluan
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:dispatcher-servlet.xml")
public class TestSpringHibernateHQL {

	private final Logger logger = Logger.getLogger(TestSpringHibernateHQL.class);
	
	@Autowired
	private IStudentService studentService;
	
	@After
	public void destroy() {
		studentService = null;
	}
	
	@Test
	public void testListHQL() {
		List<Student> list = studentService.listAllHQL();
		
		for(Student std : list){
			logger.debug("Student List::" + std);
		}
	}
	
	
	public void testGetByIdHQL() {
		Student student = new Student();
		student.setId(2);
		
		Student studInfo = studentService.getByIdHQL(student);
		logger.debug("STUDENT ==> " + studInfo);
	}
	
	
	public void testSaveHQL() {
		Student student = new Student();
		student.setName("TINTIN"); 
		student.setAddress("TUBIGAN");
		student.setAge("100");
		
		studentService.saveHQL(student);
		
		this.testListHQL();
	}
	
	
	public void testUpdateHQL() {
		Student student = new Student();
		student.setId(22);
		student.setName("JUSTINE ROSE"); 
		student.setAddress("BRGY DALIG");
		student.setAge("1");
		
		studentService.updateHQL(student);
		
		this.testListHQL();
	}
	
	
	public void testDeleteHQL() {
		Student student = new Student();
		student.setId(25);
		
		studentService.deleteHQL(student);
		
		this.testListHQL();
	}
}
