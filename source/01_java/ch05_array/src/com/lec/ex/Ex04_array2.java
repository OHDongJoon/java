package com.lec.ex;
// API를 이용한 배열 복사  System.arraycopy(원본배열,원본시작idx,복사본배열, 복사본idx, 방갯수)
public class Ex04_array2 {
	public static void main(String[] args) {
		int[] score = {100,10,20,30,40};
		int[] s = new int[score.length ];
		//시스템 어레이카피 불러 (원본  ,idx,복사배열,복사idx, 방 갯수
		//System.arraycopy(원본배열객체, int 원본시작위치, 복사본배열객체, int 복사본시작위치, int 복사길이);
		System.arraycopy(score, 0 , s, 0,  score.length);
		s[0] = 999;
		for(int idx=0; idx<score.length ; idx++) {
			System.out.printf("score[%d]=%d\t s[%d]=%d\n", idx, score[idx], idx, s[idx]);
		}
		
	}

}
