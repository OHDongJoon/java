package com.lec.ex;

import java.util.Scanner;

//����ڷκ��� ����, ö��, �浿, ����, ������ Ű�� �Է¹޾�, ���Ű�� ���
// ����� ģ���̸��� Ű, �ִܽ� ģ�� �̸��� Ű ���
public class Ex05_evg {
	public static void main(String[] args) {
		//���ڿ� ���� names ������ �ֵ� �����
		String[] arrname = {"����","ö��","�浿","����","����"};
		//�ֵ� Ű �Է¹޾Ƽ� ���� ���� ���� name �氳����ŭ �迭�����
		int[]  arrheight = new int[arrname.length];
		Scanner scanner = new Scanner(System.in);
		int totalheight = 0; // �Է� ���� Ű ���� ����
		for(int idx=0 ; idx < arrname.length ; idx ++) {
			System.out.print(arrname[idx]+"�� Ű��:");
			arrheight[idx] = scanner.nextInt();
			totalheight += arrheight[idx];
		}
		System.out.println("���Ű��"+totalheight/arrname.length );
	}
}
