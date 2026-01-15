# Vector in Java

## What is Vector?

`Vector` is a **synchronized**, resizable array implementation of the `List` interface. It was part of Java 1.0 (before Collections Framework).

```java
import java.util.Vector;
```

---

## Key Characteristics

| Property | Description |
|----------|-------------|
| **Synchronized** | Thread-safe (all methods are synchronized) |
| **Dynamic Size** | Grows automatically when full |
| **Allows Duplicates** | Yes |
| **Allows Null** | Yes |
| **Maintains Order** | Insertion order preserved |
| **Legacy Class** | Prefer `ArrayList` for single-threaded use |

---

## Creating a Vector

```java
// 1. Default constructor (initial capacity = 10)
Vector<String> v1 = new Vector<>();

// 2. With initial capacity
Vector<String> v2 = new Vector<>(20);

// 3. With capacity and increment value
Vector<String> v3 = new Vector<>(10, 5);  // capacity=10, grows by 5

// 4. From another collection
Vector<String> v4 = new Vector<>(existingList);
```

---

## Common Methods with Return Types

### Adding Elements

| Method | Returns | Description |
|--------|---------|-------------|
| `add(E e)` | `boolean` | Adds element at end, returns true |
| `add(int index, E e)` | `void` | Inserts at index |
| `addElement(E e)` | `void` | Legacy method, adds at end |
| `addAll(Collection c)` | `boolean` | Adds all elements |
| `addAll(int index, Collection c)` | `boolean` | Inserts all at index |
| `insertElementAt(E e, int index)` | `void` | Legacy insert method |

```java
Vector<String> v = new Vector<>();
v.add("Apple");                    // returns true
v.add(0, "Banana");                // void - inserts at index 0
v.addElement("Cherry");            // void - legacy method
v.addAll(Arrays.asList("D", "E")); // returns true
```

### Accessing Elements

| Method | Returns | Description |
|--------|---------|-------------|
| `get(int index)` | `E` | Element at index |
| `elementAt(int index)` | `E` | Legacy get method |
| `firstElement()` | `E` | First element |
| `lastElement()` | `E` | Last element |
| `subList(int from, int to)` | `List<E>` | View of portion |

```java
Vector<String> v = new Vector<>(Arrays.asList("A", "B", "C", "D"));

String s1 = v.get(1);           // "B"
String s2 = v.elementAt(2);     // "C"
String first = v.firstElement(); // "A"
String last = v.lastElement();   // "D"
List<String> sub = v.subList(1, 3); // ["B", "C"]
```

### Modifying Elements

| Method | Returns | Description |
|--------|---------|-------------|
| `set(int index, E e)` | `E` | Replaces, returns old value |
| `setElementAt(E e, int index)` | `void` | Legacy replace method |
| `replaceAll(UnaryOperator op)` | `void` | Replaces all using function |

```java
Vector<String> v = new Vector<>(Arrays.asList("A", "B", "C"));

String old = v.set(1, "X");      // returns "B", vector is [A, X, C]
v.setElementAt("Y", 0);          // void, vector is [Y, X, C]
v.replaceAll(s -> s.toLowerCase()); // [y, x, c]
```

### Removing Elements

| Method | Returns | Description |
|--------|---------|-------------|
| `remove(int index)` | `E` | Removes at index, returns removed |
| `remove(Object o)` | `boolean` | Removes first occurrence |
| `removeElement(Object o)` | `boolean` | Legacy remove |
| `removeElementAt(int index)` | `void` | Legacy remove at index |
| `removeAllElements()` | `void` | Legacy clear |
| `removeAll(Collection c)` | `boolean` | Removes all in c |
| `removeIf(Predicate p)` | `boolean` | Removes matching elements |
| `clear()` | `void` | Removes all elements |

```java
Vector<String> v = new Vector<>(Arrays.asList("A", "B", "C", "B", "D"));

String removed = v.remove(0);    // returns "A", vector is [B, C, B, D]
boolean b1 = v.remove("B");      // returns true, removes first B → [C, B, D]
v.removeIf(s -> s.equals("B"));  // removes all "B" → [C, D]
v.clear();                       // vector is empty
```

### Searching

| Method | Returns | Description |
|--------|---------|-------------|
| `contains(Object o)` | `boolean` | True if present |
| `containsAll(Collection c)` | `boolean` | True if all present |
| `indexOf(Object o)` | `int` | First index, or -1 |
| `indexOf(Object o, int start)` | `int` | First index from start |
| `lastIndexOf(Object o)` | `int` | Last index, or -1 |
| `lastIndexOf(Object o, int start)` | `int` | Last index searching backward |

```java
Vector<String> v = new Vector<>(Arrays.asList("A", "B", "C", "B", "D"));

boolean has = v.contains("B");       // true
int first = v.indexOf("B");          // 1
int fromIdx = v.indexOf("B", 2);     // 3 (search from index 2)
int last = v.lastIndexOf("B");       // 3
```

### Size and Capacity

| Method | Returns | Description |
|--------|---------|-------------|
| `size()` | `int` | Number of elements |
| `capacity()` | `int` | Current capacity |
| `isEmpty()` | `boolean` | True if empty |
| `setSize(int size)` | `void` | Sets size (truncates or adds nulls) |
| `ensureCapacity(int min)` | `void` | Ensures minimum capacity |
| `trimToSize()` | `void` | Trims capacity to size |

```java
Vector<String> v = new Vector<>(20);  // capacity = 20
v.addAll(Arrays.asList("A", "B", "C"));

int size = v.size();           // 3
int cap = v.capacity();        // 20
v.trimToSize();                // capacity now 3
v.ensureCapacity(50);          // capacity now 50
```

### Converting

| Method | Returns | Description |
|--------|---------|-------------|
| `toArray()` | `Object[]` | Array of elements |
| `toArray(T[] a)` | `T[]` | Typed array |
| `elements()` | `Enumeration<E>` | Legacy iterator |
| `iterator()` | `Iterator<E>` | Iterator |
| `listIterator()` | `ListIterator<E>` | Bi-directional iterator |

```java
Vector<String> v = new Vector<>(Arrays.asList("A", "B", "C"));

Object[] arr1 = v.toArray();
String[] arr2 = v.toArray(new String[0]);

// Using Enumeration (legacy)
Enumeration<String> e = v.elements();
while (e.hasMoreElements()) {
    System.out.println(e.nextElement());
}
```

---

## Complete Example

```java
import java.util.*;

public class VectorDemo {
    public static void main(String[] args) {
        // Create Vector
        Vector<Integer> numbers = new Vector<>();
        
        // Add elements
        numbers.add(10);
        numbers.add(20);
        numbers.add(30);
        numbers.addElement(40);  // legacy
        numbers.add(1, 15);      // insert at index 1
        System.out.println("After adding: " + numbers);  // [10, 15, 20, 30, 40]
        
        // Access elements
        System.out.println("First: " + numbers.firstElement());  // 10
        System.out.println("Last: " + numbers.lastElement());    // 40
        System.out.println("At index 2: " + numbers.get(2));     // 20
        
        // Modify
        int old = numbers.set(2, 25);
        System.out.println("Replaced " + old + " with 25: " + numbers);
        
        // Search
        System.out.println("Contains 25? " + numbers.contains(25));  // true
        System.out.println("Index of 25: " + numbers.indexOf(25));   // 2
        
        // Size and capacity
        System.out.println("Size: " + numbers.size());
        System.out.println("Capacity: " + numbers.capacity());
        
        // Remove
        numbers.remove(Integer.valueOf(15));  // remove by value
        numbers.remove(0);                     // remove by index
        System.out.println("After removal: " + numbers);
        
        // Iterate
        System.out.print("Elements: ");
        for (int num : numbers) {
            System.out.print(num + " ");
        }
        
        // Stream (Java 8+)
        int sum = numbers.stream().mapToInt(Integer::intValue).sum();
        System.out.println("\nSum: " + sum);
    }
}
```

---

## Vector vs ArrayList

| Aspect | Vector | ArrayList |
|--------|--------|-----------|
| **Synchronization** | Synchronized | Not synchronized |
| **Performance** | Slower | Faster |
| **Growth** | Doubles capacity | Grows by 50% |
| **Legacy Methods** | Yes (`addElement`, etc.) | No |
| **Thread Safety** | Built-in | Use `Collections.synchronizedList()` |
| **When to Use** | Legacy code only | Preferred choice |

---

## Important Points to Remember

1. **Avoid Vector for new code** - Use `ArrayList` + `Collections.synchronizedList()` or `CopyOnWriteArrayList`

2. **Synchronization overhead** - Every method call acquires a lock, even for read operations

3. **Capacity doubling** - Vector doubles its size when full (ArrayList grows by 50%)

4. **Legacy methods** - `addElement()`, `removeElement()`, `elementAt()` are legacy; prefer `add()`, `remove()`, `get()`

5. **Enumeration vs Iterator** - Use `iterator()` instead of `elements()`

6. **Null values** - Allowed but can cause `NullPointerException` in operations

7. **Fail-fast iterator** - Throws `ConcurrentModificationException` if modified during iteration

```java
// Modern alternative to Vector
List<String> syncList = Collections.synchronizedList(new ArrayList<>());

// Or for concurrent access
CopyOnWriteArrayList<String> cowList = new CopyOnWriteArrayList<>();
```

---

## Quick Reference

```java
Vector<T> v = new Vector<>();     // Create
v.add(element);                   // Add at end
v.add(index, element);            // Insert at index
v.get(index);                     // Access by index
v.set(index, element);            // Replace
v.remove(index);                  // Remove by index
v.remove(object);                 // Remove by value
v.contains(object);               // Check existence
v.indexOf(object);                // Find index
v.size();                         // Element count
v.capacity();                     // Current capacity
v.isEmpty();                      // Check if empty
v.clear();                        // Remove all
v.toArray();                      // Convert to array
```
