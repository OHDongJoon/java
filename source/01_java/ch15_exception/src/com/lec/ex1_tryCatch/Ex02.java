package com.lec.ex1_tryCatch;
// java.lang.ArithmeticException ���ܰ�ü 
import java.util.Scanner;

public class Ex02 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("��Ģ������ �� ù��° ����?");
		int i = scanner .nextInt();
		System.out.println("��Ģ������ �ι�° ���� ?");
		int j = scanner.nextInt();
		System.out.println("i = "+ i + ", j ="+ j);
		System.out.println("i * j =" + (i*j));
		try {
		System.out.println("i / j =" + (i/j)); // ���ܰ� �߻��� �� �ִ� �κ�
		}catch(ArithmeticException e) {
			//���ܰ� �߻��� ��� ��ȸ������ 
			System.out.println("���� �޼��� :" +e.getMessage());
			//e.printStackTrace();//���ܻ����� �ڼ��� ���10
		}
		System.out.println("i + j =" + (i+j));
		System.out.println("i - j =" + (i-j));
		System.out.println("DONE");
		scanner.close();
	}
}
