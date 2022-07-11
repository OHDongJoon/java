package com.lec.ex01;
// 상수 (final 변수)와 추상메소드만 존재  
public interface InterfaceEX1 {
// 다른데서도 써야되기때문에 public  
	public /*static final */int CONSTANT_NUM = 10;
	// 일반 메소드 놉 추상만 올수있다 이말이야 
	
	// 나를 상속받은 애가 void로 가져가
	public /*abstract*/ void method1();
}
