# Java Interfaces and Abstract Classes

## Table of Contents
1. [Abstract Classes](#abstract-classes)
2. [Interfaces](#interfaces)
3. [Comparison](#comparison)
4. [When to Use What](#when-to-use-what)

---

## Abstract Classes

### Definition
An abstract class is a class that cannot be instantiated and may contain both abstract methods (without implementation) and concrete methods (with implementation).

### Syntax
```java
abstract class ClassName {
    // Abstract method (no body)
    abstract void methodName();
    
    // Concrete method (with body)
    void concreteMethod() {
        // implementation
    }
}
```

### What You CAN Do

✅ **Declare abstract and concrete methods**
```java
abstract class Animal {
    // Abstract method
    abstract void makeSound();
    
    // Concrete method
    void sleep() {
        System.out.println("Sleeping...");
    }
}
```

✅ **Have instance variables (fields)**
```java
abstract class Vehicle {
    protected String brand;
    private int speed;
    
    public Vehicle(String brand) {
        this.brand = brand;
    }
}
```

✅ **Have constructors**
```java
abstract class Shape {
    protected String color;
    
    // Constructor
    public Shape(String color) {
        this.color = color;
    }
}
```

✅ **Use access modifiers (public, private, protected)**
```java
abstract class Employee {
    private String name;
    protected double salary;
    public abstract void calculateBonus();
}
```

✅ **Have static methods and variables**
```java
abstract class MathOperations {
    static final double PI = 3.14159;
    
    static int add(int a, int b) {
        return a + b;
    }
    
    abstract double calculate();
}
```

✅ **Implement interfaces**
```java
interface Drawable {
    void draw();
}

abstract class GraphicObject implements Drawable {
    abstract void resize();
}
```

### What You CANNOT Do

❌ **Cannot instantiate an abstract class**
```java
abstract class Animal {
    abstract void makeSound();
}

// This will cause compilation error
// Animal animal = new Animal(); ❌
```

❌ **Cannot have abstract methods in a non-abstract class**
```java
// This will cause compilation error
class Car {  // ❌ Must be declared abstract
    abstract void start();
}
```

❌ **Abstract methods cannot be private**
```java
abstract class Test {
    // ❌ Compilation error - abstract method cannot be private
    // private abstract void method();
}
```

❌ **Abstract methods cannot be final**
```java
abstract class Test {
    // ❌ Compilation error - abstract method cannot be final
    // final abstract void method();
}
```

❌ **Abstract methods cannot be static**
```java
abstract class Test {
    // ❌ Compilation error - abstract method cannot be static
    // static abstract void method();
}
```

### Constraints

1. **Inheritance Required**: A subclass must implement all abstract methods or be declared abstract itself
2. **Single Inheritance**: A class can extend only one abstract class
3. **Access Modifiers**: Abstract methods cannot be private
4. **Must Override**: Child class must provide implementation for all abstract methods

### Complete Example

```java
// Abstract class
abstract class BankAccount {
    protected String accountNumber;
    protected double balance;
    
    // Constructor
    public BankAccount(String accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }
    
    // Abstract methods
    abstract void calculateInterest();
    abstract void withdraw(double amount);
    
    // Concrete method
    public void deposit(double amount) {
        balance += amount;
        System.out.println("Deposited: " + amount);
    }
    
    public double getBalance() {
        return balance;
    }
}

// Concrete subclass
class SavingsAccount extends BankAccount {
    private double interestRate = 0.04;
    
    public SavingsAccount(String accountNumber, double balance) {
        super(accountNumber, balance);
    }
    
    @Override
    void calculateInterest() {
        double interest = balance * interestRate;
        balance += interest;
        System.out.println("Interest added: " + interest);
    }
    
    @Override
    void withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
            System.out.println("Withdrawn: " + amount);
        } else {
            System.out.println("Insufficient balance");
        }
    }
}

// Usage
public class Main {
    public static void main(String[] args) {
        SavingsAccount account = new SavingsAccount("SA001", 1000);
        account.deposit(500);           // Output: Deposited: 500
        account.calculateInterest();    // Output: Interest added: 60.0
        account.withdraw(200);          // Output: Withdrawn: 200
        System.out.println("Balance: " + account.getBalance());
    }
}
```

---

## Interfaces

### Definition
An interface is a completely abstract type that defines a contract. It specifies what a class must do, but not how it does it.

### Syntax
```java
interface InterfaceName {
    // Abstract method (implicitly public and abstract)
    void methodName();
    
    // Default method (Java 8+)
    default void defaultMethod() {
        // implementation
    }
    
    // Static method (Java 8+)
    static void staticMethod() {
        // implementation
    }
}
```

### What You CAN Do

✅ **Declare abstract methods (implicitly public and abstract)**
```java
interface Flyable {
    void fly();  // public abstract by default
    void land();
}
```

✅ **Have constants (implicitly public, static, and final)**
```java
interface Constants {
    int MAX_SPEED = 100;  // public static final by default
    String APP_NAME = "MyApp";
}
```

✅ **Have default methods (Java 8+)**
```java
interface Drawable {
    void draw();
    
    // Default method with implementation
    default void display() {
        System.out.println("Displaying on screen");
    }
}
```

✅ **Have static methods (Java 8+)**
```java
interface MathUtils {
    static int square(int num) {
        return num * num;
    }
}
```

✅ **Have private methods (Java 9+)**
```java
interface Logger {
    default void logInfo(String message) {
        log(message, "INFO");
    }
    
    default void logError(String message) {
        log(message, "ERROR");
    }
    
    // Private helper method
    private void log(String message, String level) {
        System.out.println(level + ": " + message);
    }
}
```

✅ **Extend multiple interfaces**
```java
interface A {
    void methodA();
}

interface B {
    void methodB();
}

interface C extends A, B {
    void methodC();
}
```

✅ **Implement multiple interfaces**
```java
interface Flyable {
    void fly();
}

interface Swimmable {
    void swim();
}

class Duck implements Flyable, Swimmable {
    public void fly() {
        System.out.println("Duck flying");
    }
    
    public void swim() {
        System.out.println("Duck swimming");
    }
}
```

### What You CANNOT Do

❌ **Cannot have instance variables**
```java
interface Test {
    // ❌ Cannot have instance variables
    // String name;  // Must be initialized and becomes constant
    
    // ✅ Only constants allowed
    String NAME = "Constant";
}
```

❌ **Cannot have constructors**
```java
interface Test {
    // ❌ Compilation error - interfaces cannot have constructors
    // Test() { }
}
```

❌ **Cannot instantiate an interface**
```java
interface Drawable {
    void draw();
}

// ❌ This will cause compilation error
// Drawable d = new Drawable();
```

❌ **Cannot have protected or private methods (except private methods in Java 9+)**
```java
interface Test {
    // ❌ Cannot use protected
    // protected void method();
    
    // ✅ Can use private in Java 9+
    private void helperMethod() { }
}
```

❌ **Abstract methods cannot have implementation (unless default/static)**
```java
interface Test {
    // ❌ Abstract methods cannot have body
    // void method() { }
    
    // ✅ Default methods can have body
    default void defaultMethod() { }
}
```

### Constraints

1. **All methods are public**: Interface methods are implicitly public
2. **All fields are constants**: Variables are implicitly public, static, and final
3. **Multiple Implementation**: A class can implement multiple interfaces
4. **Implementation Required**: All abstract methods must be implemented by the class
5. **No State**: Interfaces cannot maintain state (no instance variables)

### Complete Example

```java
// Interface
interface Payment {
    // Constants
    double TAX_RATE = 0.18;
    
    // Abstract methods
    void processPayment(double amount);
    boolean validatePayment();
    
    // Default method
    default double calculateTotal(double amount) {
        return amount + (amount * TAX_RATE);
    }
    
    // Static method
    static void displayPaymentInfo() {
        System.out.println("Payment Processing System v1.0");
    }
}

// Another interface
interface Refundable {
    void processRefund(double amount);
}

// Class implementing multiple interfaces
class CreditCardPayment implements Payment, Refundable {
    private String cardNumber;
    
    public CreditCardPayment(String cardNumber) {
        this.cardNumber = cardNumber;
    }
    
    @Override
    public void processPayment(double amount) {
        if (validatePayment()) {
            double total = calculateTotal(amount);
            System.out.println("Processing credit card payment: $" + total);
        }
    }
    
    @Override
    public boolean validatePayment() {
        System.out.println("Validating card: " + cardNumber);
        return cardNumber != null && cardNumber.length() == 16;
    }
    
    @Override
    public void processRefund(double amount) {
        System.out.println("Refunding $" + amount + " to card");
    }
}

// Usage
public class Main {
    public static void main(String[] args) {
        Payment.displayPaymentInfo();  // Static method call
        
        CreditCardPayment payment = new CreditCardPayment("1234567890123456");
        payment.processPayment(100);   // Uses default calculateTotal()
        payment.processRefund(50);
    }
}
```

---

## Comparison

| Feature | Abstract Class | Interface |
|---------|---------------|-----------|
| **Methods** | Can have both abstract and concrete methods | All methods abstract (except default/static in Java 8+) |
| **Variables** | Can have instance variables | Only constants (public static final) |
| **Constructors** | Can have constructors | Cannot have constructors |
| **Access Modifiers** | Can use any access modifier | Methods are public by default |
| **Multiple Inheritance** | Single inheritance (extends one class) | Multiple inheritance (implements multiple interfaces) |
| **Instantiation** | Cannot be instantiated | Cannot be instantiated |
| **State** | Can maintain state | Cannot maintain state |
| **When to Use** | When classes share common behavior/state | When defining a contract/capability |
| **Default Methods** | All methods can have implementation | Only default methods (Java 8+) |
| **Static Methods** | Yes | Yes (Java 8+) |

---

## When to Use What

### Use Abstract Class When:

1. **Sharing Code Among Related Classes**
```java
abstract class Employee {
    protected String name;
    protected double salary;
    
    // Common constructor
    public Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }
    
    // Common method
    public void displayInfo() {
        System.out.println(name + ": $" + salary);
    }
    
    // Abstract method for specific implementation
    abstract double calculateBonus();
}

class Manager extends Employee {
    public Manager(String name, double salary) {
        super(name, salary);
    }
    
    double calculateBonus() {
        return salary * 0.20;
    }
}
```

2. **Need Instance Variables or State**
```java
abstract class GameCharacter {
    protected int health;
    protected int power;
    protected String name;
    
    abstract void attack();
    abstract void defend();
}
```

3. **Require Non-Public Members**
```java
abstract class DatabaseConnection {
    private String connectionString;
    protected boolean isConnected;
    
    protected void connect() { }
    abstract void executeQuery();
}
```

4. **Want to Provide Common Implementation**
```java
abstract class Vehicle {
    // Common implementation
    public void start() {
        System.out.println("Starting engine...");
    }
    
    // Let subclasses decide
    abstract void accelerate();
}
```

### Use Interface When:

1. **Defining a Contract/Capability**
```java
interface Comparable<T> {
    int compareTo(T other);
}

class Student implements Comparable<Student> {
    private int rollNo;
    
    public int compareTo(Student other) {
        return this.rollNo - other.rollNo;
    }
}
```

2. **Multiple Inheritance is Required**
```java
interface Flyable {
    void fly();
}

interface Swimmable {
    void swim();
}

class Duck implements Flyable, Swimmable {
    public void fly() { System.out.println("Flying"); }
    public void swim() { System.out.println("Swimming"); }
}
```

3. **Unrelated Classes Should Implement Same Methods**
```java
interface Serializable {
    String serialize();
}

class User implements Serializable {
    public String serialize() { return "User data"; }
}

class Product implements Serializable {
    public String serialize() { return "Product data"; }
}
```

4. **Want Flexibility in Implementation**
```java
interface DataStorage {
    void save(String data);
    String load();
}

class FileStorage implements DataStorage {
    public void save(String data) { /* Save to file */ }
    public String load() { return "File data"; }
}

class DatabaseStorage implements DataStorage {
    public void save(String data) { /* Save to database */ }
    public String load() { return "Database data"; }
}
```

### Real-World Example Combining Both

```java
// Interface for contract
interface Playable {
    void play();
    void pause();
    void stop();
}

// Abstract class for common functionality
abstract class MediaPlayer implements Playable {
    protected String filename;
    protected boolean isPlaying;
    
    public MediaPlayer(String filename) {
        this.filename = filename;
    }
    
    // Common implementation
    public void pause() {
        isPlaying = false;
        System.out.println("Paused: " + filename);
    }
    
    public void stop() {
        isPlaying = false;
        System.out.println("Stopped: " + filename);
    }
    
    // Abstract method for specific implementation
    public abstract void play();
}

// Concrete classes
class AudioPlayer extends MediaPlayer {
    public AudioPlayer(String filename) {
        super(filename);
    }
    
    @Override
    public void play() {
        isPlaying = true;
        System.out.println("Playing audio: " + filename);
    }
}

class VideoPlayer extends MediaPlayer {
    public VideoPlayer(String filename) {
        super(filename);
    }
    
    @Override
    public void play() {
        isPlaying = true;
        System.out.println("Playing video: " + filename);
    }
}

// Usage
public class Main {
    public static void main(String[] args) {
        Playable audio = new AudioPlayer("song.mp3");
        audio.play();
        audio.pause();
        
        Playable video = new VideoPlayer("movie.mp4");
        video.play();
        video.stop();
    }
}
```

---

## Key Takeaways

### Abstract Class:
- **Purpose**: Share code and state among closely related classes
- **Inheritance**: Single (extends)
- **Members**: Can have everything - constructors, fields, methods
- **Use Case**: "IS-A" relationship with shared implementation

### Interface:
- **Purpose**: Define contracts that unrelated classes can implement
- **Inheritance**: Multiple (implements)
- **Members**: Constants and method signatures (+ default/static methods)
- **Use Case**: "CAN-DO" capability or behavior

### Golden Rule:
- Use **abstract class** for common implementation and state
- Use **interface** for common contracts and multiple capabilities
- Often use **both**: Interface for contract, abstract class for partial implementation