package com.lec.ex06_override;
//parentClass의 method1(), method2() 상속받음
//메소드가 맘에 안들면 메소드 그대로 똑같이  childClass 
public class ChildClass extends ParentClass {
	public ChildClass() {
		System.out.println("매개변수 없는 ChildClass 생성자");
	}
	public ChildClass(int i ) {
		System.out.println("매개변수 있는 ChildClass 생성자");
	}
	public void method3() {
		System.out.println("ChildClass의 method3() 함수");
	}
	@Override
	public void method1() { //ChildClass의 method3() 함수 (똑같은걸 가져와야된다 , 접근제한자만 달리 할수 있다.)
		System.out.println("ChildClass의 method1() 함수");
	}
	@Override
	public boolean equals(Object obj) { // object 클래스 equals 오버라이드(윗단 윗단도 가능)
		return true;
	}

}
