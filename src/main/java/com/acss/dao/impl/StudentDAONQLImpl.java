package com.acss.dao.impl;

import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.acss.dao.StudentDAO;
import com.acss.model.Student;

/**
 * Native Query Language
 * 
 * @author Johnrey Angolluan
 *
 */

@SuppressWarnings("unchecked")
@Repository("StudentDAONQLImpl")
public class StudentDAONQLImpl implements StudentDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public Session getSessionFactory() {
		return sessionFactory.getCurrentSession();
	}

	@Override
	public List<Student> listAll() {
		String sql = "select * from student_info";
		SQLQuery query = this.getSessionFactory().createSQLQuery(sql);

		query.addEntity(Student.class);

		List<Student> studentList = query.list();
		return studentList;
	}

	@Override
	public void save(Student student) {
		String sql = "insert into student_info (student_name, student_age, student_address) values (:name,:age,:address)";
		SQLQuery query = this.getSessionFactory().createSQLQuery(sql);

		query.setParameter("name", student.getName());
		query.setParameter("age", student.getAge());
		query.setParameter("address", student.getAddress());
		query.executeUpdate();
	}

	@Override
	public void update(Student student) {
		String sql = "update student_info set student_name=:name, student_age=:age, student_address=:address where student_id=:id";
		SQLQuery query = this.getSessionFactory().createSQLQuery(sql);

		query.setParameter("id", student.getId());
		query.setParameter("name", student.getName());
		query.setParameter("age", student.getAge());
		query.setParameter("address", student.getAddress());

		query.executeUpdate();
	}

	@Override
	public void delete(Student student) {
		String sql = "delete from student_info where student_id=:id";
		SQLQuery query = this.getSessionFactory().createSQLQuery(sql);

		query.setParameter("id", student.getId());
		query.executeUpdate();

	}

	@Override
	public Student getById(Student student) {
		String sql = "select * from student_info where student_id=:id";
		SQLQuery query = this.getSessionFactory().createSQLQuery(sql);

		query.addEntity(Student.class);
		query.setParameter("id", student.getId());

		return (Student) query.uniqueResult(); // query.list().get(0);
	}

}
