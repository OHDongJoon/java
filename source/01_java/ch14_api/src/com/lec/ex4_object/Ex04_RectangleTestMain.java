package com.lec.ex4_object;

public class Ex04_RectangleTestMain {
	public static void main(String[] args) throws CloneNotSupportedException {

		Rectangle r1 = new Rectangle(); // ���� 0 ���� 0 �� ����
		r1.setHeight(10); r1.setWidth(5);
		Rectangle r2 = (Rectangle) r1.clone(); // ��ü�� ���� ����� �ƴ϶� r1�� ����Ų�� r2�� ����Ų�� 
		System.out.println("r1 : " + r1);
		System.out.println("r2 :" + r2);
		// ������������ �ٸ� �ּҸ� �����Ѿ��� 
		System.out.println(r1.equals(r2) ? "���� �簢��" : "�ٸ��簢��");
		System.out.println(r1 == r2 ? "�����ѰԾƴϰ� ���� �ּҸ� ����Ŵ" : "�ٸ��ּҸ� ����Ŵ");
		//���� 
		if(r1 !=r2 && r1.equals(r2)) {
			System.out.println("��������");
		}else {
			System.out.println("��������");
		}
		System.out.println(r1.hashCode());
		System.out.println(r2.hashCode());
		System.out.println(r1.getClass());
	}
}