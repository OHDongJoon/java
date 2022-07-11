package com.lec.ex08_superdot;

public class ChildClass extends ParentClass { // ParentClass - i 는 private에 담겨 잇고 method는 public담겨잇음

	private int i = 99;

	public ChildClass() {
		System.out.println("ChildClass 생성자");
	}

	@Override
	public void method() {
		System.out.println("ChildClass의 method");
		super.method();
		System.out.println("ChildClass에서 super의 i =" + super.getI()+", Child단의 i="+i);
	}
	@Override
		public int getI() {
			
			return i;
		}
//	public int getI() {
//		return super.getI();
//	}
}
