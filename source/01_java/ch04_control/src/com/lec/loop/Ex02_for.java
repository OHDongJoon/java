package com.lec.loop;
// 1~20까지 누적합 출력
public class Ex02_for {
	public static void main(String[] args) {
		int tot = 0; // 누적할 변수 0 초기화
		for(int i = 1 ; i <=20; i++) {
			//i 1초기화 i가 20보다 작냐 
			tot += i;//tot = tot + i;
			
		}
		System.out.println("1~20까지 누적합은"+tot);
	}

}
