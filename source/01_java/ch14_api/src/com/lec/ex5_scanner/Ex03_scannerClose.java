package com.lec.ex5_scanner;

import java.util.Scanner;

public class Ex03_scannerClose {
	public static void main(String[] args) {
		//BookLib ��ü ���� ����ڿ��� ����or�ݳ�
		Scanner scMain = new Scanner(System.in);
		System.out.println("�̸�?");
		String name = scMain.nextLine();
		System.out.println("�Է��Ͻ� �̸���"+name);
		nickName();//
		System.out.println("���� ?");
		int age = scMain.nextInt();
		System.out.println("�Է��Ͻ� ���̴� ?"+age);
	}
	//����ڷκ��� ������ ����ϴ� �޼ҵ�
	private static void nickName() {// ��ü�� ����°Ծƴϴ� static���� ȣ�������� static ���� ����     
		Scanner scNickName = new Scanner(System.in);
		System.out.print("������?");
		System.out.println("�Է��Ͻ� ������ "+scNickName.nextLine());
	//	scNickName.close(); ��ĳ�� ��ü�� close�� main������
	}
}
