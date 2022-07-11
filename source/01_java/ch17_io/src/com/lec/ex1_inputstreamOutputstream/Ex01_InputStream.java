package com.lec.ex1_inputstreamOutputstream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

//	(1) ������ ����(��Ʈ����ü����) (2)�����͸� �д´�(read()) (3)������ �ݴ´�
public class Ex01_InputStream {
	public static void main(String[] args) {
		InputStream is = null;
		try {
			is = new FileInputStream("txFile/inTest.txt"); //1.������ ����
			while(true) { //2. �����͸� �д´�
				int i = is.read(); // �д� �޼ҵ�  �������� ���� -1�� �����ϰԵȴ�
				if(i==-1) break; // ������ ���̸� �ݺ��� ��Ż��~
				System.out.print((char)i + "(" + i +")");
			}
			System.out.println("\n��");  
		} catch (FileNotFoundException e) {
			System.out.println("������ �� ã�� ��� ����:"+e.getMessage());
			
		} catch (IOException e) {
			System.out.println("������ �� �д� ��� ���� :" + e.getMessage());
		} finally {
			//3.������ �ݴ´�2
			try {
				if(is!=null) is.close();
			} catch (IOException e) {
				System.out.println(e.getMessage());
			}
		}
	}
}
