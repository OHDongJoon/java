package test3;

import java.util.Scanner;

public class FriendTestMain {
	public static void main(String[] args) {
		Friend[] friend = {new Friend("오동준","010-9603-0023","서울강남구","10-10"),
							new Friend("최진영","010-4343-3434","수원 인계동","05-15"),
							new Friend("유대환","010-3323-3233","인천 동동","12-11"),
							new Friend("유대진","010-3323-3233","서울강남구","12-11"),};
		Scanner sc = new Scanner(System.in);
		while(true) {
			System.out.print("검색할 주소 앞 글자 2자리 종료는x");
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
				System.out.println("검색하신 주소는 없습니다");
			}
		}
		sc.close();
	}
}
