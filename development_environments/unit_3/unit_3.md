# Unit 3: Version Control Systems and Build Automation Tools

## Overview & Contents
- **Version Control Systems (VCS):** What a VCS is, why it matters, and the three architectures: **local**, **centralized** and **distributed**.
- **Git:** Repository, commit, the three areas (**working directory**, **staging area**, **repository**), file states, **SHA-1**, **HEAD** and **branches**.
- **Remote repositories and GitHub:** **Bare** repositories, `clone`, `push`, `fetch`, `pull`, and Git integration in **VS Code** and **Eclipse**.
- **Build automation:** Manual Java compilation with packages, **Apache Ant**, **Apache Maven** and **Gradle**.
- **Exam checklist and practice questions.**

## Block 1: Version Control Systems
A version control system records the changes made to the files of a project over time. Without history, the project depends on the programmer's memory.

A VCS answers three questions:

- What changed between two moments of the project?
- Who made a change, and when?
- How do I go back to a previous version if something breaks?

| Term | Meaning |
|---|---|
| **Repository** | Storage for the project history |
| **Commit** | A confirmed snapshot of the project |
| **Diff** | The changes between two versions |
| **Revert** | Going back to a previous state |

Example: a practice exercise works on Monday and breaks on Wednesday. The VCS lets you compare the changes and recover the stable version.

With plain text files (source code, HTML, CSS, XML, Markdown) the VCS compares line by line and shows exactly what was added, modified or deleted.

Common confusions:

- Saving a file is **not** creating a version of the project.
- A commit is **not** "uploading to the Internet". It confirms a snapshot.
- History lets you work safely. It is not just a pile of copies.

### Types of VCS
| Type | Where the history lives | Typical use | Main risk |
|---|---|---|---|
| **Local** | Only on the local machine | Individual work | Lose the machine, lose the history |
| **Centralized** | A central server; clients work against it | Teams connected to a server | The server is a single point of failure |
| **Distributed** | Every machine has a full copy (plus a shared server if there is one) | Flexible collaboration | Most robust against failures |

- **Local:** the system stores differences between versions and rebuilds a version from the base file. Simple, but not built for collaboration.
- **Centralized:** typical flow is checkout (get latest version), work locally, commit (send changes to the server).
- **Distributed:** you can work offline, local commits do not depend on the server, and you sync when you share or fetch work.

Distributed does **not** mean "no server". It means the full history does not live only on the server. **Git is distributed.**

Typical question: "A team needs to work offline and sync when the connection comes back." Answer: a distributed VCS, because every machine keeps the full repository.

## Block 2: Git Concepts and Workflow
Git works with snapshots of the file system in each commit. Every local user can have a full copy of the history, branches let you try things without breaking the main line, and **SHA-1** is used internally to identify commits and detect changes.

Golden rule: **commit saves to your local repository. Push sends to the remote repository.** They are not the same thing.

### The three areas of Git
| Area | Also called | What happens there |
|---|---|---|
| **Working directory** | Working tree | The visible area: you edit, create and delete files |
| **Staging area** | Index | Changes that will go into the next commit |
| **Repository** | `.git` | Confirmed history made of commits |

```bash
git add Archivo.java          # moves changes to the staging area
git commit -m "Add form validation"   # confirms them in the repository
```

If you modify a file after `git add`, that new change is **not** in the commit until you run `git add` again.

### File states
| State | Meaning |
|---|---|
| **Untracked** | Git sees the file but it is not under version control yet |
| **Modified** | The file was already tracked and its content changed |
| **Staged** | Prepared for the next commit |
| **Committed** | Matches what is stored in the repository |

Quick check:

| Situation | State |
|---|---|
| I create `README.md` and never run `git add` | untracked |
| I edit `App.java`, which was already in the repo | modified |
| I run `git add App.java` | staged |
| I run `git commit` successfully | committed |

Trap question: `git add` does **not** create a version in the repository. You still need `git commit`.

In VS Code, a **U** next to a file means untracked (a new file not yet in Git). An **M** means modified.

### Usual workflow
```bash
git status                     # shows changes and states
git add src/App.java           # prepares changes for the next commit
git commit -m "Fix total calculation"   # creates a snapshot in the local repo
```

A commit should be one logical unit of work. "Misc changes" is not a commit message.

### SHA-1 and HEAD
- **SHA-1:** a hexadecimal hash that uniquely identifies a commit or content. Any change produces a different hash, which helps detect tampering.
- **HEAD:** a pointer to the latest commit of the current branch. It moves forward on every new commit and changes when you switch branches.

### Branches
A branch is an alternative line of work that does not break the main line (`main` / `master`). If the work on the branch is good, you **merge** it. If not, you discard it.

Use a branch when the change will take several commits, you are not sure the new code will work, you want to fix a bug without mixing it with other tasks, or you need to keep the main branch stable.

```bash
git branch pruebas
git checkout pruebas    # or: git switch pruebas
```

A branch is not a manual copy of a folder. Switching branches changes the working directory. Merging integrates the changes of one branch into another.

## Block 3: Remote Repositories, GitHub and IDEs
A **bare repository** has no working directory. It is the shared repository on the server and looks like the inside of a `.git` folder.

### Remote workflow
| Step | Command |
|---|---|
| 1. Create the shared bare repository | `git init --bare` |
| 2. Clone it on every machine | `git clone URL` |
| 3. Work locally | `git add` / `git rm` / `git commit` |
| 4. Synchronize | `git push` / `git fetch` / `git pull` |

| Command | What it does | Memory hook |
|---|---|---|
| `push` | Sends local commits to the remote | Push goes up |
| `fetch` | Downloads information from the remote without merging | Fetch checks |
| `pull` | Downloads and integrates remote changes into the local branch | Pull brings in |

If the remote has changes you don't have, you may need to `pull` before you `push`. If two people change the same lines, you get a **conflict**.

### GitHub
GitHub is a platform that hosts Git repositories and adds collaboration tools: project management, documentation, wiki and project pages. **Git** is the version control system. **GitHub** is a platform that uses Git. You can use Git without GitHub.

### Git in VS Code and Eclipse
- **VS Code:** Git must be installed on the machine. From the editor you can open or clone a repo, initialize one, see modified and untracked files, stage, write the message and commit. Sync runs pull and push.
- **Eclipse:** first check or set `user.name` and `user.email` (Preferences > Version Control (Team) > Git > Configuration). The **Git perspective** lets you add local repositories, clone remote ones, create empty ones and see branches, working directory and remotes.

Learning outcome linked to the unit challenge: **RA4 f**, version control integrated into the development environment (repository managed from the IDE, clear commits, correct sync with the remote, conflict resolution when needed).

## Block 4: Build Automation Tools
When a project grows, compiling, running, testing and packaging by hand stops making sense. Automation means defining repeatable build tasks: **compile, run, test, package, distribute**.

### Base example: Java program with packages
```text
src/
└── com/
    └── mgh/
        └── edd/
            ├── Hola.java     (contains main)
            └── Saluda.java   (helper logic)
```

The package name must match the folder structure (`com.mgh.edd` → `com/mgh/edd`).

```java
package com.mgh.edd;

public class Saluda {
    public static void saluda(String nombre) {
        System.out.println("Hola " + nombre);
    }
}
```

```bash
javac com/mgh/edd/Saluda.java
javac com/mgh/edd/Hola.java
java com.mgh.edd.Hola Jose     # prints: Hola Jose
```

`javac` compiles to bytecode (`.class`). `java` runs the class using its fully qualified name.

### Apache Ant
Java library to automate builds, configured with an XML file called **`build.xml`**. The key concept is the **target**: a build task that can depend on other targets through `depends`.

```xml
<project name="saludaAnt">
  <target name="clean">
    <delete dir="classes" />
  </target>

  <target name="compile" depends="clean">
    <mkdir dir="classes" />
    <javac includeantruntime="false" srcdir="src/com/mgh/edd" destdir="classes" />
  </target>

  <target name="run" depends="compile">
    <property name="arg0" value="" />
    <java classpath="classes" classname="com.mgh.edd.Hola">
      <arg value="${arg0}" />
    </java>
  </target>
</project>
```

- `<project>` is the root element.
- `clean` deletes the previous output folder.
- `compile` depends on `clean`: creates `classes` and runs `javac`.
- `run` depends on `compile`: runs the main class.
- `property` defines `arg0`, and `${arg0}` reads its value.

When you ask for a target, Ant first runs its dependencies. `ant run` executes **clean → compile → run**.

```bash
ant compile             # clean + compile
ant run -Darg0=Jose     # clean + compile + run, passing "Jose"
ant clean               # clean only
```

`BUILD SUCCESSFUL` means the build finished correctly. If something fails, look at which target failed (clean, compile or run).

In VS Code you can run Ant from the terminal or with the **Ant Target Runner** extension. Eclipse ships with Ant (**Ant Build** / **Ant Build...** to choose targets). Either way, the behaviour is defined by `build.xml`.

### Apache Maven
Maven defines a standard way to organize, build and manage a Java project: project creation, build lifecycle, dependency and version management, documentation and distribution. It follows **convention over configuration**.

In Ant you describe the tasks and their order. In Maven you pick a phase of a known lifecycle and Maven uses its conventions to get there.

- **Artifact:** reusable software product managed by Maven.
- **Archetype:** template to create the skeleton of projects of the same type (`quickstart`, `simple`, `webapp`).

Maven has three lifecycles: **default** (builds the artifact), **clean** (cleans the project) and **site** (generates documentation). Each lifecycle is split into ordered phases. Running a phase also runs all the previous phases of that lifecycle.

| Phase (default lifecycle) | What it does |
|---|---|
| `validate` | Checks the project structure |
| `compile` | Generates bytecode |
| `test` | Runs unit tests |
| `package` | Builds the JAR |
| `verify` | Runs integration checks |
| `install` | Installs the artifact in the local repository |
| `deploy` | Publishes it to a remote repository |

`mvn package` runs validate → compile → test → package.

| Phase | Goal | Plugin |
|---|---|---|
| compile | `compiler:compile` | maven-compiler-plugin |
| test | `surefire:test` | maven-surefire-plugin |
| package | `jar:jar` | maven-jar-plugin |
| install | `install:install` | maven-install-plugin |
| deploy | `deploy:deploy` | maven-deploy-plugin |

**Goal** = a specific task. **Plugin** = a set of related goals. **Phase** = the moment in the lifecycle when certain goals run.

**POM:** `pom.xml` is the centre of the configuration (groupId, artifactId, version, dependencies, plugins, profiles). Its values are combined with the defaults of the **Super POM** to produce the **effective POM**, which is what Maven actually uses. Standard folders: `src/main/java`, `src/test/java` and `target`.

### Gradle
Gradle combines the flexibility of Ant (custom tasks, dependencies between tasks) with Maven's conventions and lifecycle. It does not use XML: it uses a **DSL based on Groovy or Kotlin**.

- `settings.gradle` lists the projects (and subprojects) in the build.
- `build.gradle` defines plugins, configuration and tasks.
- A **task** is an action: compile, test, package, clean...
- With Kotlin DSL: `settings.gradle.kts` and `build.gradle.kts`.

Gradle build lifecycle:

1. **Initialization:** reads `settings.gradle` to know which projects take part.
2. **Configuration:** reads the `build.gradle` files and builds a **directed acyclic graph** of tasks.
3. **Execution:** runs only the tasks needed, in graph order, and never runs the same task twice in one build.

### Ant vs Maven vs Gradle
| Tool | Configuration | Main idea | Key concept |
|---|---|---|---|
| **Ant** | `build.xml` (XML) | Explicit, custom tasks | target |
| **Maven** | `pom.xml` (XML) | Standard lifecycle + conventions | lifecycle / POM |
| **Gradle** | `build.gradle` (Groovy/Kotlin DSL) | Tasks + conventions + flexibility | tasks |

## Cheat Sheet
| I want to... | Answer |
|---|---|
| Save a snapshot of the project locally | `git commit` |
| Prepare a file for the next commit | `git add` |
| Send local commits to the server | `git push` |
| Get remote changes and integrate them | `git pull` |
| Check remote changes without merging | `git fetch` |
| Run `clean` before `compile` in Ant | `depends` |
| Standard structure and dependency management in Java | Maven |
| Flexible builds with a Groovy/Kotlin DSL | Gradle |

## Exam Checklist
- Define VCS, repository, commit, diff and revert.
- Tell apart local, centralized and distributed VCS.
- Explain working directory, staging area and repository.
- Identify untracked, modified, staged and committed.
- Tell apart commit, push, fetch and pull.
- Explain branches, HEAD and SHA-1 in simple words.
- Read Git indicators in VS Code and Eclipse.
- Explain Ant: `build.xml`, project, target, depends.
- Explain Maven: archetype, lifecycle, plugin, goal, POM.
- Explain Gradle: project, subproject, tasks and DSL.

Always add a "because..." to the answer. That sentence is what proves you understood it.
