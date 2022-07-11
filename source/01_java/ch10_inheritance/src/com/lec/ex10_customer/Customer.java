package com.lec.ex10_customer;

// �ʿ��Ѱ� (��ӹ޾��� name , tel), address, sum(�����ݾ�), point(����Ʈ ������), date(����,��ȥ�����) vip�� �ƴϳ�
// Customer c = new Customer("��" , "010", "��", "1995-10-10");
public class Customer extends Person {
	private String address; // �ּ�
	private int sum; // ���Ŵ����ݾ�
	private int point; // ����Ʈ (���Ÿ��� 5%����)
	private String date; // �����(Data Ÿ�Ե� ����)
	private boolean vip; // true�� vip, false�� �Ϲ�

	public Customer(String name, String tel, String address, String date) {
		super(name, tel);// ù��° ���ο� �;� ��
		this.address = address;
		this.date = date;
		point = 1000; // �� ���� 1000�� ����Ʈ �ڵ� �ο�
//		sum = 0; // �� ���� ���Ŵ����ݾ� 0
//		vip = false; // ������ �Ϲݰ�����
		System.out.println(name + "�� ���簨��.����Ʈ 1000�� ������");
	}

	public void buy(int price) {// c.buy(10000��)
		sum += price; // ���� ����
		int tempPoint = (int) (price * 0.05); // ���ŷ� ���� price ���ϱ� 0.05 �� temp Poin�� �Ѱ�
		point += tempPoint; // �춧 ������ �ݾ� �����Τ� point�� ����
		System.out.println(getName() + "�� ����. �̹����ŷ� ����Ʈ " + tempPoint + "�� �߰��Ǿ� �� ����Ʈ :" + point);
		if (sum >= 1000000 && vip == false) { 
			vip = true; // ���Ŵ��� �ݾ��� 100���� �̻�� vip ������
			System.out.println(getName() + "�� vip ������ ���׷��̵� �Ǽ̽���");
		} // if
	}// buy
		// sysout(c.infoString()) ,
		// @ : ������̼�

	@Override // �� ���ֱ� ��Ÿ ������ �˷��� 
	public String infoString() {
		return super.infoString() + "[�ּ�]" + address + " [����Ʈ] " + point + "[�����ݾ�]" + sum;
	}
}
