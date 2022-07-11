package com.lec.quiz;
//사용자로부터 입력받은 수가 3의 배수인지 여부 출력
import java.util.Scanner;


public class Quiz1 {
public static void main(String[] args) {
	Scanner scanner = new Scanner(System.in);
	System.out.println("수를 입력하세요");
	int i = scanner.nextInt();
	System.out.println((i%3)==0 ? "입력하신 i는 3의 배수 입니다": "입력하신 i는 3의 배수가 아닙니다");
 }
}
