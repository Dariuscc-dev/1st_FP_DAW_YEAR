# Unit 2: Installation and Use of Development Environments

## Overview & Contents
- **The Java Platform:** Core architecture covering source code compilation into **bytecode**, execution via the **JVM**, and the distinctions between **JRE**, **JDK**, **SDK**, **API**, platform editions (**Java SE**, **Java EE**, **Java ME**), and JDK implementations (**Oracle JDK**, **OpenJDK**).
- **JDK Installation & Environment Variables:** Procedures for installing **OpenJDK** on Linux and Windows, configuring **JAVA_HOME** and **PATH**, and verifying the setup with `java --version` and `javac --version`.
- **Visual Studio Code & Java Integration:** Setup, interface components, **workspaces**, configuration hierarchy (`settings.json`), the **Java Extension Pack**, configuring `java.home`, and running/debugging code.
- **Eclipse IDE:** Architecture as a full IDE with the **JDT** plugin, installation steps, core concepts (**Workspace**, **Perspective**, **View**, **Editor**), project creation, and execution vs. debugging.
- **Practical Examples & Common Pitfalls:** Distinguishing between `java` (execution) and `javac` (compilation), understanding system `JAVA_HOME` vs. VS Code's `java.home`, knowing why **breakpoints** cannot be placed on empty braces, and diagnosing environment errors.

## Block 1: The Java Platform
Java is a platform designed for developing cross-platform applications. While its primary programming language is Java, the essential aspect is its complete architecture. Java applications are not executed directly from source code; instead, they are first compiled into intermediate code called **bytecode** and then executed on the **Java Virtual Machine (JVM)**.

- **Source Code (`Hello.java`):** The human-readable code written by the developer.
- **Compilation (`javac`):** The process where the compiler translates `Hello.java` into `Hello.class`.
- **Bytecode (`Hello.class`):** The compiled intermediate file that requires a virtual machine to run.
- **Execution (`java` / JVM):** The command `java` runs the bytecode using the **JVM** to produce the program output.
- **Standard Library:** Additional software installed alongside Java that provides pre-built classes for common tasks.
- **API (Application Programming Interface):** The interface (the set of classes, methods and access rules) that allows developers to use the standard libraries in their programs (e.g., `System.out.println()` belongs to classes provided by the platform). It is not a separate program.

### Core Architecture Components: JVM, JRE, JDK, and SDK
| Concept | Purpose | Practical Rule / Scope |
|---|---|---|
| **JVM** (Java Virtual Machine) | Executes/interprets **bytecode**. | Without the JVM, `.class` files cannot be executed. |
| **JRE** (Java Runtime Environment) | Provides the **JVM** plus the core libraries needed to run Java applications. | Required if you only need to **execute** Java programs. |
| **JDK** (Java Development Kit) | Includes the **JRE** plus development tools such as the **`javac`** compiler and utilities to create bytecode. | Required if you are going to **program and compile** Java applications. |
| **SDK** (Software Development Kit) | Generic term for a set of software development tools. | General category (JDK is the specific SDK for Java). |

### Java Platform Editions & JDK Implementations
| Category | Variant | Purpose / Characteristics |
|---|---|---|
| **Platform Edition** | **Java SE** (Standard Edition) | Standard edition and usual base of the JDK; used for desktop development and graphical user interfaces (GUIs). |
| **Platform Edition** | **Java EE** (Enterprise Edition) | Built on top of Java SE; designed for web, distributed, and large-scale enterprise applications. |
| **Platform Edition** | **Java ME** (Micro Edition) | Designed for mobile and embedded devices. |
| **Implementation** | **Oracle JDK** | Maintained by Oracle (based on OpenJDK); since Java 10, it publishes feature releases every 6 months and **LTS** (Long-Term Support) versions every 3 years. |
| **Implementation** | **OpenJDK** | Free, open-source, and **official** implementation of Java SE maintained by the OpenJDK community. |
| **Implementation** | **Other Distributions** | Alternative implementations such as **Amazon Corretto**, **IBM JDK**, and **Azul Zulu**. |

## Block 2: JDK Installation and Configuration
Installing the JDK requires more than running an installer; the operating system must know where Java is located and where to find its executable commands so that compilation, execution, and verification work from any terminal location.

- **Linux (Ubuntu) Installation:** Uses the `apt` package manager to update the package cache (`apt update`) and install the recommended distribution JDK (`default-jdk`), which automatically pulls in dependencies including the **JRE**. A typical installation path is `/usr/lib/jvm/java-11-openjdk-amd64`.
- **Windows Installation:**
  1. Download the **OpenJDK** binary for Windows/x64.
  2. Unzip it into a known directory path (e.g., `C:\java\jdk-16.0.1`).
  3. Create the **`JAVA_HOME`** system environment variable pointing to the installation path.
  4. Edit the **`Path`** variable to append the JDK's `bin` directory (`%JAVA_HOME%\bin`).
  5. Open a terminal and verify with `java --version` and `javac --version`.
- **`JAVA_HOME`:** Environment variable that points to the root folder where the JDK is installed.
- **`PATH`:** Environment variable that includes `$JAVA_HOME/bin` (Linux) or `%JAVA_HOME%\bin` (Windows), allowing `java` and `javac` to be executed from any directory.
- **Reloading Configuration in Linux:** The `source` command (e.g., `source /etc/profile.d/jdk-home.sh`) loads the environment configuration immediately without restarting the user session.

### Verification Commands
| Command | Target Component | Diagnostic Meaning if It Fails |
|---|---|---|
| `java --version` | **JVM / Runtime Environment** (`java` executes bytecode) | The system cannot locate the Java runtime environment or `PATH` does not point to the JRE/JDK `bin` folder. |
| `javac --version` | **JDK Compiler** (`javac` compiles `.java` into `.class`) | The development environment is not ready: either only the **JRE** is installed (missing the full **JDK**) or `PATH` is misconfigured. |

## Block 3: Visual Studio Code
**Visual Studio Code (VS Code)** is a lightweight, cross-platform source code editor developed by Microsoft. Out of the box, it natively supports **JavaScript** and **TypeScript**, and while it is not a full IDE initially, it can closely approximate one by adding extensions for C++, C#, Python, Java, and other technologies.

- **Core Properties:**
  - **Lightweight:** Starts up quickly and focuses on editing code.
  - **Extensible:** Extensions add support for new languages, debugging, and tools.
  - **Configurable:** Supports both User and Workspace settings, including direct editing in **JSON**.
- **Key Functional Features:** **Command Palette** (`Ctrl+Shift+P`), **Git support**, **Syntax highlighting**, **JSON configuration**, **Integrated terminal**, **Multiple cursors**, **IntelliSense autocompletion**, and **Extensions**.
- **Installation:**
  - **Ubuntu:** Download the `.deb` package from `code.visualstudio.com/download` and install via double-click or terminal (`sudo apt install ./code_<version>_amd64.deb`). Note that exact version numbers change over time.
  - **Windows:** Download the stable installer, run it, accept the license, and choose the directory and shortcuts. After installation, it is accessible from the Start Menu or the System Development category.
- **User Interface (5 Basic Zones):**
  1. **Activity Bar:** Quick switcher for main activities (**Explorer**, **Search**, **Source Control**, **Debug**, and **Extensions**).
  2. **Menu Bar:** Top application menus.
  3. **Welcome / Editor:** Central area where files are edited.
  4. **Bottom Panel:** Houses the integrated terminal, output, and debug console.
  5. **Status Bar:** Bottom bar displaying project and editor status.
- **Preferences vs. Extensions:** Configuring **Preferences** adjusts editor behavior (organized by categories, searchable via the top filter bar; e.g., changing the theme via *Workbench > Appearance > Color Theme* or setting display language via `Configure Display Language`), whereas installing **Extensions** adds new capabilities (e.g., *Spanish Language Pack*).

### VS Code Workspaces and Configuration Scope
A **workspace** can contain one or multiple folders open simultaneously, is saved in a `.code-workspace` file (*File > Save Workspace As*), and can be expanded via *File > Add Folder to Workspace*.

| Scope | Description | Access / Priority Rule |
|---|---|---|
| **User Settings** | Global configuration applied to your user account across all projects. | Accessed via *File > Preferences > Settings*, `Ctrl+,`, or `Ctrl+Shift+P` (*Preferences: Open User Settings*). |
| **Workspace Settings** | Configuration specific to a single project or workspace. | **Priority:** In case of conflict, **Workspace settings override User settings**. |

## Block 4: Programming Java in VS Code
To transform VS Code into a complete Java development environment, you install the **Java Extension Pack** (which is a bundle of multiple extensions, not a single extension) and point VS Code to the local JDK via `java.home`.

- **Configuring `java.home`:**
  1. Open User Preferences (`Ctrl+Shift+P` > *Preferences: Open User Settings*).
  2. Search for the **`java.home`** parameter.
  3. Edit **`settings.json`** directly (this parameter cannot be edited via the graphical UI) and save the JDK path.
  4. **Exam Distinction:** Do not confuse **`JAVA_HOME`** (the operating system environment variable) with **`java.home`** (the VS Code setting inside `settings.json`).
- **Creating and Running `Hello.java`:**
  - Open the workspace folder in the Explorer and create a new file named `Hello.java`.
  - The Java extension detects the file type and generates the class skeleton.
  - Type `main` and accept the snippet to generate the **`main` method**, which is the entry point where program execution begins.
  - Execute using the **Run** button / `Ctrl+F5` (which automatically compiles and runs the program in the terminal) or manually via the integrated terminal (`javac Hello.java` followed by `java Hello`).
- **Debugging in VS Code:**
  - **Debug** starts step-by-step execution to inspect program behavior and variables.
  - Requires setting a **breakpoint** (stopping point) by clicking to the left of the line number.
  - **Breakpoint Rule:** Not all lines accept breakpoints; lines with only opening or closing braces (`{` or `}`) do not execute code and cannot hold an active breakpoint.
  - **Controls:** **`F5`** continues execution until the end or the next breakpoint; **`F10`** steps over code line by line.

### Components of the Java Extension Pack
| Extension | Core Functionality |
|---|---|
| **Language Support for Java** | Syntax highlighting, compilation error detection, autocompletion, refactoring, JavaDoc, and code snippets. |
| **Project Manager for Java** | Exploring, creating, and building Java projects. |
| **Debugger for Java** | Execution control, breakpoints, pausing, resuming, and variable tracking. |
| **Java Test Runner** | Running and debugging functional tests (JUnit) and viewing test logs. |
| **Maven for Java** | Managing Maven projects: generation, validation, compilation, testing, and deployment. |
| **Visual Studio IntelliCode** | Context-aware code suggestions powered by machine learning. |

## Block 5: Eclipse IDE
**Eclipse** is an open-source, cross-platform, extensible **Integrated Development Environment (IDE)**. Initially developed by IBM as the successor to VisualAge, it has been managed by the **Eclipse Foundation** since 2003 and is distributed under the **Eclipse Public License**. It operates as a tool-integration platform via plugins; Java support relies on the **JDT (Java Development Tools)** plugin included in the standard Java distribution.

- **Installation Process:**
  1. Download the official installer for your OS from the Eclipse packages page (`eclipse-inst-jre-linux64.tar.gz` on Linux or `eclipse-inst-jre-win64.exe` on Windows).
  2. Extract the archive (on Linux) and run `eclipse-inst` (or double-click the `.exe` on Windows).
  3. Select the package for **Java Developers**.
  4. Verify or select the **JVM / `JAVA_HOME`** path, accept the licenses, and complete installation.
- **Creating a Java Project:**
  - Go to *File > New > Java Project* (or use the *New* icon / *Package Explorer*).
  - Enter the project name (e.g., `Hello`), select the **JVM/JRE**, and choose the project layout to separate source files (`src`) and compiled bytecode (`bin`/`out`).
  - When prompted about creating `module-info.java`, select **Don't Create** if you are not building a modular project.
- **Creating a Class with `main`:**
  - Right-click `src` > *New > Class*, specify the package if required (the *Finish/Create* button stays disabled if mandatory information is missing), set *Name* to `Hello`, check the box to generate `public static void main(String[] args)`, and click *Finish*.
- **Run vs. Debug in Eclipse:**
  - **Run (`Ctrl+F11` or *Run > Run*):** Executes the complete program and prints output in the **Console** view.
  - **Debug (`F11` or *Debug*):** Starts the debugger to analyze and control program execution step by step.

### Core Eclipse Architecture & Java Perspective Components
| Concept / Component | Category | Purpose |
|---|---|---|
| **Workspace** | Core Concept | Working directory asked on first launch where Eclipse stores projects, preferences, and extensions. |
| **Perspective** | Core Concept | Preconfigured layout of views and editors optimized for a specific task (e.g., Java Perspective). |
| **View** | Core Concept | Specialized sub-window (manageable via *Window > Show View*) displaying specific project data. |
| **Editor** | Core Concept | Central zone where Java code is written, supporting autocompletion and snippets. |
| **Package Explorer** | Java Perspective View | Displays the project structure (`JRE`, `src`, packages) and creation options. |
| **Outline** | Java Perspective View | Displays a summary of the methods and attributes of the currently open class. |
| **Problems / Javadoc / Declarations** | Java Perspective Views | Auxiliary bottom tabs showing compilation errors, documentation, and symbol declarations. |

## Block 6: Comparison, Workflow, and Troubleshooting
A functional development environment requires completing a sequential operational chain: **Install JDK** (`java` + `javac`) → **Configure Environment** (`JAVA_HOME` / `PATH`) → **Open Editor/IDE** (VS Code / Eclipse) → **Create Project** (workspace/project) → **Create Class** (`Hello.java`) → **Compile** (`javac` / extension) → **Execute** (`java` / Run) → **Debug & Fix** (Debug + breakpoint). If an early phase fails (such as compilation), subsequent phases like debugging cannot proceed.

### VS Code vs. Eclipse Comparison
| Criterion | VS Code | Eclipse |
|---|---|---|
| **Type** | Lightweight extensible code editor | Complete and extensible IDE |
| **Java Support** | Requires installing **Java Extension Pack** | **JDT** plugin included in the standard Java distribution |
| **Organization** | Workspace and folders | Workspace and structured projects (`src` / `bin`) |
| **Configuration** | User / Workspace settings (`settings.json`) | Preferences, perspectives, and views |
| **Execution** | Run / Debug via extension or integrated terminal | Run / Debug natively integrated into the IDE |

### Common Errors and Troubleshooting Guide
| Symptom / Problem | Root Cause & Solution |
|---|---|
| **`java` is not recognized** | `PATH` does not point to the JDK/JRE `bin` directory, or Java is not installed. |
| **`javac` is not recognized** | Only the **JRE** is installed instead of the full **JDK**, or `PATH` does not include the JDK `bin` folder. |
| **VS Code does not detect Java** | Check that the **Java Extension Pack** is installed and verify `java.home` inside `settings.json`. |
| **`main` method does not appear** | Create the class properly and check the option to generate `main` (or use the `main` snippet in VS Code). |
| **Breakpoint does not activate** | Placed on a non-executable line (such as empty opening/closing braces `{}`). Move it to an executable statement. |
| **Disorganized project structure** | Confusing the workspace directory, project folder, source folder (`src`), and compiled output folder (`bin`/`out`). |

## Code Examples

### Linux JDK Installation, Environment Configuration, and Verification
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

### Windows Environment Variables & Verification
```bat
REM Set JAVA_HOME to the extracted JDK folder and append bin to Path
JAVA_HOME = C:\java\jdk-16.0.1
Path += %JAVA_HOME%\bin

REM Verify installation in terminal
java --version
javac --version
```

### Installing VS Code (.deb) and Eclipse Installer on Linux
```bash
# Install downloaded VS Code Debian package on Ubuntu
sudo apt install ./code_1.56.2-..._amd64.deb

# Extract and launch the official Eclipse installer on Linux
tar -xvzf eclipse-inst-jre-linux64.tar.gz
cd eclipse-installer
./eclipse-inst
```

### VS Code `settings.json` (`java.home` Configuration)
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

### Java Programs (`Hello.java`) and Manual Terminal Execution
```java
// Basic Hello.java (Standard Library & API / VS Code Debug Example)
public class Hello {
    public static void main(String[] args) {
        System.out.println("Hello!");
        System.out.println("My first code in VS Code");
        // In the debugging example, the second print statement is:
        // System.out.println("Debug");
    }
}
```
```java
// Hello.java generated in Eclipse IDE
public class Hello {
    public static void main(String[] args) {
        System.out.println("Hello!");
        System.out.println("This is our first code in Eclipse");
    }
}
```
```bash
# Manual compilation (.java -> .class) and execution in terminal
javac Hello.java
java Hello
```