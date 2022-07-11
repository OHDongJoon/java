package test2;

public class Gangsa extends Person2 {
	private String subjet;

	public Gangsa(String id, String name, String subjet) {
		super(id, name);
		this.subjet = subjet;
	}
	@Override
	public void print() {
		super.print();
		System.out.print("\t(°ú¸ñ)"+subjet+"\t");
	}
}
