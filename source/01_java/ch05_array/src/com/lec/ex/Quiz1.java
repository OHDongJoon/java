package com.lec.ex;
//배열에 담긴 값을 더하는 프로그램을 작성
public class Quiz1 {
	public static void main(String[] args) {
		int[] arr = {10,20,30,40,50};
		int sum = 0;
		for(int i = 0; i <arr.length; i++) {
			
		}
		for(int temp : arr) {
			sum += temp;
		}
		System.out.printf("더한값은:%d",sum);
			
		
	}
}
