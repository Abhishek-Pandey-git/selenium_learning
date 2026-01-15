import java.sql.*;
import java.util.Scanner;

// Custom exception for duplicate enrollment number
class DuplicateEnoException extends Exception {
    public DuplicateEnoException(String message) {
        super(message);
    }
}

// Custom exception for invalid percentage
class InvalidPercentageException extends Exception {
    public InvalidPercentageException(String message) {
        super(message);
    }
}

// Custom exception for empty fields
class EmptyFieldException extends Exception {
    public EmptyFieldException(String message) {
        super(message);
    }
}

// Student Management class with JDBC operations
class StudentManager {
    private String url = "jdbc:mysql://localhost:3306/studentdb";
    private String dbUsername = "root";
    private String dbPassword = "password";
    private String username = "admin";
    private String password = "admin123";
    
    // Method to validate login
    public boolean login(String user, String pass) {
        return username.equals(user) && password.equals(pass);
    }
    
    // Method to establish database connection
    private Connection getConnection() throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection(url, dbUsername, dbPassword);
        } catch(ClassNotFoundException e) {
            throw new SQLException("MySQL Driver not found");
        }
    }
    
    // Method to create Students table if not exists
    public void createTable() {
        try(Connection conn = getConnection();
            Statement stmt = conn.createStatement()) {
            
            String createTable = "CREATE TABLE IF NOT EXISTS Students (" +
                               "Eno INT PRIMARY KEY, " +
                               "Name VARCHAR(100), " +
                               "Branch VARCHAR(50), " +
                               "Percentage DOUBLE, " +
                               "Semester INT)";
            
            stmt.executeUpdate(createTable);
        } catch(SQLException e) {
            System.out.println("Error creating table: " + e.getMessage());
        }
    }
    
    // Method to add student with validation
    public void addStudent(Scanner sc) {
        try {
            System.out.print("Enter Enrollment Number: ");
            int eno = sc.nextInt();
            sc.nextLine();
            
            // Validation: Check if Eno already exists
            if(checkEnoExists(eno)) {
                throw new DuplicateEnoException("Enrollment number must be unique");
            }
            
            System.out.print("Enter Name: ");
            String name = sc.nextLine();
            
            System.out.print("Enter Branch: ");
            String branch = sc.nextLine();
            
            // Validation: Branch cannot be empty
            if(branch.trim().isEmpty()) {
                throw new EmptyFieldException("Branch cannot be empty");
            }
            
            System.out.print("Enter Percentage: ");
            double percentage = sc.nextDouble();
            
            // Validation: Percentage must be positive
            if(percentage <= 0) {
                throw new InvalidPercentageException("Percentage must be positive");
            }
            
            System.out.print("Enter Semester: ");
            int semester = sc.nextInt();
            sc.nextLine();
            
            // Validation: Semester cannot be empty (0)
            if(semester <= 0) {
                throw new EmptyFieldException("Semester cannot be empty");
            }
            
            // Insert student record
            try(Connection conn = getConnection();
                PreparedStatement pstmt = conn.prepareStatement(
                    "INSERT INTO Students VALUES (?, ?, ?, ?, ?)")) {
                
                pstmt.setInt(1, eno);
                pstmt.setString(2, name);
                pstmt.setString(3, branch);
                pstmt.setDouble(4, percentage);
                pstmt.setInt(5, semester);
                
                pstmt.executeUpdate();
                System.out.println("Student added successfully");
            }
            
        } catch(DuplicateEnoException | InvalidPercentageException | EmptyFieldException e) {
            System.out.println("Validation Error: " + e.getMessage());
        } catch(SQLException e) {
            System.out.println("Database Error: " + e.getMessage());
        } catch(Exception e) {
            System.out.println("Error: Invalid input");
            sc.nextLine();
        }
    }
    
    // Method to check if enrollment number exists
    private boolean checkEnoExists(int eno) throws SQLException {
        try(Connection conn = getConnection();
            PreparedStatement pstmt = conn.prepareStatement(
                "SELECT Eno FROM Students WHERE Eno = ?")) {
            
            pstmt.setInt(1, eno);
            ResultSet rs = pstmt.executeQuery();
            return rs.next();
        }
    }
    
    // Method to display all students
    public void displayAllStudents() {
        try(Connection conn = getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM Students")) {
            
            System.out.println("\n----- All Students -----");
            boolean found = false;
            
            while(rs.next()) {
                found = true;
                System.out.println("Eno: " + rs.getInt("Eno"));
                System.out.println("Name: " + rs.getString("Name"));
                System.out.println("Branch: " + rs.getString("Branch"));
                System.out.println("Percentage: " + rs.getDouble("Percentage"));
                System.out.println("Semester: " + rs.getInt("Semester"));
                System.out.println("------------------------");
            }
            
            if(!found) {
                System.out.println("No students found");
            }
            
        } catch(SQLException e) {
            System.out.println("Database Error: " + e.getMessage());
        }
    }
    
    // Method to search student by Eno
    public void searchByEno(Scanner sc) {
        try {
            System.out.print("Enter Enrollment Number: ");
            int eno = sc.nextInt();
            sc.nextLine();
            
            try(Connection conn = getConnection();
                PreparedStatement pstmt = conn.prepareStatement(
                    "SELECT * FROM Students WHERE Eno = ?")) {
                
                pstmt.setInt(1, eno);
                ResultSet rs = pstmt.executeQuery();
                
                if(rs.next()) {
                    System.out.println("\n----- Student Found -----");
                    System.out.println("Eno: " + rs.getInt("Eno"));
                    System.out.println("Name: " + rs.getString("Name"));
                    System.out.println("Branch: " + rs.getString("Branch"));
                    System.out.println("Percentage: " + rs.getDouble("Percentage"));
                    System.out.println("Semester: " + rs.getInt("Semester"));
                } else {
                    System.out.println("Student not found");
                }
            }
            
        } catch(SQLException e) {
            System.out.println("Database Error: " + e.getMessage());
        } catch(Exception e) {
            System.out.println("Error: Invalid input");
            sc.nextLine();
        }
    }
    
    // Method to update student branch
    public void updateBranch(Scanner sc) {
        try {
            System.out.print("Enter Enrollment Number: ");
            int eno = sc.nextInt();
            sc.nextLine();
            
            if(!checkEnoExists(eno)) {
                System.out.println("Student not found");
                return;
            }
            
            System.out.print("Enter New Branch: ");
            String branch = sc.nextLine();
            
            // Validation: Branch cannot be empty
            if(branch.trim().isEmpty()) {
                throw new EmptyFieldException("Branch cannot be empty");
            }
            
            try(Connection conn = getConnection();
                PreparedStatement pstmt = conn.prepareStatement(
                    "UPDATE Students SET Branch = ? WHERE Eno = ?")) {
                
                pstmt.setString(1, branch);
                pstmt.setInt(2, eno);
                
                pstmt.executeUpdate();
                System.out.println("Branch updated successfully");
            }
            
        } catch(EmptyFieldException e) {
            System.out.println("Validation Error: " + e.getMessage());
        } catch(SQLException e) {
            System.out.println("Database Error: " + e.getMessage());
        } catch(Exception e) {
            System.out.println("Error: Invalid input");
            sc.nextLine();
        }
    }
    
    // Method to delete student by Eno
    public void deleteByEno(Scanner sc) {
        try {
            System.out.print("Enter Enrollment Number: ");
            int eno = sc.nextInt();
            sc.nextLine();
            
            try(Connection conn = getConnection();
                PreparedStatement pstmt = conn.prepareStatement(
                    "DELETE FROM Students WHERE Eno = ?")) {
                
                pstmt.setInt(1, eno);
                int rowsAffected = pstmt.executeUpdate();
                
                if(rowsAffected > 0) {
                    System.out.println("Student deleted successfully");
                } else {
                    System.out.println("Student not found");
                }
            }
            
        } catch(SQLException e) {
            System.out.println("Database Error: " + e.getMessage());
        } catch(Exception e) {
            System.out.println("Error: Invalid input");
            sc.nextLine();
        }
    }
    
    // Method to display students sorted by Eno
    public void displaySorted() {
        try(Connection conn = getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(
                "SELECT * FROM Students ORDER BY Eno")) {
            
            System.out.println("\n----- Students Sorted by Eno -----");
            boolean found = false;
            
            while(rs.next()) {
                found = true;
                System.out.println("Eno: " + rs.getInt("Eno"));
                System.out.println("Name: " + rs.getString("Name"));
                System.out.println("Branch: " + rs.getString("Branch"));
                System.out.println("Percentage: " + rs.getDouble("Percentage"));
                System.out.println("Semester: " + rs.getInt("Semester"));
                System.out.println("------------------------");
            }
            
            if(!found) {
                System.out.println("No students found");
            }
            
        } catch(SQLException e) {
            System.out.println("Database Error: " + e.getMessage());
        }
    }
}

// Main class
public class StudentManagementSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StudentManager sm = new StudentManager();
        
        // Login system
        System.out.println("===== Student Management System =====");
        System.out.print("Username: ");
        String username = sc.nextLine();
        System.out.print("Password: ");
        String password = sc.nextLine();
        
        if(!sm.login(username, password)) {
            System.out.println("Invalid credentials");
            sc.close();
            return;
        }
        
        System.out.println("Login successful\n");
        
        // Create table if not exists
        sm.createTable();
        
        // Menu-driven program
        while(true) {
            System.out.println("\n1. Add Student");
            System.out.println("2. Display All Students");
            System.out.println("3. Search Student by Eno");
            System.out.println("4. Update Student Branch");
            System.out.println("5. Delete Student by Eno");
            System.out.println("6. Display Sorted Students");
            System.out.println("7. Exit");
            System.out.print("Enter choice: ");
            
            int choice = sc.nextInt();
            sc.nextLine();
            
            switch(choice) {
                case 1: sm.addStudent(sc); break;
                case 2: sm.displayAllStudents(); break;
                case 3: sm.searchByEno(sc); break;
                case 4: sm.updateBranch(sc); break;
                case 5: sm.deleteByEno(sc); break;
                case 6: sm.displaySorted(); break;
                case 7:
                    System.out.println("Thank you for using the system");
                    sc.close();
                    System.exit(0);
                default: System.out.println("Invalid choice");
            }
        }
    }
}
