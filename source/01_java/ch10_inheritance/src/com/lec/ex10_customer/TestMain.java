package com.lec.ex10_customer;

public class TestMain {
	public static void main(String[] args) {
		Customer customer = new Customer("��", "010-9999-9999", "����", "1995-10-10"); // ��ü���� // 12�� �� customer
		customer.buy(100000);
		customer.buy(900000);
		System.out.println(customer.infoString());
		Staff staff = new Staff("��", "016-777-123","2022-09-01", "������"); // �̸� ��ȭ �Ի��� �μ�
		Person person = new Person("��", "010-7777");
		Person[] personArr = {customer, staff, person}; 
		System.out.println("�Ϲ� for ��");
		for(int i=0 ; i < personArr.length ; i++) {
			System.out.println(personArr[i].infoString());
		}
		System.out.println("Ȯ�� for ��");
		// �迭 0~������� infoStrinf()
		for(Person p : personArr) {
			System.out.println(p.infoString());
		}
		// �迭 0~������� buy(1000)
		for(Person p : personArr) {
			if(p instanceof Customer) {// p������ Customer�� ��ü�� ???���ȷҾ� ?
				((Customer)p).buy(1000);
			}else {
				System.out.println("buy�� Customer�� ������ ����!");
			}//if
			
		}//for
	}//main
}//class
// Staff ���� Person Ÿ���̴� Person ��ӹ޾����ϱ�