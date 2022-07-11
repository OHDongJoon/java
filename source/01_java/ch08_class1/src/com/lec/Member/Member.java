package com.lec.Member;

public class Member {

	private String id ;
	private String name;
	private String email;
	private String address;
	private String birth;
	private String gender;
	public Member() {	
	}
	public Member(String id, String name, String email, String address, String birth, String gender) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.address = address;
		this.birth = birth;
		this.gender = gender;
	}
	
	public String infoString() {
		return String .format("아이디 = %s\n 이름=%s\n 이메일=%s\n 주소=%s\n 생년월일=%s\n 성별=%s\n", id,name,email,address,birth,gender);
	}
}
