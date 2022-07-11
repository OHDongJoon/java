package com.lec.ex14_account;
// CheckingAccount a2= new ChekingAco ("11-11","홍길동", 2000 , "111-11-11-")

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
		// if(this.cardNo와 cardNo가 같냐?)
		if (this.cardNo.equals(cardNo)) {// 올바른 카드 번호인지 확인
			if (getBalance() >= amount) { // 지불가능한지 (잔액이 지불할 금액이상)
				setBalance(getBalance() - amount); // balance = balance - amount;
				System.out.printf("%s(%s)님 %d원 지불하여 잔액 %d원 남았습니다 \n", getOwnerName(), getAccountNo(), amount,
						getBalance());
			} else {
				System.out.print("떼끼");
			}
		} else {
			System.out.println("올바른 카드번호를 입력하세요");
		}

	}

	public String getCardno() {
		return cardNo;
	}

}
