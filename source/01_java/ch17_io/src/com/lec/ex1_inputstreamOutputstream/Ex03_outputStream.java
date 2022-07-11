package com.lec.ex1_inputstreamOutputstream;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

// 1)���������� (��¿뽺Ʈ����ü����) 2)write�Ѵ� 3)�������ݴ´�(��Ʈ����ü.close)
public class Ex03_outputStream {
	public static void main(String[] args) {
		OutputStream os = null;
		try {
			os = new FileOutputStream("txFile/outTest.txt", true);// (1) true
			byte[] bs = {'H','e','l','l','o'};
//			for(int i =0; i <bs.length ; i++) { // (2)
//				os.write(bs[i]);
//			}
			os.write(bs);
			System.out.println("���� ��� ����");
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());

		}finally {
			try{
				if(os!=null) os.close();
			}catch (IOException e) {
				System.out.println(e.getMessage());
			}
		}
	}
}
