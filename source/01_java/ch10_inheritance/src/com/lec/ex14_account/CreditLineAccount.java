package com.lec.ex14_account;

// CreditLineAccount c2 = new CredLineAcoount("11-11","홍" , "111-2222-3333-4444", 10000)
//CreditLineAccount c2 = new CredLineAcoount("11-11","홍" ,1000, "111-2222-3333-4444", 10000)
public class CreditLineAccount extends CheckingAccount {
	private int creditLine; // 카드한도

	public CreditLineAccount(String accountNo, String ownerName, String cardNo, int creditLine) {
		super(accountNo, ownerName, cardNo);
		this.creditLine = creditLine;
	}

	public CreditLineAccount(String accountNo, String ownerName, long balance, String cardNo ) {
		super(accountNo, ownerName, balance, cardNo);
		this.creditLine = creditLine;
	}

	@Override
	public void pay(String cardNo, int amount) {
		if(cardNo.equals(getCardno())) {// 올바른 카드 번호인지 확인
			if(creditLine >= amount) { // 한도 금액
				creditLine = creditLine - amount ;//balance = balance - amount;
				System.out.printf("%s(%s)님 %d원 지불하여 한도 %d원 남았습니다 \n", getOwnerName(),getAccountNo(),amount,creditLine);
			}else {
				System.out.printf("%s(%s)님 잔액 %d원 지불하여 불가합니다 \n", getOwnerName(),getAccountNo(),creditLine,amount);
			}
	}else {
		System.out.println("올바른 카드번호를 입력하세요");
	}
}



}
