package com.lec.ex05_;

public class Child1 extends Super {
	int c1 = 2;

	public Child1() {
		System.out.println("Child1형 객체 생성");
		
	}

	public Child1(int c1) {
		 System.out.println("Child1형 객체 생성(매개변수)");
		 this.c1 = c1;
	}

}
