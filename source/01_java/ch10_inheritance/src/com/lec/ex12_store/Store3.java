package com.lec.ex12_store;

//���ǰ��� ����3ȣ��: ��ġ�-6,000(o)  �δ��-7,000(o)  �����-7,000(o)  ���뱹-6,000(o)  �����-1,000�� �̰� ���
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

}
