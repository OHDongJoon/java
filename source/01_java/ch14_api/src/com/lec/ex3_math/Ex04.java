package com.lec.ex3_math;

import java.util.Random;

// 로또번호 6개 뽑기
public class Ex04 {
	public static void main(String[] args) {
		int [] lotto = new int[6];
		Random random = new Random();
		for(int idx = 0 ; idx<lotto.length; idx++) {
			lotto[idx] = random.nextInt(45)+1;
		}
		for(int i = 0 ; i < lotto.length ; i ++) {
			for(int j = i+1 ; j < lotto.length ; j ++) {
				if(lotto[i] > lotto[j]) {// i 번째수가 j번째 수보다 크면 바꿈
					int temp = lotto[i];//
					lotto[i] = lotto[j];
					lotto[j] = temp;
				}
			}//오름차순 정
		}
		for(int l : lotto) {
			System.out.print(l+" ");
		}
	}
}
