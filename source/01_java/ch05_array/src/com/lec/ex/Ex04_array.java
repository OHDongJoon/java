package com.lec.ex;
// for���� �̿��� ������
public class Ex04_array {
//���� �ϴ¹�
	public static void main(String[] args) {
		
		int[] score = {100,10,20,30,40};
		// score�� �Ȱ��� ����� ���� �ΰ��� �迭�� ����°��� 
		int[] s = new int[score.length ];
		//�������� 
		for(int idx=0 ; idx<score.length; idx++) { //for���� �̿��� �迭 ���� 
			s[idx] = score[idx];
		}
		s[0] = 999;
		for(int idx=0; idx<score.length ; idx++) {
			System.out.printf("score[%d]=%d\t s[%d]=%d\n", idx, score[idx], idx, s[idx]);
		}
		
	}

}
