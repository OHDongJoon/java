package com.lec.loop;
// 구구단 출력
public class Quiz4 {
	public static void main(String[] args) {
		for(int i=1 ; i<10 ; i++) {
			for(int j=2 ; j<10 ; j++) {
				System.out.printf("%d * %d= %d\t",j,i, j*i);
			}// for-j
			System.out.println();//개행  추가
		}// for -i
	}
}
