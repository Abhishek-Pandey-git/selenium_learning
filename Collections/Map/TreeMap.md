# TreeMap in Java

## What is TreeMap?

A **Red-Black tree** implementation of `NavigableMap`. Stores key-value pairs in **sorted order** by keys.

```java
import java.util.TreeMap;
```

---

## Key Characteristics

| Property | Description |
|----------|-------------|
| Structure | Red-Black Tree (self-balancing BST) |
| Order | Sorted by keys (natural or Comparator) |
| Null key | **Not allowed** (throws NullPointerException) |
| Null values | Allowed |
| Duplicates | Keys unique, values can duplicate |
| Synchronized | No |
| Performance | O(log n) for get/put/remove |

---

## Creating TreeMap

```java
TreeMap<String, Integer> map1 = new TreeMap<>();              // Natural order
TreeMap<String, Integer> map2 = new TreeMap<>(Comparator.reverseOrder()); // Custom order
TreeMap<String, Integer> map3 = new TreeMap<>(existingMap);   // From another map
```

---

## Methods

### Basic Operations (Same as Map)

| Method | Returns | Description |
|--------|---------|-------------|
| `put(K, V)` | V | Add/update entry |
| `get(K)` | V | Get value by key |
| `remove(K)` | V | Remove by key |
| `containsKey(K)` | boolean | Check key exists |
| `size()` | int | Number of entries |

### Navigation Methods (TreeMap Specific)

| Method | Returns | Description |
|--------|---------|-------------|
| `firstKey()` | K | Smallest key (throws if empty) |
| `lastKey()` | K | Largest key (throws if empty) |
| `firstEntry()` | Entry<K,V> | Entry with smallest key |
| `lastEntry()` | Entry<K,V> | Entry with largest key |
| `lowerKey(K)` | K | Greatest key < given key |
| `higherKey(K)` | K | Smallest key > given key |
| `floorKey(K)` | K | Greatest key ≤ given key |
| `ceilingKey(K)` | K | Smallest key ≥ given key |
| `pollFirstEntry()` | Entry<K,V> | Remove & return first entry |
| `pollLastEntry()` | Entry<K,V> | Remove & return last entry |

### Range Views

| Method | Returns | Description |
|--------|---------|-------------|
| `subMap(from, to)` | SortedMap | Keys from (inclusive) to (exclusive) |
| `subMap(from, fromInc, to, toInc)` | NavigableMap | Customizable inclusivity |
| `headMap(toKey)` | SortedMap | Keys < toKey |
| `tailMap(fromKey)` | SortedMap | Keys ≥ fromKey |
| `descendingMap()` | NavigableMap | Reverse order view |

---

## Example

```java
TreeMap<String, Integer> scores = new TreeMap<>();

// Add entries (automatically sorted by key)
scores.put("Charlie", 85);
scores.put("Alice", 95);
scores.put("Bob", 90);
// Map: {Alice=95, Bob=90, Charlie=85}

// Navigation
String first = scores.firstKey();     // "Alice"
String last = scores.lastKey();       // "Charlie"

// Find nearby keys
String lower = scores.lowerKey("Bob");    // "Alice" (< Bob)
String higher = scores.higherKey("Bob");  // "Charlie" (> Bob)
String floor = scores.floorKey("Bob");    // "Bob" (≤ Bob)
String ceiling = scores.ceilingKey("Ben"); // "Bob" (≥ Ben)

// Range view
SortedMap<String, Integer> range = scores.subMap("Alice", "Charlie");
// {Alice=95, Bob=90}

// Reverse order
NavigableMap<String, Integer> desc = scores.descendingMap();
// {Charlie=85, Bob=90, Alice=95}
```

---

## Custom Sorting

```java
// Sort by key length, then alphabetically
TreeMap<String, Integer> map = new TreeMap<>((a, b) -> {
    int lenCompare = Integer.compare(a.length(), b.length());
    return lenCompare != 0 ? lenCompare : a.compareTo(b);
});

// Reverse order
TreeMap<String, Integer> reverseMap = new TreeMap<>(Comparator.reverseOrder());

// Case-insensitive
TreeMap<String, Integer> caseInsensitive = new TreeMap<>(String.CASE_INSENSITIVE_ORDER);
```

---

## Iteration

```java
TreeMap<String, Integer> map = new TreeMap<>();
map.put("C", 3);
map.put("A", 1);
map.put("B", 2);

// Iterate in sorted order
for (Map.Entry<String, Integer> e : map.entrySet()) {
    System.out.println(e.getKey() + " = " + e.getValue());
}
// Output: A=1, B=2, C=3

// Reverse iteration
for (String key : map.descendingKeySet()) {
    System.out.println(key);
}
// Output: C, B, A
```

---

## TreeMap vs HashMap vs LinkedHashMap

| Aspect | TreeMap | HashMap | LinkedHashMap |
|--------|---------|---------|---------------|
| Order | Sorted | None | Insertion |
| Null key | No | Yes (1) | Yes (1) |
| Performance | O(log n) | O(1) | O(1) |
| Use case | Sorted data | Fast lookup | Order + fast |

---

## When to Use TreeMap

✅ **Use TreeMap when:**
- Need sorted keys
- Need range queries (subMap, headMap, tailMap)
- Need navigation (first, last, lower, higher)
- Need floor/ceiling operations

❌ **Avoid when:**
- Just need fast key-value lookup (use HashMap)
- Need insertion order (use LinkedHashMap)

---

## Important Points

1. **Null keys not allowed** - Throws `NullPointerException`

2. **Comparable or Comparator required** - Keys must implement `Comparable` or provide `Comparator`

3. **Range views are backed** - Changes reflect in original map
   ```java
   SortedMap<String, Integer> sub = map.subMap("A", "C");
   sub.put("B", 100);  // Also modifies original map!
   ```

4. **O(log n) operations** - Slower than HashMap's O(1)

---

## Quick Reference

```java
TreeMap<K, V> map = new TreeMap<>();
// Basic
map.put(key, value);     map.get(key);      map.remove(key);
// Navigation
map.firstKey();          map.lastKey();
map.lowerKey(k);         map.higherKey(k);
map.floorKey(k);         map.ceilingKey(k);
// Entries
map.firstEntry();        map.lastEntry();
map.pollFirstEntry();    map.pollLastEntry();
// Range
map.subMap(from, to);    map.headMap(to);   map.tailMap(from);
map.descendingMap();
```
