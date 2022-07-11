package com.lec.ex05_test;
// 물려 받은것 : i1 i2 i3 m1추상 m2추상 m3추상
// 이번 클래스에서 추상 메소드 다 오버라이드 해서 일반 으로 바뀜 
// i1 i2 i3 (일반m1) (일반 m2)  (m3 일반)
// inter face 를 class로 땡겨올때 implements 해야딤

public class TestClass implements I3 {
	@Override
	public void m1() {
		System.out.println("상수 i1 = " + i1); // I1.i1

	}

	@Override
	public void m2() {
		System.out.println("상수 i2 = " + i2); // I2.i2

	}

	@Override
	public void m3() {
		System.out.println("상수 i1 = " + i3); // I3.i3

	}

}
