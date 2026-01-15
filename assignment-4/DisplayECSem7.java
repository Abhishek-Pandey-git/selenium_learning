import java.sql.*;

public class DisplayECSem7 {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/studentdb";
        String username = "root";
        String password = "password";
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(url, username, password);
            Statement stmt = conn.createStatement();
            
            String selectQuery = "SELECT * FROM Students WHERE Semester = 7 AND Branch = 'EC'";
            ResultSet rs = stmt.executeQuery(selectQuery);
            
            System.out.println("Students in EC branch, Semester 7:");
            System.out.println("---------------------------------------------------");
            
            boolean found = false;
            while(rs.next()) {
                found = true;
                System.out.println("Eno: " + rs.getInt("Eno"));
                System.out.println("Name: " + rs.getString("Name"));
                System.out.println("Branch: " + rs.getString("Branch"));
                System.out.println("Percentage: " + rs.getDouble("Percentage"));
                System.out.println("Semester: " + rs.getInt("Semester"));
                System.out.println("Year of Passing: " + rs.getInt("YearOfPassing"));
                System.out.println("---------------------------------------------------");
            }
            
            if(!found) {
                System.out.println("No students found");
            }
            
            rs.close();
            stmt.close();
            conn.close();
        } catch(Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
