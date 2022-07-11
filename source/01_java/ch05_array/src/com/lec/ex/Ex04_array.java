package com.lec.ex;
// for문을 이용한 복사방법
public class Ex04_array {
//복사 하는법
	public static void main(String[] args) {
		
		int[] score = {100,10,20,30,40};
		// score랑 똑같은 빈공간 선언 두개의 배열이 생기는거지 
		int[] s = new int[score.length ];
		//포문으로 
		for(int idx=0 ; idx<score.length; idx++) { //for문을 이용한 배열 복사 
			s[idx] = score[idx];
		}
		s[0] = 999;
		for(int idx=0; idx<score.length ; idx++) {
			System.out.printf("score[%d]=%d\t s[%d]=%d\n", idx, score[idx], idx, s[idx]);
		}
		
	}

}
