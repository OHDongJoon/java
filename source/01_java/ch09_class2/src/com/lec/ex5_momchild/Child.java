package com.lec.ex5_momchild;

// Child first = new Child("첫째");
// first.takeMoney(1000); 엄마 천원만
public class Child {
	private String name;
	static MomPouch momPouch;

	public Child() {
	}

	public Child(String name) {
		this.name = name;
		momPouch = new MomPouch(); // 초기화 하는 생성자
	}

	public void takeMoney(int money) {// w자식이달라는돈
		if (momPouch.money >= money) {
			momPouch.money -= money;
			System.out.println(name + "가" + money + "원 가져가서 엄마지갑에" + momPouch.money + "원있음");
		} else {
			System.out.println(name + "가 돈을 못 받음 . 현재 엄마 지갑에는" + momPouch.money + "원밖에 없음");
		} // if
	}// takeMoney
}// main
