package test2;

public class Person2 {
	private String id;
	private String name;
	public Person2() {}
	public Person2(String id, String name) {
		this.id = id;
		this.name = name;
		
		
	}
	public void print() {
		System.out.print("[id]"+id+"\t"+"[¿Ã∏ß]"+name);
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}
