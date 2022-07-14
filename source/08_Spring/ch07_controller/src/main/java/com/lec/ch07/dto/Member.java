package com.lec.ch07.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data   // 게터 셋터 toStirng equls
@AllArgsConstructor  // 매개변수 모두 들어가있는 
@NoArgsConstructor    // 매개변수 없는거 디폴트
public class Member {
	private String id;
	private String pw;
	@Override
	public String toString() {
		return "Member [아이디는" + id + ", 비밀번호는= "+ pw + "]";
	}
	
}
