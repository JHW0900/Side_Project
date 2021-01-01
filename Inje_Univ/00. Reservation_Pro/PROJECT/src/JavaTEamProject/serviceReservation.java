package JavaTEamProject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import DataBase.*;

class serviceType {
	int 		serviceNum;							// ���� ������ȣ
	JButton[]   resvBtn = new JButton[25];			// �¼� ��
	boolean[]	isReservation = new boolean[25];	// ����� �¼� ��
	
	int			selectedNum;			// ���� ��ư�� ���ڸ� ����
	int			tmpNum = -1;			// ���� ��ư�� �Ͻ������� ����
	
	public serviceType(int num, int dsable) {		// ���� ������ȣ �� �¼� �� ����
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
	JLabel 		pic;					// �ش� ������ ��ġ��
	
	JButton		confirmBtn = new JButton("�����ϱ�");;
	
	
	/************************************************/
	/*	���		�ش� ��ġ�� �̹��� �ּ� ���� ��		���	*/
	/************************************************/
	String[] sLayout = { 	"",
							"./StoreLayout_image/�Ե����� ��ġ��.png",
							"./StoreLayout_image/��Ű��� ��ġ��.png",
							"./StoreLayout_image/û��ٹ� ��ġ��.png",
							"./StoreLayout_image/�������� ��ġ��.png",
							"./StoreLayout_image/�����ǽ� ��ġ��.png",
							"./StoreLayout_image/�ټ� ��ġ��.png",
							"./StoreLayout_image/������ ��ġ��.png",
							"./StoreLayout_image/����24 ��ġ��.png",
							"./StoreLayout_image/���� ��ġ��.png",
							"./StoreLayout_image/���� ��ġ��.png",
							"./StoreLayout_image/���� ��ġ��.png",
							"./StoreLayout_image/��ư ��ġ��.png",
							"./StoreLayout_image/����Ŷ ��ġ��.png",
							"./StoreLayout_image/�ν�Ÿ ��ġ��.png",
							"./StoreLayout_image/�ν��̴� 1ȣ�� ��ġ��.png",
							"./StoreLayout_image/�ν��̴� 2ȣ�� ��ġ��.png" };
	
	public serviceReservation(MainPage win) {
		this.win = win;
		
		confirmBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					if (DBl.getIsreservation(win.getUserId()) == 0) {
						String space = "                 ";
						String messageOption = space + service[serviceNum - 1].getSelectedNum()
								+ "�� �¼� ����Ǿ����ϴ�!\n����Ͻ� ���·� 5,000���� �ڵ����� �Ǿ����ϴ�";
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
							messageOption = service[serviceNum - 1].getSelectedNum() + "�� �¼��� �̹� ����Ǿ����ϴ�!";
							JOptionPane.showMessageDialog(null, messageOption);
							}
						} else {
							if(win.login_flag == false) {
								String messageOption = "�α��� �� �̿����ּ���!";
								JOptionPane.showMessageDialog(null, messageOption);
							} else {
								String messageOption = "�̹� ���೻���� �ֽ��ϴ�!\n�ߺ� ������ �Ұ��� �մϴ�!";
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
		confirmBtn.setFont(new Font("���", Font.PLAIN, 26));
		
		centerPanel.setLayout(null);
		southPanel.setLayout(new GridLayout(1,2));
		
		add(centerPanel,BorderLayout.CENTER);
		add(southPanel,BorderLayout.SOUTH);
		
		pic = new JLabel();
		
		/*		centerPanel ����		*/
		centerPanel.add(pic);
		
		/*		southPanel ����		*/
//		southPanel.add(saveReservationPanel[serviceNum - 1]);
//		southPanel.add(confirmBtn);
		
	}
	
	public void setService(int key, int res) {			// ���� ���
		if(!flag[key - 1001]) {
			reservationPanel = new JPanel();
			reservationPanel.setLayout(new GridLayout(5,5));	// nxn���� ���� ��
		
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
		pic.setBounds(0, 15, 1000, 600);				// ��ġ�� ������
		
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
