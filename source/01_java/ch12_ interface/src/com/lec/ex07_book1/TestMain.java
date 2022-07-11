package com.lec.ex07_book1;

import java.util.Scanner;

public class TestMain {
	public static void main(String[] args) {
		Book[] books = { new Book("890-101-1", "�ڹ�", "ȫ�浿"), 
				new Book("110-324-1","����Ŭ","�ŵ�"),
				new Book("110-234-2","mysql","��ȣ��"), 
				new Book("233-432-3","web","��"),
				new Book("44-33-3","jsp","�浿"), 
				new Book("675-41234-3","spring","���ߵ�"), };

		Scanner scanner = new Scanner(System.in);
		int fn; // ��ɹ�ȣ(1 : ���� | 2:�ݳ�| 3:å list| 0 : ����)
		int idx; // �����ϰų� �ݳ��Ϸ��� �� �� ��ȸ�� å index ��ȸ ������
		String bTitle, borrower, checkOutDate; // ����ڿ��� ���� å�̸� , ������, ������
		do {
			System.out.print("1:���� | 2:�ݳ�| 3:å list| 0:���� :");
			fn = scanner.nextInt();// �Է� ���� �� fn �� �־�
			switch (fn) { // fn�� 1�̸�
			case 1: // 1 �̸� å�̸� �Է�
				// ���� : 1.å�̸��Է� 2.å��ȸ 3.å����Ȯ�� 4.�������Է� 5. �������Է� 6. ����޼ҵ� ȣ��
				// 1.å�̸� �Է�
				System.out.print("���� �ϰ��� �ϴ� å�̸���?"); // å�̸� �Է¹����� bTitle �� �־�
				bTitle = scanner.next(); // �����̽��� ����� String ��ĳ�� �޴¹� white-space �� ���� ��Ʈ���� ����

				// 2. å��ȸ
				for (idx = 0; idx < books.length; idx++) {
					if (bTitle.equals(books[idx].getBookTitle())) {
						break;
					}
				} // 2.å��ȸ
				if (idx == books.length) { // 5��°� å�� ����
					System.out.println("���� �������� ���� ���� �Դϴ�.");
				} else {// ������ ����ó��
						// 3.å����Ȯ��
					if (books[idx].getState() == Book.STATE_BORROWED) { // ���� �Ұ� ����
						System.out.println("���� �������� �����Դϴ�");
					} else { // ���� ���� ����
						// 4.5.6
						System.out.println("�����ڴ� ? ");
						borrower = scanner.next();
						System.out.println("�������� ? ");
						checkOutDate = scanner.next();
						books[idx].checkOut(borrower, checkOutDate);
					}
				}
				break;
			case 2:	// �ݳ� : 1. å�̸�  2. å��ȸ  3. �ݳ�  4. 
				// 1 å�̸�
				System.out.print("�ݳ��� å�̸��� ?");
				bTitle = scanner.next();
				// 2. å ��ȸ Ȯ�� for���� �ε����� ����������� 
				for(idx=0 ; idx<books.length ; idx++) {
					if(bTitle.equals(books[idx].getBookTitle())) {
						break;
					}
				}
				
				if(idx == books.length) {
					System.out.println("�ش� ������ �� �������� å�� �ƴմϴ�");
				}else {// idx ã�� ����ġ
					//3.�ݳ�
					books[idx].checkIn();
					
				}
				break;
			case 3:
//				System.out.print("å list ��� ���� �� ����");
				System.out.print("å ����Ʈ�� ������ �����ϴ�");
				for (Book book : books) {
					book.printState();
				}
				break;
			}
		} while (fn != 0);
		System.out.println("����");
//		while(true){
//			System.out.println("��ɹ�ȣ(1 : ���� | 2:�ݳ�| 3:å list| 0 : ����");
//			fn = scanner.nextInt();
//			if(fn==0) {
//				break;
//			}
//		}
	}// main
}// class
