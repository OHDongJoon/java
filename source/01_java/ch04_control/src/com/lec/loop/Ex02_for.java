package com.lec.loop;
// 1~20���� ������ ���
public class Ex02_for {
	public static void main(String[] args) {
		int tot = 0; // ������ ���� 0 �ʱ�ȭ
		for(int i = 1 ; i <=20; i++) {
			//i 1�ʱ�ȭ i�� 20���� �۳� 
			tot += i;//tot = tot + i;
			
		}
		System.out.println("1~20���� ��������"+tot);
	}

}
