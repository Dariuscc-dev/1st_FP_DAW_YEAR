# Unit 4: Class Libraries, Data Structures and Strings

## Contents
- Class libraries and wrapper classes
- Predefined classes: `Random`, `Math`, `Scanner` and dates
- Data structures: static and dynamic
- Arrays: creation, access, traversal and loading
- Multidimensional arrays: matrices
- Strings: `String` and its methods

## Class libraries
Java includes ready-made classes that we can reuse. This block covers the difference between a class and a primitive type, and what wrapper classes are used for.

### Primitive type vs class
- **Primitive type:** Represents a simple value and is written with a lowercase reserved word.
  ```java
  int age = 20;
  double price = 12.5;
  char letter = 'A';
  ```
- **Class:** Defines objects and provides methods to work with them.
  - Already known examples: `String`, `Scanner`, `System`.

### Wrapper classes
A wrapper class represents a primitive value as an object and provides useful methods to work with it.

| Primitive | Wrapper class |
| :--- | :--- |
| `int` | `Integer` |
| `char` | `Character` |
| `boolean` | `Boolean` |
| `long` | `Long` |
| `double` | `Double` |
| `float` | `Float` |
| `short` | `Short` |
| `byte` | `Byte` |

> **Exceptions to memorize:** `int` → `Integer` and `char` → `Character`. The rest are just the primitive name capitalized.

### Integer: converting between `int` and `String`

```java
int number = 123;
String text = Integer.toString(number);   // "123"

String data = "456";
int value = Integer.parseInt(data);       // 456
```

- `toString()`: Converts the integer `123` into the string `"123"`.
- `parseInt()`: Converts the numeric string `"456"` into the integer `456`.
- **Typical error:** `Integer.parseInt("hola")` cannot produce an `int` and throws an exception (`NumberFormatException`).

### Character: analyzing characters
- `Character.isDigit('2')`: Is it a digit? → `true`
- `Character.isDigit('A')`: Is it a digit? → `false`
- `Character.isUpperCase('A')`: Is it uppercase? → `true`
- `Character.isLowerCase('a')`: Is it lowercase? → `true`
- `Character.toLowerCase('A')`: Converts to lowercase → `'a'`
- `Character.toUpperCase('b')`: Converts to uppercase → `'B'`

### The dot operator: accessing class methods
The dot separates the name of the class (or object) from the method we want to use: `Class.method()`.

```java
Integer.parseInt("123");
Character.isDigit('7');
Math.sqrt(36);
```

> **Key idea:** You don't need to know object-oriented programming in depth yet. In this unit you must recognize the classes, know which methods are used and apply them correctly.

---

## Useful Predefined Classes
- **`Random`:** Generates random values.
- **`Math`:** Groups mathematical operations.
- **`Scanner`:** Reads input from the keyboard.
- **`Date` / `SimpleDateFormat`:** Work with dates and how they are displayed.

### Random: generating random numbers

```java
import java.util.Random;

Random random = new Random();
int n = random.nextInt();
double d = random.nextDouble();
```

1. **Import:** `java.util.Random`.
2. **Create:** A `Random` object with `new Random()`.
3. **Call its methods:**
   - `nextInt()`: Generates an integer.
   - `nextDouble()`: Generates a `double` between `0.0` (included) and `1.0` (excluded).

#### Random integer between 1 and 10

```java
Random random = new Random();
int number = random.nextInt(10) + 1;
System.out.println(number);
```

- `nextInt(10)`: Generates `0, 1, 2, ..., 9`.
- `+ 1`: Shifts the range to `1, 2, 3, ..., 10`.
- **General pattern (min to max):**
  ```java
  random.nextInt(max - min + 1) + min
  ```

### Math: methods and constants

| Method | Purpose | Result |
| :--- | :--- | :--- |
| `Math.round(5.2)` | Rounds | `5` |
| `Math.round(5.9)` | Rounds | `6` |
| `Math.max(10, 2)` | Greater value | `10` |
| `Math.min(10, 2)` | Smaller value | `2` |
| `Math.sqrt(36)` | Square root | `6.0` |
| `Math.pow(2, 5)` | Power | `32.0` |

#### Math.PI: circle example

```java
double radius = 3.0;

double circumference = 2 * Math.PI * radius;
double area = Math.PI * Math.pow(radius, 2);

System.out.println(circumference);
System.out.println(area);
```

- `Math.PI`: Constant that represents π.
- `Math.pow(radius, 2)`: Squares the radius.

> **Important:** `Math` is used directly. We don't create a `Math` object.

#### Scanner + Math: power entered from keyboard

```java
Scanner keyboard = new Scanner(System.in);

System.out.print("Base: ");
int base = keyboard.nextInt();

System.out.print("Exponent: ");
int exp = keyboard.nextInt();

double result = Math.pow(base, exp);
System.out.println(result);
```

- **Input:** `Scanner` reads the base and the exponent.
- **Process:** `Math.pow(base, exp)` calculates the power.
- **Output:** The calculated result is displayed.

### Date: getting the current date

```java
import java.util.Date;

Date today = new Date();
System.out.println("Today is " + today);
```

- `Date` belongs to `java.util`.
- `new Date()`: Creates an object with the current date and time.
- **Output:** Without a specific format, Java shows its full representation.

### SimpleDateFormat: formatting a date

```java
import java.text.SimpleDateFormat;
import java.util.Date;

Date today = new Date();
SimpleDateFormat f = new SimpleDateFormat("dd/MM/yyyy");

System.out.println(f.format(today));
```

- `dd`: Day with two digits.
- `MM`: Month with two digits.
- `yyyy`: Year with four digits.

> **Note:** In `SimpleDateFormat`, `MM` = month and `mm` = minutes.

#### Date with the month name in Spanish

```java
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

Date today = new Date();
SimpleDateFormat f = new SimpleDateFormat(
    "dd 'de' MMMM 'de' yyyy",
    new Locale("es", "ES"));

System.out.println(f.format(today));
```

- `MMMM`: Full name of the month.
- **Literal text:** Words between single quotes are printed as they are.
- `Locale`: Sets the language/region used when formatting.

> **Note:** The `Locale` constructor is deprecated since Java 19. In newer versions you can use `Locale.of("es", "ES")` instead.

---

## Data Structures
Until now, a variable stored a single value. A data structure lets us work with a collection of values under a single identifier.

### Simple data vs structured data
- **Simple data:** A variable holds a single value.
  ```java
  int age = 20;
  double grade = 8.5;
  char letter = 'A';
  ```
- **Structured data:** Groups several values and handles them as a collection.
  ```java
  int[] grades = {7, 5, 9, 8};
  ```

### Static vs dynamic structures
- **Static:** Their size is fixed when created and does not change during execution.
  - Examples in this unit: arrays and matrices.
  - Allow direct access through indexes.
- **Dynamic:** Can grow or shrink during execution.
  - Conceptual examples: stacks, queues, trees.
  - Covered later in the course.

---

## One-Dimensional Arrays
An array stores several elements of the same type. To master arrays you need to understand size, indexes, access, modification, traversal and data loading.

### What is an array?
A collection of elements of the same type stored under a single name. Each position is identified by an index.

| Index | 0 | 1 | 2 | 3 | 4 | 5 |
| :--- | :--- | :--- | :--- | :--- | :--- | :--- |
| **Value** | 15 | 6 | 22 | 400 | 110 | 65 |

- **Fundamental rule:** Indexes start at `0`. In an array of 6 positions, the valid indexes are `0` to `5`.
- **Index ≠ content:** In `data[2]`, the `2` is the position. The value stored there is the content.

### Declaring and creating an array

```java
int[] numbers;
// declared, the array doesn't exist yet

numbers = new int[6];
// now there are 6 positions

// It can also be done in one line:
int[] others = new int[6];
```

- **Declaration:** `int[]` indicates the variable will be an array of integers.
- `new int[6]`: Reserves space for 6 integers.
- **Fixed size:** That array will keep 6 positions for its whole life.

### Default values when creating an array
- **`int`, `long`, `short`, `byte`:** Initialized to `0`.
- **`double`, `float`:** Initialized to `0.0`.
- **`boolean`:** Initialized to `false`.

```java
int[] a = new int[3];
// {0, 0, 0}

String[] names = new String[3];
// {null, null, null}
```

> **Note:** Arrays of references (for example `String[]`) are initialized to `null`, not to `0`.

### Accessing and modifying positions

```java
int[] data = {15, 6, 22, 400, 110, 65};

System.out.println(data[4]); // 110
System.out.println(data[2]); // 22

data[2] = 23;
System.out.println(data[2]); // 23
```

- `data[4]`: Reads the content of position 4.
- `data[2] = 23`: Replaces the value at position 2.
- **Result:** The array becomes `{15, 6, 23, 400, 110, 65}`.

### Index error: going out of bounds

```java
int[] data = new int[6];

System.out.println(data[5]); // valid
System.out.println(data[6]); // ERROR
```

- **Reason:** With 6 positions, the last index is `5`.
- **Exception:** Accessing a position that doesn't exist throws `ArrayIndexOutOfBoundsException`.

> **Mental formula:** last index = `length - 1`.

### `length`: getting the size of the array

```java
int[] data = {15, 6, 22, 400, 110, 65};

System.out.println(data.length); // 6

for (int i = 0; i < data.length; i++) {
    System.out.println(data[i]);
}
```

- `data.length`: Returns the number of positions (`6`).
- `i < length`: Makes `i` go through `0, 1, 2, 3, 4, 5`.

> **Important:** In arrays it's `.length` **without parentheses**.

### Traversing an array with `for`

```java
int[] data = {10, 20, 30};

for (int i = 0; i < data.length; i++) {
    System.out.println("Position " + i + " -> " + data[i]);
}
```

- `i`: The index (`0, 1, 2`).
- `data[i]`: The content (`10, 20, 30`).

#### Step-by-step traversal

| Iteration | `i` | Action |
| :--- | :--- | :--- |
| 1st | `0` | `data[0] = 10` |
| 2nd | `1` | `data[1] = 20` |
| 3rd | `2` | `data[2] = 30` |
| End | `3` | `3 < 3` is `false` → loop ends |

> **Key:** The loop ends before `i` reaches a position that doesn't exist.

### Initializing an array with known values

```java
int[] grades = {7, 5, 9, 8, 6};

System.out.println(grades.length); // 5
System.out.println(grades[0]);     // 7
System.out.println(grades[4]);     // 6
```

- **Braces `{ }`:** Contain the initial values.
- **Size:** Java deduces 5 positions.
- **Indexes:** Go from `0` to `4`.

### Filling an array from the keyboard

```java
Scanner keyboard = new Scanner(System.in);
int[] numbers = new int[5];

for (int i = 0; i < numbers.length; i++) {
    System.out.print("Value " + i + ": ");
    numbers[i] = keyboard.nextInt();
}
```

- **Loop:** Visits every position of the array.
- `nextInt()`: Reads an integer on each iteration.
- `numbers[i]`: Stores the value in the current position.

### Solved example: sum of all elements

```java
int[] data = {4, 7, 2, 9};
int sum = 0;

for (int i = 0; i < data.length; i++) {
    sum = sum + data[i];
}

System.out.println(sum); // 22
```

| Step | Calculation |
| :--- | :--- |
| Start | `sum = 0` |
| `i = 0` | `sum = 0 + 4 = 4` |
| `i = 1` | `sum = 4 + 7 = 11` |
| `i = 2` | `sum = 11 + 2 = 13` |
| `i = 3` | `sum = 13 + 9 = 22` |

> **Pattern:** To add up values, use an accumulator initialized to `0` + a full traversal.

### Solved example: calculating the average

```java
int[] grades = {7, 5, 9, 8, 6};
int sum = 0;

for (int i = 0; i < grades.length; i++) {
    sum += grades[i];
}

double average = (double) sum / grades.length;
System.out.println(average); // 7.0
```

- **Sum:** First, accumulate all the grades.
- **Cast:** `(double)` avoids integer division.
- **Divisor:** The number of grades is `grades.length`.

### Solved example: finding the largest value

```java
int[] data = {4, 7, 2, 9, 5};
int max = data[0];

for (int i = 1; i < data.length; i++) {
    if (data[i] > max) {
        max = data[i];
    }
}

System.out.println(max); // 9
```

1. **Initialization:** The first element is the provisional maximum.
2. **Comparison:** Each value is compared with `max`.
3. **Update:** If it's greater, it replaces the stored value.

### Solved example: searching for a value

```java
int[] data = {4, 7, 2, 9, 5};
int target = 9;
boolean found = false;

for (int i = 0; i < data.length; i++) {
    if (data[i] == target) {
        found = true;
    }
}

System.out.println(found); // true
```

- **Flag:** `found` starts as `false`.
- **Condition:** Each element is compared with `target`.
- **Result:** If it appears, the flag becomes `true`.

---

## Multidimensional Arrays: Matrices
A matrix is a two-dimensional array. Each element is located using two indexes: first the row, then the column.

### How a matrix is organized

|  | col 0 | col 1 | col 2 | col 3 |
| :--- | :--- | :--- | :--- | :--- |
| **row 0** | `[0][0]` | `[0][1]` | `[0][2]` | `[0][3]` |
| **row 1** | `[1][0]` | `[1][1]` | `[1][2]` | `[1][3]` |
| **row 2** | `[2][0]` | `[2][1]` | `[2][2]` | `[2][3]` |

- **Order:** `matrix[row][column]`
- **Size:** 3 rows × 4 columns

### Declaring and initializing a matrix

```java
int[][] matrix = new int[3][4];

int[][] other = {
    {8, 3, 10, 6},
    {10, 4, 11, 12},
    {13, 17, 4, 0}
};
```

- `new int[3][4]`: Creates 3 rows and 4 columns.
- **Inner braces:** Each `{ ... }` group represents a row.
- **Example:** `other[1][2]` contains `11`.

### Accessing matrix positions

```java
int[][] m = {
    {8, 3, 10, 6},
    {10, 4, 11, 12},
    {13, 17, 4, 0}
};

System.out.println(m[0][2]); // 10
System.out.println(m[2][3]); // 0
```

- `m[0][2]`: Row 0, column 2 → `10`.
- `m[2][3]`: Row 2, column 3 → `0`.

> **Typical error:** In a 3 × 4 matrix, row 3 and column 4 don't exist.

### `length` in matrices

```java
int rows = matrix.length;
int columns = matrix[0].length;

System.out.println(rows);
System.out.println(columns);
```

- `matrix.length`: Number of rows.
- `matrix[0].length`: Number of columns in row 0.
- **Robust traversal:** Inside the loop, use `matrix[row].length`.

### Traversing a matrix with two loops

```java
for (int row = 0; row < matrix.length; row++) {
    for (int col = 0; col < matrix[row].length; col++) {
        System.out.println(matrix[row][col]);
    }
}
```

- **Outer loop:** Goes through the rows.
- **Inner loop:** Goes through the columns of the current row.
- `matrix[row][col]`: The current value.

#### Actual traversal order

```text
1. [0][0]   2. [0][1]   3. [0][2]   4. [0][3]
5. [1][0]   6. [1][1]   7. [1][2]   8. [1][3]
9. [2][0]  10. [2][1]  11. [2][2]  12. [2][3]
```

> **Reading:** A full row is completed before moving on to the next one.

### Filling a matrix from the keyboard

```java
Scanner keyboard = new Scanner(System.in);
int[][] m = new int[3][3];

for (int row = 0; row < m.length; row++) {
    for (int col = 0; col < m[row].length; col++) {
        System.out.print("[" + row + "][" + col + "]: ");
        m[row][col] = keyboard.nextInt();
    }
}
```

- **Two indexes:** Each read needs a row and a column.
- **First position:** The first input goes to `m[0][0]`.
- **Last position:** In a 3 × 3 matrix, the last one is `m[2][2]`.

### Displaying a matrix as a table

```java
for (int row = 0; row < m.length; row++) {
    for (int col = 0; col < m[row].length; col++) {
        System.out.print(m[row][col] + "\t");
    }
    System.out.println();
}
```

- `print`: Shows elements of the same row without a line break.
- `\t`: Adds a tab between columns.
- `println()`: When a row is finished, moves to the next line.

### Solved example: sum of a matrix

```java
int sum = 0;

for (int row = 0; row < m.length; row++) {
    for (int col = 0; col < m[row].length; col++) {
        sum += m[row][col];
    }
}

System.out.println("Sum = " + sum);
```

- **Accumulator:** `sum` starts at `0`.
- **Double traversal:** Every cell is visited.
- **Pattern:** Same idea as with arrays, but with two indexes.

---

## Strings: `String`
`String` is a class for working with text. You need to master creating, reading and comparing strings, plus the most common methods in this unit.

### Creating strings: null, empty and with content
- **No value:** `String a;` → No content has been assigned. Depending on the context it can be `null` or uninitialized.
- **Empty:** `String b = "";` → The string exists but contains 0 characters.
- **With text:** `String c = "Hola";` → Contains 4 characters.

> **Important:** `null` and `""` are not the same. An empty string is a valid `String` with length 0.

### Scanner: `next()` vs `nextLine()`
- **`next()`:** Reads up to the next separator (usually a space).
  - Input: `Ana María` → Result: `"Ana"`
  - The remaining part stays pending for future reads.
- **`nextLine()`:** Reads the whole line until Enter is pressed.
  - Input: `Ana María` → Result: `"Ana María"`
  - Suitable for full names or sentences.

> **Exam:** You must know how to choose between `next()` and `nextLine()` depending on the text you want to read.

#### Classic error: `nextInt()` followed by `nextLine()`

```java
System.out.print("Age: ");
int age = keyboard.nextInt();

System.out.print("Full name: ");
String name = keyboard.nextLine(); // May remain empty!

System.out.println(name);
```

- **Problem:** `name` may end up empty.
- **Cause:** `nextInt()` reads the number but leaves the Enter pending.
- **Effect:** `nextLine()` consumes that pending line break.

#### Solution: consume the pending Enter

```java
System.out.print("Age: ");
int age = keyboard.nextInt();

keyboard.nextLine(); // consumes the Enter

System.out.print("Full name: ");
String name = keyboard.nextLine();
```

- **Extra line:** The first `nextLine()` clears the pending line break.
- **Actual read:** The second `nextLine()` waits for the full name.

> **Rule:** Number → `nextLine()`: always check for the pending Enter.

### Comparing Strings: `equals()`, not `==`

```java
String s1 = "Madrid";
String s2 = "Madrid";

if (s1.equals(s2)) {
    System.out.println("Same content");
}
```

- `==`: With objects it compares references. It's not the correct way to compare text.
- `equals()`: Compares the content of the strings.
- **Result:** If both contain `"Madrid"`, it returns `true`.

### `equalsIgnoreCase()`: ignoring case

```java
String a = "Madrid";
String b = "madrid";

System.out.println(a.equals(b));           // false
System.out.println(a.equalsIgnoreCase(b)); // true
```

- `equals()`: Distinguishes between uppercase and lowercase.
- `equalsIgnoreCase()`: Compares text without distinguishing case.
- **Use case:** User answers like `SI`, `Si`, `si`...

### `length()` and `charAt()`

```java
String s = "Hola mundo";

int length = s.length(); // 10
char c = s.charAt(3);    // 'a'
```

- `length()`: Returns the number of characters.
- `charAt(3)`: Returns the character at position 3.

> **Don't confuse:** Array → `.length` · String → `.length()`

### Strings also use positions from 0

| Index | 0 | 1 | 2 | 3 |
| :--- | :--- | :--- | :--- | :--- |
| **Char** | H | O | L | A |

- `"HOLA".charAt(0)` → `'H'`
- `"HOLA".charAt(3)` → `'A'`

> **Note:** The last valid position is `length() - 1`.

### `indexOf()`: locating text

```java
String s = "Hola mundo";

int p1 = s.indexOf("mundo"); // 5
int p2 = s.indexOf("Java");  // -1
```

- **Found:** Returns the position where the substring starts.
- **Not found:** Returns `-1`.
- **Use case:** Checking whether a text contains another one.

### `substring()`: extracting a part

```java
String s = "Hola mundo";

String a = s.substring(5);    // "mundo"
String b = s.substring(5, 7); // "mu"
```

| Index | 0 | 1 | 2 | 3 | 4 | 5 | 6 | 7 | 8 | 9 |
| :--- | :--- | :--- | :--- | :--- | :--- | :--- | :--- | :--- | :--- | :--- |
| **Char** | H | o | l | a | ␠ | m | u | n | d | o |

- `substring(5)`: From position 5 (`m`) to the end → `"mundo"`.
- `substring(5, 7)`: Takes positions 5 and 6 → `"mu"`. Position 7 is left out.

> **Rule:** Start included, end excluded.

### Uppercase and lowercase

```java
String s = "Hola mundo";

String upper = s.toUpperCase(); // "HOLA MUNDO"
String lower = s.toLowerCase(); // "hola mundo"
```

- `toUpperCase()`: Returns a new string in uppercase.
- `toLowerCase()`: Returns a new string in lowercase.

> **Important:** If you want to keep the result, assign it to a variable.

### `trim()`: removing outer spaces

```java
String s = "   Hola mundo   ";
String clean = s.trim();

System.out.println(clean); // "Hola mundo"
```

- **Removes:** Spaces at the beginning and the end.
- **Keeps:** Inner spaces between words.
- **Result:** Returns a new string.

### `split()`: splitting a string

```java
String s = "Hola mundo";
String[] words = s.split(" ");

System.out.println(words[0]); // Hola
System.out.println(words[1]); // mundo
```

- **Separator:** Here we use the space `" "`.
- **Result:** `split()` returns an array of `String`.
- **Consequence:** We can loop through the words with a `for`.

### `concat()`: joining strings

```java
String s = "Hola ";
String s2 = s.concat("mundo");

System.out.println(s2); // Hola mundo

String s3 = s + "mundo"; // equivalent in this case
```

- `concat()`: Joins the original string with another one.
- **Operator `+`:** Also concatenates when `String` values are involved.
- **Result:** A new string is obtained.

### Array of `String`: reading words

```java
String[] words = new String[3];
Scanner keyboard = new Scanner(System.in);

for (int i = 0; i < words.length; i++) {
    System.out.print("Word " + (i + 1) + ": ");
    words[i] = keyboard.next();
}
```

- **Array:** Each position stores a `String`.
- **Loop:** Goes through every position.
- `next()`: In this example it reads one word at a time.

### Array of `String`: displaying content

```java
for (int i = 0; i < words.length; i++) {
    System.out.println("Position " + i + ": " + words[i]);
}
```

- `i`: Array index.
- `words[i]`: The `String` stored in that position.
- **Pattern:** Same traversal as with `int[]`.

### Integrated example: searching for a name

```java
String[] names = {"Ana", "Luis", "Marta"};
String target = "marta";
boolean found = false;

for (int i = 0; i < names.length; i++) {
    if (names[i].equalsIgnoreCase(target)) {
        found = true;
    }
}

System.out.println(found); // true
```

- **Array:** Stores several names.
- **`for`:** Goes through all the elements.
- **`equalsIgnoreCase()`:** Compares each name ignoring case.

---

## Common Mistakes to Avoid

| Mistake | Why it's wrong |
| :--- | :--- |
| `array[array.length]` | The last index is `length - 1` |
| `array.length()` | In arrays it's `.length` (no parentheses) |
| `text.length` | In `String` it's `.length()` |
| `s1 == s2` | Don't use it to compare `String` content |
| `nextInt()` → `nextLine()` | The Enter may stay pending in the buffer |
| `matrix[col][row]` | In this unit we use `matrix[row][column]` |

---

## Review & Summary

### What you must be able to do in the exam
- Recognize primitive types, classes and wrapper classes; apply `Integer` and `Character`.
- Use the studied `Random` and `Math` methods and understand the examples with `Scanner` and dates.
- Distinguish static and dynamic structures.
- Declare, create, initialize, read, modify, fill and traverse arrays.
- Solve array traversals: sum, average, search and maximum.
- Declare, access, fill and traverse matrices with nested loops.
- Read `String` values with `next()` / `nextLine()` and fix the pending line break.
- Compare `String` values with `equals()` / `equalsIgnoreCase()` and use the studied methods.

### Concept Map
- **Classes:** Wrappers, `Random`, `Math`, `Scanner`, `Date`
- **Arrays:** Indexes, `length`, `for`, loading, searching
- **Matrices:** Row/column, two nested loops
- **String:** `equals()`, `length()`, `charAt()`, `substring()`
- **Input:** `next()`, `nextLine()`, buffer and Enter

> The unit connects predefined classes + data structures + text handling. The goal isn't to memorize code: it's to understand what each instruction does and be able to adapt it to a similar problem.