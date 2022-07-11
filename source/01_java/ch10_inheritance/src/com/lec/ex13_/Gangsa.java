package com.lec.ex13_;

public class Gangsa extends Person {
	private static int cntGangsa = 0;
	private String subject;
	public Gangsa() { }
	public Gangsa(String id, String name, String subject) {
		
		super(id, subject);
		this.subject = subject;
		++cntGangsa;
		setNo("lec"+cntGangsa);
	
		
	}
	@Override
	public void print() {
		super.print();
		System.out.println("\t(과목)" + subject);
	}
	@Override
	public String infoString() {
		
		return super.infoString()+"\t(과목)"+subject;
	}

}
