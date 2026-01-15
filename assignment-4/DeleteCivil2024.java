import java.sql.*;

public class DeleteCivil2024 {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/studentdb";
        String username = "root";
        String password = "password";
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(url, username, password);
            Statement stmt = conn.createStatement();
            
            String deleteQuery = "DELETE FROM Students WHERE YearOfPassing = 2024 AND Branch = 'Civil'";
            
            int rowsAffected = stmt.executeUpdate(deleteQuery);
            
            System.out.println(rowsAffected + " records deleted successfully");
            System.out.println("Deleted all Civil branch students with passing year 2024");
            
            stmt.close();
            conn.close();
        } catch(Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
