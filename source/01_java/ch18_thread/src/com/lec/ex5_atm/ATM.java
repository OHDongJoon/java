package com.lec.ex5_atm;
// ATM a = new ATM(1000)
public class ATM {
	private int balance;
	public ATM(int balance) {
		this.balance = balance;
	}
	public void deposit(int amount, String who) {
		System.out.println(who +"가 입급 시작~~~~~~~~~");
		balance += amount;
		System.out.println(who +"가 " + amount +"원 입급하여 잔액:" + balance);
		System.out.println(who + "가 입금 종료~~~~");
	}
	public synchronized void withdraw(int amount, String who) {
		System.out.println(who +"가 출금 시작 @ @ @");
		balance -= amount;
		System.out.println(who +"가 " + amount +"원 출금해서 잔액 :" + balance);
		System.out.println(who + "가 출금 종료 @ @ @ ");
	}
	public int getBalance() {
		return balance;
	}
	
}
