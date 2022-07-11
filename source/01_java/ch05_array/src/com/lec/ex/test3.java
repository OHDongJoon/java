package com.lec.ex;
//76,45,34,89,100,50,90,92  8개의 값을 1차원 배열로 초기화 하고 값에 합계와  
//평균 그리고 최대값과 최소값을 구하는 프로그램을 작성 하시요. 
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
