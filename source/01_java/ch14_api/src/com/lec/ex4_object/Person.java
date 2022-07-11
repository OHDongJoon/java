package com.lec.ex4_object;

public class Person {
	private long juminNO;// 9512121024243

	public Person(long juminNO) {
		this.juminNO = juminNO;
	}

	@Override
	public String toString() {
		return "Person [juminNO=" + juminNO + "]";
	}
	@Override
	public boolean equals(Object obj) {
		// p1.equals(p2)  호출할경우 p1대신에 this. p2 대신에 obj => 내객체의 juminNO 와 obj.juminNo가 같은지 여부를 return
		// p1.equals(p3) 호출할 경우 p3대신 obj => false를 return
		if(obj != null && obj instanceof Person) { //obj가 Person 타입의 객체
			return  juminNO == ((Person)obj).juminNO;
		}else {
			return false;
		}
	}
}
