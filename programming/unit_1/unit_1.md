# Introduction to programming


## Contents

- Data and digital society
- Variables and constants
- Problem resolution
- Algorithms
- First program
- Errors

## Data and digital society

Data is something we can qualify or quantify

The same reality can have multiple interpretations = Data, information, knowledge and wisdom.

Data sycle = Entry, process, output, and feedback.

(John) von Neumann´s architecture, the one big idea behind computers, tablets, phones, and IoT devices.

That enabled humanity to build computers (programmable machines), which was the programmable machine that was and still is able to ingest data and process code that makes it possible to (mixed with data) build programs.

## Variables and constants

A variable can change during the programs execution.

A constant value cannot chage.

Example of a changing variable

```java
int age = 17;
age = 18;
System.out.println(age);
// The final value of the variable is 18, so that is the value that will be printed.
```

Example of declaring a constant (using the reserved word "final")

```java
final double VAT = 0.21;
double price = 12.99;
double total = price + price * VAT;
System.out.println(total); // Results in 15.7179
```

Useful fact = In Java, the convention is also to use camelCase.

Three basic characteristics of variables and constants = They have and identifier, a type, and a value.

And identifier has to be clear and significant, it can contain letters, numbers, underscores but no spaces, it is recommended to use lowerCamelCase, constants in uppercase with underscores, and try to avoid accents, rare symbols, and names that don´t explain nothing.

Data types = Integers (int), characters (char), text (string), real number (double), and logic (boolean).

## Problem solving

Quality of code depends on the quality of the analysis, we have to truly make an effort an digest the problem we have at hand precisely.

We are trying to build a program, but that program revolves around building a solution that will hopefully solve a problem. 

That solution is involved and influenced by analyzing the problem at hand correctly and creating a good algorythm for it.

So the program revolver around = Problem, analysis, algorythm, preferably in cicles and not only once.

Pólya method = Understand the problem, create a plan, execute the plan, revise the solution.
And all of that, in cycles (iterating).

## Algorithm

It describes, following logic, the operations necessary to transform data into an output result.

So = Entry - Process - Output

You can represent algorithms in = Flowchart, pseudocode.

A Flowchart consists of = Terminal, entry/output, process, and the flow chart´s line.

Pseudocode =
Every instruction has to be in a single line.
First instruction marks the start and the last one the end.
Use simple words.
Code has to be idented.
It has to be clear, ordered and easy to transform into real code.

The process of going from the problem to the program = Problem - Algorithm - Code (Java, for example) - Program (.java file).

Program = Data types + Algorithms

## First Program

```java
public class HelloFuture {
    public static void main(String[]args){
        System.out.println("Hello future Darius!");
    }
}
```

- We use public to indicate visibility.
- We have to use class always in Java as it is a programming lenguage oriented to objectives.
- HelloWorld is the identifier of the class.
- "main" is the point where the execution starts.
- "static" indicates that it is part of the parent class and it can be invoked without creating an object.
- "void" indicates that it doesn´t output a value.
- String[]args enables the console to receive arguments.
- This {} delimits code blocs, classes and methods.
- This () contains parammeters or arguments of a method.
- This "" delimits strings
- This ; finalizes an instruction.

In Java, we can also differentiate between tokens, reserved words and identifiers.

Code in java goes from = Source code (.java) to a compiler to bytecode to JVM.

## Errors

Two usual moments where failure happens while compiling or while executing.

Compilation errors can be = Lexicographic, syntactic or semantic.