package com.lec.ex02_store;
//implements �� ���� , str �߰� ������ ���� , getter �߰�
// 2ȣ��: ��ġ�-5,000 �δ��-5,000 �����-5,000 ���뱹-5,000  �����-����
public class Store2 implements HeadQuarterStore {
	private String str;
	public Store2(String str) {
		this.str = str;
		// TODO Auto-generated constructor stub
	}

	@Override
	public void bude() {
		System.out.println("�δ�� - 5000��");
	}

	@Override
	public void bibib() {
		System.out.println("����� - 5000��");
	}

	@Override
	public void gonggibab() {
		System.out.println("����� - ���� ");
	}

	@Override
	public void kimchi() {
		System.out.println("��ġ� - 5,000��");

	}

	@Override
	public void sunde() {
		System.out.println("���뱹 - 5,000��");

	}

	public String getStr() {
		return str;
	}

}
