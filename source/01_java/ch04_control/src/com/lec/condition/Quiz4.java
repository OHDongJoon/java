package com.lec.condition;

import java.util.Scanner;

public class Quiz4 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("����(0) ����(1) ��(2) �ϳ��� ������ :");
		int num = sc.nextInt();
		if(num == 0) {
			System.out.println("����");
		} else if(num == 1) {
			System.out.println("����");
		}else if(num == 2) {
			System.out.println("��");
		}else {
			System.out.println("��ȿ���� �ʴ� ���Դϴ�");
		}

 }
}