package test3;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;

public class TestMain2 {
	public static void main(String[] args) {
		Customer customer = new Customer() ;
		HashMap<String,Customer> customers = new HashMap<String,Customer>();
		String answer, name, phone, address;
		Scanner sc = new Scanner(System.in);
		
		do {
			System.out.println("회원가입 하시겠습니까 ? 아니면 n");
			answer = sc.next();
			if(answer.equalsIgnoreCase("n")) 
				break;
			System.out.print("회원님 이름은?");
			name = sc.next();
			System.out.print("회원님 전화번호는?");
			phone = sc.next();
			System.out.print("회원님 주소는?");
			sc.nextLine();
			address = sc.nextLine();
			customers.put(phone,new Customer(name,phone,address));
			
		}while(true);
		sc.close();
		if(customers.isEmpty()) {
			System.out.println("가입한 회원이 없습니다");
		}else {
			System.out.println("가입 회원리스트");
			Iterator<String> iterator = customers.keySet().iterator();
			while(iterator.hasNext()) {
				System.out.println(customers.get(iterator.next()));
			}
		}
	}
}
