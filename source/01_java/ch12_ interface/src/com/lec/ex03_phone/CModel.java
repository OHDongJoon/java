package com.lec.ex03_phone;
//c��ǰ : DMB�ۼ��źҰ�, LTE, TV������ ��ž��, 
//����     Ŭ����    Ŭ�����̸�  implements (���interface(�̸�)
public class CModel implements IAcorporation {
	private String modelName = "C ��";
	@Override
	public void dmbReceive() {
		System.out.println(modelName + "�� DMB�ۼ��źҰ�");

	}

	@Override
	public void lte() {
		System.out.println(modelName + "�� LTE");

	}

	@Override
	public void tvRemotecont() {
		System.out.println(modelName + "�� TV������ ��ž��");

	}

}
