package com.lec.ex1_string;
//concat : ���ڿ� ����
//substring (3) 3���� ���� ������
public class Ex02_stringAPImethod {
	public static void main(String[] args) {
		String str1 = "abcXabc"; // �����
		String str2 = new String("ABCXabc"); //��ü������
		String str3 = "            ja       va        ";	
		System.out.println("1."+ str1.concat(str2)); // ���ڿ� ���� abc Xabc + ABCXabc // concat : Strig Ÿ�� +
		                                               
										//substring :		//  0 1 2 3~~~~ 
		System.out.println("2."+str1.substring(3)); // str1 :   a b c X a b c   // Xabc���
		System.out.println("3."+str1.substring(3,5)); // 3���� ���� 5���� �ձ���     X , a
		System.out.println("4."+str1.length()); // ���ڱ���
		System.out.println("5."+str1.toUpperCase()); // �빮�ڷ� ����ABC
		System.out.println("6."+str1.toLowerCase()); // �빮�ڿ��� �ҹ��� ���� �ҹ��ڴ� �״�� 
		System.out.println("7."+str1.charAt(3)); // 3��° ���� 'x'
		System.out.println("8."+str1.indexOf('b')); // ù��° 'b'�� ������ ��ġ
		System.out.println("9."+str1.indexOf('c', 3));// 3������� �˻��ؼ� ù��° b��ġ
		System.out.println("10."+str1.indexOf("abc"));// ù��° "abc" ������ ��ġ 0
		System.out.println("11."+str1.indexOf("abc",3));// 3��°���� �˻��ؼ� "abc" ��ġ 4
		System.out.println("12."+str1.indexOf('z'));// ������ -1
		System.out.println("13."+str1.lastIndexOf('b'));// �������� �ִ�  'b' ��ġ 4 
		System.out.println("14."+str1.lastIndexOf('b',3)); //3������� �� ������ b �� ----------------------------------- ?
		System.out.println("---------------------------");
		System.out.println("15."+str1.equals(str2)); // str1�� str2�� ���� ���ڿ����� false
		System.out.println("16."+str1.equalsIgnoreCase(str2));// ��ҹ��ڱ��о��� �� true----------------------------??
		System.out.println("17."+str3.trim()); //�յڰ������� // �߰� �������Ŵ� ����
		System.out.println("18."+str1.replace('a', '9')); //a�� 9�� ����
		System.out.println("19."+str1.replace("abc", "��"));// abc�� ������ ����
		System.out.println("str3�� space�� ���ֱ�:"+str3.replace(" ", ""));
		System.out.println("20."+str1.replaceAll("abc", "��")); // abc�� "z"
		/* ����ǥ���� http://goo.gl/HLntbd
		 * 				������ : http://www.nextree.co.kr/p4327
		 */
		// replaceAll ��� ���� �ѱ۸�����   �Ϲ� rplace�� ������� ���� ��ã��
		String str = "�ȳ�Hello"; // ������ �� *�� �� 
		System.out.println(str.replaceAll("[a-zA-Z]", "" ));// ���ĺ��� ""�� ����
		System.out.println(str.replaceAll("[��-�R]", ""));// �ѱ۹��ڸ� "" �� ����
		//���ڿ� �޼ҵ�� ���ڿ��� ���� ���� 
		// �״�� ���� 
		System.out.println("str1 = "+ str1);
		System.out.println("str2 = "+ str2);
		System.out.println("str3 = "+ str3);
		
 	}
}
