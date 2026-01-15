# LinkedList in Java

## What is LinkedList?

A **doubly linked list** implementation of `List` and `Deque` interfaces. Each element (node) contains data + pointers to previous and next nodes.

```java
import java.util.LinkedList;
```

---

## Key Characteristics

| Property | Value |
|----------|-------|
| Structure | Doubly linked list |
| Implements | List, Deque, Queue |
| Null allowed | Yes |
| Duplicates | Yes |
| Synchronized | No |
| Best for | Frequent insert/delete at ends |

---

## Creating LinkedList

```java
LinkedList<String> list = new LinkedList<>();
LinkedList<String> list2 = new LinkedList<>(existingCollection);
```

---

## Methods

### List Operations

| Method | Returns | Description |
|--------|---------|-------------|
| `add(E e)` | boolean | Add at end |
| `add(int i, E e)` | void | Insert at index |
| `get(int i)` | E | Get element at index |
| `set(int i, E e)` | E | Replace, return old |
| `remove(int i)` | E | Remove at index |
| `remove(Object o)` | boolean | Remove first occurrence |
| `indexOf(Object o)` | int | First index or -1 |
| `size()` | int | Element count |
| `clear()` | void | Remove all |

### Deque Operations (Both Ends)

| Method | Returns | Description |
|--------|---------|-------------|
| `addFirst(E e)` | void | Add at beginning |
| `addLast(E e)` | void | Add at end |
| `getFirst()` | E | Get first (throws if empty) |
| `getLast()` | E | Get last (throws if empty) |
| `removeFirst()` | E | Remove & return first |
| `removeLast()` | E | Remove & return last |

### Queue Operations (FIFO)

| Method | Returns | Description |
|--------|---------|-------------|
| `offer(E e)` | boolean | Add at end |
| `poll()` | E | Remove first, null if empty |
| `peek()` | E | Get first, null if empty |

### Stack Operations (LIFO)

| Method | Returns | Description |
|--------|---------|-------------|
| `push(E e)` | void | Add at beginning |
| `pop()` | E | Remove & return first |

---

## Example

```java
LinkedList<String> list = new LinkedList<>();

// Add
list.add("B");
list.addFirst("A");
list.addLast("C");        // [A, B, C]

// Access
String first = list.getFirst();  // A
String last = list.getLast();    // C

// Remove
list.removeFirst();       // [B, C]
list.removeLast();        // [B]

// As Queue
list.offer("X");
String head = list.poll(); // removes & returns "B"

// As Stack
list.push("Y");
String top = list.pop();   // removes & returns "Y"
```

---

## LinkedList vs ArrayList

| Operation | LinkedList | ArrayList |
|-----------|------------|-----------|
| get(index) | O(n) | O(1) |
| add(end) | O(1) | O(1)* |
| add(start) | O(1) | O(n) |
| remove(start) | O(1) | O(n) |
| Memory | Higher | Lower |

---

## When to Use

✅ **Use LinkedList when:**
- Frequent add/remove at beginning or end
- Implementing Queue or Stack
- No random access needed

❌ **Avoid when:**
- Frequent access by index
- Memory is a concern

---

## Quick Reference

```java
LinkedList<T> list = new LinkedList<>();
list.addFirst(e);    list.addLast(e);
list.getFirst();     list.getLast();
list.removeFirst();  list.removeLast();
list.push(e);        list.pop();      // Stack
list.offer(e);       list.poll();     // Queue
```
