package strategy3.modulaization;

import strategy3.interfaces.GetStudentPay;
import strategy3.interfaces.IGet;
import strategy3.interfaces.Ijob;
import strategy3.interfaces.JobStudey;

public class Student extends Person {
	private String ban;
	public Student(String name, String id, String ban) {
		super(name, id);
		this.ban = ban;
		setJob(new JobStudey());
		setGet(new GetStudentPay());
	}
	public void print() {
		super.print();
		System.out.println("\t[¹Ý]"+ban);
	}
	
	
}
