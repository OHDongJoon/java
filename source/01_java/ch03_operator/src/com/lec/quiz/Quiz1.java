package com.lec.quiz;
//����ڷκ��� �Է¹��� ���� 3�� ������� ���� ���
import java.util.Scanner;


public class Quiz1 {
public static void main(String[] args) {
	Scanner scanner = new Scanner(System.in);
	System.out.println("���� �Է��ϼ���");
	int i = scanner.nextInt();
	System.out.println((i%3)==0 ? "�Է��Ͻ� i�� 3�� ��� �Դϴ�": "�Է��Ͻ� i�� 3�� ����� �ƴմϴ�");
 }
}
