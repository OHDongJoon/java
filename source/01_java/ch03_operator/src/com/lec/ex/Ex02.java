package com.lec.ex;
// �������� : ++ --
public class Ex02 {
	public static void main(String[]args) {
		int n1 = 10;
		int n2 = n1--; // n1���� �ϳ� ���� �ڿ������� ; �ڿ��������� ���� 
		System.out.println("n1="+n1+"\n n2="+n2);
		
		n2 = ++n1; // n1���� �ϳ� �ٷ�����
		System.out.println("n1="+n1+"\n n2="+n2);
	}

}
