package com.lec.ex02_protectedmember;
// 데이터 - 생성자 - 메소드 - setter&getter
public class SuperIJ {
	private int i;
	private int j;
	//상속 받은 클래스에서 Super 클래스(부모단) 매개 변수 없는 생성자 함수를 먼저 호출
	public SuperIJ() {
		System.out.println("매개변수 없는거 SuperIJ 생성자 함수");
	}
	public SuperIJ(int i, int j) {
		this.i = i;
		this.j = j;
		System.out.println("매개변수 있는 SuperIJ 생성자 함수로 i, j값 초기화");
	}
	protected int getI() { //protected 상속받은 애만 사용 가능 같은 페키지에서 사용 가능 다른 페키지면 상속받아야 사용가능
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
