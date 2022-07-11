package test;

import java.io.ObjectInputStream.GetField;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class TestMain1 {
	public static void main(String[] args) {
		ArrayList<Member> members = new ArrayList<Member>();
		Scanner scanner = new Scanner(System.in);
		String answer, name, phone, address;
		while(true) {
			System.out.print("회원가입 진행하시겠습니까 (Y/N)?");
			answer = scanner.next();
			if(answer.equalsIgnoreCase("n")) {
				break;
			}else if(answer.equalsIgnoreCase("y")) {
				System.out.print("가입하실 회원님 이름은 ?");
				name = scanner.next();
				System.out.print("가입하실 회원님 전화번호는 ?");
				phone = scanner.next();
				scanner.nextLine(); // 버퍼지우는 용도
				System.out.print("가입하실 회원님 주소는 ?");
				address = scanner.nextLine();
				members.add(new Member(name, phone, address));
			}
		}
		scanner.close();
		if(members.isEmpty()) {
			System.out.println(" 가입한 회원이 없습니다 ");
		}else {
			System.out.println(" 가입한 회원 리스트 목록 ");
			for(Member m : members) {
				System.out.println(m);
			} 
		}
	}
}