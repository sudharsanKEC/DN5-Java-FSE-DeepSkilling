# Chapter 4 – Maven Architecture

Before learning Maven Architecture, let's answer some common questions that every beginner has.

---

# Before Chapter 4: Answering Your Questions

## 1. Is Maven Installed Globally on My Laptop?

**Yes.**

When you ran:

```bash
mvn -version
```

you got:

```text
Apache Maven 3.9.13
Maven home: E:\DevTools\apache-maven-3.9.13
```

This means:

- Maven is installed on your machine.
- Its `bin` directory is added to your system's **PATH**.
- Therefore, you can execute:

```bash
mvn
```

from **any directory**, and Windows knows where to find Maven.

> **Conclusion:** You have a **global Maven installation**.

---

# 2. Then Why Does My Spring Boot Project Have `mvnw` and `mvnw.cmd`?

This is one of the best features of modern Java projects.

Those files are called the **Maven Wrapper**.

```text
project/
│
├── .mvn/
├── mvnw
└── mvnw.cmd
```

Notice there are actually **three components**:

- `.mvn/`
- `mvnw`
- `mvnw.cmd`

Together, they form the **Maven Wrapper**.

---

## Using Global Maven

When you execute:

```bash
mvn package
```

Windows runs something similar to:

```text
E:\DevTools\apache-maven-3.9.13\bin\mvn.cmd
```

which uses your **globally installed Maven**.

---

## Using the Maven Wrapper

When you execute:

```bash
./mvnw package
```

(or `mvnw.cmd` on Windows)

the wrapper does **not** directly use your globally installed Maven.

Instead, it performs these steps:

```text
mvnw
   │
   ▼
Check which Maven version
the project requires
   │
   ▼
Download that version
(if necessary)
   │
   ▼
Run that Maven version
```

The Maven Wrapper ensures that **every developer uses exactly the same Maven version**, regardless of what is installed globally.

---

## Why Is This Useful?

Imagine a team:

- Developer A → Maven 3.8
- Developer B → Maven 3.9
- Developer C → No Maven installed

### Without Maven Wrapper

```text
Different Maven versions
        ↓
Inconsistent builds
        ↓
Potential problems
```

### With Maven Wrapper

Everyone simply runs:

```bash
./mvnw package
```

Every developer uses the **same Maven version specified by the project**.

---

## Does the Wrapper Ignore Global Maven?

**Not exactly.**

The wrapper is a **small launcher script**.

Internally, it:

1. Uses Java to run the wrapper.
2. Checks whether the required Maven version is already cached.
3. Downloads it if necessary.
4. Launches that Maven version.

So:

```text
mvn
   │
   ▼
Global Maven Installation
```

```text
mvnw
   │
   ▼
Project-specific Maven Wrapper
```

Spring Initializr includes the Maven Wrapper by default because it is the recommended approach.

---

# 3. Is Maven Only for Java?

**Mostly, yes.**

Maven was designed specifically for Java.

It understands Java conventions such as:

- `src/main/java`
- `src/test/java`
- `target/`
- JAR
- WAR
- `javac`
- JUnit

It understands how Java projects are typically structured.

---

## Can Maven Build Other Languages?

Technically, **yes**.

Plugins exist for:

- Kotlin
- Scala
- Groovy
- Clojure

However, Maven's ecosystem is fundamentally centered around the **JVM**.

---

# 4. Is Maven Tied to Java?

**Very much.**

Java provides tools such as:

- `javac`
- `java`
- `jar`

These are individual command-line tools.

Maven doesn't replace them.

Instead, Maven **orchestrates** them.

```text
Compile
    ↓
javac
    ↓
Package
    ↓
jar
    ↓
Run Tests
    ↓
JUnit
    ↓
Generate Documentation
    ↓
Javadoc
```

> Maven coordinates Java tools rather than replacing them.

---

# 5. How Does Maven Influence Project Folder Structure?

This is one of Maven's biggest ideas.

Instead of asking:

> "Where is your source code?"

Maven assumes that **every project follows the same directory structure**.

Example:

```text
src/main/java
```

→ Application source code

```text
src/test/java
```

→ Test source code

```text
src/main/resources
```

→ Configuration files and resources

```text
target/
```

→ Build output

This concept is known as:

> **Convention over Configuration**

Instead of configuring everything manually, everyone agrees to use the same structure.

---

## Why Does Spring Boot Follow This Structure?

A Spring Boot project typically looks like:

```text
src/
├── main/
│   ├── java/
│   └── resources/
└── test/
```

This directory layout is **Maven's convention**, not Spring Boot's invention.

Spring Boot simply adopted it because almost every Java developer already understands it.

---

# 6. Do We Need Java to Install Maven?

**Yes.**

Maven itself is a **Java application**.

When you execute:

```bash
mvn
```

internally, Maven runs something similar to:

```text
java
    ↓
org.apache.maven.cli.MavenCli
```

Without Java:

- Maven cannot start.
- Maven cannot execute.

That's why:

```bash
java -version
```

must work before Maven can work.

---

# 7. Can We Create a Maven Project Without IntelliJ?

**Absolutely.**

In fact, this is how Maven was originally intended to be used.

You can generate a project entirely from the command line.

Example:

```bash
mvn archetype:generate
```

Maven asks questions such as:

- `groupId`
- `artifactId`
- `version`
- `package`

and then generates the project structure automatically.

We'll build one manually later so you can understand exactly what IntelliJ does behind the scenes.

---

# Chapter 4 – Maven Architecture

This is one of the most important chapters.

Once you understand Maven's architecture, everything else becomes much easier.

Let's start with a simple question.

---

# What Happens When You Run `mvn package`?

Many beginners think:

> Maven compiles the project.

That's **not entirely correct**.

Maven is **not a compiler**.

It doesn't know how to compile Java source code.

Instead, Maven acts as an **orchestrator**.

Think of Maven as the **project manager** of your build process.

A project manager doesn't personally complete every task.

Instead, they coordinate different teams.

Maven works in exactly the same way.

```text
                 You
                  │
                  ▼
           mvn package
                  │
                  ▼
               Maven
                  │
      ┌───────────┼───────────┐
      │           │           │
      ▼           ▼           ▼
 Read pom.xml  Resolve      Execute
               Dependencies Plugins
                  │
                  ▼
          Invoke Java Tools
      (javac, jar, test runners)
                  │
                  ▼
          Produce Build Output
```

> **Notice:** Maven coordinates the work—it does not perform all the work itself.

---

# The Major Components of Maven

A Maven build consists of several major components working together.

```text
             Maven
                │
    ┌───────────┼────────────┐
    │           │            │
    ▼           ▼            ▼
 POM File   Lifecycle     Plugins
    │                         │
    ▼                         ▼
Dependencies           Java Tools
```

We'll study each component individually in the coming chapters.

For now, let's understand their responsibilities.

---

# 1. POM (`pom.xml`)

The **Project Object Model (POM)** is the configuration file of your project.

It answers questions such as:

- What is this project called?
- Which libraries does it need?
- Which Java version should be used?
- How should the application be packaged?
- Which plugins should execute?

Every Maven build begins by reading the `pom.xml` file.

---

# 2. Lifecycle

Every Maven build follows a predefined sequence of phases.

```text
validate
    ↓
compile
    ↓
test
    ↓
package
    ↓
verify
    ↓
install
    ↓
deploy
```

When you execute:

```bash
mvn package
```

Maven does **not** jump directly to the `package` phase.

Instead, it executes every required phase before it:

```text
validate
    ↓
compile
    ↓
test
    ↓
package
```

We'll study the Maven lifecycle in detail later.

---

# 3. Plugins

Maven itself contains very little built-in functionality.

Almost everything is implemented through **plugins**.

Examples:

- Compiler Plugin → Executes `javac`
- JAR Plugin → Creates JAR files
- Surefire Plugin → Runs unit tests

This plugin-based architecture makes Maven:

- Modular
- Flexible
- Extensible

---

# 4. Repositories

Whenever Maven encounters a dependency in `pom.xml`, it searches for it in repositories.

Typical search order:

```text
Local Repository
        │
(Not Found)
        ▼
Remote Repository
(Maven Central, Company Repository, etc.)
```

Downloaded libraries are cached locally so they don't need to be downloaded again.

---

# Overall Build Flow

Suppose you execute:

```bash
mvn package
```

The overall process looks like this:

```text
You
 │
 ▼
mvn package
 │
 ▼
Read pom.xml
 │
 ▼
Resolve Dependencies
 │
 ▼
Download Missing Libraries
 │
 ▼
Execute Lifecycle Phases
 │
 ▼
Run Required Plugins
 │
 ▼
Compile Java Source
 │
 ▼
Run Tests
 │
 ▼
Create JAR/WAR
 │
 ▼
Place Output in target/
```

Every Maven topic you'll learn from now on fits into one of these steps.

---

# Key Takeaways

- Maven is **not a compiler**; it is a **build orchestration tool**.
- It coordinates Java tools like `javac`, `jar`, JUnit, and Javadoc.
- The **POM** defines the project's configuration.
- The **Lifecycle** defines the sequence of build phases.
- **Plugins** perform the actual build tasks.
- **Repositories** provide project dependencies.
- Running `mvn package` triggers the complete build workflow automatically.
