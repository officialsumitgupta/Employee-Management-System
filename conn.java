package employee.management.system;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class conn {

    Connection connection;
    public Statement statement;

    public conn() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/employeemanagement", "root", "root");
            statement = connection.createStatement();
        } catch (Exception e) {
            System.out.println("Connection failed: " + e.getMessage());
            e.printStackTrace();  // ✅ Very important for debugging
        }
    }

}
