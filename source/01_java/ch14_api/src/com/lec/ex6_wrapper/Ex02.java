package com.lec.ex6_wrapper;

public class Ex02 {
	public static void main(String[] args) {
		double i = 10.1;
		double j = 10.1;
		double sum = i+j;
		System.out.println("합은" + sum);
		System.out.println(i==j ? "두 int 는 같다" : "두 int는 다르다");
		Double iObj = 10.1;
		Double jObj = new Double(10.1);
		//Integer jObj = 10; //지가 알아서 new Integer 해준다
		sum = iObj + jObj;   //sum = iObj.intValue() + jObj.intValue();
		System.out.println("합은"+sum);
		System.out.println(iObj.equals(j)? "같다" : "다르다");
		System.out.println(iObj == jObj ? "주소가 같다" : "주소가 다르다");
	
	
		}
	}


//Sawon s = new Sawon("a01", "홍길동", Dept.COMPUTER);
//	if (s.equals(i)) { //equals는 객체가 들어가야된다