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
			System.out.println("ȸ������ �����Ͻðڽ��ϱ�? (Y/N)");
			answer = sc.next();
			if(answer.equalsIgnoreCase("n")) {
				break;
			}else if(answer.equalsIgnoreCase("y"))
			System.out.println("�̸��Է�:");
			name = sc.next();
			System.out.println("��ȭ�Է�:");
			phone = sc.next();
			if(members.get(phone) !=null) {
				System.out.println("�̹� ���ԵǾ� �ִ� ����");
				continue;
			}
			

			System.out.println("�ּ��Է�:");
			sc.nextLine();
			address = sc.nextLine();
			members.put(phone, new Member(name, phone, address));

			
		} while (true);
		sc.close();
		if(members.isEmpty()) {
			System.out.println("������ ȸ���� �����ϴ�");
		}else {
			System.out.println("���� ȸ�� ����Ʈ");
			Iterator<String> iterator = members.keySet().iterator();
			while(iterator.hasNext()) {
				System.out.println(members.get(iterator.next()));
			}
		}

	}

}