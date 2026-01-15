# Java Collections Framework - Fundamentals

## What is the Collections Framework?

The **Java Collections Framework (JCF)** is a unified architecture for representing and manipulating collections of objects. It provides:

- **Interfaces** - Abstract data types representing collections
- **Implementations** - Concrete implementations of the interfaces
- **Algorithms** - Methods for performing operations (sorting, searching, etc.)

---

## History: When and Why Were Collections Created?

### Before Collections (Pre-Java 1.2)

| Class | Problems |
|-------|----------|
| `Array` | Fixed size, no built-in methods for manipulation |
| `Vector` | Synchronized (slow), limited functionality |
| `Hashtable` | Synchronized, no null keys/values allowed |
| `Stack` | Extends Vector (poor design) |

### The Need for Collections Framework

1. **Inconsistent APIs** - Each data structure had different method names
2. **No common interface** - Couldn't write generic algorithms
3. **Performance issues** - Everything was synchronized unnecessarily
4. **Limited data structures** - No Set, Queue, LinkedList, etc.

### Java 1.2 (1998) - Collections Framework Introduced

The Collections Framework was designed by **Joshua Bloch** with these goals:
- Provide a unified interface hierarchy
- Separate interface from implementation
- Allow interoperability between different collection types
- Enable generic algorithms

### Evolution Timeline

| Version | Additions |
|---------|-----------|
| **Java 1.2** | Collection, List, Set, Map, ArrayList, LinkedList, HashSet, HashMap, TreeSet, TreeMap |
| **Java 1.4** | LinkedHashSet, LinkedHashMap |
| **Java 1.5** | Generics, Queue, PriorityQueue, ConcurrentHashMap, EnumSet, EnumMap |
| **Java 1.6** | Deque, ArrayDeque, NavigableSet, NavigableMap |
| **Java 1.8** | Stream API, forEach, Lambda support |
| **Java 9** | Factory methods: `List.of()`, `Set.of()`, `Map.of()` |
| **Java 10+** | `List.copyOf()`, `Set.copyOf()`, improved performance |

---

## Collection Hierarchy

```
                           Iterable<E>
                               │
                         Collection<E>
                               │
          ┌────────────────────┼────────────────────┐
          │                    │                    │
       List<E>              Set<E>             Queue<E>
          │                    │                    │
    ┌─────┼─────┐        ┌─────┼─────┐        ┌─────┼─────┐
    │     │     │        │     │     │        │     │     │
ArrayList │  Vector   HashSet │  TreeSet  PriorityQueue │
          │                   │                         │
     LinkedList         LinkedHashSet              Deque<E>
                                                       │
                                               ┌───────┼───────┐
                                               │               │
                                          ArrayDeque      LinkedList


                            Map<K,V>
                               │
          ┌────────────────────┼────────────────────┐
          │                    │                    │
       HashMap            TreeMap              Hashtable
          │                                        │
    LinkedHashMap                             Properties
```

---

## Core Interfaces

### 1. Iterable<E>
The root interface that enables the for-each loop.

```java
public interface Iterable<E> {
    Iterator<E> iterator();
}
```

### 2. Collection<E>
The root interface of the collection hierarchy (extends Iterable).

```java
public interface Collection<E> extends Iterable<E> {
    // Basic operations
    int size();
    boolean isEmpty();
    boolean contains(Object o);
    boolean add(E e);
    boolean remove(Object o);
    
    // Bulk operations
    boolean containsAll(Collection<?> c);
    boolean addAll(Collection<? extends E> c);
    boolean removeAll(Collection<?> c);
    boolean retainAll(Collection<?> c);
    void clear();
    
    // Array operations
    Object[] toArray();
    <T> T[] toArray(T[] a);
}
```

### 3. List<E>
Ordered collection (sequence) that allows duplicates.

```java
public interface List<E> extends Collection<E> {
    // Positional access
    E get(int index);
    E set(int index, E element);
    void add(int index, E element);
    E remove(int index);
    
    // Search
    int indexOf(Object o);
    int lastIndexOf(Object o);
    
    // Range view
    List<E> subList(int fromIndex, int toIndex);
}
```

### 4. Set<E>
Collection that contains **no duplicate elements**.

```java
public interface Set<E> extends Collection<E> {
    // Inherits all methods from Collection
    // No additional methods - enforces uniqueness
}
```

### 5. Queue<E>
Collection designed for holding elements prior to processing (FIFO).

```java
public interface Queue<E> extends Collection<E> {
    // Throws exception on failure
    boolean add(E e);
    E remove();
    E element();
    
    // Returns special value on failure
    boolean offer(E e);
    E poll();      // returns null if empty
    E peek();      // returns null if empty
}
```

### 6. Deque<E>
Double-ended queue - supports insertion/removal at both ends.

```java
public interface Deque<E> extends Queue<E> {
    void addFirst(E e);
    void addLast(E e);
    E removeFirst();
    E removeLast();
    E getFirst();
    E getLast();
    
    // Stack operations
    void push(E e);
    E pop();
}
```

### 7. Map<K,V>
Object that maps keys to values. **NOT** part of Collection hierarchy.

```java
public interface Map<K,V> {
    // Basic operations
    V get(Object key);
    V put(K key, V value);
    V remove(Object key);
    boolean containsKey(Object key);
    boolean containsValue(Object value);
    int size();
    boolean isEmpty();
    
    // Bulk operations
    void putAll(Map<? extends K, ? extends V> m);
    void clear();
    
    // Collection views
    Set<K> keySet();
    Collection<V> values();
    Set<Map.Entry<K,V>> entrySet();
}
```

---

## When to Use Which Collection?

### Decision Flowchart

```
Need to store data?
    │
    ├── Key-Value pairs? ──────────────► USE MAP
    │       │
    │       ├── Need ordering by keys? ──► TreeMap
    │       ├── Need insertion order? ────► LinkedHashMap
    │       └── Just fast access? ────────► HashMap
    │
    └── Single values? ──────────────────► USE COLLECTION
            │
            ├── Need uniqueness?
            │       │
            │       ├── Need sorting? ────────► TreeSet
            │       ├── Need insertion order? ► LinkedHashSet
            │       └── Just uniqueness? ─────► HashSet
            │
            ├── Need FIFO processing? ────────► Queue/Deque
            │       │
            │       ├── Priority based? ──────► PriorityQueue
            │       └── Both ends access? ────► ArrayDeque
            │
            └── Need ordered sequence?
                    │
                    ├── Frequent random access? ► ArrayList
                    └── Frequent insert/delete? ► LinkedList
```

### Quick Reference Table

| Requirement | Best Choice | Why |
|-------------|-------------|-----|
| Fast random access | `ArrayList` | O(1) index access |
| Frequent insertions/deletions | `LinkedList` | O(1) add/remove at ends |
| No duplicates | `HashSet` | O(1) operations |
| Sorted unique elements | `TreeSet` | Maintains natural order |
| FIFO queue | `LinkedList` or `ArrayDeque` | Deque operations |
| LIFO stack | `ArrayDeque` | push/pop operations |
| Priority processing | `PriorityQueue` | Heap-based ordering |
| Fast key-value lookup | `HashMap` | O(1) get/put |
| Sorted key-value pairs | `TreeMap` | Keys in natural order |
| Thread-safe operations | `ConcurrentHashMap` | Concurrent access |

---

## Common Methods Across Collections

### Adding Elements

```java
// Single element
collection.add(element);
list.add(index, element);
map.put(key, value);

// Multiple elements
collection.addAll(otherCollection);
map.putAll(otherMap);
```

### Removing Elements

```java
// Single element
collection.remove(element);
list.remove(index);
map.remove(key);

// Conditional removal (Java 8+)
collection.removeIf(e -> e.startsWith("A"));

// Clear all
collection.clear();
```

### Checking Contents

```java
collection.contains(element);
collection.containsAll(otherCollection);
map.containsKey(key);
map.containsValue(value);
collection.isEmpty();
collection.size();
```

### Iterating

```java
// For-each loop
for (String item : collection) {
    System.out.println(item);
}

// Iterator
Iterator<String> it = collection.iterator();
while (it.hasNext()) {
    String item = it.next();
    if (condition) it.remove();  // Safe removal
}

// forEach (Java 8+)
collection.forEach(item -> System.out.println(item));
collection.forEach(System.out::println);

// Map iteration
map.forEach((key, value) -> System.out.println(key + ": " + value));
```

### Converting

```java
// To array
Object[] arr = collection.toArray();
String[] strArr = collection.toArray(new String[0]);

// List to Set (remove duplicates)
Set<String> set = new HashSet<>(list);

// Set to List
List<String> list = new ArrayList<>(set);

// Array to List
List<String> list = Arrays.asList(array);       // Fixed-size
List<String> list = new ArrayList<>(Arrays.asList(array));  // Modifiable

// Java 9+ factory methods
List<String> list = List.of("a", "b", "c");     // Immutable
Set<String> set = Set.of("a", "b", "c");        // Immutable
Map<String, Integer> map = Map.of("a", 1, "b", 2);  // Immutable
```

---

## Time Complexity Overview

### List Implementations

| Operation | ArrayList | LinkedList |
|-----------|-----------|------------|
| `get(index)` | O(1) | O(n) |
| `add(element)` | O(1)* | O(1) |
| `add(index, element)` | O(n) | O(n) |
| `remove(index)` | O(n) | O(n) |
| `contains(element)` | O(n) | O(n) |

*Amortized - may require array resize

### Set Implementations

| Operation | HashSet | LinkedHashSet | TreeSet |
|-----------|---------|---------------|---------|
| `add` | O(1) | O(1) | O(log n) |
| `remove` | O(1) | O(1) | O(log n) |
| `contains` | O(1) | O(1) | O(log n) |

### Map Implementations

| Operation | HashMap | LinkedHashMap | TreeMap |
|-----------|---------|---------------|---------|
| `put` | O(1) | O(1) | O(log n) |
| `get` | O(1) | O(1) | O(log n) |
| `remove` | O(1) | O(1) | O(log n) |
| `containsKey` | O(1) | O(1) | O(log n) |

---

## Null Handling

| Collection | Allows Null |
|------------|-------------|
| `ArrayList` | ✅ Yes |
| `LinkedList` | ✅ Yes |
| `HashSet` | ✅ One null |
| `LinkedHashSet` | ✅ One null |
| `TreeSet` | ❌ No (throws NullPointerException) |
| `HashMap` | ✅ One null key, multiple null values |
| `LinkedHashMap` | ✅ One null key, multiple null values |
| `TreeMap` | ❌ No null keys |
| `Hashtable` | ❌ No null keys or values |
| `ConcurrentHashMap` | ❌ No null keys or values |

---

## Thread Safety

### Legacy Thread-Safe Collections (Avoid)
- `Vector` - Synchronized ArrayList
- `Hashtable` - Synchronized HashMap
- `Stack` - Synchronized stack

### Creating Synchronized Wrappers

```java
List<String> syncList = Collections.synchronizedList(new ArrayList<>());
Set<String> syncSet = Collections.synchronizedSet(new HashSet<>());
Map<String, Integer> syncMap = Collections.synchronizedMap(new HashMap<>());
```

### Concurrent Collections (Preferred)

```java
// From java.util.concurrent package
ConcurrentHashMap<String, Integer> concurrentMap = new ConcurrentHashMap<>();
CopyOnWriteArrayList<String> cowList = new CopyOnWriteArrayList<>();
CopyOnWriteArraySet<String> cowSet = new CopyOnWriteArraySet<>();
ConcurrentLinkedQueue<String> concurrentQueue = new ConcurrentLinkedQueue<>();
```

---

## The Collections Utility Class

The `java.util.Collections` class provides static utility methods:

```java
// Sorting
Collections.sort(list);
Collections.sort(list, comparator);
Collections.reverse(list);
Collections.shuffle(list);

// Searching
int index = Collections.binarySearch(sortedList, key);

// Min/Max
String min = Collections.min(collection);
String max = Collections.max(collection);

// Frequency
int count = Collections.frequency(collection, element);

// Unmodifiable views
List<String> unmodifiable = Collections.unmodifiableList(list);

// Empty collections
List<String> empty = Collections.emptyList();

// Singleton collections
List<String> single = Collections.singletonList("only");

// Fill and replace
Collections.fill(list, "default");
Collections.replaceAll(list, "old", "new");
```

---

## Key Points to Remember

1. **Collection vs Collections**
   - `Collection` - Interface (root of collection hierarchy)
   - `Collections` - Utility class with static methods

2. **Map is NOT a Collection**
   - Map doesn't extend Collection interface
   - But it's part of the Collections Framework

3. **Prefer Interfaces Over Implementations**
   ```java
   // Good
   List<String> list = new ArrayList<>();
   
   // Avoid
   ArrayList<String> list = new ArrayList<>();
   ```

4. **Use Generics**
   ```java
   // Good - Type safe
   List<String> list = new ArrayList<>();
   
   // Bad - Raw type
   List list = new ArrayList();
   ```

5. **Choose Based on Use Case**
   - Need ordering? → List
   - Need uniqueness? → Set
   - Need key-value? → Map
   - Need FIFO? → Queue

---

## What's Next?

Specialized notes for each collection type will be created in their respective folders:
- ArrayList, LinkedList, Vector (List implementations)
- HashSet, LinkedHashSet, TreeSet (Set implementations)
- HashMap, LinkedHashMap, TreeMap, Hashtable (Map implementations)
- PriorityQueue, ArrayDeque (Queue implementations)
- Concurrent collections
