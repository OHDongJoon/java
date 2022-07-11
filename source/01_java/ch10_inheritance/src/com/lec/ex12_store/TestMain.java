package com.lec.ex12_store;

public class TestMain {
	public static void main(String[] args) {
		HeadQuarterStore[] store = {new HeadQuarterStore("본사"), //7번째줄
									new Store1("= = = 1호점 = = = "),
									new Store2("= = = 2호점 = = = "),
									new Store3("= = = 3호점 = = = ")};
		for(int idx=0 ; idx <store.length ; idx++) {
			System.out.println(store[idx].getStr());
			store[idx].kimchi();
			store[idx].bude();
			store[idx].bibib();
			store[idx].sunde();
			store[idx].gonggibab();
			System.out.println("^^^^^^^^^일반for문^^^^^^^^^^^^^^^");
			
		}
		for(HeadQuarterStore st : store) {
			System.out.println(st.getStr());
			st.kimchi();
			st.bude();
			st.bibib();
			st.sunde();
			st.gonggibab();
		}
		
	}
}
