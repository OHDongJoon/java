package com.lec.ex05_;

public class TestMain2 {
	public static void main(String[] args) {
		Super c1 = new Child1(10);
		System.out.println("c1.s ="+c1.s);
		System.out.println("c1.c1 ="+( (Child1)c1).c1);// c1 객체 변수의 명시적  형변환
	}
}
