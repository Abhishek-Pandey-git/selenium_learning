import java.util.Scanner;

public class MathOperations {
    
    public double add(double a, double b) {
        return a + b;
    }
    
    public double subtract(double a, double b) {
        return a - b;
    }
    
    public double multiply(double a, double b) {
        return a * b;
    }
    
    public double divide(double a, double b) {
        return a / b;
    }
    
    public double remainder(double a, double b) {
        return a % b;
    }
    
    public double square(double a) {
        return a * a;
    }
    
    public double cube(double a) {
        return a * a * a;
    }
    
    public double absolute(double a) {
        if(a < 0)
            return -a;
        return a;
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        MathOperations math = new MathOperations();
        
        System.out.print("Enter first number: ");
        double num1 = sc.nextDouble();
        System.out.print("Enter second number: ");
        double num2 = sc.nextDouble();
        
        System.out.println("\nResults:");
        System.out.println("Addition: " + math.add(num1, num2));
        System.out.println("Subtraction: " + math.subtract(num1, num2));
        System.out.println("Multiplication: " + math.multiply(num1, num2));
        System.out.println("Division: " + math.divide(num1, num2));
        System.out.println("Remainder: " + math.remainder(num1, num2));
        System.out.println("Square of first number: " + math.square(num1));
        System.out.println("Cube of first number: " + math.cube(num1));
        System.out.println("Absolute of first number: " + math.absolute(num1));
        
        sc.close();
    }
}
