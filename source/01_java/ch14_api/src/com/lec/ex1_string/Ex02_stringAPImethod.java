package com.lec.ex1_string;
//concat : 문자열 결합
//substring (3) 3번재 부터 끝까지
public class Ex02_stringAPImethod {
	public static void main(String[] args) {
		String str1 = "abcXabc"; // 노생성
		String str2 = new String("ABCXabc"); //객체를생성
		String str3 = "            ja       va        ";	
		System.out.println("1."+ str1.concat(str2)); // 문자열 결합 abc Xabc + ABCXabc // concat : Strig 타입 +
		                                               
										//substring :		//  0 1 2 3~~~~ 
		System.out.println("2."+str1.substring(3)); // str1 :   a b c X a b c   // Xabc출력
		System.out.println("3."+str1.substring(3,5)); // 3번재 부터 5번재 앞까지     X , a
		System.out.println("4."+str1.length()); // 글자길이
		System.out.println("5."+str1.toUpperCase()); // 대문자로 변경ABC
		System.out.println("6."+str1.toLowerCase()); // 대문자에서 소문자 변경 소문자는 그대로 
		System.out.println("7."+str1.charAt(3)); // 3번째 문자 'x'
		System.out.println("8."+str1.indexOf('b')); // 첫번째 'b'가 나오는 위치
		System.out.println("9."+str1.indexOf('c', 3));// 3번재부터 검색해서 첫번째 b위치
		System.out.println("10."+str1.indexOf("abc"));// 첫번째 "abc" 나오는 위치 0
		System.out.println("11."+str1.indexOf("abc",3));// 3번째부터 검색해서 "abc" 위치 4
		System.out.println("12."+str1.indexOf('z'));// 없으면 -1
		System.out.println("13."+str1.lastIndexOf('b'));// 마지막에 있는  'b' 위치 4 
		System.out.println("14."+str1.lastIndexOf('b',3)); //3번재부터 맨 마지막 b 를 ----------------------------------- ?
		System.out.println("---------------------------");
		System.out.println("15."+str1.equals(str2)); // str1과 str2가 같은 문자열인지 false
		System.out.println("16."+str1.equalsIgnoreCase(str2));// 대소문자구분없이 비교 true----------------------------??
		System.out.println("17."+str3.trim()); //앞뒤공백제거 // 중간 공백제거는 못함
		System.out.println("18."+str1.replace('a', '9')); //a를 9로 수정
		System.out.println("19."+str1.replace("abc", "ㅁ"));// abc를 ㅁ으로 수정
		System.out.println("str3의 space를 없애기:"+str3.replace(" ", ""));
		System.out.println("20."+str1.replaceAll("abc", "ㅁ")); // abc를 "z"
		/* 정규표현식 http://goo.gl/HLntbd
		 * 				연습장 : http://www.nextree.co.kr/p4327
		 */
		// replaceAll 영어만 지워 한글만지워   일반 rplace는 영어많으면 언제 다찾아
		String str = "안녕Hello"; // 영문자 다 *로 써 
		System.out.println(str.replaceAll("[a-zA-Z]", "" ));// 알파벳을 ""로 수정
		System.out.println(str.replaceAll("[가-힣]", ""));// 한글문자를 "" 로 수정
		//문자열 메소드는 문자열을 수정 안함 
		// 그대로 있음 
		System.out.println("str1 = "+ str1);
		System.out.println("str2 = "+ str2);
		System.out.println("str3 = "+ str3);
		
 	}
}
