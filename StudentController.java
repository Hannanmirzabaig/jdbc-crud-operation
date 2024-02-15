package com.jspider.jdbc_prepared_crud_architectured.controller;
import java.security.Provider.Service;
import java.sql.Connection;
import java.util.List;
import java.util.Scanner;

import com.jspider.jdbc_prepared_crud_architectured.connection.StudentConnection;
import com.jspider.jdbc_prepared_crud_architectured.dto.Student;
import com.jspider.jdbc_prepared_crud_architectured.service.StudentService;
public class StudentController {
 
		public static void main(String[] args) {
			Scanner sc=new Scanner(System.in);
			
			StudentService service=new StudentService();
			
			while(true) {
				System.out.println("1-INSERT\n2-getById\n3-UPDATE\n4-FETCH\n5-DELETE\n6- EXIT");
				int choice =sc.nextInt();
				
				switch(choice) {
				case 1:{
					//con=StudentConnection.getStudentConnection();
					System.out.println("enter the id for insert");
					int id=sc.nextInt();
					System.out.println("enter the name for insert");
					String name=sc.next();
					System.out.println("enter the email for insert");
					String email=sc.next();
					System.out.println("enter the phone number for insert");
					long phone=sc.nextLong();
					
					Student stt=new Student(id,name,email,phone);
					
					Student st=service.saveStudentService(stt);
					
					if(st!=null) {
						System.out.println("insert data");
					}else {
						System.out.println("faild");
					} 
					
					
					
				
					
				}break;
				
				case 2:{
						System.out.println("enter the id");
						int id=sc.nextInt();
						
						
						Student st=service.getStudentByIdService(id);
						
						if(st!=null) {
							System.out.println(st);
						}else {
							System.out.println("given id is not fount or check with sql Query");
						}
					
					
				}break;
				
				case 3:{
					System.out.println("1-updateName\n 2-update name,email,phone");
					int option=sc.nextInt();
					switch(option) {
								case 1:{
									System.out.println("enter the id");
									int id=sc.nextInt();
									System.out.println("enter the new name for update");
									String name=sc.next();
								int a=service.updateStudentNameByIdService(id, name);
								if(a>0) {
									System.out.println("updated Successfully");
									
								}else {
									System.out.println("id not fount and check with sql  query");
								}
									
								}break;
								
								case 2:{
									System.out.println("enter the id ");
									int id=sc.nextInt();
									System.out.println("enter the new name");
									String name=sc.next();
									System.out.println("enter the new email");
									String email=sc.next();
									System.out.println("enter the new phone number");
									long phone=sc.nextLong();
									
								int i=service.updateStudentNameEmailPhoneByIdService(id, name, email, phone);
									if(i>0) {
										System.out.println("updated successfully");
									}else {
										System.out.println("id not found or check sql query");
									}
								}
								
						}
					
					
				}break;
				
				case 4:{
					List<Student> students=service.getAllStudentService();
					if(students !=null) {
						for (Student student : students) {
							System.out.println(student);
						}
					}else {
							System.out.println("here is no data available and check with sql");
						}
					
					
				}break;
				
				case 5:{
					System.out.println("enter the id");
					int id=sc.nextInt();
					int i=service.deleteStudentByIdService(id);
					if(i>0) {
						System.out.println("deleted successfully");
					}else {
						System.out.println("id not found or check sql query");
					}
				}break;
				
				case 6:{
					
				}break;
				
				
				default:System.out.println("please choose the valid option");		
				}
			}
		}
	}
