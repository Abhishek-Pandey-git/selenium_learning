# ArrayList in Java

## What is ArrayList?

`ArrayList` is a **resizable array** implementation of the `List` interface. It's the most commonly used collection in Java.

```java
import java.util.ArrayList;
```

---

## Key Characteristics

| Property | Description |
|----------|-------------|
| **Not Synchronized** | Not thread-safe (faster than Vector) |
| **Dynamic Size** | Grows by 50% when full |
| **Allows Duplicates** | Yes |
| **Allows Null** | Yes (multiple nulls allowed) |
| **Maintains Order** | Insertion order preserved |
| **Random Access** | O(1) access by index |

---

## Creating an ArrayList

```java
// 1. Default constructor (initial capacity = 10)
ArrayList<String> list1 = new ArrayList<>();

// 2. With initial capacity
ArrayList<String> list2 = new ArrayList<>(50);

// 3. From another collection
ArrayList<String> list3 = new ArrayList<>(existingList);

// 4. Using List.of() (Java 9+) - creates immutable, then copy
ArrayList<String> list4 = new ArrayList<>(List.of("A", "B", "C"));
```

---

## Common Methods with Return Types

### Adding Elements

| Method | Returns | Description |
|--------|---------|-------------|
| `add(E e)` | `boolean` | Adds at end, always returns true |
| `add(int index, E e)` | `void` | Inserts at specified index |
| `addAll(Collection c)` | `boolean` | Adds all elements from collection |
| `addAll(int index, Collection c)` | `boolean` | Inserts all at index |
| `addFirst(E e)` | `void` | Adds at beginning (Java 21+) |
| `addLast(E e)` | `void` | Adds at end (Java 21+) |

```java
ArrayList<String> list = new ArrayList<>();
list.add("Apple");                      // true, [Apple]
list.add(0, "Banana");                  // void, [Banana, Apple]
list.addAll(Arrays.asList("C", "D"));   // true, [Banana, Apple, C, D]
list.addAll(1, List.of("X", "Y"));      // true, [Banana, X, Y, Apple, C, D]
```

### Accessing Elements

| Method | Returns | Description |
|--------|---------|-------------|
| `get(int index)` | `E` | Element at index |
| `getFirst()` | `E` | First element (Java 21+) |
| `getLast()` | `E` | Last element (Java 21+) |
| `subList(int from, int to)` | `List<E>` | View of portion (exclusive end) |

```java
ArrayList<String> list = new ArrayList<>(List.of("A", "B", "C", "D", "E"));

String s = list.get(2);              // "C"
List<String> sub = list.subList(1, 4); // [B, C, D] - view, not copy!
```

### Modifying Elements

| Method | Returns | Description |
|--------|---------|-------------|
| `set(int index, E e)` | `E` | Replaces element, returns old value |
| `replaceAll(UnaryOperator op)` | `void` | Transforms all elements |

```java
ArrayList<String> list = new ArrayList<>(List.of("a", "b", "c"));

String old = list.set(1, "X");       // returns "b", list is [a, X, c]
list.replaceAll(String::toUpperCase); // [A, X, C]
```

### Removing Elements

| Method | Returns | Description |
|--------|---------|-------------|
| `remove(int index)` | `E` | Removes at index, returns removed |
| `remove(Object o)` | `boolean` | Removes first occurrence |
| `removeAll(Collection c)` | `boolean` | Removes all elements in c |
| `removeIf(Predicate p)` | `boolean` | Removes elements matching predicate |
| `retainAll(Collection c)` | `boolean` | Keeps only elements in c |
| `clear()` | `void` | Removes all elements |

```java
ArrayList<Integer> list = new ArrayList<>(List.of(1, 2, 3, 2, 4, 5));

Integer removed = list.remove(0);     // returns 1, list is [2, 3, 2, 4, 5]
boolean b = list.remove(Integer.valueOf(2)); // true, removes first 2 → [3, 2, 4, 5]
list.removeIf(n -> n > 3);            // [3, 2]
list.clear();                         // []
```

### Searching

| Method | Returns | Description |
|--------|---------|-------------|
| `contains(Object o)` | `boolean` | True if element exists |
| `containsAll(Collection c)` | `boolean` | True if all elements exist |
| `indexOf(Object o)` | `int` | First index of element, or -1 |
| `lastIndexOf(Object o)` | `int` | Last index of element, or -1 |

```java
ArrayList<String> list = new ArrayList<>(List.of("A", "B", "C", "B", "D"));

boolean has = list.contains("B");      // true
int first = list.indexOf("B");         // 1
int last = list.lastIndexOf("B");      // 3
int notFound = list.indexOf("Z");      // -1
```

### Size and Capacity

| Method | Returns | Description |
|--------|---------|-------------|
| `size()` | `int` | Number of elements |
| `isEmpty()` | `boolean` | True if size is 0 |
| `ensureCapacity(int min)` | `void` | Ensures minimum capacity |
| `trimToSize()` | `void` | Trims capacity to current size |

```java
ArrayList<String> list = new ArrayList<>(100);
list.addAll(List.of("A", "B", "C"));

int size = list.size();      // 3
boolean empty = list.isEmpty(); // false
list.trimToSize();           // capacity reduced to 3
```

### Converting

| Method | Returns | Description |
|--------|---------|-------------|
| `toArray()` | `Object[]` | Returns array of elements |
| `toArray(T[] a)` | `T[]` | Returns typed array |
| `iterator()` | `Iterator<E>` | Returns iterator |
| `listIterator()` | `ListIterator<E>` | Returns bi-directional iterator |
| `listIterator(int index)` | `ListIterator<E>` | Iterator starting at index |

```java
ArrayList<String> list = new ArrayList<>(List.of("A", "B", "C"));

Object[] arr1 = list.toArray();
String[] arr2 = list.toArray(new String[0]);  // preferred way
```

### Sorting

```java
ArrayList<Integer> list = new ArrayList<>(List.of(5, 2, 8, 1, 9));

// Natural order
list.sort(null);                    // [1, 2, 5, 8, 9]
// or
Collections.sort(list);

// Custom comparator
list.sort(Comparator.reverseOrder()); // [9, 8, 5, 2, 1]
list.sort((a, b) -> b - a);           // descending
```

---

## Complete Example

```java
import java.util.*;

public class ArrayListDemo {
    public static void main(String[] args) {
        // Create
        ArrayList<String> fruits = new ArrayList<>();
        
        // Add elements
        fruits.add("Apple");
        fruits.add("Banana");
        fruits.add("Cherry");
        fruits.add(1, "Apricot");  // insert at index 1
        System.out.println("After adding: " + fruits);
        // [Apple, Apricot, Banana, Cherry]
        
        // Access
        System.out.println("First: " + fruits.get(0));      // Apple
        System.out.println("Size: " + fruits.size());       // 4
        
        // Modify
        String old = fruits.set(2, "Blueberry");
        System.out.println("Replaced: " + old);             // Banana
        
        // Search
        System.out.println("Contains Apple? " + fruits.contains("Apple")); // true
        System.out.println("Index of Cherry: " + fruits.indexOf("Cherry")); // 3
        
        // Remove
        fruits.remove("Apricot");
        fruits.remove(0);
        System.out.println("After removal: " + fruits);     // [Blueberry, Cherry]
        
        // Iterate - for-each
        for (String fruit : fruits) {
            System.out.print(fruit + " ");
        }
        
        // Iterate - forEach (Java 8+)
        fruits.forEach(System.out::println);
        
        // Stream operations (Java 8+)
        List<String> filtered = fruits.stream()
            .filter(f -> f.startsWith("B"))
            .toList();
        
        // Sort
        fruits.sort(String::compareTo);
        
        // Clear
        fruits.clear();
        System.out.println("Is empty? " + fruits.isEmpty()); // true
    }
}
```

---

## Iteration Methods

```java
ArrayList<String> list = new ArrayList<>(List.of("A", "B", "C"));

// 1. For-each loop
for (String s : list) {
    System.out.println(s);
}

// 2. Traditional for loop
for (int i = 0; i < list.size(); i++) {
    System.out.println(list.get(i));
}

// 3. Iterator
Iterator<String> it = list.iterator();
while (it.hasNext()) {
    String s = it.next();
    if (s.equals("B")) it.remove();  // safe removal
}

// 4. ListIterator (bidirectional)
ListIterator<String> lit = list.listIterator();
while (lit.hasNext()) {
    lit.next();
    lit.add("X");  // can add during iteration
}

// 5. forEach (Java 8+)
list.forEach(s -> System.out.println(s));
list.forEach(System.out::println);

// 6. Stream
list.stream().forEach(System.out::println);
```

---

## ArrayList vs LinkedList

| Aspect | ArrayList | LinkedList |
|--------|-----------|------------|
| **Structure** | Dynamic array | Doubly linked list |
| **get(index)** | O(1) | O(n) |
| **add(end)** | O(1)* | O(1) |
| **add(index)** | O(n) | O(n) |
| **remove(index)** | O(n) | O(n) |
| **Memory** | Less (only data) | More (data + pointers) |
| **Use Case** | Random access | Frequent insert/delete |

*Amortized - may require resize

---

## Thread Safety

```java
// ArrayList is NOT thread-safe. Solutions:

// 1. Synchronized wrapper
List<String> syncList = Collections.synchronizedList(new ArrayList<>());

// 2. CopyOnWriteArrayList (for read-heavy scenarios)
CopyOnWriteArrayList<String> cowList = new CopyOnWriteArrayList<>();

// 3. Manual synchronization
synchronized (list) {
    // operations on list
}
```

---

## Important Points to Remember

1. **Initial Capacity** - Default is 10; set higher if you know the size to avoid resizing

2. **Growth** - Grows by 50% when full (`newCapacity = oldCapacity + oldCapacity >> 1`)

3. **Remove Integer trap**
   ```java
   ArrayList<Integer> list = new ArrayList<>(List.of(1, 2, 3));
   list.remove(1);              // removes at INDEX 1 → [1, 3]
   list.remove(Integer.valueOf(1)); // removes VALUE 1 → [3]
   ```

4. **subList() returns a view** - Changes affect original list
   ```java
   List<String> sub = list.subList(0, 2);
   sub.clear();  // also clears elements from original list!
   ```

5. **Fail-fast iterator** - Throws `ConcurrentModificationException` if list is modified during iteration (except through iterator's own methods)

6. **Use interface type**
   ```java
   List<String> list = new ArrayList<>();  // Good
   ArrayList<String> list = new ArrayList<>();  // Avoid
   ```

7. **Null elements** - Allowed but be careful with operations like `sort()`

---

## Quick Reference

```java
List<T> list = new ArrayList<>();  // Create
list.add(element);                 // Add at end
list.add(index, element);          // Insert at index
list.get(index);                   // Access by index
list.set(index, element);          // Replace
list.remove(index);                // Remove by index
list.remove(object);               // Remove by value
list.contains(object);             // Check existence
list.indexOf(object);              // Find index
list.size();                       // Element count
list.isEmpty();                    // Check if empty
list.clear();                      // Remove all
list.sort(comparator);             // Sort
list.toArray(new T[0]);            // Convert to array
```
