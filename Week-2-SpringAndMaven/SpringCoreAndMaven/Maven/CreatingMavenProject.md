# Creating Your First Maven Project manually

Since our goal is to **understand Maven**, we should **not** start with Spring Boot.

Instead, we'll begin with a **plain Java Maven project**.

This allows us to clearly understand what Maven is doing behind the scenes. Once you're comfortable with Maven, Spring Boot will become much easier to understand.

---

# What Are We Going to Build?

We'll build a simple **Java Console Application**.

Project structure:

```text
HelloMaven/
│
└── Main.java
```

Output:

```text
Hello from Maven!
```

The application itself is intentionally simple because our focus is on learning **Maven**, not Java.

---

# Learning Objectives

By building this project, you'll understand:

- How to create a Maven project from the command line.
- The standard Maven project structure.
- The purpose of `pom.xml`.
- Where Java source code should be placed.
- How Maven compiles the project.
- Where the compiled `.class` files are generated.
- How Maven packages the project into a JAR.
- How to run the application manually using the `java` command.
- Later, how to run it using Maven.

---

# Step 1 – Generate a Maven Project

Maven provides **project templates** called **Archetypes**.

Think of an **Archetype** as a project template.

Instead of manually creating:

```text
project/
│
├── src/
├── pom.xml
└── ...
```

Maven generates everything for you.

To generate a project, run:

```bash
mvn archetype:generate
```

---

# What Happens When You Run `mvn archetype:generate`?

When you execute:

```bash
mvn archetype:generate
```

Maven performs the following steps:

1. Downloads the list of available archetypes (if they are not already cached).
2. Starts an interactive project creation wizard.
3. Prompts you to provide information about your project.
4. Generates a Maven project based on the selected archetype.

---

# Step 2 – Choose an Archetype

You'll be presented with many available project templates.

For learning Maven, choose the standard **Quickstart Archetype**:

```text
org.apache.maven.archetypes:maven-archetype-quickstart
```

This archetype creates a simple Java console application.

---

# Step 3 – Enter the Group ID

Example:

```text
com.sudharsan
```

The **Group ID** usually represents:

- Your organization
- Your domain name (reversed)
- Your package namespace

Examples:

```text
com.sudharsan
com.example
org.company
```

---

# Step 4 – Enter the Artifact ID

Example:

```text
hello-maven
```

The **Artifact ID** becomes the project name.

Example:

```text
hello-maven
```

---

# Step 5 – Choose the Version

Usually, you can keep the default value:

```text
1.0-SNAPSHOT
```

> **Note:** We'll learn what **SNAPSHOT** means in a later chapter.

---

# Step 6 – Enter the Package Name

Example:

```text
com.sudharsan
```

This becomes the Java package where your source files are created.

---

# Project Generation

After confirming the entered values, Maven automatically generates the project.

The generated structure looks similar to:

```text
hello-maven/
│
├── pom.xml
│
└── src/
    ├── main/
    │   └── java/
    │       └── com/
    │           └── sudharsan/
    │               └── App.java
    │
    └── test/
        └── java/
            └── com/
                └── sudharsan/
                    └── AppTest.java
```

---

# Notice Something Important

You didn't manually create:

- `src/`
- `main/`
- `test/`
- `pom.xml`
- `App.java`

Maven generated all of them automatically using its **Standard Directory Layout**.

This is one of the reasons why Maven projects look very similar across different organizations.

---

# Why Are We Starting with a Plain Maven Project?

This single project will help us understand:

- Every important folder
- Every important element inside `pom.xml`
- Maven dependencies
- The Maven build lifecycle
- Maven plugins
- Packaging
- Running the project manually
- Running the project using Maven

By understanding these concepts first, Spring Boot will feel much more intuitive.

---

# What You'll Learn Next

As we continue using this project, you'll understand what really happens when you execute commands like:

```bash
mvn compile
```

```bash
mvn package
```

```bash
mvn install
```

You'll also discover that **Spring Boot is simply another Maven project** with additional:

- Dependencies
- Plugins
- Configuration

It is **not** a completely different build system.

---

# Learning Roadmap

```text
Create Maven Project
          │
          ▼
Understand Project Structure
          │
          ▼
Learn pom.xml
          │
          ▼
Understand Dependencies
          │
          ▼
Learn Maven Lifecycle
          │
          ▼
Understand Plugins
          │
          ▼
Compile the Project
          │
          ▼
Package into a JAR
          │
          ▼
Run the Application
          │
          ▼
Move on to Spring Boot
```

---

# Key Takeaways

- Start with a **plain Java Maven project** before learning Spring Boot.
- Maven uses **Archetypes** to generate project templates.
- The command `mvn archetype:generate` creates a new Maven project.
- Maven automatically generates a standard project directory structure.
- Every Maven project follows the same conventions, making projects easy to understand and maintain.
- Mastering Maven first provides a strong foundation for learning Spring Boot.
