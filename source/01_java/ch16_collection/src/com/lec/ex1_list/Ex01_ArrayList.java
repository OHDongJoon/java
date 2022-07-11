package com.lec.ex1_list;

import java.util.ArrayList;

public class Ex01_ArrayList {
	public static void main(String[] args) {
		String[] array = new String[5]; // 배열 5로 셋팅했다고 치면 변경하기 힘들다
		array[0] = "str0"; array[1]="str1"; array[3] ="str3"; // 5방이잉ㅆ어도 3개만 넣어도 상관없다 null로들어가니까
		for(int i =0 ; i <array.length ; i++) {
			System.out.printf("array[%d] = %s\t ", i , array[i]);
		}
		System.out.println(); //개행;
		for(String arr : array) {
			System.out.println(arr +"\t");
		}
		System.out.println("\n ~ ~ ~  ~ ArrayList ~ ~ ~ ~");
		ArrayList<String> arrayList = new ArrayList<String>();
		//ArrayList<int> list = new ArrayList<int>(); AraayList는 객체형 ArrayList만 가능
		// 배열은 정해저있는 방안에 값을 넣었는데 리스트는 그냥 추가하는 개념이다 
		arrayList.add("str0"); // arrayList에 추가해라 그냥  0인덱스를
		arrayList.add("str1"); // 1번 인덱스 - >2번 되고 
		arrayList.add("str2"); // 2번 인덱스 - > 3번 되고 
		System.out.println(arrayList);
		arrayList.add(1, "str11111111111"); // 원래 1번이있는데  1번 인덱스 추가해버리면 하나씩 밀린다
		System.out.println(arrayList);
		arrayList.set(1, "1111"); // 1번 인덱스 값 수정
		for(String alist : arrayList) {
			System.out.print(alist + "\t");
		}
		System.out.println("\n - remove한 후에 -");
		arrayList.remove(1); // 1번째 인덱스의 데이터 삭제 (2 -> 1번 인덱스, 3->2번인덱스)
		arrayList.remove(arrayList.size()-1); // 맨 마지막 인덱스 데이터 삭제 
		for(int idx = 0 ; idx < arrayList.size(); idx ++ ) {
			System.out.printf("%d번째 인데스 값은 %s\n",idx,arrayList.get(idx));
		}
		System.out.println();//개행
		arrayList.clear(); // arrayList의 모든 데이터 삭제 리스트는 남아 있고 데이터만 삭제
		if(arrayList.size() == 0) {
			System.out.println("arrayList의 데이터는 없습니다");
		}
		if(arrayList.isEmpty()) {
			System.out.println("arrayList의 데이터는 없습니다");
		}
		System.out.println(arrayList);
		arrayList = null; // arrayList null 을 넣으면 리스트 자체가 없어짐
	
	}
}
