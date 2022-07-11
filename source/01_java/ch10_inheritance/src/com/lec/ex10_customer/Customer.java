package com.lec.ex10_customer;

// 필요한거 (상속받았음 name , tel), address, sum(누적금액), point(포인트 적립금), date(생일,결혼기념일) vip냐 아니냐
// Customer c = new Customer("오" , "010", "설", "1995-10-10");
public class Customer extends Person {
	private String address; // 주소
	private int sum; // 구매누적금액
	private int point; // 포인트 (구매마다 5%적립)
	private String date; // 기념임(Data 타입될 예정)
	private boolean vip; // true면 vip, false면 일반

	public Customer(String name, String tel, String address, String date) {
		super(name, tel);// 첫번째 라인에 와야 함
		this.address = address;
		this.date = date;
		point = 1000; // 새 고객에 1000점 포인트 자동 부여
//		sum = 0; // 새 고객의 구매누적금액 0
//		vip = false; // 새고객은 일반고객으로
		System.out.println(name + "님 감사감사.포인트 1000점 선물로");
	}

	public void buy(int price) {// c.buy(10000원)
		sum += price; // 섬에 누적
		int tempPoint = (int) (price * 0.05); // 구매로 인한 price 곱하기 0.05 를 temp Poin에 넘겨
		point += tempPoint; // 살때 누적된 금액 총포인ㅌ point에 누적
		System.out.println(getName() + "님 감사. 이번구매로 포인트 " + tempPoint + "점 추가되어 총 포인트 :" + point);
		if (sum >= 1000000 && vip == false) { 
			vip = true; // 구매누적 금액이 100만원 이상시 vip 고객으로
			System.out.println(getName() + "님 vip 고객으로 업그레이드 되셨슴당");
		} // if
	}// buy
		// sysout(c.infoString()) ,
		// @ : 어노테이션

	@Override // 꼭 써주기 오타 나오면 알려줌 
	public String infoString() {
		return super.infoString() + "[주소]" + address + " [포인트] " + point + "[누적금액]" + sum;
	}
}
