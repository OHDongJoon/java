package com.lec.loop;
//1~10까지 숫자 중 짝수 또는 홀수 합
public class Qiuz2 {
	public static void main(String[] args) {
		int sum = 0;
		for(int i = 1 ; i <=10; i++) {
			if(i%2==0) {
				sum += i;
			//홀수 
//			if(i%2 != 0) {
//				sum += i;
	//		}
			}//if
		}//for
		System.out.println(sum);
	}
}
