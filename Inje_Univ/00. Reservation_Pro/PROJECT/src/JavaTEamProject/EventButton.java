package JavaTEamProject;

import java.awt.*;
import javax.swing.*;
import javax.swing.table.*;
import java.awt.event.*;

public class EventButton extends JPanel{
	private MainPage win;

	JPanel screen = new JPanel();
	
	JLabel label = new JLabel("�̺�Ʈ ������");
	
	//�̺�Ʈ��ư �̹��� ������ �̹��� �޾ƿ���

	ImageIcon image1 = new ImageIcon("./image/event1.png"); /// ���� ���̸� �ˤ���!!!
	ImageIcon image2 = new ImageIcon("./image/f1.png");
	ImageIcon image3 = new ImageIcon("./image/Sale_Event.png");
	
	//��ư�� ���� �̹��� �ޱ�
	Image pre_image1=image1.getImage();
	Image pre_image2=image2.getImage();
	Image pre_image3=image3.getImage();
	
	//�̹��� ������ ��ư������� ���߱�
	Image pos_image1=pre_image1.getScaledInstance(600,200,java.awt.Image.SCALE_SMOOTH);
	Image pos_image2=pre_image2.getScaledInstance(600,200,java.awt.Image.SCALE_SMOOTH);
	Image pos_image3=pre_image3.getScaledInstance(600,200,java.awt.Image.SCALE_SMOOTH);
	
	//������ ���� �̹��� �̹��� �����ܿ� �ֱ�
	ImageIcon event1 = new ImageIcon(pos_image1);
	ImageIcon event2 = new ImageIcon(pos_image2);
	ImageIcon event3 = new ImageIcon(pos_image3);
	
	//��ư�� �̹��� �ֱ�
	JButton button1 = new JButton(event1);
	JButton button2 = new JButton(event2);
	JButton button3 = new JButton(event3);
	
	public void setDisplay() 
	{
		String FontStyle = "���";
		int FontSize = 20;
		
		screen.setLayout(null);
		screen.setSize(1020, 800);
		
		// screen ��,��ư ��Ʈ
		label.setFont(new Font(FontStyle, Font.BOLD, 25));
		button1.setFont(new Font(FontStyle, Font.BOLD, FontSize));
		button2.setFont(new Font(FontStyle, Font.BOLD, FontSize));
		button3.setFont(new Font(FontStyle, Font.BOLD, FontSize));
		
		screen.add(button1);
		screen.add(button2);
		screen.add(button3);
		
		//��ư �׵θ� ���ֱ�
		button1.setBorder(null);
		button2.setBorder(null);
		button3.setBorder(null);
		
		// screen ��,��ư ��ġ ����
		label.setBounds(425,10,600,100);
		button1.setBounds(180,100,610,200);
		button2.setBounds(190,310,600,200);
		button3.setBounds(190,520,600,200);
		
		// ��ư ä��� ����
		button1.setContentAreaFilled(false);
		button2.setContentAreaFilled(false); 
		button3.setContentAreaFilled(false); 
		//button4.setContentAreaFilled(false); 
		
		// screen �гο� ��ư ���
		screen.add(label);
		screen.add(button1);
		screen.add(button2);
		screen.add(button3);
	}
	
	public EventButton(MainPage win)
	{
		this.win = win;
		setLayout(null);
		setBackground(new Color(223, 249, 251));
		setDisplay();
		add(label);
		add(button1);
		add(button2);
		add(button3);
		setVisible(true);
	}
}

