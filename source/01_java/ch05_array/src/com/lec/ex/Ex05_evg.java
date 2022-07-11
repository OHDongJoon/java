package com.lec.ex;

import java.util.Scanner;

//사용자로부터 영희, 철수, 길동, 영수, 말자의 키를 입력받아, 평균키를 출력
// 최장신 친구이름과 키, 최단신 친구 이름과 키 출력
public class Ex05_evg {
	public static void main(String[] args) {
		//문자열 변수 names 변수에 애들 담아줘
		String[] arrname = {"영희","철수","길동","영수","말자"};
		//애들 키 입력받아서 담을 변수 선언 name 방개수만큼 배열만들어
		int[]  arrheight = new int[arrname.length];
		Scanner scanner = new Scanner(System.in);
		int totalheight = 0; // 입력 받은 키 누적 변수
		for(int idx=0 ; idx < arrname.length ; idx ++) {
			System.out.print(arrname[idx]+"의 키는:");
			arrheight[idx] = scanner.nextInt();
			totalheight += arrheight[idx];
		}
		System.out.println("평균키는"+totalheight/arrname.length );
	}
}
