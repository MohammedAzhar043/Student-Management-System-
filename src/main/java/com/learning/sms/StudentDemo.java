package com.learning.sms;

import java.util.List;

public interface StudentDemo {
	
	void addStudent(Student student);
	void updateStudent(Student student);
	void deletedStudent(int id);
	Student getStudentById(int id);
	List<Student> getAllStudents();

}
