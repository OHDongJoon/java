package com.lec.quiz;
// ����, ����, ���� ������ ������ �Ҵ��ϰ� �� ������ ����ϰ� ����, ���(�Ҽ���2�ڸ�����) ����
import java.util.Scanner;

public class Quiz5 {
public static void main(String[] args) {
	Scanner scanner = new Scanner(System.in);
	System.out.print("��������:");
	int kor = scanner.nextInt();
	System.out.print("����:");
	int eng = scanner.nextInt();
	System.out.print("��������:");
	int math = scanner.nextInt();
	
	int sum = kor + eng + math;
	double agv = sum/3.0;
	System.out.printf("����:%d\t ����:%d\t ����:%d\n����:%d\n���:%.2f", kor, eng, math, sum, agv);
}
}
