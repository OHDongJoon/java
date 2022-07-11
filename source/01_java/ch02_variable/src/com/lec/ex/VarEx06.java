package com.lec.ex;

public class VarEx06 {
	public static void main(String[] args) {
		int i1 = 10;          // 4byte
		long l = 2200000000L; //8byte
		double d1 = 10;   //8byte = 4byte 묵시적인 형변환 (작은byte값을 큰byte 공간에)
		System.out.println("d1="+d1);
		double d2 = 10.19;
		int i2 = (int)d2;//명시적인 형변환(조심스럽게하자 데이터 손실이 발생할 수도있음) d2 8byte -> i2 4byte 
		System.out.println("i2="+i2);
		
		
	}
}
