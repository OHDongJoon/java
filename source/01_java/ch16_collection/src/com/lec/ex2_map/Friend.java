package com.lec.ex2_map;

import java.text.SimpleDateFormat;
import java.util.Date;
// Friend f = new Friend("홍","010-9999-9999")

public class Friend {
	private String name;
	private String tel;
	private Date birth;

	public Friend(String name, String tel) {
		this.name = name;
		this.tel = tel;
	}

	public Friend(String name, String tel, Date birth) {
		this.name = name;
		this.tel = tel;
		this.birth = birth;
	}

	// sysout(f) => toString 꼭 필요 홍의 연락처 010-9999-9999, 생일:4월4일
	@Override
	public String toString() {
		SimpleDateFormat sdf = new SimpleDateFormat("생일 : MM월 dd일");
		if (birth != null) {
			return name + "의 연락처: " + tel + ", " + sdf.format(birth);
		} else {
			return name + "의 연락처 :" + tel;
		} // if
	}// toString
}// class
