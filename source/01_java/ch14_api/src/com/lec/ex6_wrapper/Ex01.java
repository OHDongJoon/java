package com.lec.ex6_wrapper;

public class Ex01 {
	public static void main(String[] args) {

		int i = 10;
		int j = 10;
		int sum = i+j;
		System.out.println("합은" + sum);
		System.out.println(i==j ? "두 int 는 같다" : "두 int는 다르다");
		Integer iObj = new Integer(10);
		Integer jObj = new Integer(10);
		//Integer jObj = 10; //지가 알아서 new Integer 해준다
		sum = iObj.intValue() + jObj.intValue();
		System.out.println("합은"+sum);
		System.out.println(jObj.equals(jObj)? "두 wrapper 객체 값은 같다" : "두 wrapper 객체 값은 다르다");
		System.out.println(jObj == jObj ? "주소가 같다" : "주소가 다르다");
	//	Sawon s = new Sawon("a01", "홍길동", Dept.COMPUTER);
	//	if (s.equals(i)) { //equals는 객체가 들어가야된다
	
		}
	}
