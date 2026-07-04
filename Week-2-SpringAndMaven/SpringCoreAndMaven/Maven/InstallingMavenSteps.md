````markdown id="mvninst01"
# Installing Maven (Overview)

Before using Maven, you must install the **Java Development Kit (JDK)** because Maven itself is a Java application.

---

# Prerequisites

Since Maven is written in Java, a **JDK** must be installed before Maven can run.

Verify that Java is installed correctly by executing:

```bash
java -version
```

```bash
javac -version
```

Both commands should display the installed Java version.

> **Note:** If these commands fail, install the JDK and configure the `JAVA_HOME` environment variable before installing Maven.

---

# Downloading Maven

Apache Maven can be downloaded from the **official Apache Maven website**.

For Windows:

- Download the **Binary ZIP Archive**.
- Extract the downloaded ZIP file to a suitable location (for example, `E:\DevTools\apache-maven-3.9.13`).

For Linux and macOS:

- Download the appropriate binary distribution for your operating system.

After extraction:

- Add Maven's `bin` directory to the system **PATH** environment variable.
- This makes the `mvn` command available from any terminal or command prompt.

---

# Verifying the Installation

After configuring Maven, verify the installation by running:

```bash
mvn -version
```

Example output:

```text
Apache Maven 3.9.13
Maven home: E:\DevTools\apache-maven-3.9.13
Java version: 21.0.9
```

This confirms that:

- Maven is installed correctly.
- Maven can locate the installed JDK.
- The `mvn` command is available globally from any terminal.

---

# Maven Wrapper (`mvnw`)

Many modern Java projects—including those generated using **Spring Initializr**—include the **Maven Wrapper**.

Typical project structure:

```text
project/
│
├── .mvn/
├── mvnw
├── mvnw.cmd
├── pom.xml
└── src/
```

The Maven Wrapper allows a project to use a **specific Maven version** without requiring every developer to install that version globally.

When executed, the wrapper:

1. Determines the Maven version required by the project.
2. Downloads that version if it is not already available.
3. Launches the project using that Maven version.

Example:

```bash
./mvnw spring-boot:run
```

This ensures that every developer builds and runs the project using the same Maven version, resulting in consistent builds across different environments.

> **Note:** The Maven Wrapper does **not** contain a complete Maven installation inside the project. It only includes wrapper scripts and configuration that download and invoke the required Maven version from the local wrapper cache.

---

# When to Use `mvn` vs `mvnw`

| Command | Uses |
|---------|------|
| `mvn` | Uses the globally installed Maven available on your system. |
| `mvnw` (`mvnw.cmd` on Windows) | Uses the Maven Wrapper, ensuring the project runs with the Maven version specified by the project. |

---

# Which One Should You Use?

For personal projects, either command works.

For team projects and production applications, the **Maven Wrapper (`mvnw`) is recommended** because it guarantees that every developer uses the same Maven version.

---

# Key Takeaways

- Maven is a **Java application**, so the **JDK must be installed first**.
- Verify Java installation using:
  - `java -version`
  - `javac -version`
- Install Maven and add its `bin` directory to the system `PATH`.
- Verify Maven installation using:
  - `mvn -version`
- Modern projects typically include the **Maven Wrapper (`mvnw`)**.
- The Maven Wrapper automatically downloads and uses the Maven version required by the project.
- `mvn` uses the globally installed Maven, while `mvnw` uses the project-specific Maven version defined by the wrapper.

---

> **Next Topic:** Creating a Maven Project from the Command Line (Without Using an IDE)
````
