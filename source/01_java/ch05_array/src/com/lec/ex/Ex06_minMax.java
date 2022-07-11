package com.lec.ex;

import java.util.Scanner;

//사용자로부터 영희, 철수, 길동, 영수, 말자의 키를 입력받아, 평균키를 출력
// 최장신이름과 키, 최단신 이름과 키 출력 
public class Ex06_minMax {
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
		System.out.println("평균키는"+(double)totalheight/arrname.length );
		scanner.close();
		// 최장신이름과 키, 최단신 이름과 키 출력
		// 작은 키 변수
		int minHeight = 999 , minIdx=-1; // 최단신키와 index(위치)
		int maxHeight = 0, maxIdx=0; //최장신키와 index(위치)
		for(int i = 0 ; i<arrname.length ; i++) {
			if(arrheight[i]<minHeight) {
				minHeight = arrheight[i];
				minIdx = i;
			}//if - 최단신 키와 최단신index찾기
			if(arrheight[i] > maxHeight) {
				maxHeight = arrheight[i];
				maxIdx = i ;
			}//if - 최장신 키와 최장신index 찾기
		}
		System.out.printf("최장신 학생은 %s, 키는,%d\n", arrname[maxIdx], maxHeight);
		System.out.printf("최단신 학생은 %s, 키는,%d\n", arrname[minIdx], minHeight);
	}
}
