package JavaTEamProject;

import java.awt.*;
import javax.swing.table.JTableHeader;
import java.awt.event.*;
import java.util.Vector;
import javax.swing.*;

public class CustomerServiceButton extends JPanel{
	private MainPage win;
	
	JPanel p_table = new JPanel();
	JPanel p_infor = new JPanel();
	JTable table;
	JScrollPane title;
	Vector<String> columnNames;
	Vector<Vector<String>> rowData;

	JTextField tf_number;
	JTextField tf_title;
	JTextField tf_contents;
	JTextField tf_name;
	JTextField tf_days;

	JButton b_add;
	JButton b_modify;
	JButton b_delete;

	public void setDisplay()
	{
		p_table.setBackground(new Color(223, 249, 251));
		p_infor.setBackground(new Color(223, 249, 251));
		
		columnNames=new Vector<String>();
		rowData=new Vector<Vector<String>>();
  
		columnNames.add("질문 번호");
		columnNames.add("제목");
		columnNames.add("내용");
		columnNames.add("작성자");
		columnNames.add("작성일자");
  
		table=new JTable(rowData, columnNames);
		table.setBackground(Color.WHITE);
  
		table.setFillsViewportHeight(true);
		
		JTableHeader header = table.getTableHeader();
		header.setFont(new Font("고딕", Font.BOLD, 15));
	    header.setBackground(new Color(34, 166, 179));
	    header.setForeground(Color.WHITE);
		
		
		////////////테이블모양/////////////
		title = new JScrollPane(table, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		add(title, BorderLayout.NORTH);
		
		JLabel l_number=new JLabel("질문 번호");
		// JLabel label_kor=new JLabel("국어");﻿
		JLabel l_title=new JLabel("제목");
		JLabel l_contents=new JLabel("내용");
		JLabel l_name=new JLabel("작성자");
		JLabel l_days=new JLabel("작성일자");
		
		l_number.setFont(new Font("고딕", Font.BOLD, 20));
		l_title.setFont(new Font("고딕", Font.BOLD, 20));
		l_contents.setFont(new Font("고딕", Font.BOLD, 20));
		l_name.setFont(new Font("고딕", Font.BOLD, 20));
		l_days.setFont(new Font("고딕", Font.BOLD, 20));
		
		l_number.setHorizontalAlignment(JLabel.CENTER);
		l_title.setHorizontalAlignment(JLabel.CENTER);
		l_contents.setHorizontalAlignment(JLabel.CENTER);
		l_name.setHorizontalAlignment(JLabel.CENTER);
		l_days.setHorizontalAlignment(JLabel.CENTER);
     
		tf_number=new JTextField(10);
		tf_title=new JTextField(20);
		tf_contents=new JTextField(100);
		tf_name=new JTextField(10);
		tf_days=new JTextField(15);
  
		p_table.setLayout(null);
		
		l_number.setBounds(50,40,100,20);
		l_title.setBounds(50,90,100,20);
		l_contents.setBounds(50,140,100,20);
		l_name.setBounds(50,190,100,20);
		l_days.setBounds(50,240,100,20);
		
		tf_number.setBounds(180,30,700,40);
		tf_title.setBounds(180,80,700,40);
		tf_contents.setBounds(180,130,700,40);
		tf_name.setBounds(180,180,700,40);
		tf_days.setBounds(180,230,700,40);
		
		// 추가
		p_table.add(l_number);
		p_table.add(tf_number);
		p_table.add(l_title);
		p_table.add(tf_title);
		p_table.add(l_contents);
		p_table.add(tf_contents);
		p_table.add(l_name);
		p_table.add(tf_name);
		p_table.add(l_days);
		p_table.add(tf_days);
		
		b_add=new JButton("추가");
		b_modify=new JButton("수정");
		b_delete=new JButton("삭제");
		
		
		b_add.setBackground(new Color(34, 166, 179));
		b_modify.setBackground(new Color(34, 166, 179));
		b_delete.setBackground(new Color(34, 166, 179));
		b_add.setForeground(Color.WHITE);
		b_modify.setForeground(Color.WHITE);
		b_delete.setForeground(Color.WHITE);
		
		b_add.setFont(new Font("고딕", Font.BOLD, 26));
		b_modify.setFont(new Font("고딕", Font.BOLD, 26));
		b_delete.setFont(new Font("고딕", Font.BOLD, 26));
		
		b_add.setPreferredSize(new Dimension(150, 30));
		b_modify.setPreferredSize(new Dimension(150, 30));
		b_delete.setPreferredSize(new Dimension(150, 30));
		
		// 추가
		p_infor.add(b_add);
		p_infor.add(b_modify);
		p_infor.add(b_delete);
	}
	
	public void CustomerServiceButtonListener()
	{
		//추가하기 버튼
		b_add.addActionListener(new ActionListener() {
		   
			//@Override
			public void actionPerformed(ActionEvent e) {
		   
				String number = tf_number.getText();
				String title = tf_title.getText();
				String contents = tf_contents.getText();
				String name = tf_name.getText();
				String days = tf_days.getText();
		    
				Vector<String> v =new Vector<String>();
				v.add(number);
				v.add(title);
				v.add(contents);
				v.add(name);
				v.add(days);
		    
				rowData.add(v);//텍스트 필드에 있는 값을 추가하기.
		    
				table.updateUI();
		    
				tf_number.setText("");//추가후에, 텍스트필드에 남아있는 값 지워주기.
				tf_title.setText("");
				tf_contents.setText("");
				tf_name.setText("");
				tf_days.setText("");
			}
		});

		// 수정하기 버튼
		b_modify.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				try {
					String num = tf_number.getText();
					String tit = tf_title.getText();
					String con = tf_contents.getText();
					String name = tf_name.getText();
					String days = tf_days.getText();

					int selection = table.getSelectedRow();// 사용자가 선택
					Vector<String> v = new Vector<String>();
					v.add(num);
					v.add(tit);
					v.add(con);
					v.add(name);
					v.add(days);

					rowData.setElementAt(v, selection);
					// Vector의 메소드
					// 지정된 위치(v, selection)의 저장된 객체를 반환해주는 역할/

					table.updateUI();

					tf_number.setText("");// 수정후에, 텍스트필드에 남아있는 값 지워주기.
					tf_title.setText("");
					tf_contents.setText("");
					tf_name.setText("");
					tf_days.setText("");
				} catch (ArrayIndexOutOfBoundsException a) {
				}
			}
		});

		// 삭제하기 버튼
		b_delete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					int selection = table.getSelectedRow();
					rowData.remove(selection);
					table.updateUI();
					tf_number.setText("");
					tf_title.setText("");
					tf_contents.setText("");
					tf_name.setText("");
					tf_days.setText("");
				} catch (ArrayIndexOutOfBoundsException a) {
				}
			}
		});
		  
		table.addMouseListener(new MouseAdapter() {
			//@Override
			public void mouseClicked(MouseEvent e) {
				//마우스로 선택한 행의 정보를 각각의 텍스트필드에 출력하기 
				int selection=table.getSelectedRow();
				Vector<String> vc=rowData.get(selection);
		  			
				tf_number.setText(vc.get(0));
				tf_title.setText(vc.get(1));
				tf_contents.setText(vc.get(2));
				tf_name.setText(vc.get(3));
				tf_days.setText(vc.get(4));
			}
		});
	}
	
	public CustomerServiceButton(MainPage win)
	{
		this.win = win;
		setLayout(new BorderLayout());
		setBackground(new Color(223, 249, 251));
		add(p_table, BorderLayout.CENTER);
		add(p_infor, BorderLayout.SOUTH);
		
		setDisplay();
		CustomerServiceButtonListener();
		setVisible(true);
	}
	
}
  