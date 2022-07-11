package com.lec.ex4_newexception;

public class Account {
	private String accoutNO;
	private String ownerName;
	private int    balance;
	public Account(String accoutNO, String ownerName) {
		this.accoutNO = accoutNO;
		this.ownerName = ownerName;
	}
	public Account(String accoutNO, String ownerName, int balance) {
		this.accoutNO = accoutNO;
		this.ownerName = ownerName;
		this.balance = balance;
	}// ���� : ������ ����������� -> ���� -> ������ �������� ���
	public void deposit(int amount) { // Account a = new Account("1-1", "ȫ",100)
										//sysout pint("������:" + a)
										// a.deposit(100) -> deposit�Լ� �������� this�� a
		System.out.println("������ :"+ this);
		balance += amount; // balance + amout; ����
		System.out.println(amount + "�� ������"+ this);
	}//��� : �ܾ� Ȯ�� -> ����� ���������ͷ� -> ��� -> ��� -> ����� �������� ���
	public void withdraw(int amount) throws Exception {
		if(balance < amount) { // �ܾ׺������� ��ݵ������� : �������ܹ߻�
			throw new Exception(amount + "�� ����ϱ⿡�� �ܾ�("+balance+")�̺����մϴ�");
			
		}
		System.out.println("����� : "+this);
		balance -= amount;//balance = balance - amount;
		System.out.println(amount + "�� ����� : "+this);
		
	}
	@Override
	public String toString() {
		return"���¹�ȣ:"+accoutNO + "\t������" +ownerName +"\t�ܾ�:"+balance;
	}
}
