package com.lec.ex2_datastream;

import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Scanner;

public class Ex03_ProductWrier { // n을 입력할때가지 재고(상품명, 가격, 재고량)을 입력받아 파일 출력
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String answer; // 예스냐 노 냐 받을 변수
		OutputStream fos = null;
		DataOutputStream dos = null;
		try {
			fos = new FileOutputStream("src/com/lec/ex2_datastream/product.dat", true);// true하면 누적 안쓰면 그전거 리셋됨
			dos = new DataOutputStream(fos);
			while (true) {
				System.out.print("입력할 재고가 더 있나요?(Y/N)?");
				answer = sc.next();
				if (answer.equalsIgnoreCase("n")) {
					break;
				} else if (answer.equalsIgnoreCase("y")) {
					System.out.print("상품명은?");
					dos.writeUTF(sc.next());
					System.out.print("가격은?");
					dos.writeInt(sc.nextInt());
					System.out.print("재고수량은?");
					dos.writeInt(sc.nextInt());

				}
			}
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}finally {
			try {
				if(dos !=null) dos.close();
				if(fos != null)fos.close();
			} catch (IOException e2) {
				// TODO Auto-generated catch block
				
			}
		}
	}
}
