package com.lec.ex09_super;

// Person ��� �޾����� name, character / intro()�� ���ִ°ž�
// Baby b = new Baby("ȫ�ư�", "�̻�");
// Baby b1 = new Baby();
public class Baby extends Person {
	public Baby() {
		System.out.println("�Ű����� ���� Baby");
	}
//	public Baby(String name , String character) { // ���� �ߴ��� 
//		setName(name); setCharacter(character);

	public Baby(String name, String character) {
		super(name, character);
		System.out.println("�Ű����� �ִ� Baby ������");

	}
	@Override
	public void intro() {
		System.out.print("���� ���� �� �ư���");
		super.intro(); // �� Ŭ������ ���۴��� intro()
	}
}
