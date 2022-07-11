package com.lec.condition;

import java.util.Scanner;

//사용자로부터 국어, 영어, 수학 점수를 입력받아 각 과목별 점수가 평균 이상인지 이하인지 출력해보자
public class Quiz3 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("국어 점수:");
		int kor = sc.nextInt();
		System.out.print("수학 점수:");
		int math = sc.nextInt();
		System.out.print("영어 점수:");
		int eng = sc.nextInt();
		double eve =(kor + eng + math)/3.0;
		if(kor >= eve) {
			System.out.printf("국어점수가 평균점수(%3.1f)이상입니다\n",eve);
		}else
			System.out.printf("국어점수가 평균점수(%3.1f)이하입니다.\n",eve);
		if(math >= eve) {
			System.out.printf("수학점수가 평균점수(%.1f)이상입니다\n",eve);
		}else
			System.out.printf("수학점수가 평균점수(%3.1f)이하입니다\n",eve);
		if(eng >= eve) {
			System.out.printf("영어점수가 평균점수(%3.1f)이상입니다\n",eve);
		}else
			System.out.printf("영어점수가 평균점수(%3.1f)이하입니다\n",eve);
}

}
