package com.lec.ex1_store;

//3ȣ��: ��ġ�-6,000 �δ��-7,000 �����-7,000 ���뱹-6,000  �����-1,000����
public class Store3 extends HeadQuarterStore {

	public Store3(String str) {
		super(str);

	}

	@Override
	public void kimchi() {
		System.out.println("��ġ� - 6000��");
	}

	@Override
	public void bude() {
		System.out.println("�δ�� - 7000��");
	}

	@Override
	public void bibib() {
		System.out.println("����� - 7000��");
	}

	@Override
	public void sunde() {
		System.out.println("���뱹 - 6000��");
	}

	@Override
	public void gonggibab() {
		System.out.println("����� - 1,000��");
		
	}

}
