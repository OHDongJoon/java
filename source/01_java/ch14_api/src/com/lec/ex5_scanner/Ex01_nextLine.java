package com.lec.ex5_scanner;

import java.util.Scanner;

public class Ex01_nextLine {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("���̸� �Է��ϼ��� : ");
		int age = scanner.nextInt(); //���ھ��� ���ʹ�����  \n �� ����� ���� �Ѱ���
		System.out.println("�Է��Ͻ� ���̴� :" + age);

		System.out.print("�̸��� �Է��ϼ��� : ");
		String name = scanner.next();// whitespace �ձ��� ���� return // \n�� �״�� ����
		System.out.println("�Է��Ͻ� �̸��� " + name);

		System.out.print("�ּҸ� �Է��ϼ��� ");
		scanner.nextLine(); // ���ۿ� �����ִ� \n �� ����� ����
		String address = scanner.nextLine(); // ���� /n�� �ϱ� 
		//nextLine '\n' �տ� �ִ� ���� return �ϰ�  ���� �� 
		System.out.println("�Է��Ͻ� �ּҴ� "+ address);
		
		//nextInt ���̴� ? 30 \n => 30 �Ѱ��ְ� \n����
		//next \n ȫ�浿 \n �տ� \n�� ���� �ڿ� \n ����
		//nextLine(); /n ����� 
		//�״��� �ּ� �Է�
	}
}
