package com.lec.ex02_protectedmember;
// ������ - ������ - �޼ҵ� - setter&getter
public class SuperIJ {
	private int i;
	private int j;
	//��� ���� Ŭ�������� Super Ŭ����(�θ��) �Ű� ���� ���� ������ �Լ��� ���� ȣ��
	public SuperIJ() {
		System.out.println("�Ű����� ���°� SuperIJ ������ �Լ�");
	}
	public SuperIJ(int i, int j) {
		this.i = i;
		this.j = j;
		System.out.println("�Ű����� �ִ� SuperIJ ������ �Լ��� i, j�� �ʱ�ȭ");
	}
	protected int getI() { //protected ��ӹ��� �ָ� ��� ���� ���� ��Ű������ ��� ���� �ٸ� ��Ű���� ��ӹ޾ƾ� ��밡��
		return i;
	}
	protected void setI(int i) {
		this.i = i;
	}
	protected int getJ() {
		return j;
	}
	public void setJ(int j) {
		this.j = j;
	}
	
}
