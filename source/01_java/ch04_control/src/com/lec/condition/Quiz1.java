package com.lec.condition;

import java.util.Scanner;

//수를 입력받아 절대값을 출력하는  프로그램
public class Quiz1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("수를 입력하세요:");
		int su = sc.nextInt(); 
		if(su >= 0) {
			System.out.printf("입력하신 절대값:%d\n",su);
		}else
			System.out.printf("입력하신 절대 값:%d\n", -su);
			
	}
}

