package com.acss.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.acss.dao.StudentDAO;
import com.acss.model.Student;

/**
 * Hibernate Query Languange
 * 
 * @author Johnrey Angolluan
 *
 */

@SuppressWarnings("unchecked")
@Repository("StudentDAOHQLImpl")
public class StudentDAOHQLImpl implements StudentDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public Session getSessionFactory() {
		return sessionFactory.getCurrentSession();
	}

	@Override
	public void save(Student student) {
		this.getSessionFactory().save(student);
	}

	@Override
	public List<Student> listAll() {
		Query query = this.getSessionFactory().createQuery("from Student");
		List<Student> studentList = query.list();
		return studentList;
	}

	@Override
	public void update(Student student) {
		this.getSessionFactory().update(student);

	}

	@Override
	public void delete(Student student) {
		this.getSessionFactory().delete(student);
	}

	@Override
	public Student getById(Student student) {
		Query query = this.getSessionFactory().createQuery("from Student where id=:studentid");
		query.setParameter("studentid", student.getId());

		return (Student) query.uniqueResult(); // query.list().get(0);
	}

}
