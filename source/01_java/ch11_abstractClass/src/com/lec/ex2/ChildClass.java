package com.lec.ex2;

//					 SuperClass
//method1(추상 메소드 들어옴 ), method2(일반메소드로 들어옴)
public class ChildClass extends SuperClass {

	@Override
	public void method1() {
		System.out.println("ChildClass의 method1 - 추상메소드라서 오버라이드함");

	}

	@Override
	public void method2() {
		System.out.println("ChildClass의 method2 - 해도 되고 안해도 되공 걍 오버라이드함");
	}

}
