package com.lec.ex4_object;

public class Ex04_RectangleTestMain {
	public static void main(String[] args) throws CloneNotSupportedException {

		Rectangle r1 = new Rectangle(); // 가로 0 높이 0 색 검정
		r1.setHeight(10); r1.setWidth(5);
		Rectangle r2 = (Rectangle) r1.clone(); // 객체를 따로 만든게 아니라 r1이 가르킨걸 r2도 가르킨다 
		System.out.println("r1 : " + r1);
		System.out.println("r2 :" + r2);
		// 복제를했으면 다른 주소를 가르켜야지 
		System.out.println(r1.equals(r2) ? "같은 사각형" : "다른사각형");
		System.out.println(r1 == r2 ? "복사한게아니고 같은 주소를 가리킴" : "다른주소를 가르킴");
		//복제 
		if(r1 !=r2 && r1.equals(r2)) {
			System.out.println("복제성공");
		}else {
			System.out.println("복제실패");
		}
		System.out.println(r1.hashCode());
		System.out.println(r2.hashCode());
		System.out.println(r1.getClass());
	}
}