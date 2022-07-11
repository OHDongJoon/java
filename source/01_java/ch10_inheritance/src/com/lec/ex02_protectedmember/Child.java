package com.lec.ex02_protectedmember;
//상속 받을때 extends (상속 땡겨올 클래스 이름)
public class Child extends SuperIJ {
	private int total;

	public Child() {
		System.out.println("매개변수 없는 Child 생성자");
	
	}
	//Child c = new Child(10,20);
	// Superij에 있는 int i this로 못땡ㅇ겨옴
	public Child(int i, int j) {
		setI(i);//this.i = i 이거놉
		setJ(j);
		System.out.println("매개변수 있는 CHild 생성자");
	}
	public void sum() {
		total = getI() + getJ(); // total = i + j ;
		System.out.printf("본 객체의 i = %d, j=%d", getI(), getJ());
		System.out.println();
	}
	
}
