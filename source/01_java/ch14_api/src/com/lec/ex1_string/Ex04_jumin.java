package com.lec.ex1_string;

import java.util.Scanner;

// 7번째 
//<예제.주민번호를 입력받아 여자인지 남자인지 출력 예제> 주민번호는 “920225-2012121”형식으로 입력받는다.
public class Ex04_jumin {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String ju;
		do {
			System.out.println("주민번호를 입력하세요:");
			ju = scanner.next();
			switch (ju.charAt(7)) {
			case '1':
			case '3':
				System.out.println("남자입니다");
				break;
			case '2':
			case '4':
				System.out.println("여자입니다");
			}
		} while (!ju.equalsIgnoreCase("x"));
		System.out.println("DONE");

	}

}
