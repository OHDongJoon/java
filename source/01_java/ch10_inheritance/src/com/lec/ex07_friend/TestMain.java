package com.lec.ex07_friend;

public class TestMain {
	public static void main(String[] args) {
		Friend f1 = new Friend();// �Ű����� ���� ������ 
		System.out.println(f1.infoString()); //fr�� info
		Friend f2 = new Friend("ȫ�浿"); // �Ű����� �Ѱ�¥�� 
		System.out.println(f2.infoString());
		Friend f3 = new Friend("ȫ���", "010-9999-999");
		System.out.println(f3.infoString());
	}
}
