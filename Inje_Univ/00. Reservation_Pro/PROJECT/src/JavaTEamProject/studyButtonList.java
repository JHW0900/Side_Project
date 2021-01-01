package JavaTEamProject;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Image;
import java.util.Vector;
	 
public class studyButtonList extends JPanel {
	private MainPage win;

	JPanel screen = new JPanel();
	
	//������ ������ �̹��� ������
	ImageIcon I_st1 = new ImageIcon("./store_logo/���ν�.png");
	ImageIcon I_st2 = new ImageIcon("./store_logo/�ټַΰ�.jpg");
	ImageIcon I_st3 = new ImageIcon("./store_logo/����24.PNG");
	ImageIcon I_st4 = new ImageIcon("./store_logo/������.PNG");
		
	//ImageIcon���� ���� �̹��� ��ȯ�ϱ�(�������̹���)
	Image pre_st1 = I_st1.getImage();
	Image pre_st2 = I_st2.getImage();
	Image pre_st3 = I_st3.getImage();
	Image pre_st4 = I_st4.getImage();
		
	//�̹��� ������ ��ư�� ���缭 �����ϱ�(������̹���)
	Image pos_st1 = pre_st1.getScaledInstance(150, 150, java.awt.Image.SCALE_SMOOTH);
	Image pos_st2 = pre_st2.getScaledInstance(150, 150, java.awt.Image.SCALE_SMOOTH);
	Image pos_st3 = pre_st3.getScaledInstance(150, 150, java.awt.Image.SCALE_SMOOTH);
	Image pos_st4 = pre_st4.getScaledInstance(150, 150, java.awt.Image.SCALE_SMOOTH);
		
	//������̹����� ������ �����ϱ�(Image�� ������ ����)
	ImageIcon st1 = new ImageIcon(pos_st1);
	ImageIcon st2 = new ImageIcon(pos_st2);
	ImageIcon st3 = new ImageIcon(pos_st3);
	ImageIcon st4 = new ImageIcon(pos_st4);

	
	JButton b_st1 = new JButton("<html>&emsp&emsp&emsp&emsp������ �� ������<br>&emsp&emsp&emsp&emsp���� : 3.32<br>&emsp&emsp&emsp&emsp�����ð� : 09:00 ~ 01:00</html>", st1);
	JButton b_st2 = new JButton("<html>&emsp&emsp&emsp&emsp�ټ� ������<br>&emsp&emsp&emsp&emsp���� : 3.89<br>&emsp&emsp&emsp&emsp�����ð� : 09:00 ~ 01:30</html>", st2);
	JButton b_st3 = new JButton("<html>&emsp&emsp&emsp&emsp���� 24 ���͵�ī��<br>&emsp&emsp&emsp&emsp������������<br>&emsp&emsp&emsp&emsp���� : 4.94<br>&emsp&emsp&emsp&emsp�����ð� : 00:00 ~ 24:00</html>", st3);
	JButton b_st4 = new JButton("<html>&emsp&emsp&emsp&emsp������ ���͵�ī��<br>&emsp&emsp&emsp&emsp������������<br>&emsp&emsp&emsp&emsp���� : 4.96<br>&emsp&emsp&emsp&emsp�����ð� : 00:00 ~ 24:00</html>", st4);
	
	
	
	
	
	public void setDisplay() {		
		
		setSize(1020,800);
		screen.setLayout(null);
		screen.setSize(1020, 800);
		
		b_st1.setFont(new Font("���", Font.BOLD, 25));
		b_st2.setFont(new Font("���", Font.BOLD, 25));
		b_st3.setFont(new Font("���", Font.BOLD, 25));
		b_st4.setFont(new Font("���", Font.BOLD, 25));

		
		b_st1.setBackground(Color.white);
		b_st2.setBackground(Color.white);
		b_st3.setBackground(Color.white);
		b_st4.setBackground(Color.white);
		
		b_st1.setHorizontalAlignment(SwingConstants.CENTER);
		b_st2.setHorizontalAlignment(SwingConstants.CENTER);
		b_st3.setHorizontalAlignment(SwingConstants.CENTER);
		b_st4.setHorizontalAlignment(SwingConstants.CENTER);
		
		// screen �гο� ��ư ���
		screen.add(b_st1);
		screen.add(b_st2);
		screen.add(b_st3);
		screen.add(b_st4);
	}
	
	public void studyButtonListener()
	{
		b_st1.addActionListener(new ActionListener() {
			//@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated
				win.panelChange("study1_Button");
			}
		});
		b_st2.addActionListener(new ActionListener() {
			//@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated
				win.panelChange("study2_Button");
			}
		});
		b_st3.addActionListener(new ActionListener() {
			//@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated
				win.panelChange("study3_Button");
			}
		});
		b_st4.addActionListener(new ActionListener() {
			//@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated
				win.panelChange("study4_Button");
			}
		});
	}
	
	public studyButtonList(MainPage win)
	{
		this.win = win;
		setLayout(new GridLayout(4,2));
		
		setDisplay();
		
		add(b_st1);
		add(b_st2);
		add(b_st3);
		add(b_st4);
		studyButtonListener();
		setVisible(true);
	}
}