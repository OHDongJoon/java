package com.lec.ex1_tryCatch;
// java.lang.ArithmeticException 예외객체 
import java.util.Scanner;

public class Ex02 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("사칙연산을 할 첫번째 수는?");
		int i = scanner .nextInt();
		System.out.println("사칙연산할 두번째 수는 ?");
		int j = scanner.nextInt();
		System.out.println("i = "+ i + ", j ="+ j);
		System.out.println("i * j =" + (i*j));
		try {
		System.out.println("i / j =" + (i/j)); // 예외가 발생할 수 있는 부분
		}catch(ArithmeticException e) {
			//예외가 발생할 경우 우회적으로 
			System.out.println("예외 메세지 :" +e.getMessage());
			//e.printStackTrace();//예외사항을 자세히 출력10
		}
		System.out.println("i + j =" + (i+j));
		System.out.println("i - j =" + (i-j));
		System.out.println("DONE");
		scanner.close();
	}
}
