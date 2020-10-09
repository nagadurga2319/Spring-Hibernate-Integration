package com.pack.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.pack.model.Student;

@Repository
public class StudentDaoImpl implements StudentDao {

	private static Logger log = Logger.getLogger(StudentDaoImpl.class);
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void saveStudent(Student student) {
		// TODO Auto-generated method stub
		log.info("Inside Dao saveStudent()");
		sessionFactory.getCurrentSession().save(student);
	}

	@Override
	public List<Student> fetchStudent() {
		// TODO Auto-generated method stub
		log.info("Inside Dao fetchStudent()");
		Query query = sessionFactory.getCurrentSession().createQuery("from Student s");
		List<Student> stdList = query.list();
		return stdList;
	}

	@Override
	public Student fetchStudentById(Integer stdId) {
		// TODO Auto-generated method stub
		log.info("Inside Dao fetchStudentById()");
		Student student = (Student) sessionFactory.getCurrentSession().get(Student.class, stdId);
		return student;
	}

	@Override
	public void updateStudent(Student student) {
		// TODO Auto-generated method stub
		log.info("Inside Dao updateStudent()");
		sessionFactory.getCurrentSession().update(student);
	}

	@Override
	public void deleteStudent(Integer sid) {
		// TODO Auto-generated method stub
		log.info("Inside Dao deleteStudent()");
		Query query = sessionFactory.getCurrentSession().createQuery("delete from Student s where s.id=:stdid");
		query.setParameter("stdid", sid);
		query.executeUpdate();
	}

}
