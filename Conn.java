package bank.management.system;
 
import java.sql.*;

public class Conn {
    Connection conn;
    Statement s;

    public Conn() {
        try {
            // Replace these with your database URL, username, and password
            String url = "jdbc:mysql://localhost:3306/bankmanagementsystem";
            String user = "root";
            String password = "Y@tri-1610";
            
            conn = DriverManager.getConnection(url, user, password);
            s = conn.createStatement();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void close() {
        try {
            if (s != null) s.close();
            if (conn != null) conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
