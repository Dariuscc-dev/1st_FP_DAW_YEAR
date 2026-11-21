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
| `leerNotas()` | Input |
| `calcularMedia()` | Processing |
| `mostrarResultado()` | Output |

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
static void procesarAlumno() {
    // read data, validate, calculate grade, print report, save data
}

// BETTER: one task per method
static void leerDatos() { ... }
static boolean validar() { ... }
static double calcularNota() { ... }
static void mostrarInforme() { ... }
```

Rule of thumb: if the method name needs several verbs ("read, calculate and show"), it is doing too much.

## Block 2: Functions and Methods
In Java, functions that belong to a class are called **methods**.

What happens on a call:

1. `main()` is running.
2. It calls `calcular()`.
3. `main` waits.
4. `calcular()` runs its body.
5. It returns control (and maybe a result).
6. `main` continues right after the call.

### Anatomy of a method
```java
public static int mayor(int a, int b) {
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
| `mayor(int a, int b)` | Name + parameter list |
| `{ ... }` | Body: the instructions |

- **Header:** name, what it receives and what it returns (`static int sumar(int a, int b)`).
- **Body:** the implementation.
- **Declare / define** = write header and body. **Invoke** = call it so it runs.

```java
static int cuadrado(int n) {   // definition
    return n * n;
}

int resultado = cuadrado(5);   // invocation
System.out.println(resultado); // 25
```

### `return`
`return` ends the method and hands a value back to the caller. The value must be compatible with the declared return type. As soon as `return` runs, the method ends.

A method can contain several `return` statements, but in one execution only the first one reached runs:

```java
static int valorAbsoluto(int n) {
    if (n >= 0) {
        return n;   // ends here
    }
    return -n;      // only if n < 0
}
// valorAbsoluto(5) → 5, valorAbsoluto(-5) → 5
```

### `void` methods
They do a task and return nothing. They can use `return;` with no value to exit early, but it is optional.

```java
static void mostrarMenu() {
    System.out.println("1. Alta");
    System.out.println("2. Baja");
    System.out.println("3. Salir");
}
```

### With and without parameters
```java
static void saludo() { System.out.println("Hola"); }                 // saludo();
static void saludo(String nombre) { System.out.println("Hola " + nombre); } // saludo("Ana");
```

Parentheses are always required, in the declaration and in the call, even with no parameters.

### What to do with a returned value
```java
static int mayor(int a, int b) {
    return (a >= b) ? a : b;
}

int m = mayor(6, 10);                 // 1. store it
System.out.println(mayor(6, 10));     // 2. use it directly
int doble = mayor(6, 10) * 2;         // 3. use it in another expression
```

`mayor(6, 10);` alone compiles (Java lets you ignore a return value), but the 10 is lost, so it usually makes no sense.

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
    static int doble(int n) {
        return n * 2;
    }

    public static void main(String[] args) {
        System.out.println(doble(5));
    }
}
```

### Variable scope
```java
static int sumar(int a, int b) {
    int total = a + b;
    return total;
}

public static void main(String[] args) {
    // System.out.println(total); // ERROR: total only exists inside sumar()
}
```

Local variables (and parameters) only exist inside their method.

### Designing a good method
- The **name** says the action: `calcularMedia`, `buscarMayor`, `mostrarMenu`.
- Only the **parameters** it needs.
- Small, clear and with **one responsibility**.

```java
static int mayor(int n1, int n2, int n3) {
    int mayor = n1;
    if (n2 > mayor) mayor = n2;
    if (n3 > mayor) mayor = n3;
    return mayor;
}
```

Trace of `mayor(6, 10, 8)`: n1=6, n2=10, n3=8 → mayor starts at 6 → 10 > 6 so mayor = 10 → 8 > 10 is false → `return 10`.

### Showing is not returning
```java
static void mostrarMayor(int a, int b) {   // prints inside the method
    int mayor = (a >= b) ? a : b;
    System.out.println(mayor);
}

static int obtenerMayor(int a, int b) {    // hands the value to the caller
    return (a >= b) ? a : b;
}
```

If a method calculates something reusable, return it instead of printing it. The caller can then print it, compare it, store it or pass it to another method, which lowers coupling.

## Block 4: Parameters
```java
static int suma(int num1, int num2) {   // num1, num2 = formal parameters
    return num1 + num2;
}

int a = 5, b = 8;
int total = suma(a, b);                 // a, b = actual parameters (arguments)
```

- **Order matters:** the first argument goes to the first parameter, and so on.
- **Types matter:** each argument must be compatible with its parameter. `mostrar(20, "Ana")` fails if the method is `mostrar(String nombre, int edad)`.
- **Names don't matter:** only the position counts.

### Java always passes by value
In Java **every** argument is passed by value. What changes is which value is copied:

| Argument | What is copied | Effect |
|---|---|---|
| Primitive (`int`, `double`...) | The value | Changing the parameter does not change the original |
| Array / object | The value of the **reference** | Both point to the same object, so the method can change its contents |

```java
static void sumarDiez(int numero) {
    numero = numero + 10;
}
int original = 5;
sumarDiez(original);
System.out.println(original); // 5
```

```java
static void incrementar(int[] datos) {
    for (int i = 0; i < datos.length; i++) {
        datos[i]++;
    }
}
int[] numeros = {1, 10, 100};
incrementar(numeros); // numeros is now {2, 11, 101}
```

Modifying the object is not the same as **reassigning** the reference:

```java
static void reasignar(int[] datos) {
    datos = new int[]{9, 9, 9}; // only the local copy of the reference changes
}
int[] numeros = {1, 2, 3};
reasignar(numeros); // numeros is still {1, 2, 3}
```

`String` is an object but it is **immutable**: its methods return a new String, and reassigning the parameter only changes the local copy.

```java
static void cambiar(String texto) {
    texto = texto.toUpperCase();
}
String nombre = "Ana";
cambiar(nombre);
System.out.println(nombre); // Ana
```

A method can also **return an array**:

```java
static int[] duplicar(int[] datos) {
    int[] copia = new int[datos.length];
    for (int i = 0; i < datos.length; i++) {
        copia[i] = datos[i] * 2;
    }
    return copia;
}
```

## Block 5: Method Overloading
Same name, **different parameter list**.

```java
static int suma(int a, int b) { return a + b; }
static int suma(int a, int b, int c) { return a + b + c; }    // different number
static double suma(double a, double b) { return a + b; }       // different types
static int suma(int[] datos) { ... }                           // int[] vs double[]
static double suma(double[] datos) { ... }
```

The compiler picks the version that matches the arguments:

```java
int x = suma(2, 3);         // suma(int, int)
double y = suma(2.5, 3.1);  // suma(double, double)
int z = suma(1, 2, 3);      // suma(int, int, int)
```

Not a valid overload:

```java
static int dato(int x) { return x; }
static double dato(int x) { return x; } // ERROR: only the return type changes
```

Overloads differ by the **number, type or order of parameters**, never only by the return type.

## Block 6: Full Application
Goal: read 5 grades, calculate the average and say whether the student passes.

```java
static int[] leerNotas(Scanner teclado) {
    int[] notas = new int[5];
    for (int i = 0; i < notas.length; i++) {
        System.out.print("Nota " + (i + 1) + ": ");
        notas[i] = teclado.nextInt();
    }
    return notas;
}

static double calcularMedia(int[] notas) {
    int suma = 0;
    for (int nota : notas) {
        suma += nota;
    }
    return (double) suma / notas.length; // cast avoids integer division
}

static boolean estaAprobado(double media) {
    return media >= 5;
}

static void mostrarResultado(double media) {
    System.out.println("Media: " + media);
    if (estaAprobado(media)) {   // a method can call another one
        System.out.println("APROBADO");
    } else {
        System.out.println("SUSPENSO");
    }
}

public static void main(String[] args) {
    Scanner teclado = new Scanner(System.in);
    int[] notas = leerNotas(teclado);
    double media = calcularMedia(notas);
    mostrarResultado(media);
    teclado.close();
}
```

`main` reads like a script: read → calculate → show. When a method ends, execution goes back to the point right after the call.

## Common Mistakes
| Mistake | Example |
|---|---|
| Incompatible return | `static int f() { return 2.5; }` |
| Missing `return` | An `int` method that doesn't return on every path |
| Arguments in the wrong order | `mostrar(20, "Ana")` |
| Using a local variable outside its method | `total` only exists inside `sumar()` |
| Thinking Java passes arrays "by reference" | Java copies the value of the reference |
| Overloading only by return type | `int f(int)` and `double f(int)` clash |

## Practice Exercises (solved)
```java
static double areaCirculo(double radio) {
    return Math.PI * radio * radio;
}

static boolean esPar(int numero) {
    return numero % 2 == 0;
}
// esPar(7) → false → prints "Impar"

static int contarPares(int[] datos) {
    int contador = 0;
    for (int n : datos) {
        if (n % 2 == 0) contador++;
    }
    return contador;
}

// Is this an overload? Yes: same name, (int, int) vs (double, double).
static int minimo(int a, int b) { return (a < b) ? a : b; }
static double minimo(double a, double b) { return (a < b) ? a : b; }
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
