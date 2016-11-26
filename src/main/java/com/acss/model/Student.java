package com.acss.model;

public class Student {

	private Integer id;

	private String name;

	private String age;

	private String address;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder("");
		
		sb.append("id=" + this.id);
		sb.append(", name=" + this.name);
		sb.append(", age=" + this.age);
		sb.append(", address=" + this.address);
		
		return sb.toString();
	}

}
