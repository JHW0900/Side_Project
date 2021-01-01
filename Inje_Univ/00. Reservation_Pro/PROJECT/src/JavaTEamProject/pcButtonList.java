package JavaTEamProject;

import javax.swing.*;
import java.awt.*;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;
	 
public class pcButtonList extends JPanel {
	private MainPage win;

	JPanel screen = new JPanel();
	
	//������ ������ �̹��� ������
	ImageIcon I_pc1 = new ImageIcon("./store_logo/����Ŷ�ΰ�.jpg");
	ImageIcon I_pc2 = new ImageIcon("./store_logo/�ν�Ÿpc.jpg");
	ImageIcon I_pc3 = new ImageIcon("./store_logo/�ν��̴�.jpg");
	ImageIcon I_pc4 = new ImageIcon("./store_logo/�ν��̴�.jpg");
		
	//ImageIcon���� ���� �̹��� ��ȯ�ϱ�(�������̹���)
	Image pre_pc1 = I_pc1.getImage();
	Image pre_pc2 = I_pc2.getImage();
	Image pre_pc3 = I_pc3.getImage();
	Image pre_pc4 = I_pc4.getImage();
		
	//�̹��� ������ ��ư�� ���缭 �����ϱ�(������̹���)
	Image pos_pc1 = pre_pc1.getScaledInstance(150, 150, java.awt.Image.SCALE_SMOOTH);
	Image pos_pc2 = pre_pc2.getScaledInstance(150, 150, java.awt.Image.SCALE_SMOOTH);
	Image pos_pc3 = pre_pc3.getScaledInstance(150, 150, java.awt.Image.SCALE_SMOOTH);
	Image pos_pc4 = pre_pc4.getScaledInstance(150, 150, java.awt.Image.SCALE_SMOOTH);
		
	//������̹����� ������ �����ϱ�(Image�� ������ ����)
	ImageIcon pc1 = new ImageIcon(pos_pc1);
	ImageIcon pc2 = new ImageIcon(pos_pc2);
	ImageIcon pc3 = new ImageIcon(pos_pc3);
	ImageIcon pc4 = new ImageIcon(pos_pc4);
		
	
	JButton b_pc1 = new JButton("<html>&emsp&emsp&emsp&emsp����Ŷ PC ���� �����<br>&emsp&emsp&emsp&emsp���� : 4.35<br>&emsp&emsp&emsp&emsp�����ð� : 00:00 ~ 24:00</html>", pc1);
	JButton b_pc2 = new JButton("<html>&emsp&emsp&emsp&emsp�ν�Ÿ PCī�� ��������<br>&emsp&emsp&emsp&emsp���� : 4.28<br>&emsp&emsp&emsp&emsp�����ð� : 00:00 ~ 24:00</html>", pc2);
	JButton b_pc3 = new JButton("<html>&emsp&emsp&emsp&emsp�ν��̴� PCī�� 1ȣ��<br>&emsp&emsp&emsp&emsp���� : 4.58<br>&emsp&emsp&emsp&emsp�����ð� : 00:00 ~ 24:00</html>", pc3);
	JButton b_pc4 = new JButton("<html>&emsp&emsp&emsp&emsp�ν��̴� PCī�� 2ȣ��<br>&emsp&emsp&emsp&emsp���� : 4.55<br>&emsp&emsp&emsp&emsp�����ð� : 00:00 ~ 24:00</html>", pc4);
	
	
	
	
	public void setDisplay() {		
		
		setSize(1020,800);
		screen.setLayout(null);
		screen.setSize(1020, 800);
		
		b_pc1.setFont(new Font("���", Font.BOLD, 25));
		b_pc2.setFont(new Font("���", Font.BOLD, 25));
		b_pc3.setFont(new Font("���", Font.BOLD, 25));
		b_pc4.setFont(new Font("���", Font.BOLD, 25));
		
		
		b_pc1.setBackground(Color.white);
		b_pc2.setBackground(Color.white);
		b_pc3.setBackground(Color.white);
		b_pc4.setBackground(Color.white);
		
		// screen �гο� ��ư ���
		screen.add(b_pc1);
		screen.add(b_pc2);
		screen.add(b_pc3);
		screen.add(b_pc4);
	}
	
	public void pcButtonListener()
	{
		b_pc1.addActionListener(new ActionListener() {
			//@Override
			public void actionPerformed(ActionEvent e) {
				win.panelChange("pc1_Button");
			}
		});
		b_pc2.addActionListener(new ActionListener() {
			//@Override
			public void actionPerformed(ActionEvent e) {
				win.panelChange("pc2_Button");
			}
		});
		b_pc3.addActionListener(new ActionListener() {
			//@Override
			public void actionPerformed(ActionEvent e) {
				win.panelChange("pc3_Button");
			}
		});
		b_pc4.addActionListener(new ActionListener() {
			//@Override
			public void actionPerformed(ActionEvent e) {
				win.panelChange("pc4_Button");
			}
		});
	}
	
	
	public pcButtonList(MainPage win)
	{
		this.win = win;
		setLayout(new GridLayout(4,2));
		
		setDisplay();
		
		add(b_pc1);
		add(b_pc2);
		add(b_pc3);
		add(b_pc4);
		pcButtonListener();
		setVisible(true);
	}
}