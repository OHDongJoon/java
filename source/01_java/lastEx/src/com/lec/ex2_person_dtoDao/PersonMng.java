package com.lec.ex2_person_dtoDao;

import java.util.ArrayList;
import java.util.Scanner;

public class PersonMng {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		PersonDao dao = PersonDao.getInstance();
		String fn;
		ArrayList<PersonDto> dto;
		do {
			System.out.println("1: �Է� || 2: ��������ȸ || 3: ��ü��ȸ || 4: �׿�: ����");
			fn = sc.next();
			ArrayList<PersonDto> dtos;
			switch(fn) {
			case "1" : //�̸�, ������, ��, ��, �� �Է�
				System.out.print("�Է��� �̸���?");
				String pname = sc.next();
				System.out.print("������(���|����|����)��?");
				String jname = sc.next();
				System.out.println("���������� ? ");
				int kor = sc.nextInt();
				System.out.println("����������?");
				int eng = sc.nextInt();
				System.out.println("����������?");
				int mat = sc.nextInt();
				int result = dao.insertPerson(new PersonDto(pname,jname,kor,eng,mat));
				System.out.println(result == PersonDao.SUCCESS ? "�Է¼���" : "�Է½���");
				break;
			case "2" :
				System.out.println("��ȸ�� ������?");
				jname = sc.next();
				dtos = dao.selelctJname(jname);
				if(dtos.isEmpty()) {
					System.out.println("�ش� ���� ��� ����");
				}else {
					System.out.println("rank\t�̸�\t������\t����\t����\t����\t�հ�");
					for(PersonDto d : dtos) {
						System.out.println(d);
					}
				}
				break;
			case "3":
				dtos = dao.selectAll();
				if(dtos.size()!=0) {
					System.out.println("rank\t�̸�\t������\t����\t����\t����\t�հ�");
					for(PersonDto d : dtos) {
						System.out.println(d);
					}//for
				}else {
					System.out.println("��ϵ� ����� �����ϴ�");
				}
				dtos = dao.selectAll();
				if(dtos.size() != 0) {
					System.out.println("��ü ��ȸ");
				}
				
				break;
			
			}
		}while(fn.equals("1") || fn.equals("2") || fn.equals("3"));
		sc.close();
		System.out.println("BYE");
		
	}
}
