package com.lec.condition;

import java.util.Scanner;

//����ڷκ��� ����, ����, ���� ������ �Է¹޾� �� ���� ������ ��� �̻����� �������� ����غ���
public class Quiz3 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("���� ����:");
		int kor = sc.nextInt();
		System.out.print("���� ����:");
		int math = sc.nextInt();
		System.out.print("���� ����:");
		int eng = sc.nextInt();
		double eve =(kor + eng + math)/3.0;
		if(kor >= eve) {
			System.out.printf("���������� �������(%3.1f)�̻��Դϴ�\n",eve);
		}else
			System.out.printf("���������� �������(%3.1f)�����Դϴ�.\n",eve);
		if(math >= eve) {
			System.out.printf("���������� �������(%.1f)�̻��Դϴ�\n",eve);
		}else
			System.out.printf("���������� �������(%3.1f)�����Դϴ�\n",eve);
		if(eng >= eve) {
			System.out.printf("���������� �������(%3.1f)�̻��Դϴ�\n",eve);
		}else
			System.out.printf("���������� �������(%3.1f)�����Դϴ�\n",eve);
}

}
