package com.lec.ex5_QUIZ;

public class CustomerDto2 {
	private int sid; // �� ��ȣ
	private String stel; // ����
	private String sname;// ���̸�
	private int spoint;// ����Ʈ

	public CustomerDto2(String stel, String sname, int spoint) {

		this.stel = stel;
		this.sname = sname;
		this.spoint = spoint;
	}

	@Override
	public String toString() {

		return stel + "\tt" + sname + "\t" + "spoint";
	}

	public String getStel() {
		return stel;
	}

	public String getSname() {
		return sname;
	}

	public int getSpoint() {
		return spoint;
	}

}
