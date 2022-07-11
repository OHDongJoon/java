package test;

import java.util.HashMap;
import java.util.Scanner;
import java.util.Iterator;

public class TestMain2 {
	public static void main(String[] args) {
		Member member = new Member();
		HashMap<String, Member> members = new HashMap<String, Member>();
		String answer, name, phone, address;
		Scanner sc = new Scanner(System.in);
		
		do {
			System.out.println("회원가입 진행하시겠습니까? (Y/N)");
			answer = sc.next();
			if(answer.equalsIgnoreCase("n")) {
				break;
			}else if(answer.equalsIgnoreCase("y"))
			System.out.println("이름입력:");
			name = sc.next();
			System.out.println("전화입력:");
			phone = sc.next();
			if(members.get(phone) !=null) {
				System.out.println("이미 가입되어 있는 전번");
				continue;
			}
			

			System.out.println("주소입력:");
			sc.nextLine();
			address = sc.nextLine();
			members.put(phone, new Member(name, phone, address));

			
		} while (true);
		sc.close();
		if(members.isEmpty()) {
			System.out.println("가입한 회원이 없습니다");
		}else {
			System.out.println("가입 회원 리스트");
			Iterator<String> iterator = members.keySet().iterator();
			while(iterator.hasNext()) {
				System.out.println(members.get(iterator.next()));
			}
		}

	}

}