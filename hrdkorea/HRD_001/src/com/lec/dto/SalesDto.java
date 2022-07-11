package com.lec.dto;

import java.sql.Date;

public class SalesDto {
	private int custno;
	private int selenol;
	private int pcost;
	private int amount;
	private int price;
	private int pcode;
	private Date sdate;
	public SalesDto() {}
	public SalesDto(int custno, int selenol, int pcost, int amount, int price, int pcode, Date sdate) {
		super();
		this.custno = custno;
		this.selenol = selenol;
		this.pcost = pcost;
		this.amount = amount;
		this.price = price;
		this.pcode = pcode;
		this.sdate = sdate;
	}
	@Override
	public String toString() {
		return "SalesDto [custno=" + custno + ", selenol=" + selenol + ", pcost=" + pcost + ", amount=" + amount
				+ ", price=" + price + ", pcode=" + pcode + ", sdate=" + sdate + "]";
	}
	
}
