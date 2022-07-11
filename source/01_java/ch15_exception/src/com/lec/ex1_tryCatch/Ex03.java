package com.lec.ex1_tryCatch;

import java.util.InputMismatchException;
//예외 :  ArithmeticException, InputMismatchException(숫자 입력 안하고 a 입력할때)
import java.util.Scanner;

public class Ex03 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int i, j = 1;
		do {
			try {
				System.out.println("사칙연산을 할 첫번째 수는?"); // 수를 입력하세요 했는데 문자 입력했을때 수입력 할때 까지 예외처리
				i = scanner.nextInt();
				break; // i에 정수를 제대로 입력하면 break로 do while 빠져나가
			} catch (InputMismatchException e) {
				System.out.println("예외 메세지:" + e.getMessage());
				System.out.println("정수를 반드시 입력하세요");
				scanner.nextLine(); // 버퍼를 지우는 목적
			}
		} while (true);
		System.out.println("사칙연산할 두번째 수는 ?");
		try {
			j = scanner.nextInt(); // 예외가 발생하면 catch로 감
			System.out.println("i = " + i + ", j =" + j);
			System.out.println("i * j =" + (i * j));
			System.out.println("i / j =" + (i / j)); // 예외가 발생 0을 넣었으면 ?
		} catch (ArithmeticException e) {
			System.out.println(e.getMessage());
		} catch (InputMismatchException e) {
			System.out.println("예외메세지:" + e.getMessage());
			System.out.println("두번째 수를 잘못 입력하시면 1로 초기화 됨");
		} catch (Exception e) { // 모든 Exception 상속받아서
			System.out.println("모든 예외는 다 이쪽에 있단 이말이야" + e.getMessage());

		}

		System.out.println("i + j =" + (i + j));
		System.out.println("i - j =" + (i - j));
		System.out.println("DONE");
		scanner.close();
	}
}
