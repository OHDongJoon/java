package com.lec.ex2_date;

import java.util.Calendar;
import java.util.GregorianCalendar;
// ������?
public class Ex02_greagorinCalendar {
	public static void main(String[] args) {
		//Calendar cal = Calendar.getInstance();// �̱��� Ŭ����
		GregorianCalendar cal = new GregorianCalendar();
		System.out.println(cal);
		int year = cal.get(Calendar.YEAR); // �⵵
		int month = cal.get(Calendar.MONTH)+1; //��(Calendar,MONTH 0,1,2,3,...11��
		int day = cal.get(Calendar.DAY_OF_MONTH); // ��
		int week = cal.get(Calendar.DAY_OF_WEEK);//��1, ��2, ȭ3, ��4, ....�� 7
		int hour24 = cal.get(Calendar.HOUR_OF_DAY); // 24�ð� ����
		int ampm = cal.get(Calendar.AM_PM); /// 0 ���� 1 ���� 
		int hour = cal.get(Calendar.HOUR); // 12�ð�����
		int minute = cal.get(Calendar.MINUTE); // ��
		int second = cal. get(Calendar.SECOND); // ��
		int millisec = cal.get(Calendar.MILLISECOND); //�и�����
		System.out.printf("%d�� %d�� %d��", year, month, day);
		switch(week) {
		case 1: System.out.println("�Ͽ���"); break;
		case 2: System.out.println("������"); break;
		case 3: System.out.println("ȭ����"); break;
		case 4: System.out.println("������"); break;
		case 5: System.out.println("�����"); break;
		case 6: System.out.println("�ݿ���"); break;
		case 7: System.out.println("�����"); break;
		
		}
		System.out.println(ampm == 0 ? "����" : "����");
		System.out.printf("%d�� %d�� %d�� %d\n", hour, minute, second, millisec);
		System.out.printf("%d�� %d�� %d��\n", hour24, minute, second, millisec);
		
		// %d(����) %f(�Ǽ�) %s(���ڿ�) %c(����)
		// %ty(��) %tm(��) %td(��) %ta(����) %tp(����/����) %t1(12��) %tm(��) %ts(��)
		System.out.printf("%tY�� %tm�� %td�� %ta���� %tp %tl�� %tM�� %tS��\n", cal, cal, cal, cal, cal, cal, cal, cal);
		System.out.printf("%1$tY�� %1$tm�� %1$td�� %1$ta���� %1$tp %1$tl�� %1$tM�� %1$tS��", cal); // ??
	}
	
}
