# Selenium Learning



---

## 📚 Table of Contents

- [Selenium Learning](#selenium-learning)
  - [📚 Table of Contents](#-table-of-contents)
  - [Assignments](#assignments)
    - [Assignment 1: Java Fundamentals](#assignment-1-java-fundamentals)
    - [Assignment 2: OOP and Interfaces](#assignment-2-oop-and-interfaces)
    - [Assignment 3: Java Collections Framework](#assignment-3-java-collections-framework)
    - [Assignment 4: JDBC Database Operations](#assignment-4-jdbc-database-operations)
    - [Assignment 5: Agile Project Reports](#assignment-5-agile-project-reports)
    - [Assignment 6: Manual Testing Reports](#assignment-6-manual-testing-reports)
  - [Mini Projects](#mini-projects)
    - [Mini Project 1: Bank Management System](#mini-project-1-bank-management-system)
    - [Mini Project 2: Employee Management System](#mini-project-2-employee-management-system)
    - [Mini Project 3: Student Management System](#mini-project-3-student-management-system)
  - [🛠️ Technologies Used](#️-technologies-used)
  - [📝 How to Run](#-how-to-run)
    - [Prerequisites:](#prerequisites)
    - [Running Java Files:](#running-java-files)
    - [Database Setup (for JDBC projects):](#database-setup-for-jdbc-projects)

---

## Assignments

### Assignment 1: Java Fundamentals

This assignment focuses on core Java programming concepts including arrays, strings, mathematical operations, and exception handling.

**Files:**
- **ArrayOperations.java** - Implements array manipulation operations including:
  - Array creation and initialization
  - Insert, delete, and search operations
  - Array traversal and display

- **BankManagement.java** - Demonstrates exception handling with a banking system:
  - Custom exceptions: `InsufficientBalanceException`, `InvalidAmountException`
  - Banking operations: deposit, withdraw, balance check
  - Exception handling for invalid transactions

- **MathOperations.java** - Basic mathematical operations:
  - Addition, subtraction, multiplication, division
  - Remainder, square, and cube calculations
  - Method overloading demonstrations

- **MatrixOperations.java** - 2D array operations:
  - Matrix addition and subtraction
  - Matrix multiplication
  - Matrix transpose and display

- **StringOperationsDemo.java** - String manipulation and comparison:
  - String vs StringBuffer vs StringBuilder differences
  - Common String methods (length, charAt, substring, etc.)
  - String concatenation and comparison

---

### Assignment 2: OOP and Interfaces

This assignment covers object-oriented programming concepts, interfaces, collections, and regular expressions.

**Files:**
- **BankWithInterfaces.java** - Interface implementation in banking:
  - `Banking` interface: deposit, withdraw, getBalance
  - `CustomerService` interface: displayAccountInfo, updateContactInfo
  - Exception handling with custom exceptions
  - Multi-interface implementation

- **EmployeeRecords.java** - Employee management using HashMap:
  - Employee class with attributes (ID, name, salary)
  - CRUD operations using HashMap
  - Search and display functionality
  - Input validation with regex

- **RegexValidation.java** - Regular expression validation:
  - Mobile number validation (10-digit Indian format)
  - Email validation
  - Username validation (5-15 alphanumeric characters)
  - Password validation (minimum 8 chars with uppercase, lowercase, digit, special char)

- **StudentRecords.java** - Student management using ArrayList:
  - Student class with roll number, name, age
  - ArrayList-based operations
  - Add, remove, search, and display students
  - Input validation

- **UniversityManagement.java** - Advanced collection operations:
  - HashMap for student records
  - TreeMap conversion for sorted data
  - Set for unique courses
  - Student sorting by marks
  - Course-wise student count

---

### Assignment 3: Java Collections Framework

This assignment explores different collection types and their methods in detail.

**Files:**
- **ArrayListDemo.java** - ArrayList constructors and methods:
  - Default, capacity-based, and collection-based constructors
  - Methods: add, get, set, remove, size, contains, indexOf, subList
  - ArrayList traversal techniques

- **HashMapDemo.java** - HashMap operations:
  - Various constructors (default, capacity, load factor)
  - Methods: put, get, putIfAbsent, remove, containsKey, containsValue
  - KeySet, values, and entrySet demonstrations

- **HashtableDemo.java** - Hashtable (synchronized Map):
  - Constructor variations
  - Thread-safe operations
  - Methods: put, get, remove, contains, keys, elements
  - Comparison with HashMap

- **TreeMapDemo.java** - TreeMap (sorted Map):
  - Sorted map implementation
  - Comparator-based sorting
  - Methods: firstKey, lastKey, headMap, tailMap, subMap
  - NavigableMap features

- **VectorDemo.java** - Vector (synchronized ArrayList):
  - Capacity and increment constructors
  - Methods: add, addElement, get, firstElement, lastElement
  - Thread-safe list operations

---

### Assignment 4: JDBC Database Operations

This assignment demonstrates database connectivity and operations using JDBC with MySQL.

**Files:**
- **JDBCConnection.java** - Basic database connection:
  - MySQL JDBC driver loading
  - Connection establishment
  - Connection success/failure handling

- **CreateTableAndInsert.java** - Table creation and data insertion:
  - Creates `Students` table with columns: Eno, Name, Branch, Percentage, Semester, YearOfPassing
  - Inserts sample student records
  - Uses Statement for SQL execution

- **DisplayECSem7.java** - Data retrieval with filtering:
  - Displays students from EC branch, Semester 7
  - Uses SELECT query with WHERE clause
  - ResultSet processing and display

- **UpdateCSEPercentage.java** - Data update operations:
  - Increases percentage by 5% for CSE branch students
  - Uses UPDATE query
  - Displays affected row count

- **DeleteCivil2024.java** - Data deletion:
  - Deletes Civil branch students with passing year 2024
  - Uses DELETE query with multiple conditions
  - Confirms deletion with row count

---

### Assignment 5: Agile Project Reports

This assignment contains detailed Agile project planning and sprint documentation for various domains.

**Files:**
- **AutomatedBanking_Project_Report.md** - Banking system Agile project:
  - 20-week Agile project plan
  - Sprint-wise breakdown for online banking features
  - User stories for authentication, fund transfers, bill payments, loans, and card management
  - Team structure and Agile ceremonies

- **CRM_Project_Report.md** - Customer Relationship Management system:
  - 12-week CRM development plan
  - Sprints covering user management, lead tracking, sales pipeline, and marketing automation
  - Analytics and reporting features
  - Agile methodology implementation

- **ECommerce_Project_Report.md** - E-commerce platform:
  - Online shopping platform development
  - Product catalog, cart, payment, and order management
  - Customer reviews and recommendations

- **Healthcare_Project_Report.md** - Healthcare management system:
  - Patient management and appointment scheduling
  - Medical records and prescription management
  - Doctor-patient portal

- **TravelBooking_Project_Report.md** - Travel booking platform:
  - Flight, hotel, and package booking system
  - Payment gateway integration
  - Itinerary management

---

### Assignment 6: Manual Testing Reports

This assignment provides comprehensive manual test case documentation for various applications.

**Files:**
- **AutomatedBanking_TestCase_Report.md** - Banking system test cases:
  - Test cases for registration, login with OTP
  - Account balance and transaction history verification
  - Fund transfer testing (own accounts and beneficiaries)
  - Bill payment and loan application testing
  - Card management test scenarios

- **CRM_TestCase_Report.md** - CRM system test cases:
  - User management and authentication testing
  - Customer database CRUD operations
  - Lead and sales pipeline testing
  - Communication and activity tracking
  - Marketing campaign validation

- **ECommerce_TestCase_Report.md** - E-commerce platform testing:
  - Product search and filtering
  - Shopping cart operations
  - Checkout and payment processing
  - Order tracking and cancellation

- **Healthcare_TestCase_Report.md** - Healthcare system testing:
  - Patient registration and login
  - Appointment booking and cancellation
  - Medical record access
  - Prescription management

- **TravelBooking_TestCase_Report.md** - Travel booking testing:
  - Flight search and booking
  - Hotel reservation
  - Payment processing
  - Booking confirmation and cancellation

---

## Mini Projects

### Mini Project 1: Bank Management System

A comprehensive banking application demonstrating OOP concepts with file handling.

**Features:**
- **Abstract Class Implementation**: Account as abstract base class
- **Inheritance**: SavingsAccount and CurrentAccount extending Account
- **Polymorphism**: Method overriding for deposit and withdraw
- **File I/O**: Persistent storage of account data
- **Account Operations**:
  - Create account (Savings/Current)
  - Deposit money
  - Withdraw money
  - Display account details
  - Calculate and add interest (Savings)
  - Check minimum balance (Current)
- **Data Persistence**: Saves account data to `accounts.txt`

**Key Concepts:**
- Abstract methods
- Method overriding
- File handling with BufferedReader/BufferedWriter
- Exception handling for invalid transactions

---

### Mini Project 2: Employee Management System

An employee database management application using collections and file handling.

**Features:**
- **Employee Management**:
  - Add new employee records
  - Display all employees
  - Search employee by ID
  - Update employee salary
  - Delete employee records
  - Filter by department
  - Sort employees by salary
- **Collection Framework**: Uses HashMap for efficient employee storage and retrieval
- **File Persistence**: Saves employee data to `employees.txt`
- **Department-wise Operations**: Filter and display employees by department
- **Salary Management**: Update and sort by salary

**Key Concepts:**
- HashMap operations
- File I/O with BufferedReader/BufferedWriter
- Collection sorting with Comparator
- Stream API for filtering

---

### Mini Project 3: Student Management System

A student database management application using JDBC with MySQL.

**Features:**
- **Authentication**: Login system with username and password
- **Database Operations**:
  - Create Students table
  - Add new student records
  - Display all students
  - Search student by enrollment number
  - Update student details
  - Delete student records
  - Calculate and display percentage statistics
- **Custom Exceptions**:
  - `DuplicateEnoException`: Prevents duplicate enrollment numbers
  - `InvalidPercentageException`: Validates percentage (0-100)
  - `EmptyFieldException`: Ensures all fields are filled
- **JDBC Features**:
  - Connection management
  - PreparedStatement for SQL injection prevention
  - ResultSet processing
  - Exception handling

**Database Schema:**
```sql
Table: Students
- Eno (INT) - Primary Key
- Name (VARCHAR)
- Branch (VARCHAR)
- Percentage (DOUBLE)
- Semester (INT)
```

**Key Concepts:**
- JDBC connectivity
- PreparedStatement vs Statement
- Custom exception handling
- Database CRUD operations
- Input validation

---

## 🛠️ Technologies Used

- **Language**: Java (JDK 8+)
- **Database**: MySQL
- **JDBC Driver**: MySQL Connector/J
- **Concepts**: OOP, Collections, Exception Handling, File I/O, JDBC, Regex

---

## 📝 How to Run

### Prerequisites:
1. Install JDK 8 or higher
2. Install MySQL Server (for JDBC assignments and Mini Project 3)
3. Add MySQL JDBC driver to classpath

### Running Java Files:
```bash
# Compile
javac FileName.java

# Run
java FileName
```

### Database Setup (for JDBC projects):
```sql
CREATE DATABASE studentdb;
USE studentdb;
```

---

