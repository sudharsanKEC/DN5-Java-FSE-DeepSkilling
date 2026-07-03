# From Java Source Code to a JAR File

Let's walk through the entire process from writing Java source code to creating a JAR file. Understanding this process will also make **Maven** much easier to understand.

---

# Step 1: Write Java Source Files

Suppose you have a Java project like this:

```text
MyProject/
│
├── src/
│   ├── Main.java
│   ├── User.java
│   ├── Product.java
│   ├── Order.java
│   └── ...
```

These are **Java source files** (`.java`).

> **Important:** The JVM **cannot execute `.java` files** directly.

---

# Step 2: Compile the Source Code

Compile the source files using the Java compiler (`javac`).

```bash
javac *.java
```

or

```bash
javac -d out src/*.java
```

After compilation, you get:

```text
out/
│
├── Main.class
├── User.class
├── Product.class
└── Order.class
```

These are **bytecode** (`.class` files).

The **JVM executes bytecode**, not Java source code.

> **Key Point:** A JAR normally contains compiled **`.class` files**, **not** `.java` files (unless you intentionally include the source code).

---

# Step 3: Package the Bytecode into a JAR

The **`jar`** tool (included with the JDK) packages files into a JAR archive.

Example:

```bash
jar cf myproject.jar -C out .
```

### Meaning of the command

- `c` → Create a new JAR
- `f` → Write to a file
- `myproject.jar` → Name of the output file
- `-C out .` → Change into the `out` directory and package everything inside it

The result:

```text
myproject.jar
```

---

# What Is Inside a JAR?

A JAR file is essentially a ZIP archive.

If you unzip it, you'll see something like:

```text
myproject.jar
│
├── META-INF/
│   └── MANIFEST.MF
│
├── Main.class
├── User.class
├── Product.class
└── Order.class
```

Notice that it contains only **compiled `.class` files**.

---

# Can a JAR Contain `.java` Files?

**Yes**, but it's uncommon for application distribution.

Example:

```text
myproject.jar
│
├── Main.class
├── User.class
├── Main.java
└── User.java
```

The JVM completely ignores the `.java` files.

They may be included for:

- Reference
- Documentation
- Source distribution

---

# How Is a JAR Actually Constructed?

Internally, the `jar` tool performs these steps:

1. Creates a ZIP archive.
2. Adds a `META-INF` directory.
3. Creates a `MANIFEST.MF` file.
4. Copies all specified files into the archive.

Conceptually:

```text
Create ZIP
      ↓
Add META-INF/MANIFEST.MF
      ↓
Copy Main.class
      ↓
Copy User.class
      ↓
Copy Resources
      ↓
Rename .zip → .jar
```

> **A JAR is essentially a ZIP archive with a specific structure and metadata.**

---

# What Is the `MANIFEST.MF` File?

Every JAR contains a **Manifest** file.

Example:

```text
Manifest-Version: 1.0
Created-By: Oracle
```

If the JAR is executable, it also contains:

```text
Manifest-Version: 1.0
Main-Class: Main
```

or, if the class belongs to a package:

```text
Manifest-Version: 1.0
Main-Class: com.example.Main
```

The `Main-Class` entry tells the JVM which class to execute when running the JAR.

---

# Creating an Executable JAR

Suppose your entry point is:

```java
public class Main {

    public static void main(String[] args) {
        System.out.println("Hello");
    }

}
```

Create the executable JAR:

```bash
jar cfe myproject.jar Main -C out .
```

### Command Breakdown

- `c` → Create
- `f` → Output file
- `e` → Entry point (`Main-Class`)

Now you can run the application:

```bash
java -jar myproject.jar
```

Output:

```text
Hello
```

---

# Is Bytecode Required Before Creating a JAR?

**Absolutely.**

The process is always:

```text
.java
   │
   │ javac
   ▼
.class (Bytecode)
   │
   │ jar
   ▼
.jar
```

The `jar` tool **does not compile Java code**.

It only packages files together.

If you package only `.java` files into a JAR, you'll simply get an archive containing source code, which the JVM cannot execute.

---

# Where Does Maven Fit In?

Everything discussed above is exactly what **Maven automates**.

Instead of manually running:

```bash
javac ...
jar ...
```

you simply run:

```bash
mvn package
```

Maven automatically:

- Compiles the source code (`javac`)
- Organizes the compiled output into the correct directory structure
- Packages compiled classes and resources into a JAR
- Places the generated JAR inside the `target/` directory

---

# Maven's Role in the Build Process

```text
Java Source (.java)
        │
        ▼
Maven
        │
        ├── Compile Source Code
        ├── Copy Resources
        ├── Generate Bytecode (.class)
        ├── Package into JAR
        └── Place Output in target/
        │
        ▼
Executable JAR
```

---

# Complete Build Workflow

```text
Write Java Source (.java)
            │
            ▼
Compile with javac
            │
            ▼
Generate Bytecode (.class)
            │
            ▼
Package with jar
            │
            ▼
Create JAR File (.jar)
            │
            ▼
Run Using
java -jar myproject.jar
```

---

# Manual Build vs Maven

| Task | Manual Process | Maven |
|------|----------------|--------|
| Compile Java source | `javac` | `mvn compile` |
| Package into JAR | `jar` | `mvn package` |
| Organize build output | Manual | Automatic |
| Copy resources | Manual | Automatic |
| Manage dependencies | Manual | Automatic |
| Build entire project | Multiple commands | Single command (`mvn package`) |

---

# Key Takeaways

- The JVM executes **bytecode (`.class`)**, not Java source (`.java`).
- A JAR is primarily a **ZIP archive** containing compiled `.class` files and metadata.
- The `jar` tool **packages** files but **does not compile** them.
- Bytecode must be generated **before** creating a JAR.
- Maven automates the entire **compile → package** workflow.
- Running `mvn package` performs the same tasks that would otherwise require manually invoking `javac` and `jar`.
