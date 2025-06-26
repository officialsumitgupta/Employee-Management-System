package employee.management.system;

import javax.swing.*;
import java.awt.*;

public class AdminDashboard extends JFrame {

    AdminDashboard(String username) {
        setTitle("Admin Dashboard");
        setSize(1120, 630);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        // Set background image like Main_class
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/home.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1120, 630, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel background = new JLabel(i3);
        background.setBounds(0, 0, 1120, 630);
        add(background);

        JLabel heading = new JLabel("Welcome, Admin: " + username);
        heading.setBounds(80, 40, 500, 50);
        heading.setFont(new Font("Raleway", Font.BOLD, 30));
        heading.setForeground(Color.WHITE);  // Optional: make it pop on the image
        background.add(heading);

        JButton addEmp = new JButton("Add Employee");
        addEmp.setBounds(200, 150, 200, 50);
        styleButton(addEmp);
        addEmp.addActionListener(e -> {
            new AddEmployee();
            setVisible(false);
        });
        background.add(addEmp);

        JButton viewEmp = new JButton("View Employee");
        viewEmp.setBounds(500, 150, 200, 50);
        styleButton(viewEmp);
        viewEmp.addActionListener(e -> {
            new View_Employee();
            setVisible(false);
        });
        background.add(viewEmp);

        JButton removeEmp = new JButton("Remove Employee");
        removeEmp.setBounds(200, 250, 200, 50);
        styleButton(removeEmp);
        removeEmp.addActionListener(e -> {
            new RemoveEmployee();
            setVisible(false);
        });
        background.add(removeEmp);

        JButton logout = new JButton("Logout");
        logout.setBounds(500, 250, 200, 50);
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
        new AdminDashboard("admin");
    }
}
