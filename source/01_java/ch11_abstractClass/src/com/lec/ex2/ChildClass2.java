package com.lec.ex2;
			//	SuperClass
// method1(추상메소드상태로), method2(일반메소드)
public abstract class ChildClass2 extends SuperClass{
	@Override
	public void method2() {
		System.out.println("ChildClass2의 method2 - 걍 오버라이드함");
	}
}
