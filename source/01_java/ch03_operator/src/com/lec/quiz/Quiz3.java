package com.lec.quiz;

import java.util.Scanner;

// �μ��� �Է¹޾�
// �� ���� ������ ����� o�� x�� ���.
// ù��° ���� �� ū�� ����� o x�� ����Ѵ�.
public class Quiz3 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("���� �Է��ϼ���:");
		int su1 = scanner.nextInt();
		System.out.print("�ι�° ���� �Է��ϼ���:");
		int su2 = scanner.nextInt();
		if (su1 == su2) {
			System.out.println("�μ��� ����");
		} else
			System.out.println("�μ��� ��������");
		if (su1 > su2) {
			System.out.println("ù��°���� ŭ 0");
		}
	}
}