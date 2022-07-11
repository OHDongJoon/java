package com.lec.ex01;

//CONSTANT_STRING 추상 method1
//CONSTANT_NUM 추상 method2
// 다중으로 받을수잇다 Ex1 Ex2 이렇게 가져왓움 ㅎㅎ
public class InterfaceClass implements InterfaceEX1, InterfaceEx2 {

	@Override
	public String method2() {
		System.out.println("실제 구현은 implements한 클래스에서해요. method2");
		return null;
	}

	@Override
	public void method1() {
		System.out.println("실제 구현은 implements 받은 클래스에서 해요 method1");

	}

}
