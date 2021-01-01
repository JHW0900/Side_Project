package JavaTEamProject;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class Project extends JPanel{
	MainPage win;
    JLabel pic;
    Timer tm;
    int x = 0;
    //Images Path In Array
    String[] list = {
    		"./event_image/e2.png",
    		"./event_image/e3.jpg",
    		"./event_image/e5.png",
    		"./event_image/e7.png",
    		"./event_image/e11.png",
    		"./event_image/e12.jpg",
    		"./event_image/e13.jpg",
    		"./event_image/e14.png",
    		"./event_image/e15.png",
    		"./event_image/e20.jpg"
                    };
    
    public Project(MainPage win){
    	this.win = win;
        pic = new JLabel();
//        pic.setBounds(40, 30, 700, 300); //default
        pic.setBounds(0, 15, 980, 370); //replace
        //setPreferredSize(new Dimension(800, 400));
        
        //Call The Function SetImageSize
        SetImageSize(9);
               //set a timer
        tm = new Timer(2000,new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                SetImageSize(x);
                x += 1;
                if(x >= list.length )
                    x = 0; 
            }
        });
        add(pic);
        tm.start();
        setLayout(null);
        //setBackground(Color.decode("#bdb67b"));
        setBackground(Color.WHITE);
        setPreferredSize(new Dimension(800, 400));
    }
    //create a function to resize the image 
    public void SetImageSize(int i){
        ImageIcon icon = new ImageIcon(list[i]);
        Image img = icon.getImage();
        Image newImg = img.getScaledInstance(pic.getWidth(), pic.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon newImc = new ImageIcon(newImg);
        pic.setIcon(newImc);
    }
}
