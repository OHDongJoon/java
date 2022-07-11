package com.lec.ex1_store;
// 추상 클래스 대충 만들어 놓고 상속받아서 너가 알아서만들어 
// HeadQuarterStore hstore = new HeadQuarterStore("본사); 객체 생성 불가
// hstore.kimchi();
public abstract class HeadQuarterStore {
	private String str;// 본사 , 매장 1호점

	public HeadQuarterStore(String str) {
		// super();// 상속받은게 없으니 오브젝트에서 상속

		this.str = str;

	}

	// 메소드 구혀은 없고 선언만 되어 있는 메소드 : 추상 메소드 (상속받은 클래스에서 오버라이드)
	// public void kimchi(); //메소드 구현은 없고 선언만 되어 있는 메소드 : 추상 메소드라고한다
	public abstract void kimchi();

	public abstract void bude();

	public abstract void bibib();

	public abstract void sunde();

	public abstract void gonggibab();

	public String getStr() {
		return str;
	}

	public void setStr(String str) {
		this.str = str;
	}
}
