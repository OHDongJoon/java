package com.lec.ex2_person_dtoDao;

import java.util.ArrayList;
import java.util.Vector;

public class PersonDaoTest {
	public static void main(String[] args) {
		PersonDao dao = PersonDao.getInstance();
		PersonDto dto = new PersonDto("����", "���", 60, 80, 70);
		int result = dao.insertPerson(dto); // 1. �Է� test
		System.out.println(result==PersonDao.SUCCESS? "�Է¼���" : "�Է½���");
		System.out.println("---------------2�� �׽�Ʈ-------------------");
		ArrayList<PersonDto> dtos = dao.selelctJname("���"); // ������ ��ȸ test
		if(!dtos.isEmpty()) {
			for(PersonDto d : dtos) {
				System.out.println(d);
			}
		}else {
			System.out.println("�ش� ������ ����� ��ϵ��� �ʾƶ�");
		}
		dtos = dao.selectAll(); // 3. ��ü��ȸ test
		if(dtos.size()!=0) {
			for(PersonDto d : dtos) {
				System.out.println(d);
			}
		}else {
			System.out.println("��ϵ� ����� �����ϴ�");
		}
		Vector<String> jnames = dao.jnamelist(); // 4. ������ ����Ʈ test
		System.out.println(jnames);
	}
}
