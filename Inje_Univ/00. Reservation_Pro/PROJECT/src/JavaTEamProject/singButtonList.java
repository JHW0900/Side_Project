package JavaTEamProject;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Image;
import java.util.Vector;
	 
public class singButtonList extends JPanel {
	private MainPage win;

	JPanel screen = new JPanel();
	
	//������ ������ �̹��� ������
	ImageIcon I_si1 = new ImageIcon("./store_logo/����.PNG");
	ImageIcon I_si2 = new ImageIcon("./store_logo/����.PNG");
	ImageIcon I_si3 = new ImageIcon("./store_logo/��ư�뷡��.jpg");
	ImageIcon I_si4 = new ImageIcon("./store_logo/���ڷΰ�.jpg");
		
	//ImageIcon���� ���� �̹��� ��ȯ�ϱ�(�������̹���)
	Image pre_si1 = I_si1.getImage();
	Image pre_si2 = I_si2.getImage();
	Image pre_si3 = I_si3.getImage();
	Image pre_si4 = I_si4.getImage();
		
	//�̹��� ������ ��ư�� ���缭 �����ϱ�(������̹���)
	Image pos_si1 = pre_si1.getScaledInstance(150, 150, java.awt.Image.SCALE_SMOOTH);
	Image pos_si2 = pre_si2.getScaledInstance(150, 150, java.awt.Image.SCALE_SMOOTH);
	Image pos_si3 = pre_si3.getScaledInstance(150, 150, java.awt.Image.SCALE_SMOOTH);
	Image pos_si4 = pre_si4.getScaledInstance(150, 150, java.awt.Image.SCALE_SMOOTH);
		
	//������̹����� ������ �����ϱ�(Image�� ������ ����)
	ImageIcon si1 = new ImageIcon(pos_si1);
	ImageIcon si2 = new ImageIcon(pos_si2);
	ImageIcon si3 = new ImageIcon(pos_si3);
	ImageIcon si4 = new ImageIcon(pos_si4);

	
	JButton b_si1 = new JButton("<html>&emsp&emsp&emsp&emsp���� ���γ뷡������<br>&emsp&emsp&emsp&emsp���� ��������<br>&emsp&emsp&emsp&emsp���� : 3.99<br>&emsp&emsp&emsp&emsp�����ð� : 10:00 ~ 03:00</html>", si1);
	JButton b_si2 = new JButton("<html>&emsp&emsp&emsp&emsp���� ���� �뷡��<br>&emsp&emsp&emsp&emsp���� : 4.25<br>&emsp&emsp&emsp&emsp�����ð� : 11:00 ~ 01:00</html>", si2);
	JButton b_si3 = new JButton("<html>&emsp&emsp&emsp&emsp��ư ���γ뷡������<br>&emsp&emsp&emsp&emsp���� : 4.13<br>&emsp&emsp&emsp&emsp�����ð� : 11:00 ~ 02:00</html>", si3);
	JButton b_si4 = new JButton("<html>&emsp&emsp&emsp&emsp���� �뷡Ÿ��<br>&emsp&emsp&emsp&emsp������������<br>&emsp&emsp&emsp&emsp���� : 4.19<br>&emsp&emsp&emsp&emsp�����ð� : 18:00 ~ 07:00</html>", si4);
	
	
	
	
	public void setDisplay() {		
		
		setSize(1020,800);
		screen.setLayout(null);
		screen.setSize(1020, 800);
		
		b_si1.setFont(new Font("���", Font.BOLD, 25));
		b_si2.setFont(new Font("���", Font.BOLD, 25));
		b_si3.setFont(new Font("���", Font.BOLD, 25));
		b_si4.setFont(new Font("���", Font.BOLD, 25));

		
		b_si1.setBackground(Color.white);
		b_si2.setBackground(Color.white);
		b_si3.setBackground(Color.white);
		b_si4.setBackground(Color.white);
		
		// screen �гο� ��ư ���
		screen.add(b_si1);
		screen.add(b_si2);
		screen.add(b_si3);
		screen.add(b_si4);
	}
	
	public void singButtonListener()
	{
		b_si1.addActionListener(new ActionListener() {
			//@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated
				win.panelChange("sing1_Button");
			}
		});
		b_si2.addActionListener(new ActionListener() {
			//@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated
				win.panelChange("sing2_Button");
			}
		});
		b_si3.addActionListener(new ActionListener() {
			//@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated
				win.panelChange("sing3_Button");
			}
		});
		b_si4.addActionListener(new ActionListener() {
			//@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated
				win.panelChange("sing4_Button");
			}
		});
	}
	
	public singButtonList(MainPage win)
	{
		this.win = win;
		setLayout(new GridLayout(4,2));
		
		setDisplay();
		
		add(b_si1);
		add(b_si2);
		add(b_si3);
		add(b_si4);
		singButtonListener();
		setVisible(true);
	}
}