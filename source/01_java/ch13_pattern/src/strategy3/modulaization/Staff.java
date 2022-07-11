package strategy3.modulaization;

import strategy3.interfaces.GetSalary;
import strategy3.interfaces.JobMng;

public class Staff extends Person {
	private String part;
	public Staff(String name, String id, String part) {
		super(name, id);
		this.part = part;
		setJob(new JobMng());
		setGet(new GetSalary());
	}
	public void print() {
		super.print();
		System.out.println("\t[°ú¸ñ]"+part);
	}
}
