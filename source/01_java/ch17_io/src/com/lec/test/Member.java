package com.lec.test;
//(捞抚, 傈拳锅龋, 积老, 林家)

import java.text.SimpleDateFormat;
import java.util.Date;

public class Member {
	private String name;
	private String phone;
	private Date birthday;
	private String addres;

	public Member() {
	}

	public Member(String name, String phone, Date birthday, String addres) {

		this.name = name;
		this.phone = phone;
		this.birthday = birthday;
		this.addres = addres;
	}

	@Override
	public String toString() {
		SimpleDateFormat sdf = new SimpleDateFormat("MM-dd");
		return  name +  "\t" + phone + "\t" + sdf.format(birthday) + "林家" + addres ;
	}
}