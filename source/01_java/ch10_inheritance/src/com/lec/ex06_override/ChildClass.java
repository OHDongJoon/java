package com.lec.ex06_override;
//parentClass�� method1(), method2() ��ӹ���
//�޼ҵ尡 ���� �ȵ�� �޼ҵ� �״�� �Ȱ���  childClass 
public class ChildClass extends ParentClass {
	public ChildClass() {
		System.out.println("�Ű����� ���� ChildClass ������");
	}
	public ChildClass(int i ) {
		System.out.println("�Ű����� �ִ� ChildClass ������");
	}
	public void method3() {
		System.out.println("ChildClass�� method3() �Լ�");
	}
	@Override
	public void method1() { //ChildClass�� method3() �Լ� (�Ȱ����� �����;ߵȴ� , ���������ڸ� �޸� �Ҽ� �ִ�.)
		System.out.println("ChildClass�� method1() �Լ�");
	}
	@Override
	public boolean equals(Object obj) { // object Ŭ���� equals �������̵�(���� ���ܵ� ����)
		return true;
	}

}
