package com.lec.ex02_protectedmember;
//��� ������ extends (��� ���ܿ� Ŭ���� �̸�)
public class Child extends SuperIJ {
	private int total;

	public Child() {
		System.out.println("�Ű����� ���� Child ������");
	
	}
	//Child c = new Child(10,20);
	// Superij�� �ִ� int i this�� �������ܿ�
	public Child(int i, int j) {
		setI(i);//this.i = i �̰ų�
		setJ(j);
		System.out.println("�Ű����� �ִ� CHild ������");
	}
	public void sum() {
		total = getI() + getJ(); // total = i + j ;
		System.out.printf("�� ��ü�� i = %d, j=%d", getI(), getJ());
		System.out.println();
	}
	
}
