package com.lec.ch19.service;

import javax.servlet.http.HttpSession;

import com.lec.ch19.dto.Member;

public interface MemberService {
	//아디 중복체크
	public int idConfirm(String mid);
	//회원가입
	public int joinMember(Member member, HttpSession httpSession); //회원가입 성공후 세션에 담기위해
	//로그인체크
	public String loginCheck(String mid, String mpw,HttpSession httpSession); // 로그인후 세션에 담기위해
	//회원상세보기
	public Member getDetailMember(String mid);
	//회원수정
	public int modifyMember(Member member);
}
