package com.lec.ex1_string;

import java.util.Scanner;

public class Ex03_equal {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String fn;
		do {
			System.out.print("I : input | U : update | X : exxit");
			fn = scanner.next(); // �빮�� �� �ҹ��� ���� �Է��ϴϰ�
			switch(fn) {
			case "i":
			case "I":
				System.out.println("input ���� ���� ��");
				break;
			case "u":
			case "U":
				System.out.println("update ���� ���� ��");
			}
		}while( !fn.equalsIgnoreCase("x") );
		System.out.println("DONE");
	}
}
