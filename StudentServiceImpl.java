package com.pack.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pack.dao.StudentDao;
import com.pack.model.Student;

@Service
@Transactional
public class StudentServiceImpl implements StudentService {
	private static Logger log = Logger.getLogger(StudentServiceImpl.class);
	@Autowired
	private StudentDao studentdao;

	@Override
	public void saveStudent(Student student) {
		// TODO Auto-generated method stub
		log.info("Inside saveStudent()");
		studentdao.saveStudent(student);

	}

	@Override
	public List<Student> fetchStudent() {
		// TODO Auto-generated method stub
		log.info("Inside fetchStudent()");
		List<Student> stdList = studentdao.fetchStudent();
		return stdList;
	}

	public Student fetchStudentById(Integer stdId) {
		// TODO Auto-generated method stub
		log.info("Inside fetchStudentById()");
		Student student = studentdao.fetchStudentById(stdId);
		return student;
	}

	@Override
	public void updateStudent(Student student) {
		// TODO Auto-generated method stub
		log.info("Inside updateStudent()");
		studentdao.updateStudent(student);
	}

	@Override
	public void deleteStudent(Integer sid) {
		// TODO Auto-generated method stub
		log.info("Inside deleteStudent()");
		studentdao.deleteStudent(sid);
	}

}
