package com.lec.ex2_human.main;

// * (��������Ʈ�ض���): com.lec.ex2_human ��Ű�� ��� class�� import�Ѵ�
// ���ʿ��� package import ���� : Ŭ���ѰŸ� ����Ʈ�ϴ¹� ��+ ��+ o ����Ʈ����
import com.lec.ex2_human.*;// �׻� ����������  �� �� o

//��� ����Ʈ 100���� 100�� �� ����Ʈ�� * ���� 
public class TestMain {

	public static void main(String[] args) {
		int i = 10; // �⺻ ������
		int j = 10;

		if (i == j) {// ���� ������ Ÿ�Կ����� ������ ��
			System.out.println("i��j����");
		}

		String name = "ȫ�浿";
		String name2 = "ȫ�浿"; // ���� ȫ�浿(�ּ�) ��� ������ name2 ���� name ���� String��
		if (name.equals(name2)) {// ��ü������ ������ �񱳽�
			System.out.println("name�� name2 ����");
		}
		Woman hee1 = new Woman(); // Ŭ���ѰŸ� ����Ʈ�ϴ¹� ��+ ��+ o ����Ʈ����
		Woman hee2 = new Woman();
		// hee1.method();
		// ��ü ��ü ������ : equals
		if (hee1.equals(hee2)) {
			System.out.println("hee �� hee2����");
		}
		Man kang = new Man(22,165,60.2);
		Man kim = new Man(22,180,65.6);
		Man kim1;
		kim1 = kim;
		Man kim2 = new Man(22, 180, 65.6);
		if(kim.equals(kim1)) {
			System.out.println("kim��kim1�� ����(���� �ּҸ� ����Ų��)");
		}
		if(!kim.equals(kim2)) {
			System.out.println("kim�� kim2�� �ٸ� ��ü��(�ٸ� �ּ� ���� �ִ�)");
	}	
		
		kang.setHeight(160);
		kang.setWeight(50.9); //51�� �������� ����ȯ(double������)
		if(kang.calculateBMI() > 30) {
		// bmi ����ϴ¹�	System.out.print(kang.calculateBMI());
			System.out.println("�ǰ��ϼ���");
		}else {
			System.out.println("�ǰ��ϰڳ׿�");
		}
		
		
	}

}
