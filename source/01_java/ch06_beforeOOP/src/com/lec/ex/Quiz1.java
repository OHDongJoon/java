package com.lec.ex;

import java.util.Scanner;

//��  ���� �Ű������� �޾� �ش� �ܼ��� �������� ����ϴ� �κ��� method�� ó���Ѵ�. ����ڰ� 2~9 ������ ���� �ƴѼ���
// �Է��� �� 2~9 ������ ���� �Է��� ������ ��� �Է� �޴´�.)
public class Quiz1 {
	public static void main(String[] args) {
		int dansu;
		Scanner scanner = new Scanner(System.in);
		do {
			System.out.print("2~9�� �Է�:");
			dansu = scanner.nextInt();
		} while (2 > dansu || dansu > 9);
		gugu(dansu);

	}

	private static void gugu(int dansu) {
		for (int i = 1; i < 10; i++)
			System.out.printf("%d *%d = %d\n", dansu, i, dansu * i);

	}

}
