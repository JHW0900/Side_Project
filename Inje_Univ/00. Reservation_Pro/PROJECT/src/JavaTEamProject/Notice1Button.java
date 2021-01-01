package JavaTEamProject;

import javax.swing.*;
import java.awt.*;
import javax.swing.border.*;
	 
public class Notice1Button extends JPanel {
	private MainPage win;
	
	JLabel label = new JLabel("���� ��������");
	
	JLabel l_n = new JLabel("�ۼ���");
	JLabel l_name = new JLabel("������");
	
	JLabel l_d = new JLabel("�Խ� ��¥");
	JLabel l_days = new JLabel("2020.10.27");
	
	JLabel l_t = new JLabel("����");
	JLabel l_title = new JLabel("[����] ������ �ý��� �������");
	
	JLabel l_c = new JLabel("����");
	JLabel l_contents = new JLabel("<html>�ȳ��ϼ���. ������ ���� ���α׷��Դϴ�."
									+ "<br>10�� 27��, ���� ������ �̿� ȯ���� �����ϱ� ����"
									+ "<br>�ý��� ������ ����Ǿ����ϴ�."
									+ "<br>����� ������ �ȳ��帮���� �̿뿡 ���� ��Ź�帳�ϴ�."
									+ "<br><br>�� � ������ ���� ���Ը� �����߽��ϴ�."
									+ "<br>&nbsp&nbsp&nbsp&nbsp&nbsp���, �޾� ������ ����� �ʴ� ���Դ� ����Ʈ�� "
									+ "<br>&nbsp&nbsp&nbsp&nbsp&nbsp������� �ʵ��� �����߽��ϴ�."
									+ "<br><br>�� ���� ������ ���� ���α׷��� "
									+ "<br>�� �� �ֵ��� �׻� ����ϰڽ��ϴ�.</html>");
	
	void setDisplay() {
		setBackground(Color.WHITE);
		setLayout(null);
		
		label.setFont(new Font("����", Font.BOLD, 25));
		l_n.setFont(new Font("����", Font.BOLD, 25));
		l_name.setFont(new Font("����", Font.PLAIN, 25));
		l_d.setFont(new Font("����", Font.BOLD, 25));
		l_days.setFont(new Font("����", Font.PLAIN, 25));
		l_t.setFont(new Font("����", Font.BOLD, 25));
		l_title.setFont(new Font("����", Font.PLAIN, 25));
		l_c.setFont(new Font("����", Font.BOLD, 25));
		l_contents.setFont(new Font("����", Font.PLAIN, 22));
		
		l_n.setBackground(Color.LIGHT_GRAY);
		l_d.setBackground(Color.LIGHT_GRAY);
		l_t.setBackground(Color.LIGHT_GRAY);
		l_c.setBackground(Color.LIGHT_GRAY);
		
		
		l_n.setOpaque(true);
		l_d.setOpaque(true);
		l_t.setOpaque(true);
		l_c.setOpaque(true);
		
		
		l_n.setHorizontalAlignment(JLabel.CENTER);
		l_d.setHorizontalAlignment(JLabel.CENTER);
		l_t.setHorizontalAlignment(JLabel.CENTER);
		l_c.setHorizontalAlignment(JLabel.CENTER);
		
		label.setBounds(50,50,200,40);
		
		
		l_n.setBounds(50,150,200,40);
		l_name.setBounds(310,150,200,40);
		l_d.setBounds(450,150,200,40);
		l_days.setBounds(700,150,200,40);
		
		l_t.setBounds(50,200,200,40);
		l_title.setBounds(310,200,400,40);
		
		l_c.setBounds(50,250,200,450);
		l_contents.setBounds(310,200,800,550);
	}
	
	public Notice1Button(MainPage win) 
	{
		this.win = win;
		setLayout(null);
		add(label);
		add(l_n);
		add(l_name);
		add(l_d);
		add(l_days);
		add(l_t);
		add(l_title);
		add(l_c);
		add(l_contents);
		
		setDisplay();
	}

}

