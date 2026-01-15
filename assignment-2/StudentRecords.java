import java.util.*;
import java.util.regex.*;

class Student {
    private int rollNo;
    private String name;
    private int age;
    
    public Student(int rollNo, String name, int age) {
        this.rollNo = rollNo;
        this.name = name;
        this.age = age;
    }
    
    public int getRollNo() {
        return rollNo;
    }
    
    public String toString() {
        return "Roll No: " + rollNo + ", Name: " + name + ", Age: " + age;
    }
}

interface StudentOperations {
    void addStudent(Student s);
    void displayStudents();
    void removeStudent(int rollNo);
    void searchStudent(int rollNo);
}

class StudentManager implements StudentOperations {
    private List<Student> students;
    
    public StudentManager() {
        students = new ArrayList<>();
    }
    
    public void addStudent(Student s) {
        students.add(s);
        System.out.println("Student added successfully");
    }
    
    public void displayStudents() {
        if(students.isEmpty()) {
            System.out.println("No students found");
            return;
        }
        for(Student s : students) {
            System.out.println(s);
        }
    }
    
    public void removeStudent(int rollNo) {
        boolean found = false;
        Iterator<Student> it = students.iterator();
        while(it.hasNext()) {
            Student s = it.next();
            if(s.getRollNo() == rollNo) {
                it.remove();
                found = true;
                System.out.println("Student removed");
                break;
            }
        }
        if(!found) {
            System.out.println("Student not found");
        }
    }
    
    public void searchStudent(int rollNo) {
        for(Student s : students) {
            if(s.getRollNo() == rollNo) {
                System.out.println("Found: " + s);
                return;
            }
        }
        System.out.println("Student not found");
    }
}

public class StudentRecords {
    
    public static boolean validateName(String name) {
        return Pattern.matches("^[a-zA-Z ]{2,50}$", name);
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StudentManager sm = new StudentManager();
        
        try {
            while(true) {
                System.out.println("\n1. Add Student");
                System.out.println("2. Display All Students");
                System.out.println("3. Remove Student");
                System.out.println("4. Search Student");
                System.out.println("5. Exit");
                System.out.print("Enter choice: ");
                int choice = sc.nextInt();
                
                switch(choice) {
                    case 1:
                        System.out.print("Enter roll number: ");
                        int rollNo = sc.nextInt();
                        sc.nextLine();
                        System.out.print("Enter name: ");
                        String name = sc.nextLine();
                        
                        if(!validateName(name)) {
                            System.out.println("Invalid name");
                            break;
                        }
                        
                        System.out.print("Enter age: ");
                        int age = sc.nextInt();
                        
                        sm.addStudent(new Student(rollNo, name, age));
                        break;
                        
                    case 2:
                        sm.displayStudents();
                        break;
                        
                    case 3:
                        System.out.print("Enter roll number to remove: ");
                        int removeRoll = sc.nextInt();
                        sm.removeStudent(removeRoll);
                        break;
                        
                    case 4:
                        System.out.print("Enter roll number to search: ");
                        int searchRoll = sc.nextInt();
                        sm.searchStudent(searchRoll);
                        break;
                        
                    case 5:
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
