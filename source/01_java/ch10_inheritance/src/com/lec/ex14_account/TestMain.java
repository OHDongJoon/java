package com.lec.ex14_account;

public class TestMain {
	public static void main(String[] args) {
		Account a1 = new Account("111-11111","È«±æµ¿");
		a1.deposit(3000);
		a1.deposit(6000);
		a1.withdraw(10000);
		System.out.println("~~~~~~~~~~~~~~~~~~~");
		CheckingAccount a2 = new CheckingAccount("222-222", "½Å±æµ¿",1000, "1111-222-333");
		a2.deposit(9000);
		a2.withdraw(20000);
		a2.pay("1111-222-111", 20000);
		a2.pay("1111-222-333", 20000);
		a2.pay("1111-222-333", 10000);
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		CreditLineAccount a3 = new CreditLineAccount("33-33","È«±æ¼ø","1111-1111", 10000);
		a3.deposit(10000);
		a3.pay("1111-1111", 15000);
		
	}
}
