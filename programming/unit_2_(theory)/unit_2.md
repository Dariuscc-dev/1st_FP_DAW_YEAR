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
As we introduced ourselves in the matter, we learned that the right way to start coding in Java is to work with the Eclipse compiler, we had to download the JDK and also JVM.

I first had to also configure the environment variable of eclipse to be able to start it from the PowerShell with:
`eclipse -data "xyz path"`

Then, I also realized that the compiler I use doesn't limit me to use the powershell alongside with GitHub CLI to do CI/CD, either from Eclipse or VSC (which is the one that I'm the most familiar with).

So from now on, I will do CI/CD from the powershell as always with:
- `eclipse -data "xyz path"` (EXTRA)
- `git add .`
- `git status`
- `git commit -m "feat"`
- `git push -u origin 00-fork`
- `gh pr create`
- `gh pr merge`

We then started a new project inside of Eclipse, where we first created a java project, then a java package, and lastly, a java `public static void main` class, where the class' name has to be the same as the file's name.

We then went into exploring different data types, declaring and initializing variables/constants.

Some other basic stuff like `System.out.println()`...etc

## Variables and identifiers
A variable is a memory location identified by a name and associated with a specific data type.
It consists of three core elements:
- **Identifier:** Name to access the stored value.
- **Type:** Defines what kind of information it holds.
- **Range:** Sets the limits of the allowed values.

Example:
`int edad = 18;`

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
- Java is **case-sensitive** (`edad`, `Edad`, and `EDAD` are distinct).
- Cannot contain spaces or start with digits.
- Cannot be a reserved Java keyword (like `public`, `class`, `static`, `void`, `int`, `boolean`, etc.).
- **Naming Conventions:**
  - `UpperCamelCase` for Classes and Interfaces (e.g., `CuentaCliente`).
  - `lowerCamelCase` for Variables and Methods (e.g., `mayoriaDeEdad`, `calcularTotal()`).
  - `SCREAMING_SNAKE_CASE` for Constants (e.g., `MAYORIA_DE_EDAD`).

## Declaration and initialization

### Declaration
Associates an identifier with a data type before usage.
Syntax: `<type> <identifier>;` (e.g., `int perimetro;`)

### Initialization
Assigns the initial value to the variable.
Syntax: `<type> <identifier> = <value>;` (e.g., `int perimetro = 22;`)

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

### Referenced & Enum Types
- **Reference Types:** Point to memory locations of objects rather than holding raw values directly (e.g., `int[]` arrays, objects).
- **Enums (`enum`):** Restricts variables to a fixed set of predefined constant values.

```java
public enum Dia { LUNES, MARTES, MIERCOLES, JUEVES, VIERNES, SABADO, DOMINGO }