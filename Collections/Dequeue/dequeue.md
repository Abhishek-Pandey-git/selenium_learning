# Deque in Java

## What is Deque?

**Double-Ended Queue** - supports insertion and removal at **both ends**. Can be used as Queue (FIFO) or Stack (LIFO).

```java
import java.util.Deque;
import java.util.ArrayDeque;
import java.util.LinkedList;
```

---

## Key Characteristics

| Property | Description |
|----------|-------------|
| Full Form | Double-Ended Queue |
| Operations | Both ends (head & tail) |
| Null | Not allowed in ArrayDeque |
| Use as | Queue, Stack, or both |

---

## Creating Deque

```java
Deque<String> d1 = new ArrayDeque<>();  // Preferred (faster)
Deque<String> d2 = new LinkedList<>();  // Also implements List
```

---

## Methods

### Two Sets (Safe vs Throws Exception)

| Operation | First Element | Last Element |
|-----------|---------------|--------------|
| **Insert** | `offerFirst(e)` / `addFirst(e)` | `offerLast(e)` / `addLast(e)` |
| **Remove** | `pollFirst()` / `removeFirst()` | `pollLast()` / `removeLast()` |
| **Examine** | `peekFirst()` / `getFirst()` | `peekLast()` / `getLast()` |

### Method Details

| Method | Returns | Description |
|--------|---------|-------------|
| `offerFirst(e)` | boolean | Add at front |
| `offerLast(e)` | boolean | Add at end |
| `pollFirst()` | E | Remove from front (null if empty) |
| `pollLast()` | E | Remove from end (null if empty) |
| `peekFirst()` | E | View front (null if empty) |
| `peekLast()` | E | View end (null if empty) |

### Stack Methods

| Method | Returns | Description |
|--------|---------|-------------|
| `push(e)` | void | Add at front (same as addFirst) |
| `pop()` | E | Remove from front (same as removeFirst) |

### Queue Methods

| Method | Returns | Description |
|--------|---------|-------------|
| `offer(e)` | boolean | Add at end |
| `poll()` | E | Remove from front |
| `peek()` | E | View front |

---

## Example

```java
Deque<String> deque = new ArrayDeque<>();

// Add at both ends
deque.offerFirst("B");    // [B]
deque.offerFirst("A");    // [A, B]
deque.offerLast("C");     // [A, B, C]

// Peek both ends
String first = deque.peekFirst();  // "A"
String last = deque.peekLast();    // "C"

// Remove from both ends
deque.pollFirst();  // removes "A" → [B, C]
deque.pollLast();   // removes "C" → [B]

// As Stack
deque.push("X");    // [X, B]
deque.pop();        // removes "X" → [B]

// As Queue
deque.offer("Y");   // [B, Y]
deque.poll();       // removes "B" → [Y]
```

---

## ArrayDeque vs LinkedList

| Aspect | ArrayDeque | LinkedList |
|--------|------------|------------|
| Structure | Resizable array | Doubly linked |
| Performance | Faster | Slower |
| Null values | Not allowed | Allowed |
| Memory | Less | More |
| Recommendation | **Preferred** | Use if need List ops |

---

## Use Cases

| Use As | Methods |
|--------|---------|
| **Queue (FIFO)** | `offer()`, `poll()`, `peek()` |
| **Stack (LIFO)** | `push()`, `pop()`, `peek()` |
| **Double-ended** | `offerFirst/Last()`, `pollFirst/Last()` |

---

## Quick Reference

```java
Deque<T> d = new ArrayDeque<>();
// Both ends
d.offerFirst(e);  d.offerLast(e);
d.pollFirst();    d.pollLast();
d.peekFirst();    d.peekLast();
// Stack
d.push(e);        d.pop();
// Queue  
d.offer(e);       d.poll();       d.peek();
```
