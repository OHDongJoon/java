package com.lec.ex6_wrapper;

public class Ex01 {
	public static void main(String[] args) {

		int i = 10;
		int j = 10;
		int sum = i+j;
		System.out.println("����" + sum);
		System.out.println(i==j ? "�� int �� ����" : "�� int�� �ٸ���");
		Integer iObj = new Integer(10);
		Integer jObj = new Integer(10);
		//Integer jObj = 10; //���� �˾Ƽ� new Integer ���ش�
		sum = iObj.intValue() + jObj.intValue();
		System.out.println("����"+sum);
		System.out.println(jObj.equals(jObj)? "�� wrapper ��ü ���� ����" : "�� wrapper ��ü ���� �ٸ���");
		System.out.println(jObj == jObj ? "�ּҰ� ����" : "�ּҰ� �ٸ���");
	//	Sawon s = new Sawon("a01", "ȫ�浿", Dept.COMPUTER);
	//	if (s.equals(i)) { //equals�� ��ü�� ���ߵȴ�
	
		}
	}
