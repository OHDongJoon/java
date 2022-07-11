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
		// p1.equals(p2)  ȣ���Ұ�� p1��ſ� this. p2 ��ſ� obj => ����ü�� juminNO �� obj.juminNo�� ������ ���θ� return
		// p1.equals(p3) ȣ���� ��� p3��� obj => false�� return
		if(obj != null && obj instanceof Person) { //obj�� Person Ÿ���� ��ü
			return  juminNO == ((Person)obj).juminNO;
		}else {
			return false;
		}
	}
}
