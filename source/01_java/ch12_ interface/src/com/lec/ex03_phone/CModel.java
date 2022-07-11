package com.lec.ex03_phone;
//c제품 : DMB송수신불가, LTE, TV리모콘 미탑재, 
//접근     클래스    클래스이름  implements (상속interface(이름)
public class CModel implements IAcorporation {
	private String modelName = "C 모델";
	@Override
	public void dmbReceive() {
		System.out.println(modelName + "은 DMB송수신불가");

	}

	@Override
	public void lte() {
		System.out.println(modelName + "은 LTE");

	}

	@Override
	public void tvRemotecont() {
		System.out.println(modelName + "은 TV리모콘 미탑재");

	}

}
