package com.lec.ex4_object;

// Sawon s1 = new Sawon("a01", "홍길동" , "COMPUTER"); -오늘 입사일
//Sawon  s2 = new Sawon("a02", "신길동" , "COMPUTER", 2022, 3, 24); - 3월24일 입사일
public class Ex01_SawonTestMain {
	public static void main(String[] args) {
		Sawon s1 = new Sawon("a01", "홍길동", Dept.COMPUTER);// -오늘 입사일
		Sawon s2 = new Sawon("a02", "신길동", Dept.HUMANRESOURCES, 2022, 3, 24); // 2022, 3, 24); - 3월24일 입사일
		System.out.println(s1.toString());
		System.out.println(s2.toString());
	}
}
