package com.lec.quiz;
// 국어, 영어, 수학 점수를 변수에 할당하고 각 점수를 출력하고 총점, 평균(소수점2자리까지) 츌력
import java.util.Scanner;

public class Quiz5 {
public static void main(String[] args) {
	Scanner scanner = new Scanner(System.in);
	System.out.print("국어점수:");
	int kor = scanner.nextInt();
	System.out.print("영어:");
	int eng = scanner.nextInt();
	System.out.print("수학점수:");
	int math = scanner.nextInt();
	
	int sum = kor + eng + math;
	double agv = sum/3.0;
	System.out.printf("국어:%d\t 수학:%d\t 영어:%d\n총점:%d\n평균:%.2f", kor, eng, math, sum, agv);
}
}
