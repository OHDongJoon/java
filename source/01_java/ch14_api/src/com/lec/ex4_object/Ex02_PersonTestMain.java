package com.lec.ex4_object;

public class Ex02_PersonTestMain {
	public static void main(String[] args) {
		Person p1 = new Person(9510101213316L);
		Person p2 = new Person(9510101213316L);
		Person p3 = null;
		System.out.println(p1.toString());
		System.out.println(p2);
		System.out.println(p3);
		if(p1.equals(p2)) {
			System.out.println("p1�� p2�� �������");
		}else {
			System.out.println("�ٸ����");
		}
		if(p1==p2) {
			System.out.println("p1�� p2�� �����ּ�");
		}else {
			System.out.println("p1�� p2�� �ٸ� �ּ�");
		}
	}
}
