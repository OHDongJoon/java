package com.lec.ex1_string;

import java.util.Scanner;

// 7��° 
//<����.�ֹι�ȣ�� �Է¹޾� �������� �������� ��� ����> �ֹι�ȣ�� ��920225-2012121���������� �Է¹޴´�.
public class Ex04_jumin {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String ju;
		do {
			System.out.println("�ֹι�ȣ�� �Է��ϼ���:");
			ju = scanner.next();
			switch (ju.charAt(7)) {
			case '1':
			case '3':
				System.out.println("�����Դϴ�");
				break;
			case '2':
			case '4':
				System.out.println("�����Դϴ�");
			}
		} while (!ju.equalsIgnoreCase("x"));
		System.out.println("DONE");

	}

}
