package StudyButton;

import java.awt.*;
import javax.swing.*;
import javax.swing.table.*;
import java.awt.event.*;
import JavaTEamProject.*;

public class StudyButton2 extends JPanel{
	private MainPage win;

	JPanel screen = new JPanel();
	
	// main page�� ������ ���� 
	ImageIcon image1 = new ImageIcon("./study_picture/�ټ� ������.jpg");
	Image pre_image1=image1.getImage();
	Image pos_image1=pre_image1.getScaledInstance(1000,200,java.awt.Image.SCALE_SMOOTH);
	ImageIcon I_study1 = new ImageIcon(pos_image1);
		
	// ���� ���� �� ����
	JLabel label = new JLabel(I_study1);
	
	JLabel study_name = new JLabel("�ټ� ������");
	JLabel study_review = new JLabel("���� : 3.89");

	JLabel line = new JLabel("----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
	JButton study_menu = new JButton("�޴�");
	JButton study_information = new JButton("����");
	JButton study_picture = new JButton("����");
	
	// �޴�
	ImageIcon example = new ImageIcon("./menu_image/�ټ� �޴�.png");
	Image pre_ex1=example.getImage();
	Image pos_ex1=pre_ex1.getScaledInstance(900,280,java.awt.Image.SCALE_SMOOTH);
	ImageIcon exam = new ImageIcon(pos_ex1);
	
	JLabel ex = new JLabel(exam);
	
	// �����ϱ� ��ư
	JButton reservation = new JButton("�����ϱ�");
	
	public void setFont()
	{
		study_name.setFont(new Font("����", Font.BOLD, 20));
		study_review.setFont(new Font("����", Font.PLAIN, 15));
		study_review.setForeground(Color.BLUE);
		
		line.setForeground(Color.LIGHT_GRAY);
		study_menu.setFont(new Font("����", Font.PLAIN, 18));
		study_information.setFont(new Font("����", Font.PLAIN, 18));
		study_picture.setFont(new Font("����", Font.PLAIN, 18));
		
		study_menu.setBackground(Color.WHITE);
		study_information.setBackground(Color.WHITE);
		study_picture.setBackground(Color.WHITE);
		
		reservation.setFont(new Font("����", Font.PLAIN, 18));
	}
	public void setDisplay() 
	{
		screen.setLayout(null);
		screen.setSize(1020, 800);

		label.setBounds(0,0,1000,200);
		study_name.setBounds(450,200,400,50);
		study_review.setBounds(470,230,200,50);
		
		line.setBounds(0,260,1000,30);
		study_menu.setBounds(50,290,200,50);
		study_information.setBounds(400,290,200,50);
		study_picture.setBounds(750,290,200,50);
		
		ex.setBounds(50,220,900,600);
		
		reservation.setBackground(new Color(34, 166, 179));
		reservation.setForeground(Color.WHITE);
		reservation.setFont(new Font("����", Font.BOLD, 20));
		
		reservation.setBounds(50,680,900,50);
		
		screen.add(label);
		screen.add(study_name);
		screen.add(study_review);
		
		screen.add(line);
		screen.add(study_menu);
		screen.add(study_information);
		screen.add(study_picture);
		
		screen.add(ex);
		screen.add(reservation);
	}
	
	public void StudyButton2Listener() {
		study_menu.addActionListener(new ActionListener() {
			//@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated
				win.panelChange("study2_menu_Button");
			}
		});
		study_information.addActionListener(new ActionListener() {
			//@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated
				win.panelChange("study2_information_Button");
			}
		});
		study_picture.addActionListener(new ActionListener() {
			//@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated
				win.panelChange("study2_picture_Button");
			}
		});
		reservation.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				win.setService(1006, 20);
			}
		});
	}
	
	public StudyButton2(MainPage win)
	{
		this.win = win;
		setLayout(null);
		screen.setBackground(Color.white);
		add(screen);
		setFont();
		setDisplay();
		StudyButton2Listener();
		setVisible(true);
	}
}