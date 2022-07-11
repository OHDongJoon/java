package com.lec.ex;
// 빈태그 사용하려면 : 매개변수없는 생성자, setter, getter
public class Person {
	private String name; // 이름은 여러글자 "어덩즌"
	private int age;
	private char gender; //'f' 'n'
	private String address;
	public Person() { }
	public Person(String name, char gender, String address,int age) {
		this.name = name;
		this.gender = gender;
		this.address = address;
		this.age = age;
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
	public char getGender() {
		return gender;
	}
	public void setGender(char gender) {
		this.gender = gender;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}

}
