package employee.management.system;

import javax.swing.*;
import java.awt.*;

public class Splash extends JFrame {
    Splash() {

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/front.gif"));
        Image i2 = i1.getImage().getScaledInstance(1100, 800, Image.SCALE_DEFAULT);  // updated size
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 1100, 800);  // updated size
        add(image);

        setSize(1100, 800);               // updated size
        setLocationRelativeTo(null);      // centers the window on screen
        setLayout(null);
        setVisible(true);

        try {
            Thread.sleep(5000);
            setVisible(false);
            new Login();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Splash();
    }
}
