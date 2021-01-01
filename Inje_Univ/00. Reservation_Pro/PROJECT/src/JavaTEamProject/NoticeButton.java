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
	
	JLabel label = new JLabel("현재 공지사항");
	
	JButton notice1 = new JButton("[공지] 선결제 시스템 변경사항");
	JButton notice2 = new JButton("[공지] 선결제 시스템 업데이트 안내");
	JButton notice3 = new JButton("[공지] 선결제 시스템 서비스 정상화 안내");
	JButton notice4 = new JButton("[공지] 선결제 시스템 정기점검(11/05~11/06)");
	JButton notice5 = new JButton("[공지] 선결제 시스템 메인 개편 안내");
	JButton notice6 = new JButton("[공지] 회원가입 및 로그인 절차 변경 안내");
	
	String FontStyle = "고딕";

	public void setDisplay() {		/* 컨텐츠 배치 및 위치 설정 */

		screen.setLayout(null);
		screen.setSize(1020, 800);
		
		notice1.setBackground(Color.WHITE);
		notice2.setBackground(Color.WHITE);
		notice3.setBackground(Color.WHITE);
		notice4.setBackground(Color.WHITE);
		notice5.setBackground(Color.WHITE);
		notice6.setBackground(Color.WHITE);
		
		// 위치 지정
		screen.setBounds(0,0,1000,800);
		
		label.setBounds(50,50,200,40);
		notice1.setBounds(55,110,880,90);	
		notice2.setBounds(55,210,880,90);
		notice3.setBounds(55,310,880,90);
		notice4.setBounds(55,410,880,90);
		notice5.setBounds(55,510,880,90);
		notice6.setBounds(55,610,880,90);
		
		// screen 패널에 버튼 등록
		screen.add(label);
		screen.add(notice1);
		screen.add(notice2);
		screen.add(notice3);
		screen.add(notice4);
		screen.add(notice5);
		screen.add(notice6);
	}
	
	public void setDesign() { /* 해당 컨텐츠 디자인 */
		screen.setBackground(new Color(223, 249, 251));
		
		// 버튼 라벨,폰트 폰트
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
