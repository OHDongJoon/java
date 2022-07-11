package com.lec.ex5_scanner;

import java.util.Scanner;

public class Ex01_nextLine {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("나이를 입력하세요 : ");
		int age = scanner.nextInt(); //숫자쓰고 엔터누르면  \n 만 남기고 숫자 넘겨줌
		System.out.println("입력하신 나이는 :" + age);

		System.out.print("이름을 입력하세요 : ");
		String name = scanner.next();// whitespace 앞까지 값만 return // \n만 그대로 남김
		System.out.println("입력하신 이름은 " + name);

		System.out.print("주소를 입력하세요 ");
		scanner.nextLine(); // 버퍼에 남아있는 \n 을 지우는 목적
		String address = scanner.nextLine(); // 남은 /n이 니까 
		//nextLine '\n' 앞에 있는 값을 return 하고  빈값이 들어감 
		System.out.println("입력하신 주소는 "+ address);
		
		//nextInt 나이는 ? 30 \n => 30 넘겨주고 \n남음
		//next \n 홍길동 \n 앞에 \n은 무시 뒤에 \n 남음
		//nextLine(); /n 지우고 
		//그다음 주소 입력
	}
}
