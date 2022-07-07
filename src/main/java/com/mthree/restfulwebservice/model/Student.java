package com.mthree.restfulwebservice.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "student")
public class Student implements Serializable{
	@Id
	@GeneratedValue
	private int id;
	private String name;
	private int age;
	private long mobileNumber;
	private String address;

	public Student() {
		// TODO Auto-generated constructor stub
	}

	public Student(String name, int age, long mobileNumber, String address) {
		super();
		this.name = name;
		this.age = age;
		this.mobileNumber = mobileNumber;
		this.address = address;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public long getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(long mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", age=" + age + ", mobileNumber=" + mobileNumber + ", address="
				+ address + "]";
	}

}
