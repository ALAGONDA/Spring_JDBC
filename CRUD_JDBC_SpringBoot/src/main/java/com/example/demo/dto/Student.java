package com.example.demo.dto;


public class Student {

	private long phoneno;
	private String name;
	private String address;

	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Student(long phoneno, String name, String address) {
		super();
		this.phoneno = phoneno;
		this.name = name;
		this.address = address;
	}

	public long getPhoneno() {
		return phoneno;
	}

	public void setPhoneno(long phoneno) {
		this.phoneno = phoneno;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Student [phoneno=" + phoneno + ", name=" + name + ", address=" + address + "]";
	}

}
