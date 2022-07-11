package com.lec.ex5_money;

public class TestMain {
	public static void main(String[] args) {

		Employee[] sawon = { new SalayEmployee("홍길동", 24000000),
						     new SalayEmployee("강동원", 70000000),
						     new SalayEmployee("김고은", 12000000),
						     new HourlyEmployee("홍길구", 100,7000),
						     new HourlyEmployee("홍길동", 120,8000)};
		for(Employee temp : sawon) {
			System.out.println("~~~월급 명세서 ~~~~");
			System.out.println("성함 :" +temp.getName());
			System.out.println("월급: "+temp.computePay());
			int tempIncen = temp.computeIncentive();
			if(tempIncen!=0) {
				System.out.println("상여"+ tempIncen);
			}
			System.out.println();
		}
	}
}