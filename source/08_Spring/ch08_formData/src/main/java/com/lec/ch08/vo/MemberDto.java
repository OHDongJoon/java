package com.lec.ch08.vo;

import lombok.Data;
import lombok.NoArgsConstructor;
//@Data  : 				 getter $ settter  toStirng equls
//@AllArgsConstructor  : 매개변수 모두 들어가있는
//@NoArgsConstructor  : 매개변수 없는거 디폴트

@NoArgsConstructor
@Data

public class MemberDto {
	private String name;
	private String id;
	private String pw;
	private int age;
	private String email;
	private String address;
	// 폼데이터 사용을 위해 : getter & 매개변수 없는 생성자 
	@Override
	public String toString() {
		return "MemberDto [이름  =" + name + ", id=" + id + ", pw=" + pw + ", age=" + age + ", email=" + email
				+ ", address=" + address + "]";
	}
	
}
