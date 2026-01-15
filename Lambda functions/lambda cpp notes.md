# Lambda Functions in C++

## Introduction
Lambda functions (also called lambda expressions) were introduced in **C++11**. They allow you to define anonymous functions inline, making code more concise and readable.

---

## Basic Syntax

```cpp
[capture](parameters) -> return_type { body }
```

| Part | Description |
|------|-------------|
| `[capture]` | Specifies which variables from the enclosing scope are accessible |
| `(parameters)` | Function parameters (optional if empty) |
| `-> return_type` | Return type (optional - compiler can deduce it) |
| `{ body }` | Function body |

---

## Simple Examples

### Basic Lambda
```cpp
auto greet = []() {
    std::cout << "Hello, World!" << std::endl;
};
greet();  // Output: Hello, World!
```

### Lambda with Parameters
```cpp
auto add = [](int a, int b) {
    return a + b;
};
std::cout << add(3, 5);  // Output: 8
```

### Lambda with Explicit Return Type
```cpp
auto divide = [](double a, double b) -> double {
    return a / b;
};
```

---

## Capture Clause

The capture clause determines how variables from the enclosing scope are accessed.

| Capture | Description |
|---------|-------------|
| `[]` | No variables captured |
| `[x]` | Capture `x` by value (copy) |
| `[&x]` | Capture `x` by reference |
| `[=]` | Capture all variables by value |
| `[&]` | Capture all variables by reference |
| `[=, &x]` | Capture all by value, but `x` by reference |
| `[&, x]` | Capture all by reference, but `x` by value |
| `[this]` | Capture the `this` pointer |

### Capture Examples

```cpp
int x = 10;
int y = 20;

// Capture by value
auto byValue = [x]() {
    std::cout << x;  // x is copied
    // x = 5;  // ERROR: x is read-only
};

// Capture by reference
auto byRef = [&x]() {
    x = 100;  // Modifies original x
};

// Capture all by value
auto allByValue = [=]() {
    std::cout << x << " " << y;
};

// Capture all by reference
auto allByRef = [&]() {
    x = 50;
    y = 60;
};
```

---

## Mutable Lambdas

By default, variables captured by value are `const`. Use `mutable` to modify them:

```cpp
int count = 0;
auto counter = [count]() mutable {
    return ++count;  // Allowed because of mutable
};

std::cout << counter();  // Output: 1
std::cout << counter();  // Output: 2
std::cout << count;      // Output: 0 (original unchanged)
```

---

## Generic Lambdas (C++14)

Use `auto` for parameters to create generic lambdas:

```cpp
auto print = [](auto value) {
    std::cout << value << std::endl;
};

print(42);        // Works with int
print(3.14);      // Works with double
print("Hello");   // Works with string
```

---

## Lambda with STL Algorithms

Lambdas are commonly used with STL algorithms:

### std::for_each
```cpp
std::vector<int> nums = {1, 2, 3, 4, 5};

std::for_each(nums.begin(), nums.end(), [](int n) {
    std::cout << n * 2 << " ";
});
// Output: 2 4 6 8 10
```

### std::sort (Custom Comparator)
```cpp
std::vector<int> nums = {5, 2, 8, 1, 9};

// Sort in descending order
std::sort(nums.begin(), nums.end(), [](int a, int b) {
    return a > b;
});
// Result: 9, 8, 5, 2, 1
```

### std::find_if
```cpp
std::vector<int> nums = {1, 2, 3, 4, 5};

auto it = std::find_if(nums.begin(), nums.end(), [](int n) {
    return n > 3;
});
// *it = 4
```

### std::transform
```cpp
std::vector<int> nums = {1, 2, 3, 4, 5};
std::vector<int> squares(nums.size());

std::transform(nums.begin(), nums.end(), squares.begin(), [](int n) {
    return n * n;
});
// squares = {1, 4, 9, 16, 25}
```

### std::count_if
```cpp
std::vector<int> nums = {1, 2, 3, 4, 5, 6, 7, 8};

int evenCount = std::count_if(nums.begin(), nums.end(), [](int n) {
    return n % 2 == 0;
});
// evenCount = 4
```

---

## Immediately Invoked Lambda Expression (IILE)

Execute a lambda immediately after defining it:

```cpp
int result = [](int a, int b) {
    return a + b;
}(5, 3);  // Called immediately with arguments 5 and 3

std::cout << result;  // Output: 8
```

---

## Storing Lambdas

### Using auto
```cpp
auto lambda = [](int x) { return x * 2; };
```

### Using std::function
```cpp
#include <functional>

std::function<int(int)> lambda = [](int x) { return x * 2; };
```

---

## Lambda as Function Parameter

```cpp
void execute(std::function<void()> func) {
    func();
}

execute([]() {
    std::cout << "Executed!" << std::endl;
});
```

### Using Templates (More Efficient)
```cpp
template<typename Func>
void execute(Func func) {
    func();
}

execute([]() {
    std::cout << "Executed!" << std::endl;
});
```

---

## Returning Lambda from Function

```cpp
auto makeMultiplier(int factor) {
    return [factor](int x) {
        return x * factor;
    };
}

auto triple = makeMultiplier(3);
std::cout << triple(5);  // Output: 15
```

---

## C++17 and C++20 Enhancements

### Constexpr Lambdas (C++17)
```cpp
constexpr auto square = [](int x) {
    return x * x;
};
static_assert(square(5) == 25);  // Compile-time evaluation
```

### Template Lambdas (C++20)
```cpp
auto lambda = []<typename T>(T a, T b) {
    return a + b;
};
```

### Capture with Initializer (C++14)
```cpp
auto lambda = [value = 10]() {
    return value;
};
```

---

## Practical Examples

### Filtering a Vector
```cpp
std::vector<int> nums = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
std::vector<int> evens;

std::copy_if(nums.begin(), nums.end(), std::back_inserter(evens),
    [](int n) { return n % 2 == 0; }
);
// evens = {2, 4, 6, 8, 10}
```

### Custom Deleter for Smart Pointers
```cpp
auto deleter = [](int* ptr) {
    std::cout << "Deleting..." << std::endl;
    delete ptr;
};

std::unique_ptr<int, decltype(deleter)> ptr(new int(42), deleter);
```

### Event Callbacks
```cpp
class Button {
    std::function<void()> onClick;
public:
    void setOnClick(std::function<void()> callback) {
        onClick = callback;
    }
    void click() {
        if (onClick) onClick();
    }
};

Button btn;
btn.setOnClick([]() {
    std::cout << "Button clicked!" << std::endl;
});
btn.click();
```

---

## Summary

| Feature | Syntax |
|---------|--------|
| Basic lambda | `[]() { }` |
| With parameters | `[](int x) { return x; }` |
| Capture by value | `[x]() { }` |
| Capture by reference | `[&x]() { }` |
| Capture all by value | `[=]() { }` |
| Capture all by reference | `[&]() { }` |
| Mutable | `[x]() mutable { x++; }` |
| Generic (C++14) | `[](auto x) { }` |
| Template (C++20) | `[]<typename T>(T x) { }` |

---

## Key Points to Remember

1. Lambdas create **function objects** (functors) at compile time
2. Each lambda has a **unique type** (even identical lambdas)
3. Prefer **capture by reference** for large objects
4. Use **mutable** when you need to modify captured values
5. **Generic lambdas** (C++14) provide template-like flexibility
6. Lambdas are **closure objects** - they capture their environment
