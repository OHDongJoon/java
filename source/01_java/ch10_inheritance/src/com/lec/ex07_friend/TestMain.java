package com.lec.ex07_friend;

public class TestMain {
	public static void main(String[] args) {
		Friend f1 = new Friend();// 매개변수 없는 생성자 
		System.out.println(f1.infoString()); //fr에 info
		Friend f2 = new Friend("홍길동"); // 매개변수 한개짜리 
		System.out.println(f2.infoString());
		Friend f3 = new Friend("홍길순", "010-9999-999");
		System.out.println(f3.infoString());
	}
}
