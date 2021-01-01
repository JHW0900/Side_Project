package JavaTEamProject;

import java.awt.*;
import java.net.*;
import javax.swing.*;

public class loadingPanel extends JPanel{
	
	public loadingPanel() {
		setBackground(Color.WHITE);
		JLabel pic = new JLabel("");
		ImageIcon icon = new ImageIcon(this.getClass().getResource("splash.gif"));
		pic.setIcon(icon);
		add(pic);
	}
}
