package com.lec.ex12_store;
// 대학가에 매장2호점: 김치찌개-5,000  부대찌개-5,000(o)  비빔밥-5,000(o) 순대국-5,000  공기밥-무료(o)
public class Store2 extends HeadQuarterStore{

	public Store2(String str) {
		super(str);
		// TODO Auto-generated constructor stub
	}
	@Override
	public void bude() {
		System.out.println("부대찌개 - 5000원");
	}
	@Override
	public void bibib() {
		System.out.println("비빔밥 - 5000원");
	}
	@Override
	public void gonggibab() {
		System.out.println("공기밥 - 무료 ");
	}

}
