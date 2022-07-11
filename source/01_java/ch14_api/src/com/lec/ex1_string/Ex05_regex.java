package com.lec.ex1_string;

import java.util.Scanner;

public class Ex05_regex {
	public static void main(String[] args) {
		String str = "010-9999-9999 kok3443@naver.com (02)565-8888 �ݰ����ϴ�.  Hello 951010-144234";
		//System.out.println("replace => "+ str.replace("0","ȫ�浿")); //0 �� ȫ���� �ٲ� 
		/*����ǥ����(regex)
		 1. ���� : https://goo.g1/HLntbd
		����ǥ����

		Ư���� ��Ģ�� ���� ���ڿ��� ����
		 2. ������ ����
		        \d(���ڿ� ��ġ, [0-9] �� ���� \D(���ڰ� �ƴѰ�)
				\s (whitespacen : space, �� , ����)
				\W (�����ڳ� ����, [a-zA-ZO-9] \W(�����ڳ� ���ڰ� �ƴ� ����)
				   .(���� �ϳ�)
				   +(1���̻� �ݺ�)
				   * (0���̻� �ݺ�)
				   ?(0~1�� �ݺ�)
				   {2,4} (2~4ȸ �ݺ�)
		3. ����ǥ���� ������ https://regexr.com/ https://www.regexpal.com
			ex. ��ȭ��ȣ : .?[0-9]{2,3}.[0-9]{3,4}-[0-9]{4}
		4. Ư�� ����ǥ���� : replaceAll("����ǥ����", "��ü���ڿ�")
		*/ 
		
		// ��ȭ��ȣ ����
		System.out.println(str.replaceAll("[(]?[0-9]{2,3}\\D[0-9]{3,4}-[0-9]{4}","**��ȭ��ȣ����**"));
		// �̸��� ����
		//[0-9a-zA-Z]  == \w + @  ����̰� ������ ������ \w + .\w +
		System.out.println(str.replaceAll("\\w+@\\w+(.\\w+){1,2}", "**�̸�������**"));
		//���ĺ� ��� *�� ��ü
		System.out.println(str.replaceAll("[a-zA-Z]", "*"));
		//�ѱ� �� �� ����
		System.out.println(str.replaceAll("[��-�R��-��]", ""));
		// �ֹι�ȣ
		System.out.println(str.replaceAll("[0-9]{7}","*******"));
	}
}







