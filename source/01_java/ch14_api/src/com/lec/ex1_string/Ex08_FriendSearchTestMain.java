package com.lec.ex1_string;
//Friend 클래스형 객체 배열에 저장된 친구들의 핸드폰 번호 뒷자리로 

//친구를 검색하여, 존재하는 친구일 경우 친구의 전 정보를 출력하고, 
//존재하지 않는 친구일
//경우 존재하지 않는 친구라고 출력하는 프로그램을 구현하시오.

import java.util.Scanner;

public class Ex08_FriendSearchTestMain {
	public static void main(String[] args) {
		Friend[] friend = { new Friend("홍길동", "010-9999", "05-22"), new Friend("신길동", "010-8888-8888", "09-22"),
				new Friend("신길동","010-8888-8888", "03-28"),
				new Friend("마길동", "010-8888-9999", "08-22"),
				new Friend("윤길동", "010-7777-7777", "04-22"), 
				new Friend("김길동", "010-6666-7777", "03-22")};
		Scanner sc = new Scanner(System.in);
		while(true) {
			System.out.println("검색하고자 하는 회원의 전화번호 뒷자리는 ?:");
			String searchTel = sc.next();
			if(searchTel.equals("x")) break;
			boolean searchOk = false;
			for (int idx = 0; idx < friend.length; idx++) {
				String tel = friend[idx].getPhone();
				String post = tel.substring(tel.lastIndexOf('-'));
				if (post.equals(searchTel)) {
					System.out.println(friend[idx]);
					searchOk = true;
				}//if - 전화번호를 찾을 경우 더이상 검색하지 않고 for문 빠져나감
			}//for
			if (!searchOk) {
				System.out.println("검색하신 전화번호는 없습니다");

			}//if
			
		}//while
				sc.close();
			}//main
}//class

