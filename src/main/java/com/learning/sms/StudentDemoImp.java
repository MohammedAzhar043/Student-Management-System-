package com.learning.sms;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
public class StudentDemoImp implements StudentDemo {
	
	
	private final String url = "jdbc:mysql://localhost:3306/SMS";
	private final String name = "root";
	private final String password = "root";
	private Connection connection;
	
	public StudentDemoImp() {
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection(url, name, password);
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void addStudent(Student student) {
		
		String sql = "insert into students(name,age,course) values (?,?,?)";
		try(PreparedStatement pr = connection.prepareStatement(sql)){
			pr.setString(1, student.getName());
			pr.setInt(2, student.getAge());
			pr.setString(3, student.getCourse());
			pr.executeUpdate();
		}
		catch (Exception e) {
		e.printStackTrace();
		}
		
	}

	@Override
	public void updateStudent(Student student) {
		
		String sql = "update  students set name =?,age=?,course=? where id =?";

		try(PreparedStatement pr = connection.prepareStatement(sql)){
			pr.setString(1, student.getName());
			pr.setInt(2, student.getAge());
			pr.setString(3, student.getCourse());
			pr.setInt(4, student.getId());
			pr.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void deletedStudent(int id) {
		String sql = "delete from  students where id =?";
		
		try(PreparedStatement pr = connection.prepareStatement(sql)){
			pr.setInt(1, id);
			pr.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public Student getStudentById(int id) {
		Student student = null;
		String sql = "select * from  students where id =?";
		
		try(PreparedStatement pr = connection.prepareStatement(sql)){
			pr.setInt(1, student.getId());
			ResultSet st =pr.executeQuery();
			
			if (st.next()) {
				student = new Student(
						st.getInt("id"),
						st.getInt("age"),
						st.getString("Name"),
						st.getString("course")
						);
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return student;
	}

	
	@Override
	public List<Student> getAllStudents() {
		
		String sql = "select * from  students ";
		List<Student> students = new ArrayList<Student>();
		
		try(PreparedStatement pr = connection.prepareStatement(sql)){
			ResultSet st =pr.executeQuery();
			
			while (st.next()) {
			Student student = new Student(
						st.getInt("id"),
						st.getInt("age"),
						st.getString("Name"),
						st.getString("course")
						);
			students.add(student);
				
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return students;
	}
		
}


