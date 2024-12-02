package com.learning.sms;

import java.util.List;

public class StudentServices {
	
	private final StudentDemo std;
	
	public StudentServices() {
		this.std = new StudentDemoImp();
	}
	
	public void addStudent(Student student) {
		std.addStudent(student);
	}
	
	public void updateStudent(Student student) {
		std.updateStudent(student);
	}
	
	public void deletedStudent(int id ) {
		std.deletedStudent(id);
	}
	
	public Student getStudentById(int id) {
		return 	std.getStudentById(id);
	}
	
	public List<Student> getAllStudents(){
		return std.getAllStudents();
	}

}
