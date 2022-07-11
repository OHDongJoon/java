package com.lec.ex10_customer;

// name , tel, hiredate(입사일) , department(부서)
// Staff s = new Staff("홍","010", "2022-09-01", "개발팀"
public class Staff extends Person {

	private String hiredate; // 입사일
	private String department;// 부서

	public Staff(String name, String tel, String hiredate, String department) {
		super(name, tel);
		this.hiredate = hiredate;
		this.department = department;
	}//	                       (Person에 잇음이름 전화)( 이것만 추가하자)
	// syout(s.infoString) // - [이름] 오 [전화] 010 [입사일]2022-09-01 [부서]개발팀
	@Override
	public String infoString() {
	//	return super.infoString(); // 이렇게만 하면 이름 전화만
		return super.infoString()+"[입사일]"+hiredate+"[부서]"+department;  // info(이름 전화 출력) 추가 : 입사 , 부서
	} 
}
