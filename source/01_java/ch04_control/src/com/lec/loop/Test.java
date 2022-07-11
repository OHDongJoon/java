package com.lec.loop;

import java.util.Scanner;

public class Test {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("구구단 수를 입력하세요:");
		int num = scanner.nextInt();
		for(int i = 1 ; i < 10; i++) {
			
			System.out.printf("%d * %d = %d\n",num, i , num *i);
			
		}
	}
}
