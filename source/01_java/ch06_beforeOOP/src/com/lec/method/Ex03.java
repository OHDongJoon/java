package com.lec.method;
// Arithmetic.sum / evenOdd(static) vs abs(�Ϲݸ޼ҵ�)
public class Ex03 {
	public static void main(String[] args) {
		int tot = Arithmetic.sum(10); //�ٸ���Ű�� �ҷ� �ö� �̸�����
		System.out.println("1~10���� ����"+ tot);
		System.out.println(Arithmetic.evenOdd(tot));
		Arithmetic ar = new Arithmetic();
		System.out.println("-8�� ���밪"+ar.abs(-8));
	}

}
