package JavaTEamProject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import DataBase.*;

class serviceType {
	int 		serviceNum;							// 매장 고유번호
	JButton[]   resvBtn = new JButton[25];			// 좌석 수
	boolean[]	isReservation = new boolean[25];	// 예약된 좌석 수
	
	int			selectedNum;			// 누른 버튼의 숫자를 저장
	int			tmpNum = -1;			// 누른 버튼을 일시적으로 저장
	
	public serviceType(int num, int dsable) {		// 매장 고유번호 및 좌석 수 설정
		for(int i=0;i<25;i++) {
			isReservation[i] = false;
			resvBtn[i] = new JButton(Integer.toString(i+1));
			resvBtn[i].addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					JButton btn = (JButton)e.getSource();
					
					if(tmpNum != -1)
						resvBtn[tmpNum - 1].setEnabled(true);
					selectedNum = Integer.parseInt(btn.getText());
					tmpNum = selectedNum;
					
					resvBtn[selectedNum - 1].setEnabled(false);
				}
			});
			resvBtn[i].setBorder(BorderFactory.createLineBorder(Color.GRAY,1));
			resvBtn[i].setBackground(Color.WHITE);
		}
		
		this.serviceNum = num;
		
		for(int i = 0 ; i< dsable ; i++) {
			resvBtn[24-i].setVisible(false);
			resvBtn[24-i].setEnabled(false);
			isReservation[24-i] = true;
		}
	}
	public boolean getIsReservation(int n) { return isReservation[n-1]; }
	public void setIsReservation(int n) { isReservation[n-1] = true; }
	public JButton getButton(int n) { return resvBtn[n]; }
	public int getSelectedNum() { return selectedNum; }
	public void confirmReservation() { tmpNum = -1; }
	
}

public class serviceReservation extends JPanel{
	MainPage win;
	dbReservation DBReservation = new dbReservation();
	dbLogin DBl = new dbLogin();
	
	boolean[] 			flag = new boolean[16];
	serviceType[]		service = new serviceType[16];
	
	JPanel 	southPanel = new JPanel();
	JPanel 	centerPanel = new JPanel();
	JPanel	reservationPanel;
	
	JPanel[]	saveReservationPanel = new JPanel[16];
	
	int 		serviceNum;
	ImageIcon 	icon; 
	Image 		img;
	JLabel 		pic;					// 해당 매장의 배치도
	
	JButton		confirmBtn = new JButton("예약하기");;
	
	
	/************************************************/
	/*	↓↓		해당 배치도 이미지 주소 넣을 것		↓↓	*/
	/************************************************/
	String[] sLayout = { 	"",
							"./StoreLayout_image/롯데리아 배치도.png",
							"./StoreLayout_image/유키돈까스 배치도.png",
							"./StoreLayout_image/청년다방 배치도.png",
							"./StoreLayout_image/코이코이 배치도.png",
							"./StoreLayout_image/공부의신 배치도.png",
							"./StoreLayout_image/다솔 배치도.png",
							"./StoreLayout_image/르하임 배치도.png",
							"./StoreLayout_image/지니24 배치도.png",
							"./StoreLayout_image/락휴 배치도.png",
							"./StoreLayout_image/준코 배치도.png",
							"./StoreLayout_image/텐텐 배치도.png",
							"./StoreLayout_image/힐튼 배치도.png",
							"./StoreLayout_image/라이킷 배치도.png",
							"./StoreLayout_image/인스타 배치도.png",
							"./StoreLayout_image/인싸이더 1호점 배치도.png",
							"./StoreLayout_image/인싸이더 2호점 배치도.png" };
	
	public serviceReservation(MainPage win) {
		this.win = win;
		
		confirmBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					if (DBl.getIsreservation(win.getUserId()) == 0) {
						String space = "                 ";
						String messageOption = space + service[serviceNum - 1].getSelectedNum()
								+ "번 좌석 예약되었습니다!\n등록하신 계좌로 5,000원이 자동결제 되었습니다";
						service[serviceNum - 1].confirmReservation();

						if (!service[serviceNum - 1].getIsReservation(service[serviceNum - 1].getSelectedNum() - 1)) {
							service[serviceNum - 1].setIsReservation(service[serviceNum - 1].getSelectedNum() - 1);
							JOptionPane.showMessageDialog(null, messageOption);

							// serviceNum + 100 // primary_id
							// service[serviceNum - 1].getSlectedNum() // seat
							// win.getUserId() // user_id
							DBReservation.insertData(serviceNum + 1000, service[serviceNum - 1].getSelectedNum(),
									win.getUserId());
							System.out.println(DBReservation.getService(win.getUserId())
									+ DBReservation.getSeatNum(win.getUserId())
									+ DBReservation.getUserId(win.getUserId()) + "");

							DBl.editReservationOn(win.getUserId());
							
							setFocusable(true);
							requestFocus();
							win.panelChange("Home_Panel");
						} else {
							messageOption = service[serviceNum - 1].getSelectedNum() + "번 좌석은 이미 예약되었습니다!";
							JOptionPane.showMessageDialog(null, messageOption);
							}
						} else {
							if(win.login_flag == false) {
								String messageOption = "로그인 후 이용해주세요!";
								JOptionPane.showMessageDialog(null, messageOption);
							} else {
								String messageOption = "이미 예약내역이 있습니다!\n중복 예약은 불가능 합니다!";
								JOptionPane.showMessageDialog(null, messageOption);
							}
						}
					} catch(ArrayIndexOutOfBoundsException a) {}
			}
		});	
		
		for(int i=0;i<16;i++)
			flag[i] = false;
		
		setDisplay();
	}
	
	public void setDisplay() {
		setLayout(new BorderLayout());
		
		centerPanel.setBackground(Color.WHITE);
		confirmBtn.setBackground(new Color(34, 166, 179));
		confirmBtn.setForeground(Color.WHITE);
		confirmBtn.setFont(new Font("고딕", Font.PLAIN, 26));
		
		centerPanel.setLayout(null);
		southPanel.setLayout(new GridLayout(1,2));
		
		add(centerPanel,BorderLayout.CENTER);
		add(southPanel,BorderLayout.SOUTH);
		
		pic = new JLabel();
		
		/*		centerPanel 설정		*/
		centerPanel.add(pic);
		
		/*		southPanel 설정		*/
//		southPanel.add(saveReservationPanel[serviceNum - 1]);
//		southPanel.add(confirmBtn);
		
	}
	
	public void setService(int key, int res) {			// 매장 등록
		if(!flag[key - 1001]) {
			reservationPanel = new JPanel();
			reservationPanel.setLayout(new GridLayout(5,5));	// nxn으로 만들 것
		
			serviceNum = key - 1000;
			service[serviceNum - 1] = new serviceType(serviceNum, 25 - res);
			for(int i=0;i<res;i++)
				reservationPanel.add(service[serviceNum -1].getButton(i));
		
			saveReservationPanel[serviceNum - 1] = reservationPanel;
			flag[key - 1001] = true;
		}
	}
	
	public void setReservationPanel(int key) {
		southPanel.removeAll();
		southPanel.add(saveReservationPanel[key - 1001]);
		southPanel.add(confirmBtn);
		pic.setBounds(0, 15, 1000, 600);				// 배치도 사이즈
		
		serviceNum = key - 1000;
		SetImageSize();
		
		centerPanel.removeAll();
		centerPanel.add(pic);
		
		revalidate();
		repaint();
	}
	
	public void SetImageSize(){
        icon = new ImageIcon(sLayout[serviceNum]);
        img = icon.getImage();
        Image newImg = img.getScaledInstance(pic.getWidth(), 
        		pic.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon newImc = new ImageIcon(newImg);
        pic.setIcon(newImc);
    }
}
