package employee.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class ChangePassword extends JFrame implements ActionListener {

    JTextField usernameField;
    JPasswordField oldPasswordField, newPasswordField;
    JButton changeButton, backButton;

    ChangePassword() {
        setTitle("Change Password");
        setSize(400, 300);
        setLayout(null);
        setLocationRelativeTo(null);

        JLabel userLabel = new JLabel("Username:");
        userLabel.setBounds(50, 30, 100, 30);
        add(userLabel);

        usernameField = new JTextField();
        usernameField.setBounds(160, 30, 150, 30);
        add(usernameField);

        JLabel oldPassLabel = new JLabel("Old Password:");
        oldPassLabel.setBounds(50, 80, 100, 30);
        add(oldPassLabel);

        oldPasswordField = new JPasswordField();
        oldPasswordField.setBounds(160, 80, 150, 30);
        add(oldPasswordField);

        JLabel newPassLabel = new JLabel("New Password:");
        newPassLabel.setBounds(50, 130, 100, 30);
        add(newPassLabel);

        newPasswordField = new JPasswordField();
        newPasswordField.setBounds(160, 130, 150, 30);
        add(newPasswordField);

        changeButton = new JButton("Change");
        changeButton.setBounds(80, 190, 100, 30);
        changeButton.setBackground(Color.BLACK);
        changeButton.setForeground(Color.WHITE);
        changeButton.addActionListener(this);
        add(changeButton);

        backButton = new JButton("Back");
        backButton.setBounds(200, 190, 100, 30);
        backButton.setBackground(Color.BLACK);
        backButton.setForeground(Color.WHITE);
        backButton.addActionListener(this);
        add(backButton);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == changeButton) {
            String username = usernameField.getText();
            String oldPassword = new String(oldPasswordField.getPassword());
            String newPassword = new String(newPasswordField.getPassword());

            try {
                conn c = new conn();
                String query = "SELECT * FROM login WHERE username = '" + username + "' AND password = '" + oldPassword + "'";
                ResultSet rs = c.statement.executeQuery(query);
                if (rs.next()) {
                    String updateQuery = "UPDATE login SET password = '" + newPassword + "' WHERE username = '" + username + "'";
                    c.statement.executeUpdate(updateQuery);
                    JOptionPane.showMessageDialog(null, "Password changed successfully.");
                    setVisible(false);
                    new Login();
                } else {
                    JOptionPane.showMessageDialog(null, "Incorrect username or old password.");
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        } else if (e.getSource() == backButton) {
            setVisible(false);
            new Login();
        }
    }

    public static void main(String[] args) {
        new ChangePassword();
    }
}
