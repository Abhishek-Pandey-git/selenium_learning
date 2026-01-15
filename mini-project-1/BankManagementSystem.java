import java.io.*;
import java.util.Scanner;

// Abstract class representing a bank account
abstract class Account {
    protected String accountNumber;
    protected String name;
    protected double balance;
    
    public Account(String accountNumber, String name, double balance) {
        this.accountNumber = accountNumber;
        this.name = name;
        this.balance = balance;
    }
    
    // Abstract methods to be implemented by child classes
    abstract void deposit(double amount);
    abstract void withdraw(double amount);
    
    // Method to display account details
    public void displayDetails() {
        System.out.println("\nAccount Number: " + accountNumber);
        System.out.println("Name: " + name);
        System.out.println("Balance: " + balance);
    }
    
    // Method to get account data as comma-separated string for file storage
    public String getAccountData() {
        return accountNumber + "," + name + "," + balance;
    }
}

// Savings account class with interest feature
class SavingsAccount extends Account {
    private double interestRate;
    
    public SavingsAccount(String accountNumber, String name, double balance) {
        super(accountNumber, name, balance);
        this.interestRate = 4.5;
    }
    
    // Method overriding - deposit money into savings account
    void deposit(double amount) {
        if(amount > 0) {
            balance += amount;
            System.out.println("Deposited: " + amount);
        } else {
            System.out.println("Invalid amount");
        }
    }
    
    // Method overriding - withdraw money from savings account
    void withdraw(double amount) {
        if(amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawn: " + amount);
        } else {
            System.out.println("Insufficient balance or invalid amount");
        }
    }
    
    // Method to add interest to savings account
    public void addInterest() {
        double interest = balance * interestRate / 100;
        balance += interest;
        System.out.println("Interest added: " + interest);
    }
}

// Current account class with overdraft facility
class CurrentAccount extends Account {
    private double overdraftLimit;
    
    public CurrentAccount(String accountNumber, String name, double balance) {
        super(accountNumber, name, balance);
        this.overdraftLimit = 5000;
    }
    
    // Method overriding - deposit money into current account
    void deposit(double amount) {
        if(amount > 0) {
            balance += amount;
            System.out.println("Deposited: " + amount);
        } else {
            System.out.println("Invalid amount");
        }
    }
    
    // Method overriding - withdraw with overdraft facility
    void withdraw(double amount) {
        if(amount > 0 && (balance + overdraftLimit) >= amount) {
            balance -= amount;
            System.out.println("Withdrawn: " + amount);
        } else {
            System.out.println("Exceeds overdraft limit");
        }
    }
}

// Class to handle all bank operations
class BankOperations {
    private Account account;
    private String filename = "account_data.txt";
    
    // Method to create a new account - demonstrates polymorphism
    public void createAccount(Scanner sc) {
        System.out.print("Enter Account Number: ");
        String accNo = sc.nextLine();
        System.out.print("Enter Name: ");
        String name = sc.nextLine();
        System.out.print("Enter Initial Balance: ");
        double balance = sc.nextDouble();
        sc.nextLine();
        
        System.out.println("1. Savings Account");
        System.out.println("2. Current Account");
        System.out.print("Enter account type: ");
        int type = sc.nextInt();
        sc.nextLine();
        
        // Runtime polymorphism - account reference can point to SavingsAccount or CurrentAccount
        if(type == 1) {
            account = new SavingsAccount(accNo, name, balance);
        } else {
            account = new CurrentAccount(accNo, name, balance);
        }
        
        saveToFile();
        System.out.println("Account created successfully");
    }
    
    // Method to deposit money
    public void deposit(Scanner sc) {
        if(account == null) {
            System.out.println("No account found");
            return;
        }
        System.out.print("Enter amount: ");
        double amount = sc.nextDouble();
        account.deposit(amount);
        saveToFile();
    }
    
    // Method to withdraw money
    public void withdraw(Scanner sc) {
        if(account == null) {
            System.out.println("No account found");
            return;
        }
        System.out.print("Enter amount: ");
        double amount = sc.nextDouble();
        account.withdraw(amount);
        saveToFile();
    }
    
    // Method to check account balance
    public void checkBalance() {
        if(account == null) {
            System.out.println("No account found");
            return;
        }
        System.out.println("Balance: " + account.balance);
    }
    
    // Method to display account details
    public void displayDetails() {
        if(account == null) {
            System.out.println("No account found");
            return;
        }
        account.displayDetails();
    }
    
    // Method to save account data to file using BufferedWriter
    private void saveToFile() {
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            writer.write(account.getAccountData());
            writer.newLine();
        } catch(IOException e) {
            System.out.println("Error saving data: " + e.getMessage());
        }
    }
    
    // Method to load account data from file using BufferedReader
    public void loadFromFile() {
        try(BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line = reader.readLine();
            if(line != null) {
                String[] data = line.split(",");
                account = new SavingsAccount(data[0], data[1], Double.parseDouble(data[2]));
                System.out.println("Account loaded successfully");
            }
        } catch(IOException e) {
            System.out.println("No existing account found");
        }
    }
}

// Main class to run the bank management system
public class BankManagementSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BankOperations bank = new BankOperations();
        
        // Load existing account data from file if available
        bank.loadFromFile();
        
        while(true) {
            System.out.println("\n1. Create Account");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Check Balance");
            System.out.println("5. Account Details");
            System.out.println("6. Exit");
            System.out.print("Enter choice: ");
            int choice = sc.nextInt();
            sc.nextLine();
            
            switch(choice) {
                case 1: bank.createAccount(sc); break;
                case 2: bank.deposit(sc); break;
                case 3: bank.withdraw(sc); break;
                case 4: bank.checkBalance(); break;
                case 5: bank.displayDetails(); break;
                case 6:
                    System.out.println("Thank you");
                    sc.close();
                    System.exit(0);
                default: System.out.println("Invalid choice");
            }
        }
    }
}
