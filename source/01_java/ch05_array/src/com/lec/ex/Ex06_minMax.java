package com.lec.ex;

import java.util.Scanner;

//����ڷκ��� ����, ö��, �浿, ����, ������ Ű�� �Է¹޾�, ���Ű�� ���
// ������̸��� Ű, �ִܽ� �̸��� Ű ��� 
public class Ex06_minMax {
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
		System.out.println("���Ű��"+(double)totalheight/arrname.length );
		scanner.close();
		// ������̸��� Ű, �ִܽ� �̸��� Ű ���
		// ���� Ű ����
		int minHeight = 999 , minIdx=-1; // �ִܽ�Ű�� index(��ġ)
		int maxHeight = 0, maxIdx=0; //�����Ű�� index(��ġ)
		for(int i = 0 ; i<arrname.length ; i++) {
			if(arrheight[i]<minHeight) {
				minHeight = arrheight[i];
				minIdx = i;
			}//if - �ִܽ� Ű�� �ִܽ�indexã��
			if(arrheight[i] > maxHeight) {
				maxHeight = arrheight[i];
				maxIdx = i ;
			}//if - ����� Ű�� �����index ã��
		}
		System.out.printf("����� �л��� %s, Ű��,%d\n", arrname[maxIdx], maxHeight);
		System.out.printf("�ִܽ� �л��� %s, Ű��,%d\n", arrname[minIdx], minHeight);
	}
}
