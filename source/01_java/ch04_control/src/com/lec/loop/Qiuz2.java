package com.lec.loop;
//1~10���� ���� �� ¦�� �Ǵ� Ȧ�� ��
public class Qiuz2 {
	public static void main(String[] args) {
		int sum = 0;
		for(int i = 1 ; i <=10; i++) {
			if(i%2==0) {
				sum += i;
			//Ȧ�� 
//			if(i%2 != 0) {
//				sum += i;
	//		}
			}//if
		}//for
		System.out.println(sum);
	}
}
