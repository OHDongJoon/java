package com.lec.ex3_access;

public class AccessTestMain {
	public static void main(String[] args) {
		AccessTest obj = new AccessTest();
		// 안보여 ~obj.privateMember
		System.out.println(obj.defaultMember);
		System.out.println(obj.protectedMember);
		System.out.println(obj.publicMember);
		
	// 안보여 프라잆	obj.privateMeThod()
		obj.defaultMethod();
		obj.protectedMethod();
		obj.publicMethod();
	}
}
