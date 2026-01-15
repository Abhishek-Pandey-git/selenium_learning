import java.util.*;
import java.util.regex.*;

class Student {
    private String id;
    private String name;
    private String course;
    private int marks;
    
    public Student(String id, String name, String course, int marks) {
        this.id = id;
        this.name = name;
        this.course = course;
        this.marks = marks;
    }
    
    public String getId() {
        return id;
    }
    
    public String getCourse() {
        return course;
    }
    
    public int getMarks() {
        return marks;
    }
    
    public String toString() {
        return "ID: " + id + ", Name: " + name + ", Course: " + course + ", Marks: " + marks;
    }
}

interface UniversityOperations {
    void addStudent(Student s);
    void displayStudents();
    void removeStudent(String id);
    void searchStudent(String id);
    void sortByMarks();
    void convertToTreeMap();
    void countStudentsByCourse();
    void displayUniqueCourses();
}

class UniversityManager implements UniversityOperations {
    private HashMap<String, Student> studentMap;
    private Set<String> courses;
    
    public UniversityManager() {
        studentMap = new HashMap<>();
        courses = new HashSet<>();
    }
    
    public void addStudent(Student s) {
        if(studentMap.containsKey(s.getId())) {
            System.out.println("Student with this ID already exists");
            return;
        }
        studentMap.put(s.getId(), s);
        courses.add(s.getCourse());
        System.out.println("Student added successfully");
    }
    
    public void displayStudents() {
        if(studentMap.isEmpty()) {
            System.out.println("No students found");
            return;
        }
        for(Student s : studentMap.values()) {
            System.out.println(s);
        }
    }
    
    public void removeStudent(String id) {
        Student s = studentMap.remove(id);
        if(s != null) {
            System.out.println("Student removed");
        } else {
            System.out.println("Student not found");
        }
    }
    
    public void searchStudent(String id) {
        Student s = studentMap.get(id);
        if(s != null) {
            System.out.println("Found: " + s);
        } else {
            System.out.println("Student not found");
        }
    }
    
    public void sortByMarks() {
        List<Student> students = new ArrayList<>(studentMap.values());
        Collections.sort(students, (s1, s2) -> s2.getMarks() - s1.getMarks());
        
        System.out.println("Students sorted by marks:");
        for(Student s : students) {
            System.out.println(s);
        }
    }
    
    public void convertToTreeMap() {
        TreeMap<String, Student> treeMap = new TreeMap<>(studentMap);
        System.out.println("Converted to TreeMap (sorted by ID):");
        for(Student s : treeMap.values()) {
            System.out.println(s);
        }
    }
    
    public void countStudentsByCourse() {
        HashMap<String, Integer> courseCount = new HashMap<>();
        for(Student s : studentMap.values()) {
            courseCount.put(s.getCourse(), courseCount.getOrDefault(s.getCourse(), 0) + 1);
        }
        
        System.out.println("Students per course:");
        for(Map.Entry<String, Integer> entry : courseCount.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
    
    public void displayUniqueCourses() {
        System.out.println("Unique courses:");
        for(String course : courses) {
            System.out.println(course);
        }
    }
}

public class UniversityManagement {
    
    public static boolean validateId(String id) {
        return Pattern.matches("^S[0-9]{3,}$", id);
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        UniversityManager um = new UniversityManager();
        
        try {
            while(true) {
                System.out.println("\n1. Add Student");
                System.out.println("2. Display All Students");
                System.out.println("3. Remove Student");
                System.out.println("4. Search Student");
                System.out.println("5. Sort Students by Marks");
                System.out.println("6. Convert to TreeMap");
                System.out.println("7. Count Students by Course");
                System.out.println("8. Display Unique Courses");
                System.out.println("9. Exit");
                System.out.print("Enter choice: ");
                int choice = sc.nextInt();
                sc.nextLine();
                
                switch(choice) {
                    case 1:
                        System.out.print("Enter student ID (format: S001): ");
                        String id = sc.nextLine();
                        
                        if(!validateId(id)) {
                            System.out.println("Invalid ID format");
                            break;
                        }
                        
                        System.out.print("Enter name: ");
                        String name = sc.nextLine();
                        System.out.print("Enter course: ");
                        String course = sc.nextLine();
                        System.out.print("Enter marks: ");
                        int marks = sc.nextInt();
                        
                        um.addStudent(new Student(id, name, course, marks));
                        break;
                        
                    case 2:
                        um.displayStudents();
                        break;
                        
                    case 3:
                        System.out.print("Enter student ID: ");
                        String removeId = sc.nextLine();
                        um.removeStudent(removeId);
                        break;
                        
                    case 4:
                        System.out.print("Enter student ID: ");
                        String searchId = sc.nextLine();
                        um.searchStudent(searchId);
                        break;
                        
                    case 5:
                        um.sortByMarks();
                        break;
                        
                    case 6:
                        um.convertToTreeMap();
                        break;
                        
                    case 7:
                        um.countStudentsByCourse();
                        break;
                        
                    case 8:
                        um.displayUniqueCourses();
                        break;
                        
                    case 9:
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
