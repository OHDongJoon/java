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

	// 가입 폰조회 출력 종료
	public CustomerMng(String title) {
		super(title);
		setDefaultCloseOperation(EXIT_ON_CLOSE); // 종료
		// 컴포 객체 생성
		container = getContentPane();
		container.setLayout(new FlowLayout());
		jpup = new JPanel(new GridLayout(3, 2));
		jpdown = new JPanel();
		txtPone = new JTextField(15);
		txtName = new JTextField(15);
		txtPoint = new JTextField(15);
		
		btnJoin = new JButton("가입");
		jpdown.add(btnJoin);
		
		btnSearch = new JButton("폰조회");
		jpdown.add(btnSearch);
		
		btnOutput = new JButton("출력");
		jpdown.add(btnOutput);
		
		btnExit = new JButton("종료");
		jpdown.add(btnExit);
		
		txtPool = new JTextArea(15, 30);
		scrollPane = new JScrollPane(txtPool);
		// 컨테이너에 add 컴포넌트 배치 
		//고객 전화번호
		jpup.add(new JLabel("고객 전화", (int) CENTER_ALIGNMENT));
		jpup.add(txtPone);
		//고객이름
		jpup.add(new JLabel("고객 이름", (int) CENTER_ALIGNMENT));
		jpup.add(txtName);
		//고객 포인트
		jpup.add(new JLabel("고객 포인트", (int) CENTER_ALIGNMENT));
		jpup.add(txtPoint);
		container.add(jpup);
		container.add(jpdown);
		container.add(scrollPane);
		setSize(new Dimension(400, 450));
		setLocation(200, 100);
		setVisible(true);
		//이벤트 추가
		btnJoin.addActionListener(this);
		btnSearch.addActionListener(this);
		btnOutput.addActionListener(this);
		btnExit.addActionListener(this);
		
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnJoin) { // 회원가입
			
			String stel = txtPone.getText().trim();
			String sname = txtName.getText().trim();
			if(stel.length()<8 || sname.length()<2) {
				txtPool.setText("전화번호와 이름은 필수 입력사항");
				return;
			}
			int result = dao.insertCustomer2(stel, sname);
			if(result == CustomerDao2.SUCCESS) {
				txtPool.setText("회원가입 감사합니다 .포인트 1000점 ~");
			
			}
		}else if (e.getSource() == btnSearch) { //번호 4자리
					
					String stel = txtPone.getText().trim();
					if(stel.length() < 4) {
						txtPool.setText("4자리이상 입력");
						return;
				}
				ArrayList<CustomerDto2> customers = dao.sTelGetCustomer2(stel);
				if (customers.size()!= 0) {
					txtPool.setText("전화 \t\t 이름 \t 포인트 \n");
					txtPool.append("------------------------");
					for (CustomerDto2 customer : customers) {
						txtPone.setText(customer.getStel());
						txtName.setText(customer.getSname());
						txtPoint.setText(String.valueOf(customer.getSpoint()));
						txtPool.append(customer.toString() + "\n");
					}
				} else {
					txtPool.setText("해당 전화번호의 고객이 검색 되지 않슴둥 . 회원가입하세횸");
				}
			} else if (e.getSource() == btnOutput) { // 전체 출력
				
				ArrayList<CustomerDto2> customers = dao.getCustomers();
				if(customers.size() != 0) {
					txtPool.setText("전화 \t\t 이름 \t 포인트 \n");
					txtPool.append("------------------------");
					for (CustomerDto2 customer : customers) {
						
						txtPool.append(customer.toString() + "\n");
					}
					txtPool.append("총" + customers.size()+ "명");
				} else {
					txtPool.setText("그런 사람 없어욤 ㅎ");
				}
			} else if (e.getSource() == btnExit) { // 나가기
				setVisible(false);
				dispose();
				System.exit(0);
			}

			
		}
		
	
	public static void main(String[] args) {
		new CustomerMng("회원관리");
	}
}
