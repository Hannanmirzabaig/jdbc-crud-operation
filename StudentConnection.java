package com.jspider.jdbc_prepared_crud_architectured.connection;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.cj.jdbc.Driver;

public class StudentConnection {
	
	public static Connection getStudentConnection() {
		
			try {
				Driver driver=new Driver();
				DriverManager.registerDriver(driver);
				String url="jdbc:mysql://localhost:3306/jdbc_10am";
				String user="root";
				String pass="root";
				
			return 	DriverManager.getConnection(url,user,pass);
				
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
		
//		try {
//			Class.forName("com.mysql.cj.jdbc.Driver");
//			String url="jdbc:mysql://localhost:3306/jdbc_10am";
//			String user="root";
//			String pass="root";
//			
//				return DriverManager.getConnection(url,user,pass);
//			
//		} catch (ClassNotFoundException | SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return null;
			
			
			
		
		
		
	}

}
