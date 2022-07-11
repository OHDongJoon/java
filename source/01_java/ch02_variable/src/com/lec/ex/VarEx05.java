package com.lec.ex;

public class VarEx05 {
	public static void main(String[]args) {
		//boolean 참 거짓만 가능
		// f= 작은 주머니 10.1은 큰주머니 못들어가 10.1뒤에 F사용
		// 월급 저장 하는 변수 int 사용
		float f1;
		f1 = 10.1F;
		System.out.println("f1="+f1);	
		f1 = 10.0000017f;
		double d = 10.0000017;
		System.out.println("f1="+f1);
		System.out.println("d="+d);
		
		// float랑 duble 은 같지않다 duble을 자주사용
		f1= 10.1f;
		d = 10.1;
		if (f1==d)
			System.out.println("두변수는 같다");
		else
			System.out.println("두변수는 같지않다");
	}
}
