# Unit 2: Java Fundamentals, Variables and Operators

## Contents
- First steps in Java
- Variables and identifiers
- Declaration and initialization
- Data types
- Operators and expressions
- Operator precedence
- Type conversions and casting
- String and wrappers
- Comments and Javadoc

## First steps in Java
To start coding in Java we installed the JDK (which includes the JVM) and set up Eclipse as our IDE.

I also added Eclipse to my environment variables so I can launch it from PowerShell with:
`eclipse -data "xyz path"`

Using Eclipse doesn't stop me from working from PowerShell with Git and the GitHub CLI, the same way I already do in VS Code (the editor I'm most familiar with).

So from now on, my workflow from PowerShell is:
- `eclipse -data "xyz path"` (optional, to open the workspace)
- `git add .`
- `git status`
- `git commit -m "feat"`
- `git push -u origin 00-fork`
- `gh pr create`
- `gh pr merge`

In Eclipse we created a Java project, then a package, and finally a class with a `public static void main` method. The class name must match the file name.

After that we looked at different data types and at declaring and initializing variables and constants, plus basics like `System.out.println()`.

## Variables and identifiers
A variable is a memory location identified by a name and associated with a specific data type.
It consists of three core elements:
- **Identifier:** Name to access the stored value.
- **Type:** Defines what kind of information it holds.
- **Range:** Sets the limits of the allowed values.

Example:
`int age = 18;`

### Classification of variables
Variables can be classified based on three criteria:
- **By Data:**
  - *Primitive:* Directly holds the value.
  - *Reference:* Holds a reference to the memory location.
- **By Mutability:**
  - *Variable:* Value can change.
  - *Constant (`final`):* Value remains fixed.
- **By Scope/Location:**
  - *Member:* Created inside a class.
  - *Local:* Created inside a method or code block.

### Identifiers: naming rules and conventions
- Must indicate purpose/intent.
- Java is **case-sensitive** (`age`, `Age`, and `AGE` are distinct).
- Cannot contain spaces or start with digits.
- Cannot be a reserved Java keyword (like `public`, `class`, `static`, `void`, `int`, `boolean`, etc.).
- **Naming Conventions:**
  - `UpperCamelCase` for Classes and Interfaces (e.g., `CustomerAccount`).
  - `lowerCamelCase` for Variables and Methods (e.g., `legalAge`, `calculateTotal()`).
  - `SCREAMING_SNAKE_CASE` for Constants (e.g., `LEGAL_AGE`).

## Declaration and initialization

### Declaration
Associates an identifier with a data type before usage.
Syntax: `<type> <identifier>;` (e.g., `int perimeter;`)

### Initialization
Assigns the initial value to the variable.
Syntax: `<type> <identifier> = <value>;` (e.g., `int perimeter = 22;`)

> **Default Values Note:** Class fields automatically get default values (`int` -> `0`, `boolean` -> `false`, references -> `null`). Local variables **must** be initialized before reading, or the compiler throws an error.

### Constants
Declared using the `final` keyword; value cannot be reassigned after initialization.
Example: `final double PI = 3.141592;`

## Data types
Java has **8 Primitive Types**:
1. **Logical:** `boolean` (`true` / `false`).
2. **Character:** `char` (Single 16-bit Unicode character using single quotes `'A'`).
3. **Integers (whole numbers):**
   - `byte` (8 bits, -128 to 127)
   - `short` (16 bits, -32,768 to 32,767)
   - `int` (32 bits, default choice for integers)
   - `long` (64 bits, ends with `L` literal e.g. `3L`)
4. **Reals (floating-point):**
   - `float` (32 bits, ends with `f` e.g. `8.5f`)
   - `double` (64 bits, default choice for decimals)

### Reference & Enum Types
- **Reference Types:** Point to memory locations of objects rather than holding raw values directly (e.g., `int[]` arrays, objects).
- **Enums (`enum`):** Restricts variables to a fixed set of predefined constant values.

```java
public enum Day { MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY }
```
