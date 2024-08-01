package com.sit.SMS;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;


public class connection {
	private String pass = "0012";
	private String userName = "root";
	private String jdbcUrl = "jdbc:mysql://localhost:3306/studentManagmentDB";
	
	private Connection con = null;
//	private Statement statement = null;
	public Connection getConnection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(jdbcUrl, userName, pass);
//			statement = con.createStatement();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		return con;
	}
	
}
