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

