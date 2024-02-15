package com.jspider.jdbc_prepared_crud_architectured.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.jspider.jdbc_prepared_crud_architectured.connection.StudentConnection;
import com.jspider.jdbc_prepared_crud_architectured.dto.Student;

/**
 * @author Abdul Hannan Mirza
 * 
 * this class will communicate whit mysql database.
 */
public class StudentDao {
	
	Connection connection =StudentConnection.getStudentConnection();
	
	public Student saveStudentDao(Student student) {
		
		String insertQueryStudent="insert into student values(?,?,?,?)";
		
		try {
			PreparedStatement ps=connection.prepareStatement(insertQueryStudent);
			
			ps.setInt(1, student.getId());
			ps.setString(2, student.getName());
			ps.setString(3, student.getEmail());
			ps.setLong(4, student.getPhone());
			ps.execute();
			return student;
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return null;
		
	}
		
		public Student getStudentByIdDao(int studentId) {
			
			String selectQuery="select * from student where id=?";
		
		try {
			PreparedStatement ps=connection.prepareStatement(selectQuery);
			ps.setInt(1, studentId);
			
			ResultSet rs=ps.executeQuery();
			
			while(rs.next()) {
				
				int id=rs.getInt("id");
				String name=rs.getString("name");
				String email=rs.getString("email");
				long phone=rs.getLong("phone");
				
//	return new Student(rs.getInt("id"),rs.getString("name"),rs.getString("email"),rs.getLong("phone"));
			
//				return new Student(id,name,email,phone);  we can do as
				
				Student s=new Student(id,name,email,phone);
				return s;
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return null;
		
		}
		
		
		
public List<Student> getAllAtudentDao() {
			
			String selectQuery="select * from student";
		
		try {
			PreparedStatement ps=connection.prepareStatement(selectQuery);
			
			
			ResultSet rs=ps.executeQuery();
			List<Student> ls=new ArrayList<Student>();
			
			while(rs.next()) {
				
				int id=rs.getInt("id");
				String name=rs.getString("name");
				String email=rs.getString("email");
				long phone=rs.getLong("phone");
				Student st=new Student(id,name,email,phone);
				ls.add(st);		
			}
			return ls;
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return null;	
	

}

public int updateStuddentNameByIdDao(int id,String name) {
	
	String updateQuery="update student set name=? where id=?";
	try {
		PreparedStatement ps=connection.prepareStatement(updateQuery);
		ps.setInt(2, id);
		ps.setString(1, name);    //name come from parameter
		return ps.executeUpdate();   //method int isilye lya kyuki retun int hora ps.excecuteUpdate int value return krta zero or one
	} catch (SQLException e) {   
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return 0;
	
}

public int updateStudentNameEmailPhoneByIdDao(int id,String name,String email,long phone) {
	String updateQuery="update student set name=?,email=?,phone=? where id=?";
	
	try {
		PreparedStatement ps=connection.prepareStatement(updateQuery);
		ps.setInt(4, id);
		ps.setString(1, name);
		ps.setString(2,email);
		ps.setLong(3, phone);
		return ps.executeUpdate();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return 0;
	
}

public int deleteStudentByIdDao(int id) {
	String deleteQuery="delete from student where id=?";
	try {
		PreparedStatement ps=connection.prepareStatement(deleteQuery);
		ps.setInt(1, id);
		return ps.executeUpdate();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return 0;
	
	
}
}




