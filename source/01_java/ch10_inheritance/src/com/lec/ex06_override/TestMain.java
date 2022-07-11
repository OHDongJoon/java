package com.lec.ex06_override;

public class TestMain {
	public static void main(String[] args) {
		ParentClass pobj1 = new ParentClass();
		ParentClass pobj2 = new ParentClass();
		if (pobj1.equals(pobj2)) {
			System.out.println("두객체는 같다");
		} else {
			System.out.println("두 객체는 다르다");
		}
		ChildClass cobj = new ChildClass(2);
		if (cobj.equals(pobj2)) {
			System.out.println("무조건 true지");
		}
		pobj1.method1();
		pobj2.method2();
		System.out.println("--------------------");
		cobj.method1(); // ChildClass의method1
		cobj.method2(); // ParentClass의 method2
		cobj.method3(); // ChildClass의 method3
		ParentClass cobj1 = new ChildClass(2);
		// cObj1.method3(); // 에라남
		cobj1.method1(); // ChildClass 의 method1 실행
		cobj1.method2(); // ParentClass의 method2
		// if(ParentClass형 cobj1 변수를 ChildClass형으로반환 가능하니?)
		if (cobj1 instanceof ChildClass) {
			((ChildClass) cobj1).method3();
		}else {
			System.out.println("형변환 안됨");
		}

	}//main
}// class