package com.lec.quiz;

import java.util.Scanner;

// 두수를 입력받아
// 두 수가 같은지 결과를 o나 x로 출력.
// 첫번째 수가 더 큰지 결과를 o x로 출력한다.
public class Quiz3 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("수를 입력하세요:");
		int su1 = scanner.nextInt();
		System.out.print("두번째 수를 입력하세요:");
		int su2 = scanner.nextInt();
		if (su1 == su2) {
			System.out.println("두수가 같음");
		} else
			System.out.println("두수가 같지않음");
		if (su1 > su2) {
			System.out.println("첫번째수가 큼 0");
		}
	}
}