# Stack in Java

## What is Stack?

A **LIFO (Last-In-First-Out)** data structure. The last element added is the first one removed.

```java
import java.util.Stack;
```

> ⚠️ **Note:** `Stack` is a legacy class. Prefer `ArrayDeque` for stack operations.

---

## Key Characteristics

| Property | Description |
|----------|-------------|
| Structure | Extends Vector |
| Order | LIFO |
| Synchronized | Yes (slower) |
| Null | Allowed |
| Legacy | Yes (since Java 1.0) |

---

## Creating Stack

```java
Stack<String> stack = new Stack<>();
```

---

## Methods

| Method | Returns | Description |
|--------|---------|-------------|
| `push(E e)` | E | Add to top, returns element |
| `pop()` | E | Remove & return top (throws if empty) |
| `peek()` | E | View top without removing (throws if empty) |
| `empty()` | boolean | Check if empty |
| `search(Object o)` | int | 1-based position from top, -1 if not found |

### Inherited from Vector

| Method | Returns | Description |
|--------|---------|-------------|
| `size()` | int | Element count |
| `isEmpty()` | boolean | Check if empty |
| `contains(o)` | boolean | Check existence |
| `clear()` | void | Remove all |

---

## Example

```java
Stack<String> stack = new Stack<>();

// Push elements
stack.push("A");
stack.push("B");
stack.push("C");      // Stack: [A, B, C] (C is top)

// Peek (view top)
String top = stack.peek();    // "C" (stack unchanged)

// Pop (remove top)
String removed = stack.pop(); // "C" → Stack: [A, B]

// Search (1-based from top)
int pos = stack.search("A");  // 2 (A is 2nd from top)
int notFound = stack.search("Z"); // -1

// Check empty
boolean isEmpty = stack.empty();  // false
```

---

## Stack vs ArrayDeque

| Aspect | Stack | ArrayDeque |
|--------|-------|------------|
| Synchronized | Yes (slow) | No (fast) |
| Legacy | Yes | No |
| Extends | Vector | Nothing |
| Null | Allowed | Not allowed |
| **Recommendation** | ❌ Avoid | ✅ **Use this** |

### Modern Alternative

```java
// Instead of Stack, use:
Deque<String> stack = new ArrayDeque<>();
stack.push("A");
stack.push("B");
stack.pop();    // returns "B"
stack.peek();   // returns "A"
```

---

## Use Cases

- Expression evaluation (postfix, infix)
- Undo/Redo operations
- Backtracking algorithms
- Browser history (back button)
- Function call stack
- Parentheses matching

---

## Common Operations Example

```java
Stack<Integer> stack = new Stack<>();

// Check balanced parentheses
String expr = "((a+b)*(c-d))";
for (char c : expr.toCharArray()) {
    if (c == '(') stack.push(1);
    else if (c == ')') {
        if (stack.empty()) System.out.println("Unbalanced");
        else stack.pop();
    }
}
System.out.println(stack.empty() ? "Balanced" : "Unbalanced");
```

---

## Quick Reference

```java
Stack<T> s = new Stack<>();
s.push(e);      // Add to top
s.pop();        // Remove top (throws if empty)
s.peek();       // View top (throws if empty)
s.empty();      // Check if empty
s.search(e);    // Position from top (1-based)

// Better alternative:
Deque<T> s = new ArrayDeque<>();
s.push(e);  s.pop();  s.peek();
```
