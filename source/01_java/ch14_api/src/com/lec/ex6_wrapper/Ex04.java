package com.lec.ex6_wrapper;

import java.util.Scanner;

//����ڷκ��� �������ڿ���("100 ") �Է¹޾�  ������ �����ؼ� ����ϴ� ���α׷�
public class Ex04 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("������ �Է��ϼ���");
		String numStr = scanner.nextLine();
		System.out.println("�Է��Ͻ� ���ڿ��� "+ numStr);
		numStr = numStr.trim();// �¿� space�� �����ȴ�
		numStr = numStr.replaceAll("[a-zA-Z��-�R]", "");//���� ����
		int num = Integer.parseInt(numStr);
		System.out.println("������ ������" + num);
		
	}
}
