package com.lec.personlnfo;

//name, age, gender를 데이터로 갖고, 데이터 정보를 출력하는 print() 
//메소더를 갖는 PersonInfo 
//클래스를 구현하고 main함수를 이용하여 test 구현하시오
//(print() 메소드 실행 결과 : 이름=홍길동, 나이=20, 성별=m, 
//main 메소드 안에는 PersonInfo형 객체 인스턴스를 배열로 구현해 봅니다)
public class Personlnfo {
	private String name ;
	private int age ;
	private char gender ;

	public Personlnfo() {
	}
	public Personlnfo (String name, int age, char gender) {
		this.name = name;
		this.age = age;
		this.gender=gender;
	}
	public void vPrint() {
		System.out.println("이름은:"+name);
		System.out.println("나이는"+age);
		System.out.println("성별:"+gender);
		
	}
}
