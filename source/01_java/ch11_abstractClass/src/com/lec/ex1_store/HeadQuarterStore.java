package com.lec.ex1_store;
// �߻� Ŭ���� ���� ����� ���� ��ӹ޾Ƽ� �ʰ� �˾Ƽ������ 
// HeadQuarterStore hstore = new HeadQuarterStore("����); ��ü ���� �Ұ�
// hstore.kimchi();
public abstract class HeadQuarterStore {
	private String str;// ���� , ���� 1ȣ��

	public HeadQuarterStore(String str) {
		// super();// ��ӹ����� ������ ������Ʈ���� ���

		this.str = str;

	}

	// �޼ҵ� ������ ���� ���� �Ǿ� �ִ� �޼ҵ� : �߻� �޼ҵ� (��ӹ��� Ŭ�������� �������̵�)
	// public void kimchi(); //�޼ҵ� ������ ���� ���� �Ǿ� �ִ� �޼ҵ� : �߻� �޼ҵ����Ѵ�
	public abstract void kimchi();

	public abstract void bude();

	public abstract void bibib();

	public abstract void sunde();

	public abstract void gonggibab();

	public String getStr() {
		return str;
	}

	public void setStr(String str) {
		this.str = str;
	}
}
