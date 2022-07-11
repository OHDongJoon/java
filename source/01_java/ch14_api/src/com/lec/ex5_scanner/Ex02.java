package com.lec.ex5_scanner;

import java.util.Scanner;

public class Ex02 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("주소를 입력하세요:");
		String address =scanner.nextLine();
		System.out.println("입력하신 주소는 :"+address);
		
		System.out.print("이름을 입력하세요:");
		String name = scanner.next();
		System.out.println("입력하신 이름은 " + name);
	}
}
