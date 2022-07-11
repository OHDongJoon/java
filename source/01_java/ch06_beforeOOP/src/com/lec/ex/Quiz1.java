package com.lec.ex;

import java.util.Scanner;

//단  수를 매개변수로 받아 해당 단수의 구구단을 출력하는 부분을 method로 처리한다. 사용자가 2~9 사이의 수가 아닌수를
// 입력할 시 2~9 사이의 수를 입력할 때까지 계속 입력 받는다.)
public class Quiz1 {
	public static void main(String[] args) {
		int dansu;
		Scanner scanner = new Scanner(System.in);
		do {
			System.out.print("2~9단 입력:");
			dansu = scanner.nextInt();
		} while (2 > dansu || dansu > 9);
		gugu(dansu);

	}

	private static void gugu(int dansu) {
		for (int i = 1; i < 10; i++)
			System.out.printf("%d *%d = %d\n", dansu, i, dansu * i);

	}

}
