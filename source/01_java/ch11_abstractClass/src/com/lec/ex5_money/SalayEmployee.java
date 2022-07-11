package com.lec.ex5_money;
// ø¨∫¿¿Ã∂˚ pay ¿Œºæ
public  class SalayEmployee extends Employee {
	private int annalSalary;
	public SalayEmployee() {}
	public SalayEmployee(String name, int annalSalary) {
		super(name);
		this.annalSalary = annalSalary;
	}

	public int computePay() {

		
		return annalSalary/14;

	}
	public int getAnnalSalary() {
		return annalSalary;
	}
	public void setAnnalSalary(int annalSalary) {
		this.annalSalary = annalSalary;
	}

	

	
}