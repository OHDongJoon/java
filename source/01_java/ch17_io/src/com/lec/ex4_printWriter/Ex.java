package com.lec.ex4_printWriter;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.Writer;

public class Ex {
	public static void main(String[] args) {
		OutputStream os = null;
		Writer writer = null;
		PrintWriter printWriter = null;
		try {
//			os = new FileOutputStream("txtFile/outTest.txt", true);//�⺻ ��Ʈ��
//			printWriter = new PrintWriter(os); // ������Ʈ��
//			writer = new FileWriter("txtFile/outTest.txt\", true");
//			printWriter = new PrintWriter(writer);// ���� ��Ʈ��
			printWriter = new PrintWriter("txFile/outTest.txt");
			System.out.println("�ȳ��ϼ���\n�ݰ����ϴ�");
			printWriter.println("�ȳ��ϼ���\n�ݰ����ϴ�");
			
			System.out.print("print�� �ڵ������� �ȵǼ� �����߰�\n");
			printWriter.print("print�� �ڵ������� �ȵǼ� �����߰�\n");
			
			System.out.printf("%s\t %3d \t %d \t %5.1f\n", "ȫ�浿", 90, 91, 90.5);
			printWriter.printf ("%s\t %3d \t %d \t %5.1f", "ȫ�浿", 90, 91, 90.5);
			
			System.out.printf  ("%s\t %3d \t %d \t %5.1f", "�ű浿", 100, 100, 100.0);
			printWriter.printf ("%s\t %3d \t %d \t %5.1f", "�ű浿", 100, 91, 100.0);
			
		} catch (IOException e) {
			System.out.println(e.getMessage());

		}
	}
}