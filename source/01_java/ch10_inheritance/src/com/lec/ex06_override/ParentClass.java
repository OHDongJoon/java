package com.lec.ex06_override;

public class ParentClass {

	public ParentClass() { // �̰� overloding = �Լ� �ߺ� ����(�Ű������� ���� Ÿ���� �޸� �Ѵ� )
		System.out.println("�Ű����� ���� ParentClass ������");
		
	}
	public ParentClass(int i ) {
		System.out.println("�Ű����� �ִ� ParentClass ������");
	}
	public void method1() {
		System.out.println("ParentClass�� method1() �Լ�");
	}
	public void method2() {
		System.out.println("parentClass�� method2() �Լ�");
	}
}
