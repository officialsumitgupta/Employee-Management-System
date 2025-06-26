package employee.management.system;

import javax.swing.*;
import java.awt.*;

public class HRDashboard extends JFrame {

    HRDashboard(String username) {
        setTitle("HR Dashboard");
        setSize(1120, 630);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        // Background image same as Main_class
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/home.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1120, 630, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel background = new JLabel(i3);
        background.setBounds(0, 0, 1120, 630);
        add(background);

        JLabel heading = new JLabel("Welcome, HR: " + username);
        heading.setBounds(370, 40, 500, 40);
        heading.setFont(new Font("Raleway", Font.BOLD, 28));
        heading.setForeground(Color.WHITE); // To contrast against background
        background.add(heading);

        JButton viewEmp = new JButton("View Employee");
        viewEmp.setBounds(350, 150, 200, 50);
        styleButton(viewEmp);
        viewEmp.addActionListener(e -> {
            new View_Employee();
            setVisible(false);
        });
        background.add(viewEmp);

        JButton logout = new JButton("Logout");
        logout.setBounds(350, 250, 200, 50);
        logout.setFont(new Font("Tahoma", Font.BOLD, 16));
        logout.setBackground(Color.RED);
        logout.setForeground(Color.WHITE);
        logout.addActionListener(e -> {
            new Login();
            setVisible(false);
        });
        background.add(logout);

        setVisible(true);
    }

    private void styleButton(JButton button) {
        button.setFont(new Font("Tahoma", Font.BOLD, 16));
        button.setBackground(Color.BLACK);
        button.setForeground(Color.WHITE);
    }

    public static void main(String[] args) {
        new HRDashboard("hr");
    }
}
