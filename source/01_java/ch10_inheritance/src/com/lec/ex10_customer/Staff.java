package com.lec.ex10_customer;

// name , tel, hiredate(�Ի���) , department(�μ�)
// Staff s = new Staff("ȫ","010", "2022-09-01", "������"
public class Staff extends Person {

	private String hiredate; // �Ի���
	private String department;// �μ�

	public Staff(String name, String tel, String hiredate, String department) {
		super(name, tel);
		this.hiredate = hiredate;
		this.department = department;
	}//	                       (Person�� �����̸� ��ȭ)( �̰͸� �߰�����)
	// syout(s.infoString) // - [�̸�] �� [��ȭ] 010 [�Ի���]2022-09-01 [�μ�]������
	@Override
	public String infoString() {
	//	return super.infoString(); // �̷��Ը� �ϸ� �̸� ��ȭ��
		return super.infoString()+"[�Ի���]"+hiredate+"[�μ�]"+department;  // info(�̸� ��ȭ ���) �߰� : �Ի� , �μ�
	} 
}
