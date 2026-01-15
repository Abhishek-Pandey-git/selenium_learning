import java.io.*;
import java.util.*;

// Employee class to store employee details
class Employee {
    private String id;
    private String name;
    private double salary;
    private String department;
    
    public Employee(String id, String name, double salary, String department) {
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.department = department;
    }
    
    public String getId() {
        return id;
    }
    
    public double getSalary() {
        return salary;
    }
    
    public void setSalary(double salary) {
        this.salary = salary;
    }
    
    public String getDepartment() {
        return department;
    }
    
    // Method to display employee details
    public String toString() {
        return "ID: " + id + ", Name: " + name + ", Salary: " + salary + ", Department: " + department;
    }
    
    // Method to convert employee data to file format
    public String toFileString() {
        return id + "," + name + "," + salary + "," + department;
    }
    
    // Method to create employee object from file data
    public static Employee fromFileString(String line) {
        String[] parts = line.split(",");
        return new Employee(parts[0], parts[1], Double.parseDouble(parts[2]), parts[3]);
    }
}

// Class to manage all employee operations
class EmployeeManagement {
    private HashMap<String, Employee> employees;
    private String filename = "employees.txt";
    private String username = "admin";
    private String password = "admin123";
    
    // Constructor to initialize and load data from file
    public EmployeeManagement() {
        employees = new HashMap<>();
        loadFromFile();
    }
    
    // Method to validate login credentials
    public boolean login(String user, String pass) {
        return username.equals(user) && password.equals(pass);
    }
    
    // Method to add new employee with validation
    public void addEmployee(Scanner sc) {
        try {
            System.out.print("Enter Employee ID: ");
            String id = sc.nextLine();
            
            // Validation: Check if employee ID is unique
            if(employees.containsKey(id)) {
                System.out.println("Employee ID must be unique");
                return;
            }
            
            System.out.print("Enter Name: ");
            String name = sc.nextLine();
            
            System.out.print("Enter Salary: ");
            double salary = sc.nextDouble();
            sc.nextLine();
            
            if(salary <= 0) {
                System.out.println("Salary must be positive");
                return;
            }
            
            System.out.print("Enter Department: ");
            String dept = sc.nextLine();
            
            // Validation: Department cannot be empty
            if(dept.trim().isEmpty()) {
                System.out.println("Department cannot be empty");
                return;
            }
            
            employees.put(id, new Employee(id, name, salary, dept));
            saveToFile();
            System.out.println("Employee added successfully");
        } catch(Exception e) {
            System.out.println("Error: Invalid input");
            sc.nextLine();
        }
    }
    
    // Method to display all employees
    public void displayAll() {
        if(employees.isEmpty()) {
            System.out.println("No employees found");
            return;
        }
        for(Employee emp : employees.values()) {
            System.out.println(emp);
        }
    }
    
    // Method to search employee by ID
    public void searchById(Scanner sc) {
        System.out.print("Enter Employee ID: ");
        String id = sc.nextLine();
        
        Employee emp = employees.get(id);
        if(emp != null) {
            System.out.println("Found: " + emp);
        } else {
            System.out.println("Employee not found");
        }
    }
    
    // Method to update employee salary
    public void updateSalary(Scanner sc) {
        try {
            System.out.print("Enter Employee ID: ");
            String id = sc.nextLine();
            
            Employee emp = employees.get(id);
            if(emp == null) {
                System.out.println("Employee not found");
                return;
            }
            
            System.out.print("Enter new salary: ");
            double salary = sc.nextDouble();
            sc.nextLine();
            
            if(salary <= 0) {
                System.out.println("Salary must be positive");
                return;
            }
            
            emp.setSalary(salary);
            saveToFile();
            System.out.println("Salary updated successfully");
        } catch(Exception e) {
            System.out.println("Error: Invalid input");
            sc.nextLine();
        }
    }
    
    // Method to delete employee by ID
    public void deleteEmployee(Scanner sc) {
        System.out.print("Enter Employee ID: ");
        String id = sc.nextLine();
        
        if(employees.remove(id) != null) {
            saveToFile();
            System.out.println("Employee deleted successfully");
        } else {
            System.out.println("Employee not found");
        }
    }
    
    // Method to display employees sorted by ID
    public void displaySorted() {
        if(employees.isEmpty()) {
            System.out.println("No employees found");
            return;
        }
        
        List<Employee> empList = new ArrayList<>(employees.values());
        Collections.sort(empList, (e1, e2) -> e1.getId().compareTo(e2.getId()));
        
        System.out.println("Employees sorted by ID:");
        for(Employee emp : empList) {
            System.out.println(emp);
        }
    }
    
    // Method to display all unique departments
    public void displayDepartments() {
        if(employees.isEmpty()) {
            System.out.println("No employees found");
            return;
        }
        
        Set<String> departments = new HashSet<>();
        for(Employee emp : employees.values()) {
            departments.add(emp.getDepartment());
        }
        
        System.out.println("Departments:");
        for(String dept : departments) {
            System.out.println("- " + dept);
        }
    }
    
    // Method to save all employees to file using BufferedWriter
    private void saveToFile() {
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            for(Employee emp : employees.values()) {
                writer.write(emp.toFileString());
                writer.newLine();
            }
        } catch(IOException e) {
            System.out.println("Error saving to file: " + e.getMessage());
        }
    }
    
    // Method to load employees from file using BufferedReader
    private void loadFromFile() {
        try(BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while((line = reader.readLine()) != null) {
                Employee emp = Employee.fromFileString(line);
                employees.put(emp.getId(), emp);
            }
        } catch(IOException e) {
            System.out.println("No existing data found");
        }
    }
}

// Main class for Employee Management System
public class EmployeeManagementSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        EmployeeManagement em = new EmployeeManagement();
        
        // Login system for security
        System.out.println("Login Required");
        System.out.print("Username: ");
        String username = sc.nextLine();
        System.out.print("Password: ");
        String password = sc.nextLine();
        
        if(!em.login(username, password)) {
            System.out.println("Invalid credentials");
            sc.close();
            return;
        }
        
        System.out.println("Login successful\n");
        
        while(true) {
            System.out.println("\n1. Add Employee");
            System.out.println("2. Display All Employees");
            System.out.println("3. Search Employee by ID");
            System.out.println("4. Update Employee Salary");
            System.out.println("5. Delete Employee");
            System.out.println("6. Display Sorted Employees");
            System.out.println("7. Display Departments");
            System.out.println("8. Exit");
            System.out.print("Enter choice: ");
            
            int choice = sc.nextInt();
            sc.nextLine();
            
            switch(choice) {
                case 1: em.addEmployee(sc); break;
                case 2: em.displayAll(); break;
                case 3: em.searchById(sc); break;
                case 4: em.updateSalary(sc); break;
                case 5: em.deleteEmployee(sc); break;
                case 6: em.displaySorted(); break;
                case 7: em.displayDepartments(); break;
                case 8:
                    System.out.println("Thank you");
                    sc.close();
                    System.exit(0);
                default: System.out.println("Invalid choice");
            }
        }
    }
}
