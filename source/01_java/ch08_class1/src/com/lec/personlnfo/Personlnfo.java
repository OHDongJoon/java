package com.lec.personlnfo;

//name, age, gender�� �����ͷ� ����, ������ ������ ����ϴ� print() 
//�޼Ҵ��� ���� PersonInfo 
//Ŭ������ �����ϰ� main�Լ��� �̿��Ͽ� test �����Ͻÿ�
//(print() �޼ҵ� ���� ��� : �̸�=ȫ�浿, ����=20, ����=m, 
//main �޼ҵ� �ȿ��� PersonInfo�� ��ü �ν��Ͻ��� �迭�� ������ ���ϴ�)
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
		System.out.println("�̸���:"+name);
		System.out.println("���̴�"+age);
		System.out.println("����:"+gender);
		
	}
}
