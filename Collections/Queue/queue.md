# Queue in Java

## What is Queue?

A **FIFO (First-In-First-Out)** collection. Elements are added at the end and removed from the front.

```java
import java.util.Queue;
import java.util.LinkedList;
import java.util.PriorityQueue;
```

---

## Queue Hierarchy

```
        Queue<E>
           │
    ┌──────┼──────┐
    │      │      │
LinkedList │  PriorityQueue
           │
        Deque<E>
           │
      ArrayDeque
```

---

## Key Characteristics

| Property | Description |
|----------|-------------|
| Order | FIFO (except PriorityQueue) |
| Null | Not allowed in most implementations |
| Interface | Queue is an interface, not a class |

---

## Creating Queue

```java
Queue<String> q1 = new LinkedList<>();      // Common choice
Queue<Integer> q2 = new PriorityQueue<>();  // Sorted order
Queue<String> q3 = new ArrayDeque<>();      // Faster than LinkedList
```

---

## Methods

### Two Sets of Methods

| Operation | Throws Exception | Returns Special Value |
|-----------|------------------|----------------------|
| Insert | `add(e)` | `offer(e)` → returns false |
| Remove | `remove()` | `poll()` → returns null |
| Examine | `element()` | `peek()` → returns null |

### Method Details

| Method | Returns | Description |
|--------|---------|-------------|
| `offer(E e)` | boolean | Add at end, false if full |
| `add(E e)` | boolean | Add at end, throws if full |
| `poll()` | E | Remove & return head, null if empty |
| `remove()` | E | Remove & return head, throws if empty |
| `peek()` | E | Return head without removing, null if empty |
| `element()` | E | Return head without removing, throws if empty |
| `isEmpty()` | boolean | Check if empty |
| `size()` | int | Number of elements |

---

## Example

```java
Queue<String> queue = new LinkedList<>();

// Add elements
queue.offer("A");
queue.offer("B");
queue.offer("C");     // Queue: [A, B, C]

// Peek (view head)
String head = queue.peek();   // "A" (queue unchanged)

// Poll (remove head)
String first = queue.poll();  // "A" (queue: [B, C])
String second = queue.poll(); // "B" (queue: [C])

// Check
boolean empty = queue.isEmpty();  // false
int size = queue.size();          // 1
```

---

## PriorityQueue

Elements are ordered by **natural order** or a **Comparator** (not FIFO).

```java
// Min-heap (smallest first)
Queue<Integer> minHeap = new PriorityQueue<>();
minHeap.offer(5);
minHeap.offer(1);
minHeap.offer(3);
minHeap.poll();  // returns 1 (smallest)

// Max-heap (largest first)
Queue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
maxHeap.offer(5);
maxHeap.offer(1);
maxHeap.offer(3);
maxHeap.poll();  // returns 5 (largest)
```

---

## Queue Implementations Comparison

| Implementation | Order | Null | Use Case |
|----------------|-------|------|----------|
| LinkedList | FIFO | Yes | General purpose |
| ArrayDeque | FIFO | No | Faster, no capacity limit |
| PriorityQueue | Priority | No | Sorted processing |

---

## When to Use

✅ **Use Queue when:**
- Processing in order (FIFO)
- BFS algorithms
- Task scheduling
- Buffering data

---

## Quick Reference

```java
Queue<T> q = new LinkedList<>();
q.offer(e);     // Add (safe)
q.poll();       // Remove (safe, returns null)
q.peek();       // View head (safe, returns null)
q.isEmpty();    // Check empty
q.size();       // Count elements
```
