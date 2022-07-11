package test3;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class TestMain1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String answer, name, phone, address;
		ArrayList<Customer> customers = new ArrayList<Customer>();
		
		do {
			System.out.print("ȸ�������ϽǷ���? �ƴϸ� n��������");
			answer = sc.next();
			if(answer.equalsIgnoreCase("n"))
				break;
			System.out.print("ȸ���� �̸���?");
			name = sc.next();
			System.out.print("ȸ���� ��ȭ��ȣ��?");
			phone = sc.next();
			System.out.print("ȸ���� �ּҴ�?");
			sc.nextLine();
			address = sc.nextLine();
			customers.add(new Customer(name,phone,address));
			
		}while(true);
		sc.close();
		OutputStream os = null;
		try {
			os = new FileOutputStream("src/test3/customer.txt");
			for(Customer customer : customers ) {
				System.out.print(customer);
				os.write(customer.toString().getBytes());
			}
		} catch (FileNotFoundException e) {
			System.out.println("���� ��ã��"+ e.getMessage());
		} catch (IOException e) {
			System.out.println("���� ����"+e.getMessage());
		}finally {
			try {
				if (os != null)
					os.close();
			} catch (Exception ignore) {
				System.out.println(ignore.getMessage());
			}
		}
	}
}