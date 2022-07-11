package com.lec.ex3_set;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

public class Ex04_Iterator {
	public static void main(String[] args) {
		ArrayList<String> list = new ArrayList<String>();
		list.add("STR1"); list.add("STR2");
		//System.out.println(list);
		Iterator<String> iterator1 = list.iterator(); //Array list Iterator ���¹�
		while(iterator1.hasNext()) {
			System.out.println(iterator1.next());
		}
//		for(String l : list) {
//			System.out.println(l);
//		}
		//     ��
		HashMap<String , String > map = new HashMap<String, String>();
		map.put("ȫ�浿", "010-9999-9999");
		map.put("��浿", "010-9999-9999");
		Iterator<String> iterator2 = map.keySet().iterator(); //map Iterator ���¹�
		while(iterator2.hasNext()) {
			String key = iterator2.next();
			System.out.println(key + "Ű�� ������ : " + map.get(key));
		}
		// ��
		HashSet<String> set = new HashSet<String>();
		set.add("str0"); set.add("str1"); set.add("str1");
		Iterator<String> iterator3 = set.iterator(); // set Iterator ���¹�
		while(iterator3.hasNext()) { // ������ �������� ���� �ƹ��͵������� ��������
			System.out.println(iterator3.next());
		}
	}
}
