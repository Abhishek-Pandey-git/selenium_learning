import java.sql.*;

public class UpdateCSEPercentage {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/studentdb";
        String username = "root";
        String password = "password";
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(url, username, password);
            Statement stmt = conn.createStatement();
            
            String updateQuery = "UPDATE Students SET Percentage = Percentage * 1.05 WHERE Branch = 'CSE'";
            
            int rowsAffected = stmt.executeUpdate(updateQuery);
            
            System.out.println(rowsAffected + " records updated successfully");
            System.out.println("5% increase applied to CSE students percentage");
            
            stmt.close();
            conn.close();
        } catch(Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
