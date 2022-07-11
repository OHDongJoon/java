package com.lec.ex14_account;
//은행계좌(Account) 클래스 설계

//데이터(속성) :계좌번호(accountNo:String), 
//예금주(ownerName:String), 
//잔액(balance:long)

//기능(메소드) : 예금하다(void deposit(int)). 
//인출하다(int withdraw(int)), 
//잔액조회(long inforPrint())

// Account a = new Acoount("100-1" "홍길동"); / Account("100-2", "신길동" , 220000000)*/

public class Account {
	// 데이터는 무조건 private (계좌 예금주 잔액)
	private String accountNo; // 계좌번호
	private String ownerName; // 예금주
	private long balance; // 잔액
	// 생성자 함수 3가지만들어

	public Account() {
	} // 디폴트 생성자 아무것도 없는 생성자

	public Account(String accountNo, String ownerName) { // 생성자 역할 : 데이터 초기화
		this.accountNo = accountNo;
		this.ownerName = ownerName;
		System.out.printf("%s(%s)님 계좌 개설 감사합니다. 돈은 왜 안 갖고 오셨어요\n ", ownerName, accountNo);

	}

	public Account(String accountNo, String ownerName, long balance) {
		this.accountNo = accountNo;
		this.ownerName = ownerName;
		this.balance = balance;
		System.out.printf("%s(%s)님%d원 입금 계좌 개설 감사\n", ownerName, accountNo, balance);
	}

	// 기능(메소드) : 예금하다(void deposit(int)).
	// 인출하다(int withdraw(int)),
	// 잔액조회(long getBalance())
	public void deposit(int money) { // 예금은 양수 money가 들어오면 예금처리 balance에 넣어줘
		if (money >= 0) {
			balance += money;
			System.out.printf("%s(%s)님 %d원 입금완료했습니다. 현재잔액:%d\n",ownerName,accountNo,money,balance);
		} else {
			System.out.println("떼끼");
		}

	}

	public void withdraw(int money) { // 인출 기능
		if (money <= balance) { // 머니가 발란스보다 작거나 같으면 인출가능
			balance -= money; // balance = balace-money;
			System.out.printf("%s(%s)님 %d원 출완료했습니다. 현재잔액:%d\n",ownerName,accountNo,money,balance);
		} else {
			System.out.println(ownerName+"잔액이 부족하여 인출이 불가합니다");
		}
	}

	public String infoPrint() { // 홍길동(100-1)님 잔액 : 1000원
		return String.format("%s(%s)님 잔액: %d\n",ownerName, accountNo, balance );
		//return ownerName + "(" + accountNo + ")" + "님 잔액:" + balance + "원";
	}

	public String getAccountNo() {
		return accountNo;
	}

	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}

	public String getOwnerName() {
		return ownerName;
	}

	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}

	public long getBalance() {
		return balance;
	}

	public void setBalance(long balance) {
		this.balance = balance;
	}
	
		
}
