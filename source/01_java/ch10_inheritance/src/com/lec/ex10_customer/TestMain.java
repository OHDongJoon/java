package com.lec.ex10_customer;

public class TestMain {
	public static void main(String[] args) {
		Customer customer = new Customer("오", "010-9999-9999", "서울", "1995-10-10"); // 객체생성 // 12번 줄 customer
		customer.buy(100000);
		customer.buy(900000);
		System.out.println(customer.infoString());
		Staff staff = new Staff("김", "016-777-123","2022-09-01", "개발팀"); // 이름 전화 입사일 부서
		Person person = new Person("이", "010-7777");
		Person[] personArr = {customer, staff, person}; 
		System.out.println("일반 for 문");
		for(int i=0 ; i < personArr.length ; i++) {
			System.out.println(personArr[i].infoString());
		}
		System.out.println("확장 for 문");
		// 배열 0~끝방까지 infoStrinf()
		for(Person p : personArr) {
			System.out.println(p.infoString());
		}
		// 배열 0~끝방까지 buy(1000)
		for(Person p : personArr) {
			if(p instanceof Customer) {// p변수가 Customer형 객체야 ???시팔롬아 ?
				((Customer)p).buy(1000);
			}else {
				System.out.println("buy는 Customer만 가능해 시팔!");
			}//if
			
		}//for
	}//main
}//class
// Staff 지만 Person 타입이다 Person 상속받았으니까