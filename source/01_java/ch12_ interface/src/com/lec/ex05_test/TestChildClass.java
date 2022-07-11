package com.lec.ex05_test;
// i1, i2, i3, i11, m1일반 m2 일반 m3 일반, m11 추상 오버라이드
public class TestChildClass extends TestClass implements I11 {
//인터페이스는 private 못쓴다 가져와야 되기 때문에 
	@Override
	public void m11() {
		System.out.println("상수 i11 =" + i11);

	}

}
