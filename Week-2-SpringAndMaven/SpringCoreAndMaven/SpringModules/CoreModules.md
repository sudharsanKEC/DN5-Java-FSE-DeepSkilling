# Spring Framework - Core Modules

## What is a Spring Module?

Before learning the modules, let's first understand what a **module** actually means.

> **A common misconception is that Spring Core, Spring MVC, Spring Data, etc., are single libraries.**
>
> **They are not.**

A **Spring module** is a logical grouping of one or more Java libraries (**JAR files**) that provide a particular functionality.

### Example

```text
Spring Framework
│
├── Core Container
│   ├── spring-core.jar
│   ├── spring-beans.jar
│   ├── spring-context.jar
│   └── spring-expression.jar
│
├── AOP Module
│   ├── spring-aop.jar
│   └── spring-aspects.jar
│
├── Web Module
│   ├── spring-web.jar
│   └── spring-webmvc.jar
│
├── Data Access Module
│
├── Messaging Module
│
└── Test Module
```

### Module vs Library

- **Module** → A logical feature group
- **Library (JAR)** → The actual Java code implementing that feature

---

# Core Modules of the Spring Framework

The Spring Framework is commonly divided into the following major modules.

| Module | Purpose |
|---------|---------|
| Core Container | Bean management, IoC, DI |
| AOP | Aspect-Oriented Programming |
| Data Access / Integration | Database support and transactions |
| Web | Web applications and REST APIs |
| Messaging | Messaging abstraction |
| Test | Testing support |

---

# 1. Core Container Module ⭐⭐⭐⭐⭐

The **Core Container** is the heart of the Spring Framework.

Without this module:

- There is no Spring.
- Everything else depends on it.

## Libraries

- `spring-core.jar`
- `spring-beans.jar`
- `spring-context.jar`
- `spring-expression.jar`

These libraries together implement the **Core Container**.

## Responsibilities

The Core Container provides:

- IoC Container
- Dependency Injection (DI)
- Bean creation
- Bean lifecycle
- Bean scopes
- Configuration support
- Event system
- Resource loading
- Spring Expression Language (SpEL)

---

## Components Inside the Core Container

### 1. spring-core

Provides the fundamental utilities used by almost every Spring module.

#### Examples

- Reflection utilities
- Resource abstraction
- Type conversion
- Utility classes

> Think of it as the **foundation library** of Spring.

---

### 2. spring-beans ⭐⭐⭐⭐⭐

Responsible for:

- Bean creation
- Bean configuration
- Bean lifecycle
- `BeanFactory`

Whenever you write:

```java
@Component
@Service
@Repository
```

or

```java
@Bean
```

this library plays a major role.

---

### 3. spring-context ⭐⭐⭐⭐⭐

Builds on top of **spring-beans**.

Provides:

- `ApplicationContext`
- Event publishing
- Resource loading
- Internationalization (i18n)
- Component scanning

> This is the library you'll interact with most frequently.

---

### 4. spring-expression (SpEL)

Provides the **Spring Expression Language (SpEL).**

Example:

```java
@Value("#{2 + 5}")
```

or

```java
@Value("#{user.name}")
```

Useful for dynamic configuration.

---

## Why is the Core Container Important?

Without it, none of these work:

- `@Autowired`
- `@Component`
- `@Service`
- `@Bean`
- `@Configuration`

Everything starts here.

---

# 2. AOP Module

## Libraries

- `spring-aop.jar`
- `spring-aspects.jar`

## Purpose

Separates:

- Logging
- Security
- Transactions
- Auditing

from your business logic.

### Without AOP

```text
saveUser();

log();

checkPermission();

startTransaction();
```

### With AOP

```text
Logging
      ↓
Security
      ↓
Transaction
      ↓
saveUser()
      ↓
Commit
```

Spring automatically executes these cross-cutting concerns without cluttering your business methods.

### As a Spring Boot Developer

You'll use AOP indirectly through:

- `@Transactional`
- Spring Security
- Logging frameworks
- Method interceptors

Even if you never write your own aspects, you'll benefit from AOP.

---

# 3. Data Access / Integration Module

## Libraries

- `spring-jdbc.jar`
- `spring-tx.jar`
- `spring-orm.jar`
- `spring-oxm.jar`

## Responsibilities

Provides:

- JDBC support
- Transaction management
- ORM integration
- Exception translation

### Traditional JDBC

```java
Connection
PreparedStatement
ResultSet

finally {
    close everything;
}
```

Spring simplifies database interaction and manages resources automatically.

### As a Spring Boot Developer

You'll mostly use:

- Spring Data JPA
- Hibernate

Internally, they rely on this module.

---

# 4. Web Module ⭐⭐⭐⭐⭐

## Libraries

- `spring-web.jar`
- `spring-webmvc.jar`
- `spring-websocket.jar`

## Responsibilities

Provides:

- HTTP request handling
- REST APIs
- Controllers
- DispatcherServlet
- Validation
- JSON conversion

### Examples

```java
@RestController
@GetMapping
@PostMapping
@RequestBody
```

All belong to this module.

### As a Spring Boot Developer

You'll use this module every day.

Whenever you build REST APIs, you're using **Spring MVC**.

---

# 5. Messaging Module

## Library

- `spring-messaging.jar`

## Responsibilities

Supports:

- Messaging abstraction
- WebSocket messaging
- STOMP

Mostly used for:

- Chat applications
- Real-time notifications

### As a Spring Boot Developer

Not used in every project.

Useful for:

- Chat systems
- Live dashboards
- Notifications

---

# 6. Test Module

## Library

- `spring-test.jar`

## Responsibilities

Supports:

- Unit Testing
- Integration Testing
- MockMvc
- Test Context
- Dependency Injection during tests

### Examples

```java
@SpringBootTest
@WebMvcTest
@DataJpaTest
```

These annotations come from this module.

---

# How These Modules Depend on Each Other

```text
                 Spring Framework
                        │
        ┌───────────────┼────────────────┐
        │               │                │
        ▼               ▼                ▼
 Core Container       AOP          Data Access
        │               │                │
        └───────────────┼────────────────┘
                        │
                        ▼
                    Web Module
                        │
                        ▼
                 Spring Boot Apps
```

> **Notice:** Almost every module depends on the **Core Container**. That's why it is called the **foundation of Spring**.

---

# Which Modules Should a Spring Boot Developer Know Deeply?

| Module | Priority | Why |
|---------|----------|-----|
| Core Container | ⭐⭐⭐⭐⭐ | IoC, DI, Beans, and ApplicationContext are fundamental to Spring. |
| Web (Spring MVC) | ⭐⭐⭐⭐⭐ | Used for building REST APIs and handling HTTP requests. |
| Data Access | ⭐⭐⭐⭐⭐ | Essential for working with databases using JPA/Hibernate. |
| AOP | ⭐⭐⭐⭐☆ | Important because features like `@Transactional` rely on it. |
| Test | ⭐⭐⭐⭐☆ | Critical for writing unit and integration tests. |
| Messaging | ⭐⭐☆☆☆ | Learn when working on real-time features like chat or notifications. |

> **💡 Note:** You don't need to master every module before becoming productive. Focus first on the ones you'll use daily in backend development.

---

# Important Things to Know (Interview Perspective)

## 1. Spring Framework vs Spring Boot

They are **not** the same.

```text
Spring Framework
        │
Provides Features
        │
        ▼
Spring Boot
        │
        ├── Auto Configuration
        ├── Starter Dependencies
        └── Embedded Server
```

> **Spring Boot is built on top of the Spring Framework.**

---

## 2. Module vs Library

```text
Module
   │
   ▼
Logical Feature
   │
Contains
   │
   ▼
One or More JAR Libraries
```

### Example

```text
Core Container Module
        │
        ├── spring-core.jar
        ├── spring-beans.jar
        ├── spring-context.jar
        └── spring-expression.jar
```

---

## 3. The Core Container is the Foundation

Without the Core Container, none of these work:

- `@Component`
- `@Service`
- `@Repository`
- `@Autowired`
- `@Bean`
- `ApplicationContext`

---

## 4. Spring Boot Developers Don't Directly Use Every Module

Although Spring contains many modules, a typical Spring Boot developer primarily interacts with:

- Core Container
- Spring MVC (Web)
- Spring Data
- Spring Security *(separate Spring project)*
- Spring Boot

Many other modules work behind the scenes to support these features.
