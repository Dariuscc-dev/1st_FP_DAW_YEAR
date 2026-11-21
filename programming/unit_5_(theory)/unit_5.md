# Unit 5: Modular Programming and Methods

## Overview & Contents
- **Modular decomposition:** why we split a program into modules, top-down design, **cohesion** and **coupling**.
- **Functions and methods:** what happens on a call, method anatomy, `return`, `void`, parameters.
- **Methods in Java:** full syntax, `static`, where methods live, **variable scope**, good method design.
- **Parameters:** formal vs actual, order and types, and why **Java always passes by value**.
- **Method overloading:** what is (and isn't) a valid overload.
- **Full application** split into methods, common mistakes and solved exercises.

## Block 1: Modular Decomposition
- **Linear programming:** the program grows as one big block. Hard to find bugs, follow the flow or reuse parts.
- **Structured programming:** organizes the flow with sequence, selection (`if` / `switch`) and repetition (`for` / `while`), without arbitrary jumps like `GOTO`.
- **Modular programming:** goes one step further and splits complete tasks into **modules** (subprograms) that can be called when needed.

Example, a grades program:

| Method | Role |
|---|---|
| `main()` | Coordinates |
| `readGrades()` | Input |
| `calculateAverage()` | Processing |
| `showResult()` | Output |

### Why modularize
| Structuring gives you | Modularizing gives you |
|---|---|
| Code that is easier to understand | Reuse: one method, many calls |
| Simpler testing | Teamwork on separate modules |
| Localized maintenance (fix only the affected module) | Less duplicated code |

### Top-down design ("divide and conquer")
Complex problem → smaller tasks → concrete methods. Example: *Manage contacts* → add, delete, search, list → read data, validate, locate, show. Keep refining until every task can be solved with a simple algorithm.

### Cohesion and coupling
| Concept | Meaning | Goal |
|---|---|---|
| **Cohesion** | All the instructions of a module work on ONE task | **High** cohesion |
| **Coupling** | How much a module depends on others | **Low** coupling (little external data, clear interfaces) |

```java
// BAD: too many tasks in one method
static void processStudent() {
    // read data, validate, calculate grade, print report, save data
}

// BETTER: one task per method
static void readData() { ... }
static boolean validate() { ... }
static double calculateGrade() { ... }
static void showReport() { ... }
```

Rule of thumb: if the method name needs several verbs ("read, calculate and show"), it is doing too much.

## Block 2: Functions and Methods
In Java, functions that belong to a class are called **methods**.

What happens on a call:

1. `main()` is running.
2. It calls `calculate()`.
3. `main` waits.
4. `calculate()` runs its body.
5. It returns control (and maybe a result).
6. `main` continues right after the call.

### Anatomy of a method
```java
public static int max(int a, int b) {
    if (a > b) {
        return a;
    }
    return b;
}
```

| Part | Meaning |
|---|---|
| `public static` | Modifiers (for now, so we can call it from `main`) |
| `int` | Return type |
| `max(int a, int b)` | Name + parameter list |
| `{ ... }` | Body: the instructions |

- **Header:** name, what it receives and what it returns (`static int add(int a, int b)`).
- **Body:** the implementation.
- **Declare / define** = write header and body. **Invoke** = call it so it runs.

```java
static int square(int n) {   // definition
    return n * n;
}

int result = square(5);   // invocation
System.out.println(result); // 25
```

### `return`
`return` ends the method and hands a value back to the caller. The value must be compatible with the declared return type. As soon as `return` runs, the method ends.

A method can contain several `return` statements, but in one execution only the first one reached runs:

```java
static int absoluteValue(int n) {
    if (n >= 0) {
        return n;   // ends here
    }
    return -n;      // only if n < 0
}
// absoluteValue(5) → 5, absoluteValue(-5) → 5
```

### `void` methods
They do a task and return nothing. They can use `return;` with no value to exit early, but it is optional.

```java
static void showMenu() {
    System.out.println("1. Add");
    System.out.println("2. Delete");
    System.out.println("3. Exit");
}
```

### With and without parameters
```java
static void greet() { System.out.println("Hello"); }                 // greet();
static void greet(String name) { System.out.println("Hello " + name); } // greet("Ana");
```

Parentheses are always required, in the declaration and in the call, even with no parameters.

### What to do with a returned value
```java
static int max(int a, int b) {
    return (a >= b) ? a : b;
}

int m = max(6, 10);                 // 1. store it
System.out.println(max(6, 10));     // 2. use it directly
int twice = max(6, 10) * 2;         // 3. use it in another expression
```

`max(6, 10);` alone compiles (Java lets you ignore a return value), but the 10 is lost, so it usually makes no sense.

## Block 3: Methods in Java
```java
public static returnType methodName(type p1, type p2) {
    // instructions
    return result; // if returnType is not void
}
```

Methods are declared **inside the class but outside `main`**. Since `main` is `static`, at this level the methods we call from `main` are also `static`. Instance methods come later with OOP.

```java
public class App {
    static int twice(int n) {
        return n * 2;
    }

    public static void main(String[] args) {
        System.out.println(twice(5));
    }
}
```

### Variable scope
```java
static int add(int a, int b) {
    int total = a + b;
    return total;
}

public static void main(String[] args) {
    // System.out.println(total); // ERROR: total only exists inside add()
}
```

Local variables (and parameters) only exist inside their method.

### Designing a good method
- The **name** says the action: `calculateAverage`, `findMax`, `showMenu`.
- Only the **parameters** it needs.
- Small, clear and with **one responsibility**.

```java
static int max(int n1, int n2, int n3) {
    int largest = n1;
    if (n2 > largest) largest = n2;
    if (n3 > largest) largest = n3;
    return largest;
}
```

Trace of `max(6, 10, 8)`: n1=6, n2=10, n3=8 → largest starts at 6 → 10 > 6 so largest = 10 → 8 > 10 is false → `return 10`.

### Showing is not returning
```java
static void showMax(int a, int b) {   // prints inside the method
    int larger = (a >= b) ? a : b;
    System.out.println(larger);
}

static int getMax(int a, int b) {    // hands the value to the caller
    return (a >= b) ? a : b;
}
```

If a method calculates something reusable, return it instead of printing it. The caller can then print it, compare it, store it or pass it to another method, which lowers coupling.

## Block 4: Parameters
```java
static int sum(int num1, int num2) {   // num1, num2 = formal parameters
    return num1 + num2;
}

int a = 5, b = 8;
int total = sum(a, b);                 // a, b = actual parameters (arguments)
```

- **Order matters:** the first argument goes to the first parameter, and so on.
- **Types matter:** each argument must be compatible with its parameter. `show(20, "Ana")` fails if the method is `show(String name, int age)`.
- **Names don't matter:** only the position counts.

### Java always passes by value
In Java **every** argument is passed by value. What changes is which value is copied:

| Argument | What is copied | Effect |
|---|---|---|
| Primitive (`int`, `double`...) | The value | Changing the parameter does not change the original |
| Array / object | The value of the **reference** | Both point to the same object, so the method can change its contents |

```java
static void addTen(int number) {
    number = number + 10;
}
int original = 5;
addTen(original);
System.out.println(original); // 5
```

```java
static void increment(int[] data) {
    for (int i = 0; i < data.length; i++) {
        data[i]++;
    }
}
int[] numbers = {1, 10, 100};
increment(numbers); // numbers is now {2, 11, 101}
```

Modifying the object is not the same as **reassigning** the reference:

```java
static void reassign(int[] data) {
    data = new int[]{9, 9, 9}; // only the local copy of the reference changes
}
int[] numbers = {1, 2, 3};
reassign(numbers); // numbers is still {1, 2, 3}
```

`String` is an object but it is **immutable**: its methods return a new String, and reassigning the parameter only changes the local copy.

```java
static void change(String text) {
    text = text.toUpperCase();
}
String name = "Ana";
change(name);
System.out.println(name); // Ana
```

A method can also **return an array**:

```java
static int[] doubleValues(int[] data) {
    int[] copy = new int[data.length];
    for (int i = 0; i < data.length; i++) {
        copy[i] = data[i] * 2;
    }
    return copy;
}
```

## Block 5: Method Overloading
Same name, **different parameter list**.

```java
static int sum(int a, int b) { return a + b; }
static int sum(int a, int b, int c) { return a + b + c; }    // different number
static double sum(double a, double b) { return a + b; }       // different types
static int sum(int[] data) { ... }                           // int[] vs double[]
static double sum(double[] data) { ... }
```

The compiler picks the version that matches the arguments:

```java
int x = sum(2, 3);         // sum(int, int)
double y = sum(2.5, 3.1);  // sum(double, double)
int z = sum(1, 2, 3);      // sum(int, int, int)
```

Not a valid overload:

```java
static int value(int x) { return x; }
static double value(int x) { return x; } // ERROR: only the return type changes
```

Overloads differ by the **number, type or order of parameters**, never only by the return type.

## Block 6: Full Application
Goal: read 5 grades, calculate the average and say whether the student passes.

```java
static int[] readGrades(Scanner keyboard) {
    int[] grades = new int[5];
    for (int i = 0; i < grades.length; i++) {
        System.out.print("Grade " + (i + 1) + ": ");
        grades[i] = keyboard.nextInt();
    }
    return grades;
}

static double calculateAverage(int[] grades) {
    int sum = 0;
    for (int grade : grades) {
        sum += grade;
    }
    return (double) sum / grades.length; // cast avoids integer division
}

static boolean hasPassed(double average) {
    return average >= 5;
}

static void showResult(double average) {
    System.out.println("Average: " + average);
    if (hasPassed(average)) {   // a method can call another one
        System.out.println("PASS");
    } else {
        System.out.println("FAIL");
    }
}

public static void main(String[] args) {
    Scanner keyboard = new Scanner(System.in);
    int[] grades = readGrades(keyboard);
    double average = calculateAverage(grades);
    showResult(average);
    keyboard.close();
}
```

`main` reads like a script: read → calculate → show. When a method ends, execution goes back to the point right after the call.

## Common Mistakes
| Mistake | Example |
|---|---|
| Incompatible return | `static int f() { return 2.5; }` |
| Missing `return` | An `int` method that doesn't return on every path |
| Arguments in the wrong order | `show(20, "Ana")` |
| Using a local variable outside its method | `total` only exists inside `add()` |
| Thinking Java passes arrays "by reference" | Java copies the value of the reference |
| Overloading only by return type | `int f(int)` and `double f(int)` clash |

## Practice Exercises (solved)
```java
static double circleArea(double radius) {
    return Math.PI * radius * radius;
}

static boolean isEven(int number) {
    return number % 2 == 0;
}
// isEven(7) → false → prints "Odd"

static int countEvens(int[] data) {
    int counter = 0;
    for (int n : data) {
        if (n % 2 == 0) counter++;
    }
    return counter;
}

// Is this an overload? Yes: same name, (int, int) vs (double, double).
static int min(int a, int b) { return (a < b) ? a : b; }
static double min(double a, double b) { return (a < b) ? a : b; }
```

## Questions You Should Be Able to Answer
1. What are the advantages of modularizing a program?
2. What do cohesion and coupling mean?
3. What happens from the moment a method is called until it ends?
4. What is the difference between `void` and a method with a return value?
5. What are formal parameters and actual arguments?
6. What is copied when you pass an `int`? And an array?
7. What makes a valid overload?
8. Why does `main` get clearer when it delegates tasks?

A good program is not one huge block: it is a set of small pieces that work together.
