package com.lec.ex1_string;

import java.util.Scanner;

public class Ex05_regex {
	public static void main(String[] args) {
		String str = "010-9999-9999 kok3443@naver.com (02)565-8888 반갑습니다.  Hello 951010-144234";
		//System.out.println("replace => "+ str.replace("0","홍길동")); //0 만 홍으로 바뀜 
		/*정규표현식(regex)
		 1. 참조 : https://goo.g1/HLntbd
		정규표현식

		특정한 규칙을 가진 문자열의 집합
		 2. 간략한 문법
		        \d(숫자와 매치, [0-9] 와 동일 \D(숫자가 아닌것)
				\s (whitespacen : space, 탭 , 엔터)
				\W (영문자나 숫자, [a-zA-ZO-9] \W(영문자나 숫자가 아닌 문자)
				   .(문자 하나)
				   +(1번이상 반복)
				   * (0번이상 반복)
				   ?(0~1번 반복)
				   {2,4} (2~4회 반복)
		3. 정규표현식 연습장 https://regexr.com/ https://www.regexpal.com
			ex. 전화번호 : .?[0-9]{2,3}.[0-9]{3,4}-[0-9]{4}
		4. 특정 정규표현식 : replaceAll("정규표현식", "대체문자열")
		*/ 
		
		// 전화번호 지움
		System.out.println(str.replaceAll("[(]?[0-9]{2,3}\\D[0-9]{3,4}-[0-9]{4}","**전화번호지움**"));
		// 이메일 지움
		//[0-9a-zA-Z]  == \w + @  골뱅이가 무조건 나오고 \w + .\w +
		System.out.println(str.replaceAll("\\w+@\\w+(.\\w+){1,2}", "**이메일지움**"));
		//알파벳 대신 *로 대체
		System.out.println(str.replaceAll("[a-zA-Z]", "*"));
		//한글 싹 다 없애
		System.out.println(str.replaceAll("[가-힣ㄱ-ㅎ]", ""));
		// 주민번호
		System.out.println(str.replaceAll("[0-9]{7}","*******"));
	}
}







