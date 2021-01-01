package JavaTEamProject;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;

import java.awt.*;
import java.awt.event.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.border.*;

import DataBase.*;
public class OrderListButton extends JPanel{
	private MainPage win;
	dbReservation DBReservation = new dbReservation();
	dbService DBService = new dbService();
	
	SimpleDateFormat format = new SimpleDateFormat(" yyyy-MM-dd");
	Date time = new Date();
	
	String time0 = format.format(time);
	
	JPanel screen = new JPanel();
	
	JLabel label = new JLabel("현재 예약 내역");
	
	JLabel line1 = new JLabel("-----------------------------------------------------------------------------------------------------------");
	JLabel rv_day = new JLabel(time0);  // DB에서 날짜 받아오기
	JLabel line2 = new JLabel("----------------------------------------------------------------------------------------------------------------");
	
	ImageIcon image = new ImageIcon("./image/reserved.png");
	Image pre_image=image.getImage();
	Image pos_image=pre_image.getScaledInstance(200,200,java.awt.Image.SCALE_SMOOTH);
	ImageIcon I_image = new ImageIcon(pos_image);
	JLabel rv_image = new JLabel(I_image);
	
	JLabel rv_p = new JLabel("예약 장소     :");
	JLabel rv_place = new JLabel("코이코이 인제대점"); // DB에서 장소 받아오기
	JLabel rv_s = new JLabel("좌석 번호     :");
	JLabel rv_seat = new JLabel("6"); // DB에서 좌석 번호 받아오기
	
	JLabel rv_m = new JLabel("총 금액        :");
	JLabel rv_money = new JLabel("5000원");
	
	JLabel rv_notice = new JLabel("<html>예약이 완료되었습니다. 이용해주셔서 감사합니다."
								+ "<br>더 노력하는 선결제 예약 프로그램이 되겠습니다.</html>");
	
	public void setDisplay() {	
		
		setSize(1020,800);
		screen.setLayout(null);
		screen.setSize(1020, 800);
		
		line1.setForeground(new Color(126,214,223));
		line2.setForeground(new Color(126,214,223));
		
		// screen 라벨 위치 지정
		label.setBounds(50,50,200,40);	

		line1.setBounds(0,150,480,20);
		rv_day.setBorder(BorderFactory.createLineBorder(new Color(126,214,223), 1, true));
		rv_day.setBounds(430,140,140,40);
		line2.setBounds(568,150,500,20);
		
		rv_image.setBounds(100,270,200,200);
		
		rv_p.setBounds(400,280,200,20);
		rv_place.setBounds(550,280,300,20);
		rv_s.setBounds(400,360,200,20);
		rv_seat.setBounds(550,360,300,20);
		rv_m.setBounds(400,440,200,20);
		rv_money.setBounds(550,440,300,20);
		
		rv_notice.setBounds(250,530,800,60);
		
		// screen 패널에 버튼 등록
		screen.add(label);

		screen.add(rv_seat);
		screen.add(line1);
		screen.add(rv_day);
		screen.add(line2);
		screen.add(rv_image);
		
		screen.add(rv_p);
		screen.add(rv_place);
		screen.add(rv_s);
		screen.add(rv_seat);
		screen.add(rv_m);
		screen.add(rv_money);
		
		screen.add(rv_notice);
		
	}
	
	public void setDesign() { /* 해당 컨텐츠 디자인 */
		screen.setBackground(new Color(223, 249, 251));
		
		// screen 라벨,폰트 폰트
		label.setFont(new Font("고딕", Font.BOLD, 25));
		
		rv_day.setFont(new Font("고딕", Font.BOLD, 23));
		rv_seat.setFont(new Font("고딕", Font.BOLD, 20));
		rv_place.setFont(new Font("고딕", Font.BOLD, 20));
		rv_money.setFont(new Font("고딕", Font.BOLD, 20));
		rv_s.setFont(new Font("고딕", Font.BOLD, 20));
		rv_p.setFont(new Font("고딕", Font.BOLD, 20));
		rv_m.setFont(new Font("고딕", Font.BOLD, 20));
		rv_notice.setFont(new Font("고딕", Font.BOLD, 20));
		
		screen.setBackground(new Color(223, 249, 251));
	}

	public OrderListButton(MainPage win)
	{
		this.win = win;
		setLayout(null);
		
		setDisplay();
		setDesign();
		validate();

		add(screen);
	}
	
	public void setLabel() {
		String name = DBService.getServiceName(DBReservation.getService(win.getUserId()));
		String seat = Integer.toString(DBReservation.getSeatNum(win.getUserId()));
		
		rv_place.setText(name);
		rv_seat.setText(seat);
	}
}