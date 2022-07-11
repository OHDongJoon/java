package com.lec.ex1_tryCatch;

import java.util.InputMismatchException;
//���� :  ArithmeticException, InputMismatchException(���� �Է� ���ϰ� a �Է��Ҷ�)
import java.util.Scanner;

public class Ex03 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int i, j = 1;
		do {
			try {
				System.out.println("��Ģ������ �� ù��° ����?"); // ���� �Է��ϼ��� �ߴµ� ���� �Է������� ���Է� �Ҷ� ���� ����ó��
				i = scanner.nextInt();
				break; // i�� ������ ����� �Է��ϸ� break�� do while ��������
			} catch (InputMismatchException e) {
				System.out.println("���� �޼���:" + e.getMessage());
				System.out.println("������ �ݵ�� �Է��ϼ���");
				scanner.nextLine(); // ���۸� ����� ����
			}
		} while (true);
		System.out.println("��Ģ������ �ι�° ���� ?");
		try {
			j = scanner.nextInt(); // ���ܰ� �߻��ϸ� catch�� ��
			System.out.println("i = " + i + ", j =" + j);
			System.out.println("i * j =" + (i * j));
			System.out.println("i / j =" + (i / j)); // ���ܰ� �߻� 0�� �־����� ?
		} catch (ArithmeticException e) {
			System.out.println(e.getMessage());
		} catch (InputMismatchException e) {
			System.out.println("���ܸ޼���:" + e.getMessage());
			System.out.println("�ι�° ���� �߸� �Է��Ͻø� 1�� �ʱ�ȭ ��");
		} catch (Exception e) { // ��� Exception ��ӹ޾Ƽ�
			System.out.println("��� ���ܴ� �� ���ʿ� �ִ� �̸��̾�" + e.getMessage());

		}

		System.out.println("i + j =" + (i + j));
		System.out.println("i - j =" + (i - j));
		System.out.println("DONE");
		scanner.close();
	}
}
