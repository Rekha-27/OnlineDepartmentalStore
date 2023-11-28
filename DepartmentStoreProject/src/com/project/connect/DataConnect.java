package com.project.connect;
import java.sql.*;
public class DataConnect {
	private static Connection con;
	private DataConnect(){
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("connection is establishing");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/imgpractise","root","password123");
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
	}
	public static Connection getConnection() {
		if(con==null) {
			DataConnect d=new DataConnect();
			
		}
		return con;
	}
	
}
