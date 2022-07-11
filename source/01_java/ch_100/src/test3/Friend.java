package test3;

public class Friend {
	private String name;
	private String phone;
	private String address;
	private String birthday;
	public Friend() {}
	public Friend(String name, String phone, String address, String birthday) {

		this.name = name;
		this.phone = phone;
		this.address = address;
		this.birthday = birthday;
	}
	@Override
	public String toString() {
		return  "이름 :"+ name + "\n" +"핸드폰:"+phone +  "\n" + "주소:" + address + "\n"+ "생일:" + birthday ;
	}
	public String getName() {
		return name;
	}
	public String getPhone() {
		return phone;
	}
	public String getAddress() {
		return address;
	}
	public String getBirthday() {
		return birthday;
	}
	
}
