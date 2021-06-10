package com.up.homework.one;

public class Employee {
	
	private int id;
	private String firstName;
	private String lastName;
	private String gender;
	private String email;
	private String province;
	
	public Employee() {
		
	}
	public Employee(int id) {
		this.id = id;
	}
	public Employee(int id, String firstName, String lastname, String gender, String email, String province) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastname;
		this.gender = gender;
		this.email = email;
		this.province = province;
	}
	public Employee(String firstName, String lastname, String gender, String email, String province) {
		super();
		this.firstName = firstName;
		this.lastName = lastname;
		this.gender = gender;
		this.email = email;
		this.province = province;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	
}
