package com.lec.ex03_point;

public class Point {
	private int x ;
	private int y;
	public Point(){} // �Ű����� ���� ����Ʈ  ���� // �����ε� (�Լ�)
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
		System.out.println("�Ű����� �ΰ�");
	}//  Point p = new Point(1,2);  -1
	// p.pointPrint();				-2
	//System.out. println(p.infoStirng()	-3
	//System.out.prinntln(p)		-4
	
	public void pointPrint() {
		System.out.println("2���� ��ǥ : x="+x+",y="+y);
	}
	public  String infoString() {
		return "2���� ��ǥ : x="+x+", y="+y;
	}
	@Override // ��� ������ ���� �ȵ鶧 
	public String toString() { // �������̵�(�Լ� ������) = ��ӹ��� �Լ��� �Ű�����, ����Ÿ�� ����
		return "2���� ��ǥ : x="+x+", y="+y+"-----";
		
	}
	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}


	
}
