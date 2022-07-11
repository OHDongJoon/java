package com.lec.ex03_point;

public class TestMain {
	public static void main(String[] args) {
		Point point = new Point(5,5);
		System.out.println("-------");
		point.setX(10);
		System.out.println("------");
		point.pointPrint();
		System.out.println("---------------");
		
		System.out.println(point.infoString());
		System.out.println("--------");
		System.out.println(point); // object의 toString() 호출됨
		System.out.println(point.toString());
		Point3D point3d = new Point3D(1, 2, 3);
		System.out.println(point3d.infoString());
		System.out.println(point3d.infoString());// 상속을 받으면 모든 멤버와 메소드 다 상속
		
	}
	
}
