import java.sql.*;

public class JDBCConnection {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/studentdb";
        String username = "root";
        String password = "password";
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(url, username, password);
            
            if(conn != null) {
                System.out.println("Connection Successful");
                conn.close();
            }
        } catch(Exception e) {
            System.out.println("Unable to connect");
            System.out.println("Error: " + e.getMessage());
        }
    }
}
