package com.sit.SMS;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Student {
	Scanner scanner = new Scanner(System.in);
	PreparedStatement ps = null;
	CallableStatement cs = null;
	ResultSet rs = null;
	
	//adding student

	public void addStudent() {
	try {
		
		System.out.println("To exit press 0.");
		System.out.println("Add Students details: ");
		boolean loop = true;
		int countStudent = 0;
		while(loop) {
		countStudent++;	
		System.out.println("Enter the name of the " + countStudent + " Student: ");
		String name = scanner.nextLine();
		
		System.out.println("Enter the age of the " + countStudent + " Student: ");
		int age = scanner.nextInt();
		scanner.nextLine();
		System.out.println("Enter the course of the " + countStudent + " Student: ");
		String course = scanner.nextLine();

		
		//Establishing connection
		connection conn = new connection();
		
		//sql query
		String sql = "Insert into student(name, age, course) values"
				+ "(?,?,?)";
		ps = conn.getConnection().prepareStatement(sql);
		ps.setString(1,name);
		ps.setInt(2, age);
		ps.setString(3, course);
		ps.execute();
		System.out.println("Student added successfully!");
		System.out.println("Continue? press 1\nTO exit press 0");
		int choose = scanner.nextInt();
		scanner.nextLine();
		if(choose == 0) {
			loop = false;
		}else {
			continue;
		}
		}
	}catch(SQLException e) {
		e.printStackTrace();
	}finally {
		if(cs != null)
			try {
				cs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
	}
	}
	
	
	//updating student

	public void updatingStudent() {
	try {
		
		System.out.println("To exit press 0.");
		System.out.println("Upadate Student details: ");
		boolean loop = true;
		connection conn = new connection();
		while(loop) {
			
		System.out.println("Enter the id of the student you want to update: ");
		
		int studId = scanner.nextInt();
		
		String checkId = "select * from student where id = ?";
		
		ps = conn.getConnection().prepareStatement(checkId);
		
		ps.setInt(1,studId);
		ps.execute();
	
		
		System.out.println("If you want to udpate name press 1\n"
				+ "If you want to update age press 2\n"
				+ "If you want to update course press 3\n");
		
		int captureUserInput = scanner.nextInt();
		scanner.nextLine();
		switch(captureUserInput) {
		case 1:
			System.out.println("Enter the student's name: ");
			String studName = scanner.nextLine();
			String sql = "update student set name = ? where id = ?";
			ps = conn.getConnection().prepareStatement(sql);
			ps.setString(1, studName);
			ps.setInt(2, studId);
			ps.execute();
			break;
		case 2:
			System.out.println("Enter the student's new age: ");
			int studentNewId = scanner.nextInt();
			String sql1 = "update student set age = ? where id = ?";
			ps = conn.getConnection().prepareStatement(sql1);
			ps.setInt(1, studentNewId);
			ps.setInt(2, studId);
			ps.execute();
			break;
		case 3:
			System.out.println("Enter the student's new course: ");
			String studCourse = scanner.nextLine();
			String sql2 = "update student set course = ? where id = ?";
			ps = conn.getConnection().prepareStatement(sql2);
			ps.setString(1, studCourse);
			ps.setInt(2, studId);
			ps.execute();
			break;
		}
		
		System.out.println("Details updated!");
		System.out.println("Want to update more details?"
				+ "press 0 to exit. Press 1 to continue.");
		int choose = scanner.nextInt();
		if(choose == 0) {
			loop = false;
		}else {
			continue;
		}
		}
	}catch(SQLException e) {
		e.printStackTrace();
	}finally {
		if(cs != null)
			try {
				cs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
	}
	}
	
	
	
	//deleting student

	public void deletingStudent() {
	try {
		
		System.out.println("To exit press 0.");
		System.out.println("Delete Student details ");
		boolean loop = true;
		
		while(loop) {
			
		System.out.println("Enter the id of the Student: ");
		int id = scanner.nextInt();

		
		//Establishing connection
		connection conn = new connection();
		
		//sql query
		String sql = "delete from student where id = ?";
		ps = conn.getConnection().prepareStatement(sql);
		ps.setInt(1,id);
		ps.execute();
		System.out.println("Record deleted!");
		System.out.println("Delete more press 1\nExit press 0");
		int choose = scanner.nextInt();
		if(choose == 0) {
			loop = false;
		}else {
			continue;
		}
		}
	}catch(SQLException e) {
		e.printStackTrace();
	}finally {
		if(cs != null)
			try {
				cs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
	}
	}
	
	
	//list all students
	public void listAllStudent() {
	try {	
		//Establishing connection
		connection conn = new connection();
		System.out.println("All student details:\n");
		
		String sqlQuery = "Select * from student;";
		
		ps = conn.getConnection().prepareStatement(sqlQuery);
		rs = ps.executeQuery();
		
		while(rs.next()) {
			System.out.println("Id: " + rs.getInt("id") + " |Name: " + rs.getString("name") + " |Age: " + rs.getInt("age") + " |Course: " + rs.getString("course"));
		}
			
	}catch(SQLException e) {
		e.printStackTrace();
	}finally {
		if(cs != null)
			try {
				cs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
	}
	}
}
