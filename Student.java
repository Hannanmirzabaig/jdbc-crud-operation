package com.jspider.jdbc_prepared_crud_architectured.dto;


/**
 * @author Abdul Hannan Mirza.
 * 
 * this is our student encapsulation class which has id ,name,email,phone
 * with the same attributes we have taken as a student table column
 * 
 */
public class Student {
	
	private int id;
	private String name;
	private String email;
	private long phone;
	
	public Student(){
		super();
	}
// alt+s+a
	public Student(int id, String name, String email, long phone) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.phone = phone;
	}
// alt+s+r then select all to getter and setter method both.
	public int getId() {
		return id;
	}

	public  void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public long getPhone() {
		return phone;
	}

	public void setPhone(long phone) {
		this.phone = phone;
	}
	@Override
	public String toString() {
		return " id=" + id + "\n name=" + name + "\n email=" + email + "\n phone=" + phone;
	}
	
	
	

}
