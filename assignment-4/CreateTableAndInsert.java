import java.sql.*;

public class CreateTableAndInsert {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/studentdb";
        String username = "root";
        String password = "password";
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(url, username, password);
            Statement stmt = conn.createStatement();
            
            String createTable = "CREATE TABLE IF NOT EXISTS Students (" +
                                 "Eno INT PRIMARY KEY, " +
                                 "Name VARCHAR(100), " +
                                 "Branch VARCHAR(50), " +
                                 "Percentage DOUBLE, " +
                                 "Semester INT, " +
                                 "YearOfPassing INT)";
            
            stmt.executeUpdate(createTable);
            System.out.println("Table created successfully");
            
            String insert1 = "INSERT INTO Students VALUES (101, 'Rahul', 'CSE', 85.5, 7, 2025)";
            String insert2 = "INSERT INTO Students VALUES (102, 'Priya', 'EC', 78.0, 7, 2025)";
            String insert3 = "INSERT INTO Students VALUES (103, 'Amit', 'Civil', 72.5, 6, 2024)";
            String insert4 = "INSERT INTO Students VALUES (104, 'Sneha', 'CSE', 90.0, 8, 2025)";
            String insert5 = "INSERT INTO Students VALUES (105, 'Vikram', 'Civil', 68.0, 5, 2024)";
            
            stmt.executeUpdate(insert1);
            stmt.executeUpdate(insert2);
            stmt.executeUpdate(insert3);
            stmt.executeUpdate(insert4);
            stmt.executeUpdate(insert5);
            
            System.out.println("Records inserted successfully");
            
            stmt.close();
            conn.close();
        } catch(Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
