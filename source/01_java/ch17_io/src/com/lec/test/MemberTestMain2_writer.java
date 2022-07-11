package com.lec.test;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;
import java.util.StringTokenizer;

public class MemberTestMain2_writer {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String answer, name, phone, birth, addres; //
		int year, month, day;
		Date birthday;

		ArrayList<Member> members = new ArrayList<Member>();
		Date now = new Date();

		SimpleDateFormat sdf = new SimpleDateFormat("MM-dd");
		String today = sdf.format(now); // 04-06 생일축하축하
		do {
			System.out.print("회원가입 하실래요(단, 원하지 않으면 N)? ");
			answer = scanner.next();
			if (answer.equalsIgnoreCase("n"))
				break; // n을누르면 브레이크
			System.out.print("회원이름 ? ");
			name = scanner.next();
			System.out.print("전화번호 ? ");
			phone = scanner.next();
			System.out.print("생일(yyyy-MM-dd) ? ");// 스트링 데이터형으로 변환
			birth = scanner.next();
			StringTokenizer token = new StringTokenizer(birth, "-");//
			if (token.countTokens() == 3) { // 생일 똑바로 적었으면 실행
				year = Integer.parseInt(token.nextToken()); // 스트링에서 인트로
				month = Integer.parseInt(token.nextToken());
				day = Integer.parseInt(token.nextToken());
				// birthday = new Date(year-1900, month-1, day);
				birthday = new Date(new GregorianCalendar(year, month - 1, day).getTimeInMillis());
			} else {
				System.out.println("생일 정보가 올바르지 않습니다. 확인해 주세요");
				continue;
			}
			if (today.equals(birth.substring(birth.indexOf("-") + 1))) {
				System.out.println(name + "님 생일이시군요. 생일축하합니다");
			}
			System.out.print("주소 ? ");
			scanner.nextLine();
			addres = scanner.nextLine();
			members.add(new Member(name, phone, birthday, addres));
		} while (true);
		scanner.close();
		// 2. ArrayList 정보와 몇명 가입했는지 파일 출력과 콘솔 출력한다.
		Writer writer = null;
		try {
			writer = new FileWriter("src/com/lec/test/member.txt");
			for (Member member : members) {
				System.out.print(member);
				writer.write(member.toString());// to -> byt로 변환
			} // 파일에 써주는 거 write
			String msg = String.format("\t\t\t...이하 %d명 가입\n\n", members.size()); // 이하 몇명 가입

			writer.write(msg);
		} catch (FileNotFoundException e) {
			System.out.println("파일 못 찾음" + e.getMessage());
		} catch (IOException e) {
			System.out.println("쓰기 예외" + e.getMessage());
		} finally {
			try {
				if (writer != null)
					writer.close();
			} catch (Exception ignore) {
				System.out.println(ignore.getMessage());
			}
		} // try-catch-finally
	}
}
