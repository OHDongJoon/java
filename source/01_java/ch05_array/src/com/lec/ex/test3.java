package com.lec.ex;
//76,45,34,89,100,50,90,92  8���� ���� 1���� �迭�� �ʱ�ȭ �ϰ� ���� �հ��  
//��� �׸��� �ִ밪�� �ּҰ��� ���ϴ� ���α׷��� �ۼ� �Ͻÿ�. 
public class test3 {
	public static void main(String[] args) {
		int[] num = {76,45,34,89,100,50,90,92};
		int num1 = 0;
		for(int idx = 0 ; idx < num.length ; idx++) {
			num1 += num[idx] ;
		}
		int maxnum = num[0];
		int minnum = num[0];
		for(int i =0 ; i < num.length ; i++) {
			if(num[i] < minnum) {
				minnum = num[i];
			}
			if(num[i] > maxnum) {
				maxnum = num[i];
			}
		}
		
	}
}
