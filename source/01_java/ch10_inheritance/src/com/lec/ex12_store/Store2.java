package com.lec.ex12_store;
// ���а��� ����2ȣ��: ��ġ�-5,000  �δ��-5,000(o)  �����-5,000(o) ���뱹-5,000  �����-����(o)
public class Store2 extends HeadQuarterStore{

	public Store2(String str) {
		super(str);
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

}
