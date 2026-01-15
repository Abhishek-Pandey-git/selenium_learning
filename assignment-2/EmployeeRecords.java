import java.util.*;
import java.util.regex.*;

class Employee {
    private String empId;
    private String name;
    private double salary;
    
    public Employee(String empId, String name, double salary) {
        this.empId = empId;
        this.name = name;
        this.salary = salary;
    }
    
    public String getEmpId() {
        return empId;
    }
    
    public String toString() {
        return "ID: " + empId + ", Name: " + name + ", Salary: " + salary;
    }
}

interface EmployeeOperations {
    void addEmployee(Employee e);
    void displayEmployees();
    void searchEmployee(String empId);
    void removeEmployee(String empId);
}

class EmployeeManager implements EmployeeOperations {
    private Map<String, Employee> employees;
    
    public EmployeeManager() {
        employees = new HashMap<>();
    }
    
    public void addEmployee(Employee e) {
        employees.put(e.getEmpId(), e);
        System.out.println("Employee added successfully");
    }
    
    public void displayEmployees() {
        if(employees.isEmpty()) {
            System.out.println("No employees found");
            return;
        }
        for(Employee e : employees.values()) {
            System.out.println(e);
        }
    }
    
    public void searchEmployee(String empId) {
        Employee e = employees.get(empId);
        if(e != null) {
            System.out.println("Found: " + e);
        } else {
            System.out.println("Employee not found");
        }
    }
    
    public void removeEmployee(String empId) {
        if(employees.remove(empId) != null) {
            System.out.println("Employee removed");
        } else {
            System.out.println("Employee not found");
        }
    }
    
    public void demonstrateNullSupport() {
        System.out.println("\nHashMap allows null key and null values");
        HashMap<String, String> hm = new HashMap<>();
        hm.put(null, "value");
        hm.put("key", null);
        System.out.println("HashMap with null: " + hm);
        
        System.out.println("\nHashtable does not allow null key or null values");
        System.out.println("\nTreeMap does not allow null key but allows null values");
    }
}

public class EmployeeRecords {
    
    public static boolean validateEmpId(String empId) {
        return Pattern.matches("^E[0-9]{3,}$", empId);
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        EmployeeManager em = new EmployeeManager();
        
        try {
            while(true) {
                System.out.println("\n1. Add Employee");
                System.out.println("2. Display All Employees");
                System.out.println("3. Search Employee");
                System.out.println("4. Remove Employee");
                System.out.println("5. Demonstrate Null Support");
                System.out.println("6. Exit");
                System.out.print("Enter choice: ");
                int choice = sc.nextInt();
                sc.nextLine();
                
                switch(choice) {
                    case 1:
                        System.out.print("Enter employee ID (format: E001): ");
                        String empId = sc.nextLine();
                        
                        if(!validateEmpId(empId)) {
                            System.out.println("Invalid employee ID");
                            break;
                        }
                        
                        System.out.print("Enter name: ");
                        String name = sc.nextLine();
                        System.out.print("Enter salary: ");
                        double salary = sc.nextDouble();
                        
                        em.addEmployee(new Employee(empId, name, salary));
                        break;
                        
                    case 2:
                        em.displayEmployees();
                        break;
                        
                    case 3:
                        System.out.print("Enter employee ID: ");
                        String searchId = sc.nextLine();
                        em.searchEmployee(searchId);
                        break;
                        
                    case 4:
                        System.out.print("Enter employee ID: ");
                        String removeId = sc.nextLine();
                        em.removeEmployee(removeId);
                        break;
                        
                    case 5:
                        em.demonstrateNullSupport();
                        break;
                        
                    case 6:
                        System.out.println("Exiting");
                        sc.close();
                        System.exit(0);
                        
                    default:
                        System.out.println("Invalid choice");
                }
            }
        } catch(Exception e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            sc.close();
        }
    }
}
