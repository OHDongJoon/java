package com.lec.ex03_point;

public class Point {
	private int x ;
	private int y;
	public Point(){} // 매개변수 없는 디폴트  설정 // 오버로딩 (함수)
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
		System.out.println("매개변수 두개");
	}//  Point p = new Point(1,2);  -1
	// p.pointPrint();				-2
	//System.out. println(p.infoStirng()	-3
	//System.out.prinntln(p)		-4
	
	public void pointPrint() {
		System.out.println("2차원 좌표 : x="+x+",y="+y);
	}
	public  String infoString() {
		return "2차원 좌표 : x="+x+", y="+y;
	}
	@Override // 상속 받은게 맘에 안들때 
	public String toString() { // 오버라이드(함수 재정의) = 상속받은 함수의 매개변수, 리턴타입 동일
		return "2차원 좌표 : x="+x+", y="+y+"-----";
		
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
