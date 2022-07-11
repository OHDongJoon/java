package com.lec.ex2_map;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class Ex01_HashMap {
	public static void main(String[] args) {
		ArrayList<String> list = new ArrayList<String>();
		list.add("aaa");
		System.out.println(list.get(0)); // list계열의 collection은 index로 get 함 
		HashMap<Integer , String> hashMap = new HashMap<Integer,String>(); 
		hashMap.put(11, "str11"); // 11key값에 데이터 "str11"을 추가 
		hashMap.put(20, "str20"); // 처음에 HashMap에 <Integer, 을 넣어놔서 그냥 숫자만 적어도 new 한것처럼 사용할수 있다
						  	      // 20 key 에 매핑되는 데이터 "str20"추가
		hashMap.put(33, "str33"); //  
		System.out.println(hashMap.get(20));// key값으로 데이터 get 함
		System.out.println("remove 전:" + hashMap);
		hashMap.remove(20); // key값을 적어야함
		System.out.println("remove 후 " + hashMap);
		hashMap.clear();
		System.out.println(hashMap.isEmpty()? " 데이터 모두 삭제 ": "데이터 있음"); 
		hashMap.put(0	, "honggildong");
		hashMap.put(10, "Kim dongil);");
		hashMap.put(22, "Lee soonsin");
		hashMap.put(40, "Yu ain");
		System.out.println(hashMap);
		Iterator <Integer> iterator = hashMap.keySet().iterator();
		// 순서가 없으니 0가르키는애 가져와 10을 가르키는애 가져와 22 가르키는애 가져와 ...
		while(iterator.hasNext()) {
			Integer key = iterator.next();
			System.out.println(key + "의 데이터는" + hashMap.get(key));
		}
	}
}
