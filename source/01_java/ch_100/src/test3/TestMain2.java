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
			System.out.println("ȸ������ �Ͻðڽ��ϱ� ? �ƴϸ� n");
			answer = sc.next();
			if(answer.equalsIgnoreCase("n")) 
				break;
			System.out.print("ȸ���� �̸���?");
			name = sc.next();
			System.out.print("ȸ���� ��ȭ��ȣ��?");
			phone = sc.next();
			System.out.print("ȸ���� �ּҴ�?");
			sc.nextLine();
			address = sc.nextLine();
			customers.put(phone,new Customer(name,phone,address));
			
		}while(true);
		sc.close();
		if(customers.isEmpty()) {
			System.out.println("������ ȸ���� �����ϴ�");
		}else {
			System.out.println("���� ȸ������Ʈ");
			Iterator<String> iterator = customers.keySet().iterator();
			while(iterator.hasNext()) {
				System.out.println(customers.get(iterator.next()));
			}
		}
	}
}
