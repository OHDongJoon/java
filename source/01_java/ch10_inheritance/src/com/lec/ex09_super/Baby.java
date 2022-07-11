package com.lec.ex09_super;

// Person 상속 받았으니 name, character / intro()가 다있는거얌
// Baby b = new Baby("홍아가", "이뻐");
// Baby b1 = new Baby();
public class Baby extends Person {
	public Baby() {
		System.out.println("매개변수 없는 Baby");
	}
//	public Baby(String name , String character) { // 원래 했던거 
//		setName(name); setCharacter(character);

	public Baby(String name, String character) {
		super(name, character);
		System.out.println("매개변수 있는 Baby 생성자");

	}
	@Override
	public void intro() {
		System.out.print("응애 응애 난 아가야");
		super.intro(); // 내 클래스의 슈퍼단의 intro()
	}
}
