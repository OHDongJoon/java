package com.lec.ex1_string;
//Friend Ŭ������ ��ü �迭�� ����� ģ������ �ڵ��� ��ȣ ���ڸ��� 

//ģ���� �˻��Ͽ�, �����ϴ� ģ���� ��� ģ���� �� ������ ����ϰ�, 
//�������� �ʴ� ģ����
//��� �������� �ʴ� ģ����� ����ϴ� ���α׷��� �����Ͻÿ�.

import java.util.Scanner;

public class Ex08_FriendSearchTestMain {
	public static void main(String[] args) {
		Friend[] friend = { new Friend("ȫ�浿", "010-9999", "05-22"), new Friend("�ű浿", "010-8888-8888", "09-22"),
				new Friend("�ű浿","010-8888-8888", "03-28"),
				new Friend("���浿", "010-8888-9999", "08-22"),
				new Friend("���浿", "010-7777-7777", "04-22"), 
				new Friend("��浿", "010-6666-7777", "03-22")};
		Scanner sc = new Scanner(System.in);
		while(true) {
			System.out.println("�˻��ϰ��� �ϴ� ȸ���� ��ȭ��ȣ ���ڸ��� ?:");
			String searchTel = sc.next();
			if(searchTel.equals("x")) break;
			boolean searchOk = false;
			for (int idx = 0; idx < friend.length; idx++) {
				String tel = friend[idx].getPhone();
				String post = tel.substring(tel.lastIndexOf('-'));
				if (post.equals(searchTel)) {
					System.out.println(friend[idx]);
					searchOk = true;
				}//if - ��ȭ��ȣ�� ã�� ��� ���̻� �˻����� �ʰ� for�� ��������
			}//for
			if (!searchOk) {
				System.out.println("�˻��Ͻ� ��ȭ��ȣ�� �����ϴ�");

			}//if
			
		}//while
				sc.close();
			}//main
}//class

