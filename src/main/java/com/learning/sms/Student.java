package com.learning.sms;

public class Student {

	private int id;
	private int age;
	private String name;
	private String course;
	
	public Student(){
		
	}
	
   public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCourse() {
		return course;
	}

	public void setCourse(String course) {
		this.course = course;
	}

public Student(int id,int age,String name,String course){
		this.id=id;
		this.age=age;
		this.name=name;
		this.course=course;
	}


}
