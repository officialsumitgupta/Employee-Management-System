package employee.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;

public class Login extends JFrame implements ActionListener {

    JTextField tusername, trole;
    JPasswordField tpassword;
    JButton login, back;

    Login() {
        setTitle("Login - Employee Management System");

        JLabel username = new JLabel("Username");
        username.setBounds(40, 30, 100, 30);
        add(username);

        tusername = new JTextField();
        tusername.setBounds(150, 30, 150, 30);
        add(tusername);

        JLabel password = new JLabel("Password");
        password.setBounds(40, 80, 100, 30);
        add(password);

        tpassword = new JPasswordField();
        tpassword.setBounds(150, 80, 150, 30);
        add(tpassword);

        JLabel role = new JLabel("Role");
        role.setBounds(40, 130, 100, 30);
        add(role);

        trole = new JTextField();
        trole.setBounds(150, 130, 150, 30);
        add(trole);

        login = new JButton("LOGIN");
        login.setBounds(150, 180, 150, 30);
        login.setBackground(Color.black);
        login.setForeground(Color.white);
        login.addActionListener(this);
        add(login);

        back = new JButton("BACK");
        back.setBounds(150, 220, 150, 30);
        back.setBackground(Color.black);
        back.setForeground(Color.white);
        back.addActionListener(this);
        add(back);

        // Optional image on right side
        ImageIcon i11 = new ImageIcon(ClassLoader.getSystemResource("icons/second.jpg"));
        Image i22 = i11.getImage().getScaledInstance(600, 400, Image.SCALE_DEFAULT);
        ImageIcon i33 = new ImageIcon(i22);
        JLabel imgg = new JLabel(i33);
        imgg.setBounds(350, 10, 600, 400);
        add(imgg);

        // Background image
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/LoginB.jpg"));
        Image i2 = i1.getImage().getScaledInstance(600, 350, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel img = new JLabel(i3);
        img.setBounds(0, 0, 600, 350);
        add(img);

        setSize(600, 350);
        setLocationRelativeTo(null);
        setLayout(null);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == login) {
            try {
                String username = tusername.getText().trim();
                String password = new String(tpassword.getPassword()).trim();
                String role = trole.getText().trim();

                if (username.isEmpty() || password.isEmpty() || role.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "All fields are required.");
                    return;
                }

                conn c = new conn();
                String query = "SELECT * FROM login WHERE username = '" + username + "' AND password = '" + password + "' AND role = '" + role + "'";
                ResultSet resultSet = c.statement.executeQuery(query);

                if (resultSet.next()) {
                    setVisible(false);
                    if (role.equalsIgnoreCase("admin")) {
                        new AdminDashboard(username);
                    } else if (role.equalsIgnoreCase("hr")) {
                        new HRDashboard(username);
                    } else {
                        JOptionPane.showMessageDialog(null, "Invalid role assigned to user.");
                    }

                } else {
                    JOptionPane.showMessageDialog(null, "Invalid username, password or role.");
                }

            } catch (Exception ex) {
                ex.printStackTrace();
            }

        } else if (e.getSource() == back) {
            setVisible(false);
            new Main_class();
        }
    }

    public static void main(String[] args) {
        new Login();
    }
}
