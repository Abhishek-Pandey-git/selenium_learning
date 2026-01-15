# Strings in Java

## What is a String?

A String is a sequence of characters. In Java, String is a **class** that represents character strings. All string literals (e.g., "Hello") are implemented as instances of the String class.

### Key Points
- Strings are **immutable** - once created, their value cannot be changed
- String is a reference type, not a primitive type
- Stored in the **String Pool** (a special memory region in heap)
- String class is in `java.lang` package (automatically imported)

---
> Too see functions for string use command "javap java.lang.String" in terminal.

## String Creation

### 1. Using String Literal
```java
String str1 = "Hello";
String str2 = "Hello";
```
- Created in **String Pool**
- If same literal exists, reference is reused
- `str1 == str2` returns `true` (same reference)

### 2. Using `new` Keyword
```java
String str3 = new String("Hello");
String str4 = new String("Hello");
```
- Created in **heap memory**
- New object created every time
- `str3 == str4` returns `false` (different references)
- `str3.equals(str4)` returns `true` (same content)

### 3. Using Character Array
```java
char[] chars = {'H', 'e', 'l', 'l', 'o'};
String str = new String(chars);
```

### 4. Using Byte Array
```java
byte[] bytes = {72, 101, 108, 108, 111};
String str = new String(bytes);
```

---

## String Immutability

Once a String object is created, it **cannot be modified**. Any operation that seems to modify a String actually creates a new String object.

```java
String str = "Hello";
str.concat(" World");
System.out.println(str);

String newStr = str.concat(" World");
System.out.println(newStr);
```

### Why Strings are Immutable?
1. **Security** - Strings are used in network connections, file paths, etc.
2. **Thread Safety** - Immutable objects are inherently thread-safe
3. **String Pool** - Enables string pooling for memory efficiency
4. **Hashcode Caching** - String's hashcode is cached for better performance

---

## Accessing String Elements

### 1. `charAt(int index)`
Returns character at specified index (0-based)
```java
String str = "Hello";
char ch = str.charAt(0);
System.out.println(ch);
```

### 2. `toCharArray()`
Converts string to character array
```java
String str = "Hello";
char[] chars = str.toCharArray();
for (char c : chars) {
    System.out.println(c);
}
```

### 3. `getChars(int srcBegin, int srcEnd, char[] dst, int dstBegin)`
Copies characters from string to char array
```java
String str = "Hello World";
char[] dest = new char[5];
str.getChars(0, 5, dest, 0);
System.out.println(dest);
```

### 4. Using Loop
```java
String str = "Hello";
for (int i = 0; i < str.length(); i++) {
    System.out.println(str.charAt(i));
}
```

---

## String Methods

### Length and Empty Check
```java
String str = "Hello";
int len = str.length();

boolean empty = str.isEmpty();

boolean blank = str.isBlank();
```

### Comparison Methods
```java
String s1 = "Hello";
String s2 = "hello";

boolean equal = s1.equals(s2);

boolean equalIgnoreCase = s1.equalsIgnoreCase(s2);

int compare = s1.compareTo(s2);

boolean startsWith = s1.startsWith("He");

boolean endsWith = s1.endsWith("lo");

boolean contains = s1.contains("ell");
```

### Search Methods
```java
String str = "Hello World";

int index = str.indexOf('o');

int lastIndex = str.lastIndexOf('o');

int indexStr = str.indexOf("World");

int notFound = str.indexOf('z');
```

### Substring Methods
```java
String str = "Hello World";

String sub1 = str.substring(6);

String sub2 = str.substring(0, 5);
```

### Case Conversion
```java
String str = "Hello World";

String upper = str.toUpperCase();

String lower = str.toLowerCase();
```

### Trim and Strip
```java
String str = "  Hello World  ";

String trimmed = str.trim();

String stripped = str.strip();

String stripLeading = str.stripLeading();

String stripTrailing = str.stripTrailing();
```

### Replace Methods
```java
String str = "Hello World";

String replaced = str.replace('o', 'a');

String replacedStr = str.replace("World", "Java");

String replaceFirst = str.replaceFirst("l", "L");

String replaceAll = str.replaceAll("l", "L");
```

### Split Method
```java
String str = "apple,banana,orange";
String[] fruits = str.split(",");

String str2 = "one two  three";
String[] words = str2.split("\\s+");
```

### Join Method (Static)
```java
String joined = String.join("-", "apple", "banana", "orange");

String[] arr = {"apple", "banana", "orange"};
String joined2 = String.join(", ", arr);
```

### Concatenation
```java
String s1 = "Hello";
String s2 = "World";

String result1 = s1 + " " + s2;

String result2 = s1.concat(" ").concat(s2);

String result3 = String.format("%s %s", s1, s2);
```

### Format Method
```java
String formatted = String.format("Name: %s, Age: %d", "John", 25);

String price = String.format("Price: $%.2f", 19.99);
```

### Repeat Method (Java 11+)
```java
String str = "Ha";
String repeated = str.repeat(3);
```

### Other Useful Methods
```java
String str = "Hello";

byte[] bytes = str.getBytes();

char[] chars = str.toCharArray();

String intern = str.intern();

boolean matches = str.matches("[A-Z][a-z]+");

int hashCode = str.hashCode();
```

---

## String Comparison

### Using `==` Operator
Compares **references** (memory addresses)
```java
String s1 = "Hello";
String s2 = "Hello";
String s3 = new String("Hello");

System.out.println(s1 == s2);
System.out.println(s1 == s3);
```

### Using `equals()` Method
Compares **content**
```java
String s1 = "Hello";
String s3 = new String("Hello");

System.out.println(s1.equals(s3));
```

### Using `compareTo()` Method
Lexicographically compares strings
```java
String s1 = "Apple";
String s2 = "Banana";

int result = s1.compareTo(s2);
```

---

## String Sorting

### Sorting String Array
```java
import java.util.Arrays;

String[] fruits = {"Banana", "Apple", "Orange", "Mango"};

Arrays.sort(fruits);
System.out.println(Arrays.toString(fruits));

Arrays.sort(fruits, Collections.reverseOrder());
System.out.println(Arrays.toString(fruits));
```

### Sorting Characters in String
```java
import java.util.Arrays;

String str = "dcba";
char[] chars = str.toCharArray();
Arrays.sort(chars);
String sorted = new String(chars);
System.out.println(sorted);
```

### Using Streams (Java 8+)
```java
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

List<String> fruits = Arrays.asList("Banana", "Apple", "Orange");
List<String> sorted = fruits.stream()
                            .sorted()
                            .collect(Collectors.toList());
```

---

## StringBuilder Class

StringBuilder is a **mutable** sequence of characters. It's used when you need to modify strings frequently.

### Key Features
- **Mutable** - can be modified without creating new objects
- **Not thread-safe** - faster than StringBuffer
- **Better performance** - for string manipulation in single-threaded environment
- Initial capacity: 16 characters (can grow automatically)

### Creating StringBuilder

```java
StringBuilder sb1 = new StringBuilder();

StringBuilder sb2 = new StringBuilder(50);

StringBuilder sb3 = new StringBuilder("Hello");

StringBuilder sb4 = new StringBuilder(charSequence);
```

### StringBuilder Methods

#### Append Methods
```java
StringBuilder sb = new StringBuilder("Hello");

sb.append(" World");

sb.append(123);

sb.append(true);

sb.append('!');

sb.append(new char[]{'a', 'b', 'c'});
```

#### Insert Methods
```java
StringBuilder sb = new StringBuilder("Hello World");

sb.insert(5, ",");

sb.insert(0, "Start: ");

sb.insert(sb.length(), " End");
```

#### Delete Methods
```java
StringBuilder sb = new StringBuilder("Hello World");

sb.delete(5, 11);

sb.deleteCharAt(0);
```

#### Replace Method
```java
StringBuilder sb = new StringBuilder("Hello World");

sb.replace(6, 11, "Java");
```

#### Reverse Method
```java
StringBuilder sb = new StringBuilder("Hello");
sb.reverse();
System.out.println(sb);
```

#### Capacity and Length
```java
StringBuilder sb = new StringBuilder();

int capacity = sb.capacity();

int length = sb.length();

sb.ensureCapacity(50);

sb.setLength(5);
```

#### Character Access and Modification
```java
StringBuilder sb = new StringBuilder("Hello");

char ch = sb.charAt(0);

sb.setCharAt(0, 'h');

String sub = sb.substring(0, 3);

sb.getChars(0, 5, destArray, 0);
```

#### Conversion
```java
StringBuilder sb = new StringBuilder("Hello");

String str = sb.toString();
```

### StringBuilder Example
```java
StringBuilder sb = new StringBuilder();
sb.append("Name: ").append("John");
sb.append(", Age: ").append(25);
sb.insert(0, "Person - ");
System.out.println(sb.toString());
```

---

## StringBuffer Class

StringBuffer is a **mutable** and **thread-safe** sequence of characters.

### Key Features
- **Mutable** - can be modified without creating new objects
- **Thread-safe** - synchronized methods, slower than StringBuilder
- **Same methods** as StringBuilder
- Initial capacity: 16 characters

### Creating StringBuffer

```java
StringBuffer sbf1 = new StringBuffer();

StringBuffer sbf2 = new StringBuffer(50);

StringBuffer sbf3 = new StringBuffer("Hello");
```

### StringBuffer Methods

All methods are same as StringBuilder but **synchronized**.

#### Append Methods
```java
StringBuffer sbf = new StringBuffer("Hello");

sbf.append(" World");

sbf.append(123);

sbf.append(true);
```

#### Insert Methods
```java
StringBuffer sbf = new StringBuffer("Hello World");

sbf.insert(5, ",");

sbf.insert(0, "Start: ");
```

#### Delete Methods
```java
StringBuffer sbf = new StringBuffer("Hello World");

sbf.delete(5, 11);

sbf.deleteCharAt(0);
```

#### Replace Method
```java
StringBuffer sbf = new StringBuffer("Hello World");

sbf.replace(6, 11, "Java");
```

#### Reverse Method
```java
StringBuffer sbf = new StringBuffer("Hello");
sbf.reverse();
System.out.println(sbf);
```

#### Capacity Methods
```java
StringBuffer sbf = new StringBuffer();

int capacity = sbf.capacity();

int length = sbf.length();

sbf.ensureCapacity(50);

sbf.trimToSize();
```

#### Character Access
```java
StringBuffer sbf = new StringBuffer("Hello");

char ch = sbf.charAt(0);

sbf.setCharAt(0, 'h');

String sub = sbf.substring(0, 3);
```

#### Conversion
```java
StringBuffer sbf = new StringBuffer("Hello");

String str = sbf.toString();
```

---

## String vs StringBuilder vs StringBuffer

| Feature | String | StringBuilder | StringBuffer |
|---------|--------|---------------|--------------|
| **Mutability** | Immutable | Mutable | Mutable |
| **Thread Safety** | Thread-safe (immutable) | Not thread-safe | Thread-safe (synchronized) |
| **Performance** | Slow (creates new objects) | Fast | Slower than StringBuilder |
| **Memory** | More memory (creates copies) | Less memory | Less memory |
| **Use Case** | When string won't change | Single-threaded manipulation | Multi-threaded manipulation |
| **Methods** | Many utility methods | Append, insert, delete, replace | Same as StringBuilder |
| **Storage** | String Pool + Heap | Heap only | Heap only |

### When to Use What?

**Use String when:**
- Value won't change
- Few concatenations
- Need immutability for security

**Use StringBuilder when:**
- Frequent modifications
- Single-threaded environment
- Need better performance

**Use StringBuffer when:**
- Frequent modifications
- Multi-threaded environment
- Need thread safety

---

## Performance Comparison

```java
long startTime, endTime;

startTime = System.currentTimeMillis();
String str = "";
for (int i = 0; i < 10000; i++) {
    str += "a";
}
endTime = System.currentTimeMillis();
System.out.println("String: " + (endTime - startTime) + "ms");

startTime = System.currentTimeMillis();
StringBuilder sb = new StringBuilder();
for (int i = 0; i < 10000; i++) {
    sb.append("a");
}
endTime = System.currentTimeMillis();
System.out.println("StringBuilder: " + (endTime - startTime) + "ms");

startTime = System.currentTimeMillis();
StringBuffer sbf = new StringBuffer();
for (int i = 0; i < 10000; i++) {
    sbf.append("a");
}
endTime = System.currentTimeMillis();
System.out.println("StringBuffer: " + (endTime - startTime) + "ms");
```

---

## Complete Examples

### Example 1: String Manipulation
```java
public class StringExample {
    public static void main(String[] args) {
        String str = "  Hello World  ";
        
        System.out.println("Original: '" + str + "'");
        System.out.println("Length: " + str.length());
        System.out.println("Trimmed: '" + str.trim() + "'");
        System.out.println("Uppercase: " + str.toUpperCase());
        System.out.println("Replace: " + str.replace("World", "Java"));
        System.out.println("Substring: " + str.substring(2, 7));
        System.out.println("Contains 'World': " + str.contains("World"));
        
        String[] parts = str.trim().split(" ");
        System.out.println("Split: " + Arrays.toString(parts));
    }
}
```

### Example 2: StringBuilder Operations
```java
public class StringBuilderExample {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder("Hello");
        
        sb.append(" World");
        System.out.println("After append: " + sb);
        
        sb.insert(5, ",");
        System.out.println("After insert: " + sb);
        
        sb.delete(5, 6);
        System.out.println("After delete: " + sb);
        
        sb.replace(0, 5, "Hi");
        System.out.println("After replace: " + sb);
        
        sb.reverse();
        System.out.println("After reverse: " + sb);
        
        sb.reverse();
        sb.setCharAt(0, 'h');
        System.out.println("Final: " + sb);
    }
}
```

### Example 3: StringBuffer with Thread Safety
```java
public class StringBufferExample {
    public static void main(String[] args) {
        StringBuffer sbf = new StringBuffer("Initial");
        
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                sbf.append(" T1");
            }
        });
        
        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                sbf.append(" T2");
            }
        });
        
        t1.start();
        t2.start();
        
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        System.out.println(sbf);
    }
}
```

### Example 4: Palindrome Check
```java
public class PalindromeCheck {
    public static void main(String[] args) {
        String str = "madam";
        
        StringBuilder sb = new StringBuilder(str);
        String reversed = sb.reverse().toString();
        
        if (str.equals(reversed)) {
            System.out.println(str + " is a palindrome");
        } else {
            System.out.println(str + " is not a palindrome");
        }
    }
}
```

### Example 5: Count Vowels and Consonants
```java
public class CountCharacters {
    public static void main(String[] args) {
        String str = "Hello World";
        int vowels = 0, consonants = 0;
        
        str = str.toLowerCase();
        
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch >= 'a' && ch <= 'z') {
                if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                    vowels++;
                } else {
                    consonants++;
                }
            }
        }
        
        System.out.println("Vowels: " + vowels);
        System.out.println("Consonants: " + consonants);
    }
}
```

---

## Common String Operations Summary

### Accessing Elements
- `charAt(index)` - get character at index
- `toCharArray()` - convert to char array
- Loop with `charAt(i)` - iterate through characters

### Modifying (Creates New String)
- `concat()` - concatenate strings
- `replace()` - replace characters/substrings
- `substring()` - extract substring
- `toLowerCase()` / `toUpperCase()` - change case
- `trim()` / `strip()` - remove whitespace

### StringBuilder/StringBuffer Modifications (In-place)
- `append()` - add at end
- `insert()` - add at specific position
- `delete()` / `deleteCharAt()` - remove characters
- `replace()` - replace range
- `reverse()` - reverse the sequence
- `setCharAt()` - modify single character

### Searching
- `indexOf()` - find first occurrence
- `lastIndexOf()` - find last occurrence
- `contains()` - check if substring exists
- `startsWith()` / `endsWith()` - check prefix/suffix

### Comparison
- `equals()` - content equality
- `equalsIgnoreCase()` - case-insensitive equality
- `compareTo()` - lexicographic comparison
- `==` - reference equality

### Sorting
- `Arrays.sort()` - sort string array
- Convert to char array and sort - sort characters in string
- Use streams with `sorted()` - functional approach

---

## Best Practices

1. **Use String for immutable data**
2. **Use StringBuilder for single-threaded string manipulation**
3. **Use StringBuffer only when thread safety is required**
4. **Avoid string concatenation with `+` in loops** (use StringBuilder instead)
5. **Use `equals()` for string comparison**, not `==`
6. **Use String literals when possible** (for String Pool benefits)
7. **Consider using `String.format()` or `StringBuilder` for complex concatenations**
8. **Use `intern()` carefully** (can lead to memory issues)
9. **Prefer `isEmpty()` over `length() == 0`**
10. **Use `isBlank()` (Java 11+) to check for whitespace-only strings**

---

## Summary

- **String**: Immutable, thread-safe, stored in String Pool, use for fixed values
- **StringBuilder**: Mutable, not thread-safe, faster, use for single-threaded modifications
- **StringBuffer**: Mutable, thread-safe, slower, use for multi-threaded modifications
- All three classes provide rich methods for string manipulation
- Choose based on mutability requirements and thread safety needs
- StringBuilder is generally preferred for string manipulation due to better performance
