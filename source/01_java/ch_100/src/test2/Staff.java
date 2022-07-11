package test2;

public class Staff extends Person2 {
	private String department;

	public Staff(String id, String name, String department) {
		super(id,name);
		this.department = department;
	}
	@Override
	public void print() {
		super.print();
		System.out.print("\t(ºÎ¼­)" + department +"\n");
	}
}
