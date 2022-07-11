package com.lec.ex1_string;

public class Friend {
	private String name;
	private String phone;
	private String birthday;
	public Friend(String name, String phone, String birthday) {
		this.name = name;
		this.phone = phone;
		this.birthday = birthday;
	}
	@Override
	public String toString() {
		return "Friend [name=" + name + ", phone=" + phone + ", birthday=" + birthday + "]";
	}
	public String getName() {
		return name;
	}
	public String getPhone() {
		return phone;
	}
	public String getBirthday() {
		return birthday;
	}
	
	}
	
