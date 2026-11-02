# Unit 2: Installation and Use of Development Environments[cite: 1]

## Overview & Contents
- **The Java Platform:** Core architecture covering source code compilation into **bytecode**, execution via the **JVM**, and the distinctions between **JRE**, **JDK**, **SDK**, **API**, platform editions (**Java SE**, **Java EE**, **Java ME**), and JDK implementations (**Oracle JDK**, **OpenJDK**)[cite: 1].
- **JDK Installation & Environment Variables:** Procedures for installing **OpenJDK** on Linux and Windows, configuring **JAVA_HOME** and **PATH**, and verifying the setup with `java --version` and `javac --version`[cite: 1].
- **Visual Studio Code & Java Integration:** Setup, interface components, **workspaces**, configuration hierarchy (`settings.json`), the **Java Extension Pack**, configuring `java.home`, and running/debugging code[cite: 1].
- **Eclipse IDE:** Architecture as a full IDE with the **JDT** plugin, installation steps, core concepts (**Workspace**, **Perspective**, **View**, **Editor**), project creation, and execution vs. debugging[cite: 1].
- **Practical Examples & Common Pitfalls:** Distinguishing between `java` (execution) and `javac` (compilation), understanding system `JAVA_HOME` vs. VS Code's `java.home`, knowing why **breakpoints** cannot be placed on empty braces, and diagnosing environment errors[cite: 1].

## Block 1: The Java Platform[cite: 1]
Java is a platform designed for developing cross-platform applications[cite: 1]. While its primary programming language is Java, the essential aspect is its complete architecture[cite: 1]. Java applications are not executed directly from source code; instead, they are first compiled into intermediate code called **bytecode** and then executed on the **Java Virtual Machine (JVM)**[cite: 1].

- **Source Code (`Hola.java`):** The human-readable code written by the developer[cite: 1].
- **Compilation (`javac`):** The process where the compiler translates `Hola.java` into `Hola.class`[cite: 1].
- **Bytecode (`Hola.class`):** The compiled intermediate file that requires a virtual machine to run[cite: 1].
- **Execution (`java` / JVM):** The command `java` runs the bytecode using the **JVM** to produce the program output[cite: 1].
- **Standard Library:** Additional software installed alongside Java that provides pre-built classes for common tasks[cite: 1].
- **API (Application Programming Interface):** The interface—comprising the set of classes, methods, and access rules—that allows developers to use the standard libraries in their programs (e.g., `System.out.println()` belongs to classes provided by the platform)[cite: 1]. It is not a separate program[cite: 1].

### Core Architecture Components: JVM, JRE, JDK, and SDK[cite: 1]
| Concept | Purpose | Practical Rule / Scope |
|---|---|---|
| **JVM** (Java Virtual Machine) | Executes/interprets **bytecode**[cite: 1]. | Without the JVM, `.class` files cannot be executed[cite: 1]. |
| **JRE** (Java Runtime Environment) | Provides the **JVM** plus the core libraries needed to run Java applications[cite: 1]. | Required if you only need to **execute** Java programs[cite: 1]. |
| **JDK** (Java Development Kit) | Includes the **JRE** plus development tools such as the **`javac`** compiler and utilities to create bytecode[cite: 1]. | Required if you are going to **program and compile** Java applications[cite: 1]. |
| **SDK** (Software Development Kit) | Generic term for a set of software development tools[cite: 1]. | General category (JDK is the specific SDK for Java)[cite: 1]. |

### Java Platform Editions & JDK Implementations[cite: 1]
| Category | Variant | Purpose / Characteristics |
|---|---|---|
| **Platform Edition** | **Java SE** (Standard Edition) | Standard edition and usual base of the JDK; used for desktop development and graphical user interfaces (GUIs)[cite: 1]. |
| **Platform Edition** | **Java EE** (Enterprise Edition) | Built on top of Java SE; designed for web, distributed, and large-scale enterprise applications[cite: 1]. |
| **Platform Edition** | **Java ME** (Micro Edition) | Designed for mobile and embedded devices[cite: 1]. |
| **Implementation** | **Oracle JDK** | Maintained by Oracle (based on OpenJDK); since Java 10, it publishes feature releases every 6 months and **LTS** (Long-Term Support) versions every 3 years[cite: 1]. |
| **Implementation** | **OpenJDK** | Free, open-source, and **official** implementation of Java SE maintained by the OpenJDK community[cite: 1]. |
| **Implementation** | **Other Distributions** | Alternative implementations such as **Amazon Corretto**, **IBM JDK**, and **Azul Zulu**[cite: 1]. |

## Block 2: JDK Installation and Configuration[cite: 1]
Installing the JDK requires more than running an installer; the operating system must know where Java is located and where to find its executable commands so that compilation, execution, and verification work from any terminal location[cite: 1].

- **Linux (Ubuntu) Installation:** Uses the `apt` package manager to update the package cache (`apt update`) and install the recommended distribution JDK (`default-jdk`), which automatically pulls in dependencies including the **JRE**[cite: 1]. A typical installation path is `/usr/lib/jvm/java-11-openjdk-amd64`[cite: 1].
- **Windows Installation:**
  1. Download the **OpenJDK** binary for Windows/x64[cite: 1].
  2. Unzip it into a known directory path (e.g., `C:\java\jdk-16.0.1`)[cite: 1].
  3. Create the **`JAVA_HOME`** system environment variable pointing to the installation path[cite: 1].
  4. Edit the **`Path`** variable to append the JDK's `bin` directory (`%JAVA_HOME%\bin`)[cite: 1].
  5. Open a terminal and verify with `java --version` and `javac --version`[cite: 1].
- **`JAVA_HOME`:** Environment variable that points to the root folder where the JDK is installed[cite: 1].
- **`PATH`:** Environment variable that includes `$JAVA_HOME/bin` (Linux) or `%JAVA_HOME%\bin` (Windows), allowing `java` and `javac` to be executed from any directory[cite: 1].
- **Reloading Configuration in Linux:** The `source` command (e.g., `source /etc/profile.d/jdk-home.sh`) loads the environment configuration immediately without restarting the user session[cite: 1].

### Verification Commands[cite: 1]
| Command | Target Component | Diagnostic Meaning if It Fails |
|---|---|---|
| `java --version` | **JVM / Runtime Environment** (`java` executes bytecode)[cite: 1] | The system cannot locate the Java runtime environment or `PATH` does not point to the JRE/JDK `bin` folder[cite: 1]. |
| `javac --version` | **JDK Compiler** (`javac` compiles `.java` into `.class`)[cite: 1] | The development environment is not ready: either only the **JRE** is installed (missing the full **JDK**) or `PATH` is misconfigured[cite: 1]. |

## Block 3: Visual Studio Code[cite: 1]
**Visual Studio Code (VS Code)** is a lightweight, cross-platform source code editor developed by Microsoft[cite: 1]. Out of the box, it natively supports **JavaScript** and **TypeScript**, and while it is not a full IDE initially, it can closely approximate one by adding extensions for C++, C#, Python, Java, and other technologies[cite: 1].

- **Core Properties:**
  - **Lightweight:** Starts up quickly and focuses on editing code[cite: 1].
  - **Extensible:** Extensions add support for new languages, debugging, and tools[cite: 1].
  - **Configurable:** Supports both User and Workspace settings, including direct editing in **JSON**[cite: 1].
- **Key Functional Features:** **Command Palette** (`Ctrl+Shift+P`), **Git support**, **Syntax highlighting**, **JSON configuration**, **Integrated terminal**, **Multiple cursors**, **IntelliSense autocompletion**, and **Extensions**[cite: 1].
- **Installation:**
  - **Ubuntu:** Download the `.deb` package from `code.visualstudio.com/download` and install via double-click or terminal (`sudo apt install ./code_<version>_amd64.deb`)[cite: 1]. Note that exact version numbers change over time[cite: 1].
  - **Windows:** Download the stable installer, run it, accept the license, and choose the directory and shortcuts[cite: 1]. After installation, it is accessible from the Start Menu or the System Development category[cite: 1].
- **User Interface (5 Basic Zones):**
  1. **Activity Bar:** Quick switcher for main activities (**Explorer**, **Search**, **Source Control**, **Debug**, and **Extensions**)[cite: 1].
  2. **Menu Bar:** Top application menus[cite: 1].
  3. **Welcome / Editor:** Central area where files are edited[cite: 1].
  4. **Bottom Panel:** Houses the integrated terminal, output, and debug console[cite: 1].
  5. **Status Bar:** Bottom bar displaying project and editor status[cite: 1].
- **Preferences vs. Extensions:** Configuring **Preferences** adjusts editor behavior (organized by categories, searchable via the top filter bar; e.g., changing the theme via *Workbench > Appearance > Color Theme* or setting display language via `Configure Display Language`), whereas installing **Extensions** adds new capabilities (e.g., *Spanish Language Pack*)[cite: 1].

### VS Code Workspaces and Configuration Scope[cite: 1]
A **workspace** can contain one or multiple folders open simultaneously, is saved in a `.code-workspace` file (*File > Save Workspace As*), and can be expanded via *File > Add Folder to Workspace*[cite: 1].

| Scope | Description | Access / Priority Rule |
|---|---|---|
| **User Settings** | Global configuration applied to your user account across all projects[cite: 1]. | Accessed via *File > Preferences > Settings*, `Ctrl+,`, or `Ctrl+Shift+P` (*Preferences: Open User Settings*)[cite: 1]. |
| **Workspace Settings** | Configuration specific to a single project or workspace[cite: 1]. | **Priority:** In case of conflict, **Workspace settings override User settings**[cite: 1]. |

## Block 4: Programming Java in VS Code[cite: 1]
To transform VS Code into a complete Java development environment, you install the **Java Extension Pack** (which is a bundle of multiple extensions, not a single extension) and point VS Code to the local JDK via `java.home`[cite: 1].

- **Configuring `java.home`:**
  1. Open User Preferences (`Ctrl+Shift+P` > *Preferences: Open User Settings*)[cite: 1].
  2. Search for the **`java.home`** parameter[cite: 1].
  3. Edit **`settings.json`** directly (this parameter cannot be edited via the graphical UI) and save the JDK path[cite: 1].
  4. **Exam Distinction:** Do not confuse **`JAVA_HOME`** (the operating system environment variable) with **`java.home`** (the VS Code setting inside `settings.json`)[cite: 1].
- **Creating and Running `Hola.java`:**
  - Open the workspace folder in the Explorer and create a new file named `Hola.java`[cite: 1].
  - The Java extension detects the file type and generates the class skeleton[cite: 1].
  - Type `main` and accept the snippet to generate the **`main` method**, which is the entry point where program execution begins[cite: 1].
  - Execute using the **Run** button / `Ctrl+F5` (which automatically compiles and runs the program in the terminal) or manually via the integrated terminal (`javac Hola.java` followed by `java Hola`)[cite: 1].
- **Debugging in VS Code:**
  - **Debug** starts step-by-step execution to inspect program behavior and variables[cite: 1].
  - Requires setting a **breakpoint** (stopping point) by clicking to the left of the line number[cite: 1].
  - **Breakpoint Rule:** Not all lines accept breakpoints; lines with only opening or closing braces (`{` or `}`) do not execute code and cannot hold an active breakpoint[cite: 1].
  - **Controls:** **`F5`** continues execution until the end or the next breakpoint; **`F10`** steps over code line by line[cite: 1].

### Components of the Java Extension Pack[cite: 1]
| Extension | Core Functionality |
|---|---|
| **Language Support for Java** | Syntax highlighting, compilation error detection, autocompletion, refactoring, JavaDoc, and code snippets[cite: 1]. |
| **Project Manager for Java** | Exploring, creating, and building Java projects[cite: 1]. |
| **Debugger for Java** | Execution control, breakpoints, pausing, resuming, and variable tracking[cite: 1]. |
| **Java Test Runner** | Running and debugging functional tests (JUnit) and viewing test logs[cite: 1]. |
| **Maven for Java** | Managing Maven projects: generation, validation, compilation, testing, and deployment[cite: 1]. |
| **Visual Studio IntelliCode** | Context-aware code suggestions powered by machine learning[cite: 1]. |

## Block 5: Eclipse IDE[cite: 1]
**Eclipse** is an open-source, cross-platform, extensible **Integrated Development Environment (IDE)**[cite: 1]. Initially developed by IBM as the successor to VisualAge, it has been managed by the **Eclipse Foundation** since 2003 and is distributed under the **Eclipse Public License**[cite: 1]. It operates as a tool-integration platform via plugins; Java support relies on the **JDT (Java Development Tools)** plugin included in the standard Java distribution[cite: 1].

- **Installation Process:**
  1. Download the official installer for your OS from the Eclipse packages page (`eclipse-inst-jre-linux64.tar.gz` on Linux or `eclipse-inst-jre-win64.exe` on Windows)[cite: 1].
  2. Extract the archive (on Linux) and run `eclipse-inst` (or double-click the `.exe` on Windows)[cite: 1].
  3. Select the package for **Java Developers**[cite: 1].
  4. Verify or select the **JVM / `JAVA_HOME`** path, accept the licenses, and complete installation[cite: 1].
- **Creating a Java Project:**
  - Go to *File > New > Java Project* (or use the *New* icon / *Package Explorer*)[cite: 1].
  - Enter the project name (e.g., `Hola`), select the **JVM/JRE**, and choose the project layout to separate source files (`src`) and compiled bytecode (`bin`/`out`)[cite: 1].
  - When prompted about creating `module-info.java`, select **Don't Create** if you are not building a modular project[cite: 1].
- **Creating a Class with `main`:**
  - Right-click `src` > *New > Class*, specify the package if required (the *Finish/Create* button stays disabled if mandatory information is missing), set *Name* to `Hola`, check the box to generate `public static void main(String[] args)`, and click *Finish*[cite: 1].
- **Run vs. Debug in Eclipse:**
  - **Run (`Ctrl+F11` or *Run > Run*):** Executes the complete program and prints output in the **Console** view[cite: 1].
  - **Debug (`F11` or *Debug*):** Starts the debugger to analyze and control program execution step by step[cite: 1].

### Core Eclipse Architecture & Java Perspective Components[cite: 1]
| Concept / Component | Category | Purpose |
|---|---|---|
| **Workspace** | Core Concept | Working directory asked on first launch where Eclipse stores projects, preferences, and extensions[cite: 1]. |
| **Perspective** | Core Concept | Preconfigured layout of views and editors optimized for a specific task (e.g., Java Perspective)[cite: 1]. |
| **View** | Core Concept | Specialized sub-window (manageable via *Window > Show View*) displaying specific project data[cite: 1]. |
| **Editor** | Core Concept | Central zone where Java code is written, supporting autocompletion and snippets[cite: 1]. |
| **Package Explorer** | Java Perspective View | Displays the project structure (`JRE`, `src`, packages) and creation options[cite: 1]. |
| **Outline** | Java Perspective View | Displays a summary of the methods and attributes of the currently open class[cite: 1]. |
| **Problems / Javadoc / Declarations** | Java Perspective Views | Auxiliary bottom tabs showing compilation errors, documentation, and symbol declarations[cite: 1]. |

## Block 6: Comparison, Workflow, and Troubleshooting[cite: 1]
A functional development environment requires completing a sequential operational chain: **Install JDK** (`java` + `javac`) $\rightarrow$ **Configure Environment** (`JAVA_HOME` / `PATH`) $\rightarrow$ **Open Editor/IDE** (VS Code / Eclipse) $\rightarrow$ **Create Project** (workspace/project) $\rightarrow$ **Create Class** (`Hola.java`) $\rightarrow$ **Compile** (`javac` / extension) $\rightarrow$ **Execute** (`java` / Run) $\rightarrow$ **Debug & Fix** (Debug + breakpoint)[cite: 1]. If an early phase fails (such as compilation), subsequent phases like debugging cannot proceed[cite: 1].

### VS Code vs. Eclipse Comparison[cite: 1]
| Criterion | VS Code | Eclipse |
|---|---|---|
| **Type** | Lightweight extensible code editor[cite: 1] | Complete and extensible IDE[cite: 1] |
| **Java Support** | Requires installing **Java Extension Pack**[cite: 1] | **JDT** plugin included in the standard Java distribution[cite: 1] |
| **Organization** | Workspace and folders[cite: 1] | Workspace and structured projects (`src` / `bin`)[cite: 1] |
| **Configuration** | User / Workspace settings (`settings.json`)[cite: 1] | Preferences, perspectives, and views[cite: 1] |
| **Execution** | Run / Debug via extension or integrated terminal[cite: 1] | Run / Debug natively integrated into the IDE[cite: 1] |

### Common Errors and Troubleshooting Guide[cite: 1]
| Symptom / Problem | Root Cause & Solution |
|---|---|
| **`java` is not recognized** | `PATH` does not point to the JDK/JRE `bin` directory, or Java is not installed[cite: 1]. |
| **`javac` is not recognized** | Only the **JRE** is installed instead of the full **JDK**, or `PATH` does not include the JDK `bin` folder[cite: 1]. |
| **VS Code does not detect Java** | Check that the **Java Extension Pack** is installed and verify `java.home` inside `settings.json`[cite: 1]. |
| **`main` method does not appear** | Create the class properly and check the option to generate `main` (or use the `main` snippet in VS Code)[cite: 1]. |
| **Breakpoint does not activate** | Placed on a non-executable line (such as empty opening/closing braces `{}`)[cite: 1]. Move it to an executable statement[cite: 1]. |
| **Disorganized project structure** | Confusing the workspace directory, project folder, source folder (`src`), and compiled output folder (`bin`/`out`)[cite: 1]. |

## Code Examples[cite: 1]

### Linux JDK Installation, Environment Configuration, and Verification[cite: 1]
```bash
# 1. Update package cache and install the default OpenJDK on Ubuntu
sudo apt update
sudo apt install default-jdk

# 2. Verify runtime (JVM) and compiler (JDK) versions
java --version
javac --version

# 3. Configure JAVA_HOME and PATH environment variables in Linux
export JAVA_HOME=/usr/lib/jvm/java-11-openjdk-amd64
export PATH=$PATH:$JAVA_HOME/bin

# 4. Reload profile script without restarting the session
source /etc/profile.d/jdk-home.sh
```

### Windows Environment Variables & Verification[cite: 1]
```bat
REM Set JAVA_HOME to the extracted JDK folder and append bin to Path
JAVA_HOME = C:\java\jdk-16.0.1
Path += %JAVA_HOME%\bin

REM Verify installation in terminal
java --version
javac --version
```

### Installing VS Code (.deb) and Eclipse Installer on Linux[cite: 1]
```bash
# Install downloaded VS Code Debian package on Ubuntu
sudo apt install ./code_1.56.2-..._amd64.deb

# Extract and launch the official Eclipse installer on Linux
tar -xvzf eclipse-inst-jre-linux64.tar.gz
cd eclipse-installer
./eclipse-inst
```

### VS Code `settings.json` (`java.home` Configuration)[cite: 1]
```json
// Example 1: Linux JDK path configuration in settings.json
{
  "workbench.editor.closeEmptyGroups": false,
  "java.home": "/usr/lib/jvm/java-11-openjdk-amd64"
}
```
```json
// Example 2: Windows JDK path configuration in settings.json (escaped backslashes)
{
  "java.home": "C:\\java\\jdk-16.0.1"
}
```

### Java Programs (`Hola.java`) and Manual Terminal Execution[cite: 1]
```java
// Basic Hola.java (Standard Library & API / VS Code Debug Example)
public class Hola {
    public static void main(String[] args) {
        System.out.println("Hola!");
        System.out.println("Primer código desde VS Code");
        // In the debugging example, the second print statement is:
        // System.out.println("Debug");
    }
}
```
```java
// Hola.java generated in Eclipse IDE
public class Hola {
    public static void main(String[] args) {
        System.out.println("Hola!");
        System.out.println("Este es nuestro primer código desde Eclipse");
    }
}
```
```bash
# Manual compilation (.java -> .class) and execution in terminal
javac Hola.java
java Hola
```