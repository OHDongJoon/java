package test;

public class Member {
	private String name;
	private String phone;
	private String address;
	public Member() {}
	

	public Member(String name, String phone, String addres) {
		this.name = name;
		this.phone = phone;
		this.address = addres;
	}
	@Override
	public String toString() {
		return  name + " \t" + phone + "\t"+ address;
	}
	
	
	public void setName(String name) {
		this.name = name;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public void setAddres(String address) {
		this.address = address;
	}


	public String getName() {
		return name;
	}


	public String getphone() {
		return phone;
	}


	public String getAddress() {
		return address;
	}
	
}
