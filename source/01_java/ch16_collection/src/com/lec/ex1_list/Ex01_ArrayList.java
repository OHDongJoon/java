package com.lec.ex1_list;

import java.util.ArrayList;

public class Ex01_ArrayList {
	public static void main(String[] args) {
		String[] array = new String[5]; // �迭 5�� �����ߴٰ� ġ�� �����ϱ� �����
		array[0] = "str0"; array[1]="str1"; array[3] ="str3"; // 5�����פ�� 3���� �־ ������� null�ε��ϱ�
		for(int i =0 ; i <array.length ; i++) {
			System.out.printf("array[%d] = %s\t ", i , array[i]);
		}
		System.out.println(); //����;
		for(String arr : array) {
			System.out.println(arr +"\t");
		}
		System.out.println("\n ~ ~ ~  ~ ArrayList ~ ~ ~ ~");
		ArrayList<String> arrayList = new ArrayList<String>();
		//ArrayList<int> list = new ArrayList<int>(); AraayList�� ��ü�� ArrayList�� ����
		// �迭�� �������ִ� ��ȿ� ���� �־��µ� ����Ʈ�� �׳� �߰��ϴ� �����̴� 
		arrayList.add("str0"); // arrayList�� �߰��ض� �׳�  0�ε�����
		arrayList.add("str1"); // 1�� �ε��� - >2�� �ǰ� 
		arrayList.add("str2"); // 2�� �ε��� - > 3�� �ǰ� 
		System.out.println(arrayList);
		arrayList.add(1, "str11111111111"); // ���� 1�����ִµ�  1�� �ε��� �߰��ع����� �ϳ��� �и���
		System.out.println(arrayList);
		arrayList.set(1, "1111"); // 1�� �ε��� �� ����
		for(String alist : arrayList) {
			System.out.print(alist + "\t");
		}
		System.out.println("\n - remove�� �Ŀ� -");
		arrayList.remove(1); // 1��° �ε����� ������ ���� (2 -> 1�� �ε���, 3->2���ε���)
		arrayList.remove(arrayList.size()-1); // �� ������ �ε��� ������ ���� 
		for(int idx = 0 ; idx < arrayList.size(); idx ++ ) {
			System.out.printf("%d��° �ε��� ���� %s\n",idx,arrayList.get(idx));
		}
		System.out.println();//����
		arrayList.clear(); // arrayList�� ��� ������ ���� ����Ʈ�� ���� �ְ� �����͸� ����
		if(arrayList.size() == 0) {
			System.out.println("arrayList�� �����ʹ� �����ϴ�");
		}
		if(arrayList.isEmpty()) {
			System.out.println("arrayList�� �����ʹ� �����ϴ�");
		}
		System.out.println(arrayList);
		arrayList = null; // arrayList null �� ������ ����Ʈ ��ü�� ������
	
	}
}
