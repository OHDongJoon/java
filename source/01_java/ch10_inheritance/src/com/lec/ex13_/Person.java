package com.lec.ex13_;

public class Person {
	
	private String no ;
	private String id;
	private String name;
	public Person() {}
	
	public Person(String id,  String name) {
		this.id = id;
		this.name = name;
		
	}
public void print() {
		if(id.length() < 4) {
		System.out.print("(��ȣ)"+ no+"\t(ID)"+id+"\t\t(�̸�):"+name);
	}else {
		System.out.print("(��ȣ)"+no+"\t(ID)"+id+"\t(�̸�):"+name);
	}
}
public String infoString() {
	return "(��ȣ)"+no+"\t(ID)"+id+"\t(�̸�):"+name;
}

public String getNo() {
	return no;
}

public void setNo(String no) {
	this.no = no;
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
