package com.lec.ex2;

public class Testmain2 {
	public static void main(String[] args) {
		//SuperClass s = new SuperClass() //추상 클래스를 이용한 객체 생성 불가
		//ChildClass2 c = new ChildClass2();// 놉
		GrandChild g = new GrandChild();
		g.method1();
		g.method2();
	}
}
