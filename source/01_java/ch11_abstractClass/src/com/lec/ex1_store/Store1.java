package com.lec.ex1_store;

//주택가에 매장1호점: 김치찌개-5,000  부대찌개-5,000(오버)  비빔밥-6,000 순대국-안팔아(오버) 공기밥-1,000원 
public class Store1 extends HeadQuarterStore {

	public Store1(String str) {
		super(str);

	}

	@Override
	public void bude() {

		System.out.println("부대찌개 - 5000원");
	}

	@Override
	public void sunde() {

		System.out.println("순대국 - 안 팔아");
	}

	@Override
	public void kimchi() {
		System.out.println("김치찌개 - 4,500원");

	}

	@Override
	public void bibib() {
		System.out.println("비빔밥 - 4,500원");

	}

	@Override
	public void gonggibab() {
		System.out.println("공기밥 - 1,000원");

	}
}
