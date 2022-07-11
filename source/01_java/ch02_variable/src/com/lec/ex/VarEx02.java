package com.lec.ex;
// println(); 콘솔창에 출력(개행포함)
// print ; 콘솔창에 출력(개행노포함)
// printf ; 콘솔창에 특정 포맷으로 출력 (개행미포함)
public class VarEx02 {
	public static void main(String[] args) {
		// 데이터타입 변수명 = 초기값
		int i = 10; // 4byte짜리 i라는 메모리공간에 10을 할당한다 
		byte j = 10; // 2byte짜리 j라는 공간에 10을 할당한다
		double h = 10.15; 
		i = 5;
		System.out.println("i="+i+"\t j="+j +"\t h="+h);
		//char 문자하나 두개쓰면 에라남 
		char c1 = 'A';
		char c2 = 'B';
		System.out.print("c1 =" +c1+"\t c2="+c2+"\n");
		
		//System.out.printf("c1=c1값\t c2=c2값\n", args)
		System.out.printf("c1=%c \t c2=%c\n", c1,c2);
		// %c = 문자
		//%d = 숫자 (정수)
		//%f = 실수
		//%s = 문자열
		System.out.printf("i=%d, j=%d, h=%5.1f \n" , i, j, h);
		// %5칸중에.1번재 자리까지 표시
		
		System.out.println("끝");
	}
	

}
