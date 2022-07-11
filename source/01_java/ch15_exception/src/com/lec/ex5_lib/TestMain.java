package com.lec.ex5_lib;

import java.util.Date;

public class TestMain {
	public static void main(String[] args) {
		BookLib book1 = new BookLib("89a-01", "java", "홍길동");
		BookLib book2 = new BookLib("89a-02", "DBMS", "이디비");
		System.out.println(book1);
		try {// try반드시 해줘  메인에서는 throws 하면 에러를 남기고 프로그램 종료되니까 
			book1.checkOut("김빌림");
		} catch (Exception e) { //BookLib에서 24번째줄  throws Exception 한게 여기로 출력
			System.out.println(e.getMessage());
		}  
		// 대출일 조작
		book1.setCheckOutDate(new Date(122, 2, 11));// 3월 11일에 대출함으로 수정
		System.out.println(book1);
		try {
			book1.checkIn();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		System.out.println(book1);
	}
}
