package com.lec.ex1_tryCatch;
//����ó������
import java.util.Scanner;

public class Ex01 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("��Ģ������ �� ù��° ����?");
		int i = scanner .nextInt();
		System.out.println("��Ģ������ �ι�° ���� ?");
		int j = scanner.nextInt();
		System.out.println("i = "+ i + ", j ="+ j);
		System.out.println("i * j =" + (i*j));
		System.out.println("i / j =" + (i/j)); // ���ܰ� �߻�
		System.out.println("i + j =" + (i+j));
		System.out.println("i - j =" + (i-j));
		System.out.println("DONE");
		scanner.close();
	}
}
