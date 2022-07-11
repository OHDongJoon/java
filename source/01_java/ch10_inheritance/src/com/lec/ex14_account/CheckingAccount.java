package com.lec.ex14_account;
// CheckingAccount a2= new ChekingAco ("11-11","ȫ�浿", 2000 , "111-11-11-")

public class CheckingAccount extends Account {
	private String cardNo;

	public CheckingAccount(String accountNo, String ownerName, String cardNo) {
		super(accountNo, ownerName);
		this.cardNo = cardNo;

	}

	public CheckingAccount(String accountNo, String ownerName, long balance, String cardNo) {
		super(accountNo, ownerName, balance);
		this.cardNo = cardNo;

	}

	// a2.pay ("1111-111-222-333",1000);
	public void pay(String cardNo, int amount) {
		// if(this.cardNo�� cardNo�� ����?)
		if (this.cardNo.equals(cardNo)) {// �ùٸ� ī�� ��ȣ���� Ȯ��
			if (getBalance() >= amount) { // ���Ұ������� (�ܾ��� ������ �ݾ��̻�)
				setBalance(getBalance() - amount); // balance = balance - amount;
				System.out.printf("%s(%s)�� %d�� �����Ͽ� �ܾ� %d�� ���ҽ��ϴ� \n", getOwnerName(), getAccountNo(), amount,
						getBalance());
			} else {
				System.out.print("����");
			}
		} else {
			System.out.println("�ùٸ� ī���ȣ�� �Է��ϼ���");
		}

	}

	public String getCardno() {
		return cardNo;
	}

}
