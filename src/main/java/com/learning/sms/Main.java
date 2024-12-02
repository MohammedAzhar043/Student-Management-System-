package com.learning.sms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		StudentServices service = new StudentServices();
		
//		Scanner scanner = new Scanner(System.in);
		BufferedReader scanner = new BufferedReader(new InputStreamReader(System.in));
		
		
		while (true) {
            System.out.println("Student Management System");
            System.out.println("1. Add Student");
            System.out.println("2. Update Student");
            System.out.println("3. Delete Student");
            System.out.println("4. View Student");
            System.out.println("5. View All Students");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            int choice =Integer.parseInt(scanner.readLine());

            switch (choice) {
                case 1:
                    System.out.print("Enter name: ");
                    String name = scanner.readLine();
                    System.out.print("Enter age: ");
                    int age = Integer.parseInt(scanner.readLine());
                    System.out.print("Enter id: ");
                    int id = Integer.parseInt(scanner.readLine());
                    System.out.print("Enter course: ");
                    String course = scanner.readLine();
                    Student student = new Student(id,age, name, course);
                    service.addStudent(student);
                    break;

                case 2:
                    System.out.print("Enter student ID to update: ");
                    int updateId = Integer.parseInt(scanner.readLine());
                    Student updateStudent = service.getStudentById(updateId);
                    if (updateStudent != null) {
                        System.out.print("Enter new name: ");
                        updateStudent.setName(scanner.readLine());
                        System.out.print("Enter new age: ");
                        updateStudent.setAge(Integer.parseInt(scanner.readLine()));
                        System.out.print("Enter new course: ");
                        updateStudent.setCourse(scanner.readLine());
                        service.updateStudent(updateStudent);
                    } else {
                        System.out.println("Student not found.");
                    }
                    break;

                case 3:
                    System.out.print("Enter student ID to delete: ");
                    int deleteId = Integer.parseInt(scanner.readLine());
                    service.deletedStudent(deleteId);
                    break;

                case 4:
                    System.out.print("Enter student ID to view: ");
                    int viewId = Integer.parseInt(scanner.readLine());
                    Student viewStudent = service.getStudentById(viewId);
                    if (viewStudent != null) {
                        System.out.println(viewStudent);
                    } else {
                        System.out.println("Student not found.");
                    }
                    break;

                case 5:
                    List<Student> students = service.getAllStudents();
                    for (Student s : students) {
                        System.out.println(s);
                    }
                    break;

                case 6:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }

	}

}
