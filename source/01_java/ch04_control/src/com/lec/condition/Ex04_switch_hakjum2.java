package com.lec.condition;

import java.util.Scanner;

//사용자로부터 점수를 입력받아 학점 출력.
public class Ex04_switch_hakjum2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("점수 :");
		int score = sc.nextInt();
		if((90 <= score && score <= 100)){
			System.out.println("A학점");
		}else if(80<= score && score < 90) {
			System.out.println("B학점");
		}else if(70<= score && score < 80) {
			System.out.println("B학점");
		}else if(70<= score && score < 80) {
			System.out.println("C학점");
		}else if(60 <= score && score < 70) {
			System.out.println("D");
		}else if(0<= score && score < 60) {
			System.out.println("F학점");
		}else {
			System.out.println("유효한 점수가 아닙니다.");
		}
			sc.close();
	}

}
