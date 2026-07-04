When I run ./mvnw springboot:run, maven fully compiles the springboot java project folders and make the .class file go inside target folder and then the DB connection happens, server getting started and listening on the port 8080, so behind this how maven is doing everything like starting tomcat servlet container.
# What Happens When You Run `./mvnw spring-boot:run`?

Understanding this process helps you clearly distinguish **where Maven's responsibility ends** and **where Spring Boot's responsibility begins**.

> **Note:** The correct command is:
>
> ```bash
> ./mvnw spring-boot:run
> ```
>
> **Not:**
>
> ```bash
> ./mvnw springboot:run
> ```

---

# High-Level Flow

When you execute:

```bash
./mvnw spring-boot:run
```

The overall flow looks like this:

```text
You
 │
 ▼
Maven Wrapper (mvnw)
 │
 ▼
Maven
 │
 ▼
Spring Boot Maven Plugin
 │
 ▼
Java Virtual Machine (JVM)
 │
 ▼
Spring Boot Application
 │
 ▼
Embedded Tomcat
 │
 ▼
Listening on Port 8080
```

Notice that **many different software components** are involved.

Let's study each one step by step.

---

# Step 1 – Maven Wrapper (`mvnw`)

When you execute:

```bash
./mvnw spring-boot:run
```

the **Maven Wrapper** starts first.

Its responsibilities are:

- Determine which Maven version the project requires.
- Download that version if necessary.
- Launch Maven.

After completing these tasks, the wrapper's job is finished.

---

# Step 2 – Maven Starts

Now Maven begins executing.

The very first thing Maven does is locate:

```text
pom.xml
```

Everything starts from this file.

Maven reads information such as:

- Dependencies
- Plugins
- Java version
- Packaging type
- Project metadata

---

# Step 3 – Maven Finds the Spring Boot Plugin

Inside your `pom.xml`, you'll typically find:

```xml
<plugin>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-maven-plugin</artifactId>
</plugin>
```

When you execute:

```bash
spring-boot:run
```

you're actually telling Maven:

> **Execute the `run` goal of the Spring Boot Maven Plugin.**

> **Important:** `spring-boot:run` is **not built into Maven**. It is provided by the **Spring Boot Maven Plugin**.

---

# Step 4 – Maven Executes the Plugin

Maven loads the Spring Boot Maven Plugin.

Conceptually:

```text
Maven
   │
   ▼
Spring Boot Maven Plugin
   │
   ▼
execute()
```

Internally, the plugin performs tasks similar to:

```java
public void execute() {

    compileProject();

    buildClasspath();

    launchApplication();

}
```

The real implementation is much more sophisticated, but this illustrates the overall idea.

---

# Step 5 – Project Compilation

Before running your application, the plugin ensures the project is compiled.

Internally, Maven performs the equivalent of:

```text
compile
```

The **Maven Compiler Plugin** invokes:

```text
javac
```

Every Java source file in:

```text
src/main/java
```

is compiled into:

```text
target/classes
```

Example:

```text
src/main/java/
└── UserController.java
        │
        ▼
target/classes/
└── UserController.class
```

This process happens for every Java source file.

---

# Step 6 – Resources Are Copied

Everything inside:

```text
src/main/resources
```

is copied into:

```text
target/classes
```

Example:

```text
src/main/resources/
└── application.properties
        │
        ▼
target/classes/
└── application.properties
```

The runtime classpath contains both:

- Compiled classes
- Resource files

---

# Step 7 – Dependency Resolution

Suppose your project depends on:

- Spring Web
- Spring Data JPA
- MySQL Driver
- Jackson
- Hibernate

Maven builds a runtime classpath.

Conceptually:

```text
target/classes
        +
spring-context.jar
        +
spring-web.jar
        +
tomcat-embed-core.jar
        +
hibernate.jar
        +
mysql.jar
        +
...
```

The JVM will later use this classpath when running the application.

---

# Step 8 – The JVM Starts

Now the Spring Boot Maven Plugin launches the JVM.

Conceptually, it performs something similar to:

```bash
java -cp <very-long-classpath> com.example.Application
```

> **Important:** Maven does **not** start your application directly.

Instead:

- Maven starts the JVM.
- The JVM starts your application.

---

# Step 9 – The JVM Calls `main()`

Your Spring Boot application contains:

```java
@SpringBootApplication
public class SocialMediaApplication {

    public static void main(String[] args) {

        SpringApplication.run(
            SocialMediaApplication.class,
            args
        );

    }

}
```

At this point:

- Maven has almost completed its work.
- The JVM has taken control.

---

# Step 10 – Spring Boot Starts

Now:

```java
SpringApplication.run()
```

begins executing.

Everything from this point onward is handled by **Spring Boot**, not Maven.

Spring Boot performs tasks such as:

- Component scanning
- Bean creation
- Dependency Injection
- Configuration loading
- Creating the `ApplicationContext`

---

# Step 11 – Database Connection

Spring Boot loads:

```text
application.properties
```

Example:

```properties
spring.datasource.url=...
```

Auto-configuration creates:

```text
DataSource
      │
      ▼
Connection Pool
      │
      ▼
Database Connection
```

Your application now connects to MySQL (or another configured database).

> Maven is **not involved** in this step.

---

# Step 12 – Embedded Tomcat Starts

Spring Boot notices the dependency:

```text
spring-boot-starter-web
```

This starter includes the embedded Tomcat libraries (such as `tomcat-embed-core`).

Spring Boot creates a Tomcat server.

Conceptually:

```java
Tomcat tomcat = new Tomcat();

tomcat.setPort(8080);

tomcat.start();
```

The real implementation is more complex, but the idea is the same.

---

# Step 13 – Tomcat Opens Port 8080

Tomcat creates a server socket.

Conceptually:

```java
ServerSocket socket = new ServerSocket(8080);
```

Now:

```text
http://localhost:8080
```

is listening for incoming HTTP requests.

Your application is finally ready.

---

# Who Is Responsible for What?

The responsibility of each component can be summarized as follows.

```text
./mvnw spring-boot:run
            │
            ▼
Maven Wrapper
──────────────────────────────
• Finds the correct Maven version
• Downloads it if necessary

            │
            ▼
Maven
──────────────────────────────
• Reads pom.xml
• Resolves dependencies
• Compiles Java code
• Copies resources
• Executes the Spring Boot Maven Plugin

            │
            ▼
Spring Boot Maven Plugin
──────────────────────────────
• Builds the runtime classpath
• Starts the JVM

            │
            ▼
JVM
──────────────────────────────
• Loads classes
• Invokes main()

            │
            ▼
Spring Boot
──────────────────────────────
• Creates ApplicationContext
• Performs Dependency Injection
• Configures Beans
• Starts Embedded Tomcat

            │
            ▼
Tomcat
──────────────────────────────
• Opens Port 8080
• Accepts HTTP Requests
```

---

# One Key Idea to Remember

Many beginners think:

> **"Maven starts Tomcat."**

That is **not** what actually happens.

Maven's responsibility ends after launching the Java application.

From that point onward:

- The JVM executes your `main()` method.
- `main()` calls `SpringApplication.run()`.
- Spring Boot initializes the application.
- Spring Boot creates the embedded Tomcat server.
- Spring Boot instructs Tomcat to start listening on port **8080**.

---

# The Correct Mental Model

```text
Maven
   │
   └──► Starts the JVM

JVM
   │
   └──► Executes your main()

Spring Boot
   │
   └──► Starts Embedded Tomcat

Tomcat
   │
   └──► Listens for HTTP Requests on Port 8080
```

This separation of responsibilities is fundamental.

It also explains why **the same Maven build tool can run many kinds of Java applications**, not just Spring Boot web applications.

Maven knows nothing about:

- HTTP
- Tomcat
- REST APIs
- Controllers

Its responsibility is simply to:

- Build the project.
- Execute the appropriate plugin.
- Launch the Java application.

Everything after that is handled by the JVM and your application's code.
