package com.lec.ex05_test;
// i1, i2, i3, i11, m1�Ϲ� m2 �Ϲ� m3 �Ϲ�, m11 �߻� �������̵�
public class TestChildClass extends TestClass implements I11 {
//�������̽��� private ������ �����;� �Ǳ� ������ 
	@Override
	public void m11() {
		System.out.println("��� i11 =" + i11);

	}

}
