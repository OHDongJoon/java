package com.lec.ex06_override;

public class TestMain {
	public static void main(String[] args) {
		ParentClass pobj1 = new ParentClass();
		ParentClass pobj2 = new ParentClass();
		if (pobj1.equals(pobj2)) {
			System.out.println("�ΰ�ü�� ����");
		} else {
			System.out.println("�� ��ü�� �ٸ���");
		}
		ChildClass cobj = new ChildClass(2);
		if (cobj.equals(pobj2)) {
			System.out.println("������ true��");
		}
		pobj1.method1();
		pobj2.method2();
		System.out.println("--------------------");
		cobj.method1(); // ChildClass��method1
		cobj.method2(); // ParentClass�� method2
		cobj.method3(); // ChildClass�� method3
		ParentClass cobj1 = new ChildClass(2);
		// cObj1.method3(); // ����
		cobj1.method1(); // ChildClass �� method1 ����
		cobj1.method2(); // ParentClass�� method2
		// if(ParentClass�� cobj1 ������ ChildClass�����ι�ȯ �����ϴ�?)
		if (cobj1 instanceof ChildClass) {
			((ChildClass) cobj1).method3();
		}else {
			System.out.println("����ȯ �ȵ�");
		}

	}//main
}// class