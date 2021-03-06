package com.lec.ex1_inputstreamOutputstream;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

// 1)파일을연다 (출력용스트림객체생성) 2)write한다 3)파일을닫는다(스트림객체.close)
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
			System.out.println("파일 출력 성공");
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
