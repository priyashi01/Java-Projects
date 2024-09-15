package EMS;

import javax.swing.*;
import java.awt.*;

public class Splash extends JFrame {

    Splash(){

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("ICON/front.gif"));
        Image i2 = i1.getImage().getScaledInstance(1100,650,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,1100,650);
        add(image);

        setSize(1100,650);
        setLayout(null);
        setVisible(true);
        setLocation(80,20);


        try{
            Thread.sleep(5000);
            setVisible(false);
            new Login();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public static void main(String[] args){
        new Splash();
    }
}

