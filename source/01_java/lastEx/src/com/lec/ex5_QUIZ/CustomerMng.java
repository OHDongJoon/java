package com.lec.ex5_QUIZ;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class CustomerMng extends JFrame implements ActionListener {

	CustomerDao2 dao = CustomerDao2.getInstance();
	private Container container;
	private JPanel jpup, jpdown;
	private JTextField txtPone, txtName, txtPoint;
	private JButton btnJoin, btnSearch, btnOutput, btnExit;
	private JTextArea txtPool;
	private JScrollPane scrollPane;

	// ���� ����ȸ ��� ����
	public CustomerMng(String title) {
		super(title);
		setDefaultCloseOperation(EXIT_ON_CLOSE); // ����
		// ���� ��ü ����
		container = getContentPane();
		container.setLayout(new FlowLayout());
		jpup = new JPanel(new GridLayout(3, 2));
		jpdown = new JPanel();
		txtPone = new JTextField(15);
		txtName = new JTextField(15);
		txtPoint = new JTextField(15);
		
		btnJoin = new JButton("����");
		jpdown.add(btnJoin);
		
		btnSearch = new JButton("����ȸ");
		jpdown.add(btnSearch);
		
		btnOutput = new JButton("���");
		jpdown.add(btnOutput);
		
		btnExit = new JButton("����");
		jpdown.add(btnExit);
		
		txtPool = new JTextArea(15, 30);
		scrollPane = new JScrollPane(txtPool);
		// �����̳ʿ� add ������Ʈ ��ġ 
		//�� ��ȭ��ȣ
		jpup.add(new JLabel("�� ��ȭ", (int) CENTER_ALIGNMENT));
		jpup.add(txtPone);
		//���̸�
		jpup.add(new JLabel("�� �̸�", (int) CENTER_ALIGNMENT));
		jpup.add(txtName);
		//�� ����Ʈ
		jpup.add(new JLabel("�� ����Ʈ", (int) CENTER_ALIGNMENT));
		jpup.add(txtPoint);
		container.add(jpup);
		container.add(jpdown);
		container.add(scrollPane);
		setSize(new Dimension(400, 450));
		setLocation(200, 100);
		setVisible(true);
		//�̺�Ʈ �߰�
		btnJoin.addActionListener(this);
		btnSearch.addActionListener(this);
		btnOutput.addActionListener(this);
		btnExit.addActionListener(this);
		
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnJoin) { // ȸ������
			
			String stel = txtPone.getText().trim();
			String sname = txtName.getText().trim();
			if(stel.length()<8 || sname.length()<2) {
				txtPool.setText("��ȭ��ȣ�� �̸��� �ʼ� �Է»���");
				return;
			}
			int result = dao.insertCustomer2(stel, sname);
			if(result == CustomerDao2.SUCCESS) {
				txtPool.setText("ȸ������ �����մϴ� .����Ʈ 1000�� ~");
			
			}
		}else if (e.getSource() == btnSearch) { //��ȣ 4�ڸ�
					
					String stel = txtPone.getText().trim();
					if(stel.length() < 4) {
						txtPool.setText("4�ڸ��̻� �Է�");
						return;
				}
				ArrayList<CustomerDto2> customers = dao.sTelGetCustomer2(stel);
				if (customers.size()!= 0) {
					txtPool.setText("��ȭ \t\t �̸� \t ����Ʈ \n");
					txtPool.append("------------------------");
					for (CustomerDto2 customer : customers) {
						txtPone.setText(customer.getStel());
						txtName.setText(customer.getSname());
						txtPoint.setText(String.valueOf(customer.getSpoint()));
						txtPool.append(customer.toString() + "\n");
					}
				} else {
					txtPool.setText("�ش� ��ȭ��ȣ�� ���� �˻� ���� �ʽ��� . ȸ�������ϼ��L");
				}
			} else if (e.getSource() == btnOutput) { // ��ü ���
				
				ArrayList<CustomerDto2> customers = dao.getCustomers();
				if(customers.size() != 0) {
					txtPool.setText("��ȭ \t\t �̸� \t ����Ʈ \n");
					txtPool.append("------------------------");
					for (CustomerDto2 customer : customers) {
						
						txtPool.append(customer.toString() + "\n");
					}
					txtPool.append("��" + customers.size()+ "��");
				} else {
					txtPool.setText("�׷� ��� ����� ��");
				}
			} else if (e.getSource() == btnExit) { // ������
				setVisible(false);
				dispose();
				System.exit(0);
			}

			
		}
		
	
	public static void main(String[] args) {
		new CustomerMng("ȸ������");
	}
}
