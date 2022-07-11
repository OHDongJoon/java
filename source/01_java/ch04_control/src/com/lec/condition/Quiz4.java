package com.lec.condition;

import java.util.Scanner;

public class Quiz4 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("가위(0) 바위(1) 보(2) 하나를 고르세요 :");
		int num = sc.nextInt();
		if(num == 0) {
			System.out.println("가위");
		} else if(num == 1) {
			System.out.println("바위");
		}else if(num == 2) {
			System.out.println("보");
		}else {
			System.out.println("유효하지 않는 값입니다");
		}

 }
}