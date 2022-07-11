package com.lec.ex2_datastream;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class Ex02_dataInputStream {
	public static void main(String[] args) {
		InputStream fis = null;
		DataInputStream dis = null;
		try {
			fis = new FileInputStream("txFile/dataFile.dat");
			dis = new DataInputStream(fis); // 보조스트림은 기본스트림을 통해서생성
			while(true) {
				String name = dis.readUTF();
				int grade = dis.readInt();
				double score = dis.readDouble();
				System.out.printf("%s는 %d학년 %f점\n", name, grade,score);
			}
		} catch (FileNotFoundException e) {
			System.out.println("파일 못찾음 :" + e.getMessage());
		} catch (IOException e) {
			System.out.println("이상 데이터 끝");
		}finally {
			try {
				if(dis!=null) dis.close();
				if(fis!=null) fis.close();
			}catch(IOException e2) {}
		}
	}
}
