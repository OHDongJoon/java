package test3;

import java.util.Scanner;

public class FriendTestMain {
	public static void main(String[] args) {
		Friend[] friend = {new Friend("������","010-9603-0023","���ﰭ����","10-10"),
							new Friend("������","010-4343-3434","���� �ΰ赿","05-15"),
							new Friend("����ȯ","010-3323-3233","��õ ����","12-11"),
							new Friend("������","010-3323-3233","���ﰭ����","12-11"),};
		Scanner sc = new Scanner(System.in);
		while(true) {
			System.out.print("�˻��� �ּ� �� ���� 2�ڸ� �����x");
			String searchAddress = sc.next();
			if(searchAddress.equalsIgnoreCase("x"))break;
			boolean searchOk = false;
			for(int idx = 0 ; idx <friend.length; idx++) {
				String address = friend[idx].getAddress();
				String post = address.substring(0,2);
		
				if(post.equals(searchAddress)) {
					System.out.println(friend[idx]);
					searchOk = true;
				}
			}
			if(!searchOk) {
				System.out.println("�˻��Ͻ� �ּҴ� �����ϴ�");
			}
		}
		sc.close();
	}
}
