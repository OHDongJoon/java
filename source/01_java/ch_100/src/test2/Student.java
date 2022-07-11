package test2;

public class Student extends Person2 {
	private String ban;

	public Student(String id, String name,String ban) {
		super(id, name);
		this.ban = ban;
	}
	@Override
	public void print() {
		super.print();
		System.out.print("\t (¹Ý)"+ ban+"\n");
	}
}
