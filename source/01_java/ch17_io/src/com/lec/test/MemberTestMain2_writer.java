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
		String today = sdf.format(now); // 04-06 ������������
		do {
			System.out.print("ȸ������ �ϽǷ���(��, ������ ������ N)? ");
			answer = scanner.next();
			if (answer.equalsIgnoreCase("n"))
				break; // n�������� �극��ũ
			System.out.print("ȸ���̸� ? ");
			name = scanner.next();
			System.out.print("��ȭ��ȣ ? ");
			phone = scanner.next();
			System.out.print("����(yyyy-MM-dd) ? ");// ��Ʈ�� ������������ ��ȯ
			birth = scanner.next();
			StringTokenizer token = new StringTokenizer(birth, "-");//
			if (token.countTokens() == 3) { // ���� �ȹٷ� �������� ����
				year = Integer.parseInt(token.nextToken()); // ��Ʈ������ ��Ʈ��
				month = Integer.parseInt(token.nextToken());
				day = Integer.parseInt(token.nextToken());
				// birthday = new Date(year-1900, month-1, day);
				birthday = new Date(new GregorianCalendar(year, month - 1, day).getTimeInMillis());
			} else {
				System.out.println("���� ������ �ùٸ��� �ʽ��ϴ�. Ȯ���� �ּ���");
				continue;
			}
			if (today.equals(birth.substring(birth.indexOf("-") + 1))) {
				System.out.println(name + "�� �����̽ñ���. ���������մϴ�");
			}
			System.out.print("�ּ� ? ");
			scanner.nextLine();
			addres = scanner.nextLine();
			members.add(new Member(name, phone, birthday, addres));
		} while (true);
		scanner.close();
		// 2. ArrayList ������ ��� �����ߴ��� ���� ��°� �ܼ� ����Ѵ�.
		Writer writer = null;
		try {
			writer = new FileWriter("src/com/lec/test/member.txt");
			for (Member member : members) {
				System.out.print(member);
				writer.write(member.toString());// to -> byt�� ��ȯ
			} // ���Ͽ� ���ִ� �� write
			String msg = String.format("\t\t\t...���� %d�� ����\n\n", members.size()); // ���� ��� ����

			writer.write(msg);
		} catch (FileNotFoundException e) {
			System.out.println("���� �� ã��" + e.getMessage());
		} catch (IOException e) {
			System.out.println("���� ����" + e.getMessage());
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
