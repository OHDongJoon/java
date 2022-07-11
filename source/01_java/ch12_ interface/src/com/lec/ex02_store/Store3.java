package com.lec.ex02_store;
// implements 로 수정 , str 추가 생성자 수정 , getter 추가
// 증권가에 매장 3호점 : 김치 6 부대 7 비빔밥 7 순대 6 공기 1
public class Store3 implements HeadQuarterStore {
	private String str;
	public Store3(String str) {
		this.str = str;

	}

	@Override
	public void kimchi() {
		System.out.println("김치찌개 - 6000원");
	}

	@Override
	public void bude() {
		System.out.println("부대찌개 - 7000원");
	}

	@Override
	public void bibib() {
		System.out.println("비빔밥 - 7000원");
	}

	@Override
	public void sunde() {
		System.out.println("순대국 - 6000원");
	}

	@Override
	public void gonggibab() {
		System.out.println("공기밥 - 1,000원");
		
	}

	public String getStr() {
		return str;
	}

}
