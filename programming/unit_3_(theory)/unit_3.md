# Unit 3: Console and Control Structures

## Contents
- Console applications
- Input and output streams
- Scanner and keyboard input
- Sequential structure
- Selection: `if` / `else` / `switch`
- Repetition: `while` / `do-while` / `for`
- `foreach`, infinite, and nested loops
- `break` / `continue` / `return`

## Console applications
A console application is a program that uses a text-based interface to communicate with the user.
- **Input:** Usually via keyboard.
- **Program:** Processes data and executes instructions.
- **Output:** Usually via screen/display.

Console applications are especially useful for learning a programming language because they remove the complexity of a Graphical User Interface (GUI).

## Stream concept
A stream is an abstraction that allows communication of information between the program and the outside world.
- **Source:** Keyboard, file, network.
- **Stream:** Sequence of data.
- **Destination:** Screen, file, network.

**Key advantages:**
- Device independence.
- Flexibility and variety of sources/destinations.

### Stream packages and classes
- `java.io`: Library that gathers classes related to input/output, avoiding direct device handling complexity.
- `java.lang`: Includes standard streams `System.in`, `System.out`, and `System.err`.

**Types of streams:**
- **Byte streams:** `InputStream`, `OutputStream`
- **Character streams:** `Reader`, `Writer`

**Standard Java streams:**
- `System.in`: Standard input (`InputStream` - `read()`, `skip()`, `available()`).
- `System.out`: Standard output (`PrintStream` - `print()`, `println()`, `printf()`, `flush()`).
- `System.err`: Standard error (`PrintStream` - similar methods to `System.out`).

**Other stream classes:**
- `BufferedInputStream` / `BufferedOutputStream`: Buffered input/output.
- `FileInputStream` / `FileOutputStream`: Read/write bytes to/from files.
- `StreamTokenizer`: Splits input into tokens.
- `StringReader` / `StringWriter`: String-based streams.

**How to use a stream:**
1. **Open:** Create/associate the stream with a source or destination.
2. **Read/Write:** Process data while available.
3. **Close:** Close the stream using `close()` when applicable.

> **Note:** For standard streams (`System.in`, `System.out`, `System.err`), the system automatically manages opening and closing.

## Keyboard input

### Scanner: reading from keyboard
Belongs to `java.util` and allows reading different data types.

```java
import java.util.Scanner;
Scanner teclado = new Scanner(System.in); 
```

### Main Scanner Methods
- `next()`: Next element as `String`.
- `nextLine()`: Reads the rest of the complete line.
- `nextInt()` / `nextLong()`: Integer numbers.
- `nextFloat()` / `nextDouble()`: Decimal numbers.
- `nextBoolean()`: Boolean value.
- `hasNextXxx()`: Checks if the next input matches the expected data type.

#### Scanner: Classic Error when Mixing Numbers and Strings
When reading a number followed by a call to `nextLine()`, the `String` variable often ends up empty:

```java
Scanner teclado = new Scanner(System.in);
System.out.print("Edad: ");
int edad = teclado.nextInt();
System.out.print("Nombre completo: ");
String nombre = teclado.nextLine(); // Remains empty!
```

- **Reason:** `nextInt()` consumes the numeric value, but leaves the newline character (`\n` / Enter) pending in the buffer. `nextLine()` then reads this remaining newline character immediately.
- **Solutions:**
  1. **Extra `nextLine()`:** Add an extra `teclado.nextLine()` after reading the number to consume the pending newline.
  2. **Read complete line and parse:** Read the line as a `String` and convert it:
     ```java
     int edad = Integer.parseInt(teclado.nextLine());
     ```

---

## Sequential Structure
Instructions execute sequentially, one after another, in the order they appear.

```java
{
    instruccion_1;
    instruccion_2;
    instruccion_3;
}
```

Blocks are delimited using `{ }`. Keeping curly braces is recommended even for single-line blocks.

### ANSI Text Formatting
ANSI escape sequences can be used to modify text colors in compatible terminals:

```java
String rojo = "\033[31m";
String reset = "\u001B[0m";
System.out.println(rojo + "Texto rojo" + reset);
```

- **General Format:** `ESC [ brightness ; foregroundColor ; backgroundColor m`

---

## Selection Structures
Selection structures allow choosing which instructions to execute based on a boolean condition (`true` or `false`).
- **Simple (`if`):** A single conditional path.
- **Double (`if ... else`):** Two mutually exclusive paths.
- **Multiple (`else if` / `switch`):** Multiple alternatives.

### Simple Selection (`if`)

```java
if (condicion) {
    // Executes if condition is true
}
```

### Double Selection (`if ... else`)

```java
if (condicion) {
    // Executes if condition is true
} else {
    // Executes if condition is false
}
```

### Ternary Conditional Operator (`?:`)
Expresses a decision with three operands and produces a result value:

```java
condicion ? valorSiTrue : valorSiFalse
```

**Example:**
```java
System.out.println(num % 2 == 0 ? "PAR" : "IMPAR");
```

### Multiple Selection (`else if`)
Evaluates conditions sequentially from top to bottom. Once a condition evaluates to `true`, its block executes and the remaining chain is skipped.

```java
if (hora < 12) {
    System.out.println("Buenos días");
} else if (hora < 20) {
    System.out.println("Buenas tardes");
} else {
    System.out.println("Buenas noches");
}
```

### Multiple Selection (`switch`)
Evaluates an expression and branches execution to matching `case` labels.

```java
switch (expresion) {
    case valor1:
        // instructions
        break;
    case valor2:
        // instructions
        break;
    default:
        // instructions executed if no case matches
}
```

#### Supported Data Types in `switch`
- **Primitive integer types:** `byte`, `short`, `char`, `int`.
- **Wrapper classes:** `Byte`, `Short`, `Character`, `Integer`.
- **Enums:** `enum`.
- **String:** Supported since Java 7.

#### Fall-Through Effect
If a `break` statement is omitted, execution falls through into subsequent `case` blocks regardless of whether their values match, until a `break` or the end of the `switch` is reached.

#### `switch` vs `else if`
- **`switch`:** Best when comparing a single expression against several specific discrete values (e.g., menus, days, options).
- **`else if`:** Best for complex boolean expressions, ranges, or different dynamic conditions.

---

## Repetition Structures (Loops)
Loops repeat a block of code while a condition is met or over a collection/range.

### `while` Loop
Evaluates the condition before executing the loop body. The block may run 0 or more times.

```java
while (condicion) {
    // instructions
}
```

> **Important:** Always compare `String` content using `.equals()` instead of `!=` or `==`:
> ```java
> while (!cadena.equals("FIN")) { ... }
> ```

### `do-while` Loop
Executes the loop body first, then checks the condition. The block is guaranteed to run at least once.

```java
do {
    // instructions
} while (condicion);
```

### `for` Loop
Best suited when the exact number of iterations is known or controlled explicitly.

```java
for (inicializacion; condicion; actualizacion) {
    // instructions
}
```

1. **Initialization:** Runs once at the start.
2. **Condition:** Evaluated before every iteration.
3. **Update:** Executed after every iteration.

### Enhanced `for` (`foreach`)
Iterates over elements in an array or collection without managing an explicit index.

```java
for (Tipo elemento : coleccion) {
    // instructions
}
```

**Example:**
```java
String[] nombres = {"Ana", "José", "Merxe"};
for (String nombre : nombres) {
    System.out.println(nombre);
}
```

### Summary of Loop Selection
- **`while`:** Unknown number of iterations; might need to run 0 times.
- **`do-while`:** Must run at least once (e.g., input validation).
- **`for`:** Iteration count is known or tracked via an explicit counter.
- **`foreach`:** Traversing all elements of a collection/array directly.

### Infinite and Nested Loops
- **Infinite Loops:** Occur when the exit condition is never satisfied (e.g., `while (true)` or `for (;;)`). They must be terminated using a `break` or proper logic.
- **Nested Loops:** A loop placed entirely inside another loop. Control variables must be distinct.

---

## Jump Statements
Jump statements alter the normal control flow of execution.

| Statement | Where Used | Effect | Next Action |
| :--- | :--- | :--- | :--- |
| `break` | Loops / `switch` | Exits the loop or `switch` immediately | Continues after the structure |
| `continue` | Loops only | Skips the remainder of current iteration | Begins the next iteration |
| `return` | Methods | Terminates method execution | Returns control to caller |

---

## Review & Summary

### Concept Map
- **Input / Output:** `Scanner`, `System.in`, `System.out`
- **Sequence:** Order of instruction execution
- **Decision:** `if`, `else`, `switch`
- **Repetition:** `while`, `do-while`, `for`, `foreach`
- **Nesting:** Placing control structures inside one another
- **Jumps:** `break`, `continue`, `return`