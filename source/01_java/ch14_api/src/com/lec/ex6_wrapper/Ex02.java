package com.lec.ex6_wrapper;

public class Ex02 {
	public static void main(String[] args) {
		double i = 10.1;
		double j = 10.1;
		double sum = i+j;
		System.out.println("����" + sum);
		System.out.println(i==j ? "�� int �� ����" : "�� int�� �ٸ���");
		Double iObj = 10.1;
		Double jObj = new Double(10.1);
		//Integer jObj = 10; //���� �˾Ƽ� new Integer ���ش�
		sum = iObj + jObj;   //sum = iObj.intValue() + jObj.intValue();
		System.out.println("����"+sum);
		System.out.println(iObj.equals(j)? "����" : "�ٸ���");
		System.out.println(iObj == jObj ? "�ּҰ� ����" : "�ּҰ� �ٸ���");
	
	
		}
	}


//Sawon s = new Sawon("a01", "ȫ�浿", Dept.COMPUTER);
//	if (s.equals(i)) { //equals�� ��ü�� ���ߵȴ�