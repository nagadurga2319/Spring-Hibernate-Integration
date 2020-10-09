package com.pack.dao;

import java.util.List;

import com.pack.model.Student;

public interface StudentDao {
	public void saveStudent(Student student);

	public List<Student> fetchStudent();

	public Student fetchStudentById(Integer stdId);

	public void updateStudent(Student student);

	public void deleteStudent(Integer sid);
}