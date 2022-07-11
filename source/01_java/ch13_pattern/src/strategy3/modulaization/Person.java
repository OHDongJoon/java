package strategy3.modulaization;

import strategy3.interfaces.IGet;
import strategy3.interfaces.Ijob;

public abstract class Person {
	private String name;
	private String id;
	private Ijob job;
	private IGet get;

	public Person(String name, String id) {
		this.name = name;
		this.id = id;
	}

	public void job() {
		job.job();
	}

	public void get() {
		get.Get();
	}

	public void print() {
		System.out.println("[id]" + id + "\t[name]" + name);

	}

	@Override
	public String toString() {
		return "id=" + id + "\t name=" + name + "\t";
	}

	public void setJob(Ijob job) {
		this.job = job;
	}

	public void setGet(IGet get) {
		this.get = get;
	}
	

}