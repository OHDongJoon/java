package com.lec.customer;

import java.sql.Date;
import java.sql.Timestamp;

public class CustomerDto {
	private String cid;    //아이디
	private String cname; // 이름
	private String cpw; // 비번
	private String ctel; // 전번
	private String cemail; // 이메일
	private String caddress; //주소
	private String cgender; // 성별
	private Timestamp cbirth;// 생년월일
	private Date 	  crdate;
	public CustomerDto() {}
	public CustomerDto(String cid, String cname, String cpw, String ctel, String cemail, String caddress,
			String cgender, Timestamp cbirth, Date crdate) {
		
		this.cid = cid;
		this.cname = cname;
		this.cpw = cpw;
		this.ctel = ctel;
		this.cemail = cemail;
		this.caddress = caddress;
		this.cgender = cgender;
		this.cbirth = cbirth;
		this.crdate = crdate;
	}
	public String getCid() {
		return cid;
	}
	public void setCid(String cid) {
		this.cid = cid;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public String getCpw() {
		return cpw;
	}
	public void setCpw(String cpw) {
		this.cpw = cpw;
	}
	public String getCtel() {
		return ctel;
	}
	public void setCtel(String ctel) {
		this.ctel = ctel;
	}
	public String getCemail() {
		return cemail;
	}
	public void setCemail(String cemail) {
		this.cemail = cemail;
	}
	public String getCaddress() {
		return caddress;
	}
	public void setCaddress(String caddress) {
		this.caddress = caddress;
	}
	public String getCgender() {
		return cgender;
	}
	public void setCgender(String cgender) {
		this.cgender = cgender;
	}
	public Timestamp getCbirth() {
		return cbirth;
	}
	public void setCbirth(Timestamp cbirth) {
		this.cbirth = cbirth;
	}
	public Date getCrdate() {
		return crdate;
	}
	public void setCrdate(Date crdate) {
		this.crdate = crdate;
	}
	@Override
	public String toString() {
		return "CustomerDto [cid=" + cid + ", cname=" + cname + ", cpw=" + cpw + ", ctel=" + ctel + ", cemail=" + cemail
				+ ", caddress=" + caddress + ", cgender=" + cgender + ", cbirth=" + cbirth + ", crdate=" + crdate + "]";
	}
	
}
