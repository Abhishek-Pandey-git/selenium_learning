# Lambda Functions in Java

## Definition
A **lambda function** (or lambda expression) in Java is an anonymous function—i.e., a function without a name—that can be used to provide the implementation of a functional interface (an interface with a single abstract method). Introduced in Java 8, lambda expressions enable clearer and more concise code, especially when working with collections and functional-style operations.

## Syntax
```java
(parameters) -> expression
// or
(parameters) -> { statements }
```
**Example:**
```java
(int a, int b) -> a + b
```

## Usage
- Used primarily to implement methods of functional interfaces (e.g., Runnable, Comparator, Predicate).
- Commonly used with Java Streams API for operations like `map`, `filter`, and `forEach`.
- Helps write cleaner, more readable code by reducing boilerplate.

**Example:**
```java
List<String> names = Arrays.asList("Alice", "Bob", "Charlie");
names.forEach(name -> System.out.println(name));
```

## Dos and Don'ts

### Dos
- Use lambda expressions for short, simple implementations.
- Use them with functional interfaces.
- Use them to improve code readability and reduce verbosity.

### Don'ts
- Avoid using lambdas for complex logic—prefer regular methods for clarity.
- Don't use lambdas where checked exceptions need to be handled inside the lambda (unless necessary).
- Don't overuse lambdas; excessive use can make code harder to debug.

## What You Can Do
- Access final or effectively final variables from the enclosing scope.
- Pass lambdas as arguments to methods.
- Return lambdas from methods.

## What You Cannot Do
- Cannot access non-final local variables (unless they are effectively final).
- Cannot declare checked exceptions not specified by the functional interface.
- Cannot have state (fields) or constructors.

## Key Points to Remember
- Lambda expressions are for functional interfaces only.
- They improve code brevity and readability.
- Use them judiciously for simple, stateless operations.
