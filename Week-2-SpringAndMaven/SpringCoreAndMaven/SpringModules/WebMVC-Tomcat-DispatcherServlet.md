# Spring MVC, DispatcherServlet, Servlet, Servlet Container, and Tomcat

Many beginners get confused because these technologies come from **different organizations** and belong to **different layers of the Java web ecosystem**.

Let's untangle them one by one.

---

# Step 1: Who Owns What?

Let's first classify everything.

| Technology | What is it? | Developed By | Part of Spring? |
|------------|------------|--------------|-----------------|
| Spring MVC | Web framework/module | Spring | ✅ Yes |
| DispatcherServlet | A Servlet provided by Spring MVC | Spring | ✅ Yes |
| Servlet | Java technology (API) | Java (now Jakarta EE) | ❌ No |
| Servlet Container | Runtime that executes Servlets | Apache Tomcat, Jetty, Undertow | ❌ No |
| Apache Tomcat | Servlet Container / Web Server | Apache | ❌ No |

> **Notice:** Only **Spring MVC** and **DispatcherServlet** belong to the Spring Framework.

---

# Step 2: Let's Start from the Beginning

Imagine the Internet didn't have Spring.

How would Java create websites?

The answer was **Servlets**.

Suppose someone requests:

```text
http://localhost:8080/hello
```

Java introduced **Servlets**.

You would write:

```java
public class HelloServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req,
                         HttpServletResponse resp) {

        resp.getWriter().write("Hello");
    }
}
```

This is **pure Java**.

No Spring.

But can this class run by itself?

**No.**

It's just another Java class.

Some software has to:

- Listen on port **8080**
- Receive HTTP requests
- Create request objects
- Call `doGet()`

Who does that?

**The Servlet Container.**

---

# Step 3: What is a Servlet Container?

A **Servlet Container** is software that knows how to execute Servlets.

## Examples

- Apache Tomcat
- Jetty
- Undertow

## Responsibilities

- Listen for HTTP requests
- Create `HttpServletRequest`
- Create `HttpServletResponse`
- Create Servlets
- Manage the Servlet lifecycle
- Call:

```text
service()
    ↓
doGet()
```

or

```text
service()
    ↓
doPost()
```

### Mental Model

```text
Java Runtime
      ↓
Runs Java Classes
```

Similarly,

```text
Servlet Container
        ↓
Runs Servlets
```

---

# Step 4: Where Does Tomcat Fit?

Tomcat is simply one implementation of a **Servlet Container**.

```text
Servlet Container
        │
        ├── Apache Tomcat
        ├── Jetty
        └── Undertow
```

Tomcat isn't special.

It's simply the **most popular implementation**.

---

# Step 5: Then Why Was Spring MVC Created?

Imagine building an application using only Servlets.

```text
LoginServlet
RegisterServlet
ProductServlet
CartServlet
OrderServlet
AdminServlet
PaymentServlet
```

Problems:

- Every URL requires another Servlet.
- Routing becomes painful.
- Business logic gets mixed with HTTP code.
- Code becomes difficult to maintain.

Spring MVC was created to solve these problems.

---

# Step 6: Spring MVC's Biggest Idea

Instead of having:

```text
100 Servlets
```

Spring says:

> **Let's have only ONE Servlet.**

That Servlet is called:

```text
DispatcherServlet
```

This is the **heart of Spring MVC**.

---

## Who Owns DispatcherServlet?

```text
Spring MVC
      ↓
DispatcherServlet
```

`DispatcherServlet` is a **normal Servlet**.

It extends:

```text
HttpServlet
```

Which means:

> **Tomcat can execute it.**

---

## Request Flow

```text
Browser
    ↓
Tomcat
    ↓
DispatcherServlet
    ↓
Controller
    ↓
Service
    ↓
Repository
    ↓
Database
```

### Notice

Tomcat **never calls your Controller**.

Tomcat only knows about:

```text
DispatcherServlet
```

Everything after that is handled by **Spring MVC**.

---

# Step 7: Responsibilities of Spring MVC

Spring MVC is responsible for:

## 1. URL Routing

```text
GET /users
      ↓
UserController
```

using:

```java
@GetMapping("/users")
```

---

## 2. Request Mapping

Converts:

```text
/users/5
```

into:

```java
Long id
```

using:

```java
@PathVariable
```

---

## 3. Request Body Conversion

Converts:

```text
JSON
    ↓
Java Object
```

using:

```java
@RequestBody
```

---

## 4. Response Conversion

Converts:

```text
Java Object
      ↓
JSON
```

using **Jackson**.

---

## 5. Validation

```java
@Valid
```

---

## 6. Exception Handling

```java
@ControllerAdvice
```

---

## 7. View Rendering (Traditional MVC)

Earlier, Spring MVC generated **HTML pages**.

Nowadays, it is primarily used to build **REST APIs**.

---

# So What Exactly Does Tomcat Do?

Tomcat's responsibilities stop here:

```text
Receive HTTP Request
        ↓
Find DispatcherServlet
        ↓
Call
dispatcherServlet.service()
```

Tomcat has **no idea** what:

- `@GetMapping`
- `@RestController`
- `Controller`

mean.

---

# What Does DispatcherServlet Do?

DispatcherServlet acts like the **traffic police** of Spring MVC.

Suppose the request is:

```text
GET /users/10
```

DispatcherServlet asks:

> Which controller handles this request?

Spring replies:

```text
UserController
```

DispatcherServlet calls:

```java
userController.getUser(10);
```

When the controller returns:

```java
User
```

DispatcherServlet converts it to JSON and sends it back to Tomcat.

Tomcat then sends it to the browser.

---

# Complete Request Lifecycle

```text
Browser
    ↓
HTTP Request
    ↓
Tomcat
    ↓
DispatcherServlet
    ↓
Handler Mapping
    ↓
Controller
    ↓
Service
    ↓
Repository
    ↓
Database
    ↓
Repository
    ↓
Service
    ↓
Controller
    ↓
DispatcherServlet
    ↓
JSON
    ↓
Tomcat
    ↓
Browser
```

---

# What is the Role of Spring MVC?

Think of Spring MVC as a **complete web framework**.

It provides:

- Controllers
- Routing
- REST APIs
- JSON conversion
- Validation
- Exception handling
- View rendering
- DispatcherServlet

Everything related to handling web requests **after they enter your application**.

---

# Simple Analogy

Imagine a hospital.

| Component | Analogy |
|-----------|---------|
| Tomcat | Receptionist |
| DispatcherServlet | Department Coordinator |
| Controller | Doctor |
| Service | Medical Specialist |
| Repository | Medical Records Department |

### Flow

```text
Tomcat
(Receptionist)
        ↓
Receives patients
        ↓
DispatcherServlet
(Department Coordinator)
        ↓
Finds the correct doctor
        ↓
Controller
(Doctor)
        ↓
Service
(Medical Specialist)
        ↓
Repository
(Medical Records)
```

---

# The Biggest Mental Model

Instead of memorizing names, remember the layers.

```text
Networking Layer
──────────────────────────────
Tomcat (Servlet Container)

            ↓

Servlet Layer
──────────────────────────────
DispatcherServlet (Spring MVC)

            ↓

Web Framework Layer
──────────────────────────────
Controllers
@RequestMapping
@RestController

            ↓

Business Layer
──────────────────────────────
Services

            ↓

Persistence Layer
──────────────────────────────
Repositories

            ↓

Database
```

Each layer has a **well-defined responsibility**, making the architecture much easier to understand.

---

# Key Takeaways

- **Servlet** → A Java class that can handle HTTP requests.
- **Servlet Container (Tomcat)** → Runs Servlets.
- **DispatcherServlet** → Spring's special Servlet that acts as the **Front Controller**.
- **Spring MVC** → A web framework built around `DispatcherServlet` that provides:
  - Routing
  - Controllers
  - Validation
  - JSON conversion
  - Exception handling
  - REST API support
  - View rendering

> **Mental Model:**  
> **Servlet → Runs HTTP logic**  
> **Servlet Container → Runs Servlets**  
> **DispatcherServlet → Routes requests inside Spring MVC**  
> **Spring MVC → Builds an entire web framework around DispatcherServlet**
