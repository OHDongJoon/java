package com.lec.ex02_store;
//implements 로 수정 , str 추가 생성자 수정 , getter 추가
// 인터페이스 헤드쿼 에서 받앗으니 imp 
public class Store1 implements HeadQuarterStore {
	private String str;
	public Store1(String str) {
		this.str = str;
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

	public String getStr() {
		return str;
	}
}
