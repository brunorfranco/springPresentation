package com.springxml2.model;

public class Person {

	private String name;
	private String phoneNumber;
	
	@Override
	public String toString() {
		return "Person [name=" + name + ", phoneNumber=" + phoneNumber + "]";
	}

	public Person(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

}
