# ArrayDeque in Java

## What is ArrayDeque?

A **resizable array** implementation of `Deque`. Faster than `LinkedList` for stack and queue operations.

```java
import java.util.ArrayDeque;
```

---

## Key Characteristics

| Property | Description |
|----------|-------------|
| Structure | Resizable circular array |
| Null | **Not allowed** |
| Thread-safe | No |
| Capacity | Grows automatically (doubles) |
| Performance | O(1) for both ends |

---

## Creating ArrayDeque

```java
ArrayDeque<String> d1 = new ArrayDeque<>();        // Default capacity 16
ArrayDeque<String> d2 = new ArrayDeque<>(32);      // Custom capacity
ArrayDeque<String> d3 = new ArrayDeque<>(list);    // From collection
```

---

## Methods

### Deque Operations (Both Ends)

| Method | Returns | Description |
|--------|---------|-------------|
| `offerFirst(e)` | boolean | Add at front |
| `offerLast(e)` | boolean | Add at end |
| `pollFirst()` | E | Remove front (null if empty) |
| `pollLast()` | E | Remove end (null if empty) |
| `peekFirst()` | E | View front (null if empty) |
| `peekLast()` | E | View end (null if empty) |

### Stack Operations (LIFO)

| Method | Returns | Description |
|--------|---------|-------------|
| `push(e)` | void | Add at front |
| `pop()` | E | Remove front (throws if empty) |

### Queue Operations (FIFO)

| Method | Returns | Description |
|--------|---------|-------------|
| `offer(e)` | boolean | Add at end |
| `poll()` | E | Remove front (null if empty) |
| `peek()` | E | View front (null if empty) |

### Other Methods

| Method | Returns | Description |
|--------|---------|-------------|
| `size()` | int | Element count |
| `isEmpty()` | boolean | Check if empty |
| `contains(o)` | boolean | Check existence |
| `clear()` | void | Remove all |
| `toArray()` | Object[] | Convert to array |

---

## Example

```java
ArrayDeque<Integer> deque = new ArrayDeque<>();

// As Stack (LIFO)
deque.push(1);
deque.push(2);
deque.push(3);        // [3, 2, 1]
deque.pop();          // returns 3 → [2, 1]

// As Queue (FIFO)
deque.offer(4);       // [2, 1, 4]
deque.poll();         // returns 2 → [1, 4]

// Both ends
deque.offerFirst(0);  // [0, 1, 4]
deque.offerLast(5);   // [0, 1, 4, 5]
deque.pollFirst();    // returns 0 → [1, 4, 5]
deque.pollLast();     // returns 5 → [1, 4]
```

---

## ArrayDeque vs Stack vs LinkedList

| Aspect | ArrayDeque | Stack | LinkedList |
|--------|------------|-------|------------|
| Speed | **Fastest** | Slow (sync) | Slower |
| Null | No | Yes | Yes |
| Thread-safe | No | Yes | No |
| Use for Stack | ✅ **Yes** | ❌ Avoid | ⚠️ OK |
| Use for Queue | ✅ **Yes** | ❌ No | ⚠️ OK |

---

## Why Prefer ArrayDeque?

1. **Faster** than LinkedList (no node allocation)
2. **Less memory** (no prev/next pointers)
3. **Better than Stack class** (Stack is legacy, synchronized)
4. **No null** = catches bugs early

---

## Quick Reference

```java
ArrayDeque<T> d = new ArrayDeque<>();
// Stack
d.push(e);      d.pop();        d.peek();
// Queue
d.offer(e);     d.poll();       d.peek();
// Both ends
d.offerFirst(e);  d.offerLast(e);
d.pollFirst();    d.pollLast();
d.peekFirst();    d.peekLast();
```
