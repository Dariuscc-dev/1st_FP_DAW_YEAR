# Introduction to Programming

## Contents

- Data and the digital society
- Variables and constants
- Problem solving
- Algorithms
- First program
- Errors

## Data and the digital society

Data is anything we can describe (qualify) or measure (quantify).

The same reality can be seen at different levels: data, information, knowledge and wisdom.

Data cycle: input, processing, output and feedback.

The von Neumann architecture (John von Neumann) is the core idea behind computers, tablets, phones and IoT devices.

It made it possible to build programmable machines: computers that take in data and run code, and that combination of data and code is what we call a program.

## Variables and constants

The value of a variable can change while the program runs.

The value of a constant cannot change.

Example of a variable that changes:

```java
int age = 17;
age = 18;
System.out.println(age);
// The final value of the variable is 18, so that is the value printed.
```

Example of a constant (declared with the reserved word `final`):

```java
final double VAT = 0.21;
double price = 12.99;
double total = price + price * VAT;
System.out.println(total); // Prints 15.7179
```

Variables and constants have three basic characteristics: an identifier, a type and a value.

An identifier must be clear and meaningful. It can contain letters, numbers and underscores, but no spaces. In Java the convention is lowerCamelCase for variables and UPPER_CASE with underscores for constants. Avoid accents, unusual symbols and names that don't explain anything.

Basic data types: integers (`int`), characters (`char`), text (`String`), real numbers (`double`) and logical values (`boolean`).

## Problem solving

The quality of the code depends on the quality of the analysis, so it is worth taking the time to understand the problem properly.

A program is a solution to a problem. Whether that solution works depends on analyzing the problem correctly and designing a good algorithm for it.

So the process is: problem, analysis, algorithm. Ideally this is done in cycles, not just once.

Pólya's method: understand the problem, make a plan, carry out the plan, review the solution.
And repeat the whole process in cycles (iterating).

## Algorithms

An algorithm describes, step by step and following a logic, the operations needed to transform input data into an output result.

So: input, process, output.

Algorithms can be represented with flowcharts or pseudocode.

A flowchart uses these symbols: terminal (start/end), input/output, process, and flow lines.

Pseudocode rules:
- One instruction per line.
- The first instruction marks the start and the last one marks the end.
- Use simple words.
- Code must be indented.
- It must be clear, ordered and easy to turn into real code.

From problem to program: problem, algorithm, code (Java, for example), program (`.java` file).

Program = data structures + algorithms.

## First program

```java
public class HelloFuture {
    public static void main(String[] args) {
        System.out.println("Hello future Darius!");
    }
}
```

- `public` sets the visibility.
- In Java, all code must live inside a class, because Java is an object-oriented language.
- `HelloFuture` is the identifier (name) of the class.
- `main` is the method where execution starts.
- `static` means the method belongs to the class itself and can be called without creating an object.
- `void` means the method does not return a value.
- `String[] args` lets the program receive arguments from the console.
- `{}` delimit code blocks, classes and methods.
- `()` contain the parameters or arguments of a method.
- `""` delimit strings.
- `;` ends an instruction.

In Java we also distinguish between tokens, reserved words and identifiers.

Java code goes from source code (`.java`) to the compiler, which produces bytecode (`.class`), which is then run by the JVM.

## Errors

Errors usually show up at two moments: at compile time or at runtime.

Compilation errors can be lexical, syntactic or semantic.
