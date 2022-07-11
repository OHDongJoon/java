package com.lec.ex5_scanner;

import java.util.Scanner;

public class Ex03_scannerClose {
	public static void main(String[] args) {
		//BookLib 객체 만들어서 사용자에게 대출or반납
		Scanner scMain = new Scanner(System.in);
		System.out.println("이름?");
		String name = scMain.nextLine();
		System.out.println("입력하신 이름은"+name);
		nickName();//
		System.out.println("나이 ?");
		int age = scMain.nextInt();
		System.out.println("입력하신 나이는 ?"+age);
	}
	//사용자로부터 별명을 출력하는 메소드
	private static void nickName() {// 객체를 만드는게아니니 static에서 호출햇으니 static 으로 받자     
		Scanner scNickName = new Scanner(System.in);
		System.out.print("별명은?");
		System.out.println("입력하신 별명은 "+scNickName.nextLine());
	//	scNickName.close(); 스캐너 객체의 close는 main에서만
	}
}
