# Java Generics - Easy Notes

## 1. What Are Generics?
Generics allow you to write classes, interfaces, and methods that work with **different data types** while maintaining **type safety**.

Think of it as writing a flexible recipe that works with different ingredients!

## 2. Why Use Generics?
- ✅ **Type Safety**: Catch errors at compile time, not runtime
- ✅ **No Casting**: No need for explicit type casting
- ✅ **Code Reusability**: Write once, use with any type

### Without Generics (Old Way)
```java
List list = new ArrayList();
list.add("Hello");
list.add(123); // This is allowed - BAD!

String name = (String) list.get(0); // Need casting
```

### With Generics (New Way)
```java
List<String> list = new ArrayList<String>();
list.add("Hello");
list.add(123); // Compiler ERROR - Type safe!

String name = list.get(0); // No casting needed!
```

## 3. Generic Classes

### Basic Syntax
```java
public class Box<T> {
    private T item;
    
    public void set(T item) {
        this.item = item;
    }
    
    public T get() {
        return item;
    }
}
```

**`T` is a type parameter** - it's a placeholder for any type!

### Using Generic Classes
```java
Box<String> stringBox = new Box<>();
stringBox.set("Hello");
String result = stringBox.get(); // No casting!

Box<Integer> intBox = new Box<>();
intBox.set(42);
Integer num = intBox.get();
```

### Multiple Type Parameters
```java
public class Pair<K, V> {
    private K key;
    private V value;
    
    public Pair(K key, V value) {
        this.key = key;
        this.value = value;
    }
}

// Usage
Pair<String, Integer> pair = new Pair<>("age", 25);
```

## 4. Generic Methods

You can make individual methods generic, even in non-generic classes:

```java
public class Utilities {
    // Generic method
    public static <T> void printArray(T[] array) {
        for (T item : array) {
            System.out.println(item);
        }
    }
}

// Usage
Integer[] nums = {1, 2, 3};
String[] names = {"Alice", "Bob"};

Utilities.printArray(nums);   // Works with Integer
Utilities.printArray(names);  // Works with String
```

## 5. Bounded Type Parameters

Restrict which types can be used as type arguments.

### Upper Bound (Extends)
```java
// T must be Number or its subclass
public class Counter<T extends Number> {
    public double add(T a, T b) {
        return a.doubleValue() + b.doubleValue();
    }
}

// Valid
Counter<Integer> counter1 = new Counter<>();
Counter<Double> counter2 = new Counter<>();

// Invalid - String is not a Number
// Counter<String> counter3 = new Counter<>();
```

### Multiple Bounds
```java
// T must extend both Comparable and Serializable
public class Container<T extends Comparable & Serializable> {
    // ...
}
```

## 6. Wildcards (?)

Use wildcards when you don't know or don't care about the exact type.

### Unbounded Wildcard
```java
public void printList(List<?> list) {
    for (Object item : list) {
        System.out.println(item);
    }
}

printList(new ArrayList<String>());
printList(new ArrayList<Integer>());
```

### Upper Bounded Wildcard (? extends)
```java
// Accept only Number or its subtypes
public double sumNumbers(List<? extends Number> list) {
    double sum = 0;
    for (Number num : list) {
        sum += num.doubleValue();
    }
    return sum;
}

sumNumbers(Arrays.asList(1, 2, 3));           // Integer
sumNumbers(Arrays.asList(1.5, 2.5, 3.5));     // Double
```

### Lower Bounded Wildcard (? super)
```java
// Accept Integer or its supertypes (Integer, Number, Object)
public void addNumbers(List<? super Integer> list) {
    list.add(100);
    list.add(200);
}
```

## 7. Type Erasure (Important!)

Generics are **erased at runtime** for backward compatibility:

```java
List<String> stringList = new ArrayList<>();
List<Integer> intList = new ArrayList<>();

// At runtime, both become: List
System.out.println(stringList.getClass() == intList.getClass()); // true!
```

**Why it matters:**
- You **can't** use `new T()` in generic classes
- You **can't** check `instanceof` with generic types
- Type information is lost at runtime

## 8. Common Examples

### Generic List
```java
List<String> names = new ArrayList<>();
names.add("Alice");
names.add("Bob");

for (String name : names) {
    System.out.println(name); // No casting!
}
```

### Generic Map
```java
Map<String, Integer> scores = new HashMap<>();
scores.put("Alice", 95);
scores.put("Bob", 87);

Integer aliceScore = scores.get("Alice"); // No casting!
```

## Key Takeaways
| Concept | Purpose |
|---------|---------|
| `<T>` | Generic type parameter |
| `<K, V>` | Multiple type parameters |
| `<T extends Number>` | Bounded type parameter |
| `<?>` | Unbounded wildcard |
| `<? extends X>` | Upper bounded wildcard |
| `<? super X>` | Lower bounded wildcard |

---

**Remember:** Generics help you write safer, cleaner code by catching type errors at compile time! 🎯