package com.lec.ex01;

public class TestMain {

	public static void main(String[] args) {
		// InterfaceEx1 ex1 = new InterfaceEx1(); // 인터페이스를 이용한 객체 생성 노오오오옵
		InterfaceClass obj1 = new InterfaceClass();
		obj1.method1();
		obj1.method2();
		System.out.println(obj1.CONSTANT_NUM + "/" + obj1.CONSTANT_STRING); // 객체 변수로 sstatic access 비추
		System.out.println(InterfaceClass.CONSTANT_NUM + "/" + InterfaceEx2.CONSTANT_STRING);
		InterfaceEX1 obj2 = new InterfaceClass();
		obj2.method1();
		if (obj2 instanceof InterfaceClass) {
			((InterfaceClass) obj2).method2();
		}
		InterfaceEx2 obj3 = new InterfaceClass();
		// 안됨 oobj3.method1();xxxx  ? interfaceEx는 메서드 1이 없다
		obj3.method2();
	}
}
