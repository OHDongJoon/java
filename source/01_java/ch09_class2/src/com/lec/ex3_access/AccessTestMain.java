package com.lec.ex3_access;

public class AccessTestMain {
	public static void main(String[] args) {
		AccessTest obj = new AccessTest();
		// �Ⱥ��� ~obj.privateMember
		System.out.println(obj.defaultMember);
		System.out.println(obj.protectedMember);
		System.out.println(obj.publicMember);
		
	// �Ⱥ��� �����	obj.privateMeThod()
		obj.defaultMethod();
		obj.protectedMethod();
		obj.publicMethod();
	}
}
