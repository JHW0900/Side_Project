package JavaTEamProject;

import javax.swing.*;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableCellRenderer;

import java.awt.*;
import java.awt.event.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NoticeButton extends JPanel{
	private MainPage win;
	JPanel screen = new JPanel();
	
	JLabel label = new JLabel("���� ��������");
	
	JButton notice1 = new JButton("[����] ������ �ý��� �������");
	JButton notice2 = new JButton("[����] ������ �ý��� ������Ʈ �ȳ�");
	JButton notice3 = new JButton("[����] ������ �ý��� ���� ����ȭ �ȳ�");
	JButton notice4 = new JButton("[����] ������ �ý��� ��������(11/05~11/06)");
	JButton notice5 = new JButton("[����] ������ �ý��� ���� ���� �ȳ�");
	JButton notice6 = new JButton("[����] ȸ������ �� �α��� ���� ���� �ȳ�");
	
	String FontStyle = "���";

	public void setDisplay() {		/* ������ ��ġ �� ��ġ ���� */

		screen.setLayout(null);
		screen.setSize(1020, 800);
		
		notice1.setBackground(Color.WHITE);
		notice2.setBackground(Color.WHITE);
		notice3.setBackground(Color.WHITE);
		notice4.setBackground(Color.WHITE);
		notice5.setBackground(Color.WHITE);
		notice6.setBackground(Color.WHITE);
		
		// ��ġ ����
		screen.setBounds(0,0,1000,800);
		
		label.setBounds(50,50,200,40);
		notice1.setBounds(55,110,880,90);	
		notice2.setBounds(55,210,880,90);
		notice3.setBounds(55,310,880,90);
		notice4.setBounds(55,410,880,90);
		notice5.setBounds(55,510,880,90);
		notice6.setBounds(55,610,880,90);
		
		// screen �гο� ��ư ���
		screen.add(label);
		screen.add(notice1);
		screen.add(notice2);
		screen.add(notice3);
		screen.add(notice4);
		screen.add(notice5);
		screen.add(notice6);
	}
	
	public void setDesign() { /* �ش� ������ ������ */
		screen.setBackground(new Color(223, 249, 251));
		
		// ��ư ��,��Ʈ ��Ʈ
		label.setFont(new Font(FontStyle, Font.BOLD, 25));
		notice1.setFont(new Font(FontStyle, Font.BOLD, 25));
		notice2.setFont(new Font(FontStyle, Font.BOLD, 25));
		notice3.setFont(new Font(FontStyle, Font.BOLD, 25));
		notice4.setFont(new Font(FontStyle, Font.BOLD, 25));
		notice5.setFont(new Font(FontStyle, Font.BOLD, 25));
		notice6.setFont(new Font(FontStyle, Font.BOLD, 25));
	}

	public void NoticeButtonListener() {
		notice1.addActionListener(new ActionListener() {
			//@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated
				win.panelChange("notice1Button");
			}
		});
		notice2.addActionListener(new ActionListener() {
			//@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated
				win.panelChange("notice2Button");
			}
		});
		notice3.addActionListener(new ActionListener() {
			//@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated
				win.panelChange("notice3Button");
			}
		});
		notice4.addActionListener(new ActionListener() {
			//@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated
				win.panelChange("notice4Button");
			}
		});
		notice5.addActionListener(new ActionListener() {
			//@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated
				win.panelChange("notice5Button");
			}
		});
		notice6.addActionListener(new ActionListener() {
			//@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated
				win.panelChange("notice6Button");
			}
		});
	}
	
	public NoticeButton(MainPage win)
	{
		this.win = win;
		setLayout(null);
		
		setDisplay();
		setDesign();

		validate();
		add(screen);
		NoticeButtonListener();
	}
}
