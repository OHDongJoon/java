package com.lec.ex;

import java.util.Scanner;

public class Quiz2 {
	public static void main(String[] args) {
		int su;
		Scanner scanner = new Scanner(System.in);
		System.out.print("ÀÔ·ÂÇØ:");
		su = scanner.nextInt();
		System.out.print(su2(su));
	}

	private static int su2(int num) {
		int result;
		if (num >= 0) {
			result = num;
		} else {
			result = -num;
		}
		return result;
	}
}
