package strategy3.modulaization;

import strategy3.interfaces.GetSalary;
import strategy3.interfaces.JobMng;

public class Lecturer extends Person {
	private String subject;
	public Lecturer(String id, String name, String subject) {
		super(id, name);
		this.subject = subject;
		setJob(new JobMng());
		setGet(new GetSalary());
	}
	public void print() {
		super.print();
		System.out.println("\t[¹Ý]"+subject);
	}

}
