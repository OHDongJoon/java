package com.lec.ex1_string;

import java.util.Scanner;

public class Ex03_equal {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String fn;
		do {
			System.out.print("I : input | U : update | X : exxit");
			fn = scanner.next(); // 대문자 랑 소문자 랜덤 입력하니가
			switch(fn) {
			case "i":
			case "I":
				System.out.println("input 로직 있을 곳");
				break;
			case "u":
			case "U":
				System.out.println("update 로직 있을 곳");
			}
		}while( !fn.equalsIgnoreCase("x") );
		System.out.println("DONE");
	}
}
