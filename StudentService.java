package com.jspider.jdbc_prepared_crud_architectured.service;

import java.util.List;

import com.jspider.jdbc_prepared_crud_architectured.dao.StudentDao;
import com.jspider.jdbc_prepared_crud_architectured.dto.Student;

public class StudentService {
	
	StudentDao dao=new StudentDao();
	
	public Student saveStudentService(Student  student) {
		
		int id=student.getId();
		
		if(id<=999) {
			return dao.saveStudentDao(student);
		}else {
			
			
			//exception return krna h 
			System.out.println("please pass id wtih 3 digit or less than three digi");
			return null;
		}
		
		
	}
	
	/*
	 * 
	 */
	public Student getStudentByIdService(int studentId) {
		return dao.getStudentByIdDao(studentId);
	}
	
	public	List<Student> getAllStudentService() {
		return dao.getAllAtudentDao();
	}
	
	public int updateStudentNameByIdService(int id,String name) {
		return dao.updateStuddentNameByIdDao(id, name);
	}
	
	public int updateStudentNameEmailPhoneByIdService(int id,String name,String email,long phone) {
		return dao.updateStudentNameEmailPhoneByIdDao(id, name, email, phone);
	}
	
	public int deleteStudentByIdService(int id) {
		return dao.deleteStudentByIdDao(id);
	}

}
