package com.lec.condition;

import java.util.Scanner;

//���� �Է¹޾� ���밪�� ����ϴ�  ���α׷�
public class Quiz1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("���� �Է��ϼ���:");
		int su = sc.nextInt(); 
		if(su >= 0) {
			System.out.printf("�Է��Ͻ� ���밪:%d\n",su);
		}else
			System.out.printf("�Է��Ͻ� ���� ��:%d\n", -su);
			
	}
}

