import java.util.Scanner;

class InsufficientBalanceException extends Exception {
    public InsufficientBalanceException(String message) {
        super(message);
    }
}

class InvalidAmountException extends Exception {
    public InvalidAmountException(String message) {
        super(message);
    }
}

class BankAccount {
    private String accountNumber;
    private String accountHolder;
    private double balance;
    
    public BankAccount(String accountNumber, String accountHolder, double initialBalance) {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.balance = initialBalance;
    }
    
    public void deposit(double amount) throws InvalidAmountException {
        if(amount <= 0) {
            throw new InvalidAmountException("Deposit amount must be positive");
        }
        balance += amount;
        System.out.println("Deposited: " + amount);
    }
    
    public void withdraw(double amount) throws InsufficientBalanceException, InvalidAmountException {
        if(amount <= 0) {
            throw new InvalidAmountException("Withdrawal amount must be positive");
        }
        if(amount > balance) {
            throw new InsufficientBalanceException("Insufficient balance");
        }
        balance -= amount;
        System.out.println("Withdrawn: " + amount);
    }
    
    public void displayBalance() {
        System.out.println("Current Balance: " + balance);
    }
    
    public void displayAccountDetails() {
        System.out.println("\nAccount Details:");
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Account Holder: " + accountHolder);
        System.out.println("Balance: " + balance);
    }
}

public class BankManagement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        try {
            System.out.print("Enter Account Number: ");
            String accNo = sc.nextLine();
            System.out.print("Enter Account Holder Name: ");
            String name = sc.nextLine();
            System.out.print("Enter Initial Balance: ");
            double balance = sc.nextDouble();
            
            BankAccount account = new BankAccount(accNo, name, balance);
            
            while(true) {
                System.out.println("\n1. Deposit");
                System.out.println("2. Withdraw");
                System.out.println("3. Balance Enquiry");
                System.out.println("4. Account Details");
                System.out.println("5. Exit");
                System.out.print("Enter choice: ");
                int choice = sc.nextInt();
                
                switch(choice) {
                    case 1:
                        System.out.print("Enter deposit amount: ");
                        double depositAmt = sc.nextDouble();
                        account.deposit(depositAmt);
                        break;
                        
                    case 2:
                        System.out.print("Enter withdrawal amount: ");
                        double withdrawAmt = sc.nextDouble();
                        account.withdraw(withdrawAmt);
                        break;
                        
                    case 3:
                        account.displayBalance();
                        break;
                        
                    case 4:
                        account.displayAccountDetails();
                        break;
                        
                    case 5:
                        System.out.println("Thank you for using our services");
                        sc.close();
                        System.exit(0);
                        
                    default:
                        System.out.println("Invalid choice");
                }
            }
        } catch(InsufficientBalanceException e) {
            System.out.println("Error: " + e.getMessage());
        } catch(InvalidAmountException e) {
            System.out.println("Error: " + e.getMessage());
        } catch(Exception e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            sc.close();
        }
    }
}
