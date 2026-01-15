import java.util.Scanner;

interface Banking {
    void deposit(double amount) throws Exception;
    void withdraw(double amount) throws Exception;
    double getBalance();
}

interface CustomerService {
    void displayAccountInfo();
    void updateContactInfo(String contact);
}

class InsufficientFundsException extends Exception {
    public InsufficientFundsException(String message) {
        super(message);
    }
}

class InvalidAmountException extends Exception {
    public InvalidAmountException(String message) {
        super(message);
    }
}

class Account implements Banking, CustomerService {
    private String accountNumber;
    private String name;
    private String contact;
    private double balance;
    
    public Account(String accountNumber, String name, String contact, double balance) {
        this.accountNumber = accountNumber;
        this.name = name;
        this.contact = contact;
        this.balance = balance;
    }
    
    public void deposit(double amount) throws InvalidAmountException {
        if(amount <= 0) {
            throw new InvalidAmountException("Amount must be positive");
        }
        balance += amount;
        System.out.println("Deposited: " + amount);
    }
    
    public void withdraw(double amount) throws InsufficientFundsException, InvalidAmountException {
        if(amount <= 0) {
            throw new InvalidAmountException("Amount must be positive");
        }
        if(amount > balance) {
            throw new InsufficientFundsException("Insufficient balance");
        }
        balance -= amount;
        System.out.println("Withdrawn: " + amount);
    }
    
    public double getBalance() {
        return balance;
    }
    
    public void displayAccountInfo() {
        System.out.println("\nAccount Information:");
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Name: " + name);
        System.out.println("Contact: " + contact);
        System.out.println("Balance: " + balance);
    }
    
    public void updateContactInfo(String contact) {
        this.contact = contact;
        System.out.println("Contact updated successfully");
    }
}

public class BankWithInterfaces {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        try {
            System.out.print("Enter Account Number: ");
            String accNo = sc.nextLine();
            System.out.print("Enter Name: ");
            String name = sc.nextLine();
            System.out.print("Enter Contact: ");
            String contact = sc.nextLine();
            System.out.print("Enter Initial Balance: ");
            double balance = sc.nextDouble();
            
            Account account = new Account(accNo, name, contact, balance);
            
            while(true) {
                System.out.println("\n1. Deposit");
                System.out.println("2. Withdraw");
                System.out.println("3. Check Balance");
                System.out.println("4. Account Info");
                System.out.println("5. Update Contact");
                System.out.println("6. Exit");
                System.out.print("Enter choice: ");
                int choice = sc.nextInt();
                
                switch(choice) {
                    case 1:
                        System.out.print("Enter amount: ");
                        double dep = sc.nextDouble();
                        account.deposit(dep);
                        break;
                        
                    case 2:
                        System.out.print("Enter amount: ");
                        double with = sc.nextDouble();
                        account.withdraw(with);
                        break;
                        
                    case 3:
                        System.out.println("Balance: " + account.getBalance());
                        break;
                        
                    case 4:
                        account.displayAccountInfo();
                        break;
                        
                    case 5:
                        sc.nextLine();
                        System.out.print("Enter new contact: ");
                        String newContact = sc.nextLine();
                        account.updateContactInfo(newContact);
                        break;
                        
                    case 6:
                        System.out.println("Thank you");
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
