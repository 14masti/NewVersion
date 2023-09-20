package com.example;

public class Passenger {
	private String name;
	private String gender;
	private String age;
	private String berth;

	public Passenger() {

	}

	public Passenger(String name, String gender, String age, String berth) {
		this.name = name;
		this.gender = gender;
		this.age = age;
		this.berth = berth;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getBerth() {
		return berth;
	}

	public void setBerth(String berth) {
		this.berth = berth;
	}

}
