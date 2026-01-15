# HashMap in Java

## What is HashMap?

A **hash table** implementation of the `Map` interface. Stores **key-value pairs** with O(1) average time for get/put operations.

```java
import java.util.HashMap;
```

---

## Key Characteristics

| Property | Description |
|----------|-------------|
| Structure | Array of buckets + linked list/tree |
| Order | No guaranteed order |
| Null keys | One null key allowed |
| Null values | Multiple null values allowed |
| Duplicates | Keys unique, values can duplicate |
| Synchronized | No (not thread-safe) |
| Performance | O(1) average for get/put |

---

## Creating HashMap

```java
HashMap<String, Integer> map1 = new HashMap<>();           // Default capacity 16
HashMap<String, Integer> map2 = new HashMap<>(32);         // Custom capacity
HashMap<String, Integer> map3 = new HashMap<>(32, 0.75f);  // Capacity + load factor
HashMap<String, Integer> map4 = new HashMap<>(existingMap); // From another map
```

---

## Methods

### Adding/Updating

| Method | Returns | Description |
|--------|---------|-------------|
| `put(K, V)` | V | Add/update, returns old value (null if new) |
| `putAll(Map)` | void | Copy all from another map |
| `putIfAbsent(K, V)` | V | Add only if key absent |

### Getting

| Method | Returns | Description |
|--------|---------|-------------|
| `get(K)` | V | Value for key (null if not found) |
| `getOrDefault(K, default)` | V | Value or default if not found |

### Removing

| Method | Returns | Description |
|--------|---------|-------------|
| `remove(K)` | V | Remove by key, returns value |
| `remove(K, V)` | boolean | Remove only if key maps to value |
| `clear()` | void | Remove all entries |

### Checking

| Method | Returns | Description |
|--------|---------|-------------|
| `containsKey(K)` | boolean | Check if key exists |
| `containsValue(V)` | boolean | Check if value exists |
| `isEmpty()` | boolean | Check if empty |
| `size()` | int | Number of entries |

### Views

| Method | Returns | Description |
|--------|---------|-------------|
| `keySet()` | Set<K> | Set of all keys |
| `values()` | Collection<V> | Collection of all values |
| `entrySet()` | Set<Entry<K,V>> | Set of key-value pairs |

### Java 8+ Methods

| Method | Returns | Description |
|--------|---------|-------------|
| `compute(K, BiFunction)` | V | Compute new value |
| `computeIfAbsent(K, Function)` | V | Compute if key absent |
| `computeIfPresent(K, BiFunction)` | V | Compute if key present |
| `merge(K, V, BiFunction)` | V | Merge value |
| `replace(K, V)` | V | Replace value |
| `replace(K, oldV, newV)` | boolean | Replace if matches |

---

## Example

```java
HashMap<String, Integer> scores = new HashMap<>();

// Add entries
scores.put("Alice", 95);
scores.put("Bob", 87);
scores.put("Charlie", 92);

// Get values
int aliceScore = scores.get("Alice");           // 95
int unknown = scores.getOrDefault("Dave", 0);   // 0

// Update
scores.put("Bob", 90);                          // Updates Bob's score
scores.putIfAbsent("Alice", 100);               // No change (Alice exists)

// Check
boolean hasAlice = scores.containsKey("Alice"); // true
boolean has100 = scores.containsValue(100);     // false

// Remove
scores.remove("Charlie");                       // Removes Charlie

// Size
int count = scores.size();                      // 2
```

---

## Iteration Methods

```java
HashMap<String, Integer> map = new HashMap<>();
map.put("A", 1);
map.put("B", 2);
map.put("C", 3);

// 1. Iterate keys
for (String key : map.keySet()) {
    System.out.println(key + " = " + map.get(key));
}

// 2. Iterate values
for (Integer value : map.values()) {
    System.out.println(value);
}

// 3. Iterate entries (most efficient)
for (Map.Entry<String, Integer> entry : map.entrySet()) {
    System.out.println(entry.getKey() + " = " + entry.getValue());
}

// 4. forEach (Java 8+)
map.forEach((key, value) -> System.out.println(key + " = " + value));
```

---

## Java 8+ Features

```java
HashMap<String, Integer> map = new HashMap<>();

// computeIfAbsent - compute only if key is absent
map.computeIfAbsent("count", k -> 0);

// computeIfPresent - compute only if key exists
map.computeIfPresent("count", (k, v) -> v + 1);

// merge - combine values
map.merge("count", 1, Integer::sum);  // Add 1 to existing or set to 1

// getOrDefault
int val = map.getOrDefault("missing", -1);

// replaceAll
map.replaceAll((k, v) -> v * 2);  // Double all values
```

---

## How HashMap Works

```
HashMap Internal Structure:

Index:  [0]    [1]    [2]    [3]    [4]    ...
         │      │      │
         ▼      ▼      ▼
       null   Entry  Entry
               │      │
               ▼      ▼
             Entry   null
               │
               ▼
             null

- hash(key) determines bucket index
- Collisions handled by linked list (or tree if > 8 nodes)
- Load factor (0.75) triggers resize
```

---

## HashMap vs Other Maps

| Aspect | HashMap | LinkedHashMap | TreeMap | Hashtable |
|--------|---------|---------------|---------|-----------|
| Order | None | Insertion | Sorted | None |
| Null key | Yes (1) | Yes (1) | No | No |
| Null value | Yes | Yes | Yes | No |
| Thread-safe | No | No | No | Yes |
| Performance | O(1) | O(1) | O(log n) | O(1) |

---

## Thread Safety

```java
// HashMap is NOT thread-safe. Solutions:

// 1. Synchronized wrapper
Map<String, Integer> syncMap = Collections.synchronizedMap(new HashMap<>());

// 2. ConcurrentHashMap (preferred)
ConcurrentHashMap<String, Integer> concMap = new ConcurrentHashMap<>();
```

---

## Important Points

1. **Key immutability** - Don't modify keys after insertion (breaks hash)

2. **equals() and hashCode()** - Custom key classes must override both
   ```java
   // If two objects are equal, they MUST have same hashCode
   ```

3. **Initial capacity** - Set if you know the size (avoids resizing)
   ```java
   // For n elements, use capacity = n / 0.75 + 1
   HashMap<String, Integer> map = new HashMap<>(134); // for 100 elements
   ```

4. **Null key** - Only one null key allowed, stored at index 0

5. **Load factor** - Default 0.75 (75% full triggers resize)

---

## Quick Reference

```java
Map<K, V> map = new HashMap<>();
map.put(key, value);              // Add/update
map.get(key);                     // Get value
map.getOrDefault(key, default);   // Get or default
map.remove(key);                  // Remove
map.containsKey(key);             // Check key
map.containsValue(value);         // Check value
map.keySet();                     // All keys
map.values();                     // All values
map.entrySet();                   // All entries
map.size();                       // Count
map.isEmpty();                    // Check empty
map.clear();                      // Remove all
map.forEach((k, v) -> ...);       // Iterate
```
