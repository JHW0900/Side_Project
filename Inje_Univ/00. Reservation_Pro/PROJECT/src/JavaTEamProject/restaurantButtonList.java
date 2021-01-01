package JavaTEamProject;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Image;
import java.util.Vector;
	 
public class restaurantButtonList extends JPanel {
	private MainPage win;

	JPanel screen = new JPanel();
	
	//������ ������ �̹��� ������
	ImageIcon I_re1 = new ImageIcon("./store_logo/��������.jpg");
	ImageIcon I_re2 = new ImageIcon("./store_logo/��Ű.jpg");
	ImageIcon I_re3 = new ImageIcon("./store_logo/û��ٹ�.jpg");
	ImageIcon I_re4 = new ImageIcon("./store_logo/�Ե�����.png");
		
	//ImageIcon���� ���� �̹��� ��ȯ�ϱ�(�������̹���)
	Image pre_re1 = I_re1.getImage();
	Image pre_re2 = I_re2.getImage();
	Image pre_re3 = I_re3.getImage();
	Image pre_re4 = I_re4.getImage();
		
	//�̹��� ������ ��ư�� ���缭 �����ϱ�(������̹���)
	Image pos_re1 = pre_re1.getScaledInstance(150, 150, java.awt.Image.SCALE_SMOOTH);
	Image pos_re2 = pre_re2.getScaledInstance(150, 150, java.awt.Image.SCALE_SMOOTH);
	Image pos_re3 = pre_re3.getScaledInstance(150, 150, java.awt.Image.SCALE_SMOOTH);
	Image pos_re4 = pre_re4.getScaledInstance(150, 150, java.awt.Image.SCALE_SMOOTH);
		
	//������̹����� ������ �����ϱ�(Image�� ������ ����)
	ImageIcon re1 = new ImageIcon(pos_re1);
	ImageIcon re2 = new ImageIcon(pos_re2);
	ImageIcon re3 = new ImageIcon(pos_re3);
	ImageIcon re4 = new ImageIcon(pos_re4);
		
	//JLabel l_pc = new JLabel(pc);
	//JLabel l_sing = new JLabel(sing);
	//JLabel l_study = new JLabel(study);
	//JLabel l_restaurant = new JLabel(restaurant);
	
	JButton b_re1 = new JButton("<html>&emsp&emsp&emsp&emsp�������� ��������<br>&emsp&emsp&emsp&emsp���� : 4.6<br>&emsp&emsp&emsp&emsp�����ð� : 11:30 ~ 21:00</html>", re1);
	JButton b_re2 = new JButton("<html>&emsp&emsp&emsp&emsp��Ű ��� ��������<br>&emsp&emsp&emsp&emsp���� : 4.53<br>&emsp&emsp&emsp&emsp�����ð� : 11:00 ~ 21:00</html>", re2);
	JButton b_re3 = new JButton("<html>&emsp&emsp&emsp&emspû��ٹ� ��������<br>&emsp&emsp&emsp&emsp���� : 4.44<br>&emsp&emsp&emsp&emsp�����ð� : 11:00 ~ 24:00</html>", re3);
	JButton b_re4 = new JButton("<html>&emsp&emsp&emsp&emsp�Ե����� ���ؾ����<br>&emsp&emsp&emsp&emsp���� : 4.35<br>&emsp&emsp&emsp&emsp�����ð� : 10:00 ~ 22:00</html>", re4);
	
	
	
	
	public void setDisplay() {		
		
		setSize(1020,800);
		screen.setLayout(null);
		screen.setSize(1020, 800);
		
		b_re1.setFont(new Font("���", Font.BOLD, 25));
		b_re2.setFont(new Font("���", Font.BOLD, 25));
		b_re3.setFont(new Font("���", Font.BOLD, 25));
		b_re4.setFont(new Font("���", Font.BOLD, 25));
		
		//l_pc.setBackground(Color.white);
		//l_sing.setBackground(Color.white);
		//l_study.setBackground(Color.white);
		//l_restaurant.setBackground(Color.white);
		
		//l_pc.setOpaque(true);
		//l_sing.setOpaque(true);
		//l_study.setOpaque(true);
		//l_restaurant.setOpaque(true);
		
		b_re1.setBackground(Color.white);
		b_re2.setBackground(Color.white);
		b_re3.setBackground(Color.white);
		b_re4.setBackground(Color.white);
		
		// screen �гο� ��ư ���
		screen.add(b_re1);
		screen.add(b_re2);
		screen.add(b_re3);
		screen.add(b_re4);
	}
	
	public void restaurantButtonListener()
	{
		b_re1.addActionListener(new ActionListener() {
			//@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated
				win.panelChange("restaurant1_Button");
			}
		});
		b_re2.addActionListener(new ActionListener() {
			//@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated
				win.panelChange("restaurant2_Button");
			}
		});
		b_re3.addActionListener(new ActionListener() {
			//@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated
				win.panelChange("restaurant3_Button");
			}
		});
		b_re4.addActionListener(new ActionListener() {
			//@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated
				win.panelChange("restaurant4_Button");
			}
		});
	}
	
	public restaurantButtonList(MainPage win)
	{
		this.win = win;
		setLayout(new GridLayout(4,2));
		
		setDisplay();

		add(b_re1);
		add(b_re2);
		add(b_re3);
		add(b_re4);
		
		restaurantButtonListener();
		
		setVisible(true);
	}
}