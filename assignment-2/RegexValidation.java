import java.util.Scanner;
import java.util.regex.*;

public class RegexValidation {
    
    public boolean validateMobile(String mobile) {
        String regex = "^[6-9][0-9]{9}$";
        return Pattern.matches(regex, mobile);
    }
    
    public boolean validateEmail(String email) {
        String regex = "^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
        return Pattern.matches(regex, email);
    }
    
    public boolean validateUsername(String username) {
        String regex = "^[a-zA-Z0-9_]{5,15}$";
        return Pattern.matches(regex, username);
    }
    
    public boolean validatePassword(String password) {
        String regex = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@#$%^&+=]).{8,}$";
        return Pattern.matches(regex, password);
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        RegexValidation rv = new RegexValidation();
        
        try {
            while(true) {
                System.out.println("\n1. Validate Mobile Number");
                System.out.println("2. Validate Email ID");
                System.out.println("3. Validate Username");
                System.out.println("4. Validate Password");
                System.out.println("5. Exit");
                System.out.print("Enter choice: ");
                int choice = sc.nextInt();
                sc.nextLine();
                
                switch(choice) {
                    case 1:
                        System.out.print("Enter mobile number: ");
                        String mobile = sc.nextLine();
                        if(rv.validateMobile(mobile)) {
                            System.out.println("Welcome! Valid mobile number");
                        } else {
                            System.out.println("Invalid mobile number");
                        }
                        break;
                        
                    case 2:
                        System.out.print("Enter email: ");
                        String email = sc.nextLine();
                        if(rv.validateEmail(email)) {
                            System.out.println("Welcome! Valid email");
                        } else {
                            System.out.println("Invalid email");
                        }
                        break;
                        
                    case 3:
                        System.out.print("Enter username: ");
                        String username = sc.nextLine();
                        if(rv.validateUsername(username)) {
                            System.out.println("Welcome! Valid username");
                        } else {
                            System.out.println("Invalid username (5-15 alphanumeric characters)");
                        }
                        break;
                        
                    case 4:
                        System.out.print("Enter password: ");
                        String password = sc.nextLine();
                        if(rv.validatePassword(password)) {
                            System.out.println("Welcome! Valid password");
                        } else {
                            System.out.println("Invalid password (min 8 chars, 1 uppercase, 1 lowercase, 1 digit, 1 special)");
                        }
                        break;
                        
                    case 5:
                        System.out.println("Goodbye");
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
