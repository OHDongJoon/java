package com.lec.ex4_supermarket;
//  CID, CTEL, CNAME, CPOINT, CAMOUNT, LEVELNAME, forLevelUP
public class CustomerDto {
	private int cid; // ����ȣ
	private String ctel; // ����
	private String cname; // �̸�
	private int		cpoint; // ����Ʈ
	private int     camount; // ���űݾ�
	private String   levelName; //���
	private int 	forLevelUp; // �󸶴���� ������
	public CustomerDto(String ctel, String cname, int cpoint, int camount, String levelName, int forLevelUp) {
		
		this.ctel = ctel;
		this.cname = cname;
		this.cpoint = cpoint;
		this.camount = camount;
		this.levelName = levelName;
		this.forLevelUp = forLevelUp;
	}
	@Override
	public String toString() {
		return cid+"\t"+ ctel + "\t\t" + cname + "\t" + cpoint +"\t" + camount + 
				"\t" + levelName + "\t" + forLevelUp;
	}
	public int getCid() {
		return cid;
	}
	public String getCtel() {
		return ctel;
	}
	public String getCname() {
		return cname;
	}
	public int getCpoint() {
		return cpoint;
	}
	public int getCamount() {
		return camount;
	}
	public String getLevelName() {
		return levelName;
	}
	public int getForLevelUp() {
		return forLevelUp;
	}
	
}



