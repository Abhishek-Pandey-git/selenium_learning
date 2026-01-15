# Arrays in Java

## What is an Array?

An array is a container object that holds a **fixed number of values** of a **single type**. The length of an array is established when the array is created and remains fixed throughout its lifetime.

### Key Points
- Arrays store multiple values of the same data type
- Arrays have a fixed size that cannot be changed after creation
- Array elements are stored in contiguous memory locations
- Arrays use zero-based indexing (first element is at index 0)

---

## Array Declaration in Java

### Syntax
```java
dataType[] arrayName;    // Preferred way
// OR
dataType arrayName[];    // C-style (also valid)
```

### Examples
```java
int[] numbers;           // Declares an array of integers
String[] names;          // Declares an array of strings
double[] prices;         // Declares an array of doubles
char[] letters;          // Declares an array of characters
```

---

## Different Ways to Declare and Initialize Arrays

### 1. Declaration and Memory Allocation Separately
```java
int[] arr;                    // Declaration
arr = new int[5];            // Memory allocation for 5 integers
```

### 2. Declaration and Instantiation Together
```java
int[] arr = new int[5];      // Declares and allocates memory
```

### 3. Declaration, Instantiation, and Initialization Together
```java
int[] arr = {10, 20, 30, 40, 50};  // All in one step
// OR
int[] arr = new int[]{10, 20, 30, 40, 50};
```

### 4. Anonymous Array
```java
// Array without reference variable (passed directly to method)
printArray(new int[]{1, 2, 3, 4, 5});
```

### 5. Multidimensional Arrays
```java
// 2D Array Declaration
int[][] matrix = new int[3][4];        // 3 rows, 4 columns

// 2D Array with Initialization
int[][] matrix = {
    {1, 2, 3},
    {4, 5, 6},
    {7, 8, 9}
};

// Jagged Array (arrays of different lengths)
int[][] jagged = new int[3][];
jagged[0] = new int[2];
jagged[1] = new int[4];
jagged[2] = new int[3];
```

---

## Arrays as Objects in Java

In Java, **arrays are objects**. This means:

1. **Arrays are created using the `new` keyword** (except when using literal initialization)
2. **Arrays are stored in heap memory**
3. **Array reference variables are stored in stack memory**
4. **Arrays have a `length` property** (not a method)
5. **Arrays inherit from Object class**

### Proof that Arrays are Objects
```java
int[] arr = new int[5];

// Arrays have the length property
System.out.println(arr.length);  // Output: 5

// Arrays can be passed to methods expecting Object
Object obj = arr;

// Arrays have a class
System.out.println(arr.getClass());  // Output: class [I

// Arrays can use Object class methods
System.out.println(arr.toString());
System.out.println(arr.hashCode());
```

### Array Class Naming Convention
- `[I` = int array
- `[D` = double array
- `[L` + classname = Object array (e.g., `[Ljava.lang.String;`)
- `[[I` = 2D int array

---

## Inserting/Accessing Values in Arrays

### Accessing Array Elements
```java
int[] numbers = new int[5];

// Inserting values using index
numbers[0] = 10;
numbers[1] = 20;
numbers[2] = 30;
numbers[3] = 40;
numbers[4] = 50;

// Accessing values
System.out.println(numbers[0]);  // Output: 10
System.out.println(numbers[2]);  // Output: 30
```

### Array Index Bounds
```java
int[] arr = new int[5];
// Valid indices: 0, 1, 2, 3, 4
// arr[5] would throw ArrayIndexOutOfBoundsException
```

### Default Values
When an array is created, elements are initialized with default values:
- `int`, `short`, `byte`, `long`: `0`
- `float`, `double`: `0.0`
- `boolean`: `false`
- `char`: `'\u0000'` (null character)
- Object references: `null`

```java
int[] numbers = new int[3];
System.out.println(numbers[0]);  // Output: 0

String[] names = new String[3];
System.out.println(names[0]);    // Output: null
```

---

## Traversing Arrays

### 1. Using Traditional for Loop
```java
int[] numbers = {10, 20, 30, 40, 50};

for (int i = 0; i < numbers.length; i++) {
    System.out.println(numbers[i]);
}
```

### 2. Using Enhanced for Loop (for-each)
```java
int[] numbers = {10, 20, 30, 40, 50};

for (int num : numbers) {
    System.out.println(num);
}
```

### 3. Using while Loop
```java
int[] numbers = {10, 20, 30, 40, 50};
int i = 0;

while (i < numbers.length) {
    System.out.println(numbers[i]);
    i++;
}
```

### 4. Using Streams (Java 8+)
```java
int[] numbers = {10, 20, 30, 40, 50};

Arrays.stream(numbers).forEach(System.out::println);
```

### Traversing 2D Arrays
```java
int[][] matrix = {
    {1, 2, 3},
    {4, 5, 6},
    {7, 8, 9}
};

// Using nested loops
for (int i = 0; i < matrix.length; i++) {
    for (int j = 0; j < matrix[i].length; j++) {
        System.out.print(matrix[i][j] + " ");
    }
    System.out.println();
}

// Using enhanced for loop
for (int[] row : matrix) {
    for (int element : row) {
        System.out.print(element + " ");
    }
    System.out.println();
}
```

---

## Characteristics of Arrays in Java

### 1. **Fixed Size**
- Once created, the size cannot be changed
- To resize, you must create a new array

### 2. **Homogeneous Elements**
- All elements must be of the same data type
- Exception: Object arrays can hold different types if they inherit from the same parent class

### 3. **Contiguous Memory Allocation**
- Array elements are stored in consecutive memory locations
- Enables fast access using index (O(1) time complexity)

### 4. **Zero-Based Indexing**
- First element is at index 0
- Last element is at index (length - 1)

### 5. **Type Safety**
- Arrays are type-checked at compile time
- Prevents storing wrong data types

### 6. **Primitive and Reference Types**
- Arrays can hold both primitive types and object references

### 7. **Length Property**
- Every array has a `length` property (not method)
- Read-only property that returns the number of elements

### 8. **Cloneable**
- Arrays implement the Cloneable interface
- Can be cloned using `clone()` method

```java
int[] original = {1, 2, 3};
int[] copy = original.clone();
```

### 9. **Serializable**
- Arrays implement Serializable interface
- Can be serialized and deserialized

### 10. **Default Initialization**
- Array elements are automatically initialized with default values

---

## Arrays Class and Its Methods

The `java.util.Arrays` class contains various static methods for manipulating arrays.

### Import Statement
```java
import java.util.Arrays;
```

### Common Methods

#### 1. **toString()**
Converts array to string representation
```java
int[] arr = {1, 2, 3, 4, 5};
System.out.println(Arrays.toString(arr));  
// Output: [1, 2, 3, 4, 5]

// For 2D arrays
int[][] matrix = {{1, 2}, {3, 4}};
System.out.println(Arrays.deepToString(matrix));
// Output: [[1, 2], [3, 4]]
```

#### 2. **sort()**
Sorts array in ascending order
```java
int[] arr = {5, 2, 8, 1, 9};
Arrays.sort(arr);
System.out.println(Arrays.toString(arr));
// Output: [1, 2, 5, 8, 9]

// Sort a specific range
Arrays.sort(arr, 0, 3);  // Sort first 3 elements
```

#### 3. **binarySearch()**
Searches for an element (array must be sorted)
```java
int[] arr = {1, 2, 3, 4, 5};
int index = Arrays.binarySearch(arr, 3);
System.out.println(index);  // Output: 2

// If element not found, returns negative value
int notFound = Arrays.binarySearch(arr, 10);
// Returns: -(insertion point) - 1
```

#### 4. **fill()**
Fills array with specified value
```java
int[] arr = new int[5];
Arrays.fill(arr, 10);
System.out.println(Arrays.toString(arr));
// Output: [10, 10, 10, 10, 10]

// Fill a specific range
Arrays.fill(arr, 1, 4, 20);
// Output: [10, 20, 20, 20, 10]
```

#### 5. **copyOf()**
Creates a copy of array with specified length
```java
int[] original = {1, 2, 3, 4, 5};
int[] copy = Arrays.copyOf(original, 3);
System.out.println(Arrays.toString(copy));
// Output: [1, 2, 3]

// Larger length pads with default values
int[] extended = Arrays.copyOf(original, 7);
// Output: [1, 2, 3, 4, 5, 0, 0]
```

#### 6. **copyOfRange()**
Copies specific range of array
```java
int[] arr = {1, 2, 3, 4, 5, 6};
int[] range = Arrays.copyOfRange(arr, 2, 5);
System.out.println(Arrays.toString(range));
// Output: [3, 4, 5]
```

#### 7. **equals()**
Compares two arrays for equality
```java
int[] arr1 = {1, 2, 3};
int[] arr2 = {1, 2, 3};
int[] arr3 = {1, 2, 4};

System.out.println(Arrays.equals(arr1, arr2));  // true
System.out.println(Arrays.equals(arr1, arr3));  // false

// For multidimensional arrays
System.out.println(Arrays.deepEquals(arr1, arr2));
```

#### 8. **compare()**
Lexicographically compares two arrays (Java 9+)
```java
int[] arr1 = {1, 2, 3};
int[] arr2 = {1, 2, 4};

int result = Arrays.compare(arr1, arr2);
// Returns: negative if arr1 < arr2, 0 if equal, positive if arr1 > arr2
```

#### 9. **mismatch()**
Finds first index where arrays differ (Java 9+)
```java
int[] arr1 = {1, 2, 3, 4};
int[] arr2 = {1, 2, 5, 4};

int index = Arrays.mismatch(arr1, arr2);
System.out.println(index);  // Output: 2
```

#### 10. **asList()**
Converts array to List
```java
String[] arr = {"A", "B", "C"};
List<String> list = Arrays.asList(arr);
System.out.println(list);  // Output: [A, B, C]

// Note: Returns fixed-size list backed by array
// list.add("D");  // This will throw UnsupportedOperationException
```

#### 11. **stream()**
Creates a stream from array (Java 8+)
```java
int[] arr = {1, 2, 3, 4, 5};

// Sum of elements
int sum = Arrays.stream(arr).sum();

// Filter and print
Arrays.stream(arr)
      .filter(n -> n > 2)
      .forEach(System.out::println);
```

#### 12. **setAll()** and **parallelSetAll()**
Sets all elements using a generator function
```java
int[] arr = new int[5];
Arrays.setAll(arr, i -> i * 2);
System.out.println(Arrays.toString(arr));
// Output: [0, 2, 4, 6, 8]
```

#### 13. **parallelSort()**
Sorts array using parallel sorting (Java 8+)
```java
int[] arr = {5, 2, 8, 1, 9};
Arrays.parallelSort(arr);
// Faster for large arrays
```

---

## Complete Example Program

```java
import java.util.Arrays;

public class ArraysExample {
    public static void main(String[] args) {
        // Declaration and initialization
        int[] numbers = {5, 2, 8, 1, 9, 3};
        
        System.out.println("Original Array: " + Arrays.toString(numbers));
        
        // Sorting
        Arrays.sort(numbers);
        System.out.println("Sorted Array: " + Arrays.toString(numbers));
        
        // Binary Search
        int index = Arrays.binarySearch(numbers, 8);
        System.out.println("Index of 8: " + index);
        
        // Fill
        int[] filled = new int[5];
        Arrays.fill(filled, 7);
        System.out.println("Filled Array: " + Arrays.toString(filled));
        
        // Copy
        int[] copy = Arrays.copyOf(numbers, 3);
        System.out.println("Copy: " + Arrays.toString(copy));
        
        // Traversing
        System.out.println("Traversing with enhanced for:");
        for (int num : numbers) {
            System.out.print(num + " ");
        }
        System.out.println();
        
        // Using streams
        System.out.println("Sum: " + Arrays.stream(numbers).sum());
        System.out.println("Max: " + Arrays.stream(numbers).max().getAsInt());
    }
}
```

---

## Summary

- Arrays are fixed-size, homogeneous data structures
- Arrays are objects in Java (stored in heap memory)
- Multiple ways to declare and initialize arrays
- Arrays use zero-based indexing
- Can traverse using loops or streams
- `java.util.Arrays` class provides utility methods for array manipulation
- Arrays provide O(1) access time but O(n) search time (without sorting)
- Use ArrayList or other collections when dynamic size is needed
