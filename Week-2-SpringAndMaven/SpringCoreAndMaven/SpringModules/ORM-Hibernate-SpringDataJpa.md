# ORM, Hibernate, Spring ORM and Spring Data JPA - Complete Picture

These are probably the most confusing topics in the Spring ecosystem because there are multiple frameworks involved.

After reading this, you should clearly understand **who does what**.

---

# First, What is ORM?

ORM stands for **Object Relational Mapping**.

It is **not a library**.

It is **not a framework**.

It is a **programming technique (or concept)**.

Its goal is to solve one problem:

> "How do we convert Java Objects into rows in a relational database, and vice versa?"

For example,

Java Object

```java
User user = new User();

user.setId(1L);
user.setName("Sudharsan");
user.setEmail("abc@gmail.com");
```

↓

ORM converts it to

| id | name | email |
|----|------|-------|
| 1 | Sudharsan | abc@gmail.com |

Likewise,

Database

| id | name | email |
|----|------|-------|
| 1 | Sudharsan | abc@gmail.com |

↓

becomes

```java
User user;
```

So yes, your understanding is correct.

> ORM is the technique of mapping Java Objects to relational database tables and back again.

---

# Then who implements ORM?

ORM is just an idea.

Some framework has to implement it.

Examples:

- Hibernate
- EclipseLink
- OpenJPA
- MyBatis (not a complete ORM)

Among these,

**Hibernate** is by far the most popular.

---

# Where can I read the ORM specification?

There is **no official ORM specification**.

ORM itself is only a software design technique.

What **does have a specification** is **JPA**.

---

# What is JPA?

JPA stands for

**Java Persistence API**

It is a **Specification**.

Think of it like this:

```text
ORM
│
├── Idea / Technique
│
└── JPA
      │
      ├── Rules
      ├── Interfaces
      ├── Annotations
      └── Contracts
```

JPA defines things like

```java
@Entity

@Id

@OneToMany

@ManyToOne
```

and interfaces such as

```java
EntityManager
```

It says

> "Any ORM framework implementing JPA should behave like this."

---

# Where can I read the JPA Specification?

Nowadays, JPA is maintained under **Jakarta Persistence**.

Official specification:

https://jakarta.ee/specifications/persistence/

You don't need to read the entire specification.

It's written mainly for framework implementers.

For Spring developers,

the Javadocs are usually sufficient.

---

# Does Spring ORM use Hibernate?

Yes.

But let's phrase it correctly.

Spring ORM **doesn't perform ORM itself**.

Instead,

it **integrates Hibernate (or another JPA provider) into Spring**.

Think of it like this:

```text
Spring ORM

↓

Uses Hibernate

↓

Hibernate performs ORM
```

So,

Spring ORM itself doesn't know how to convert

```java
User
```

into SQL.

Hibernate does.

---

# Then what exactly does Spring ORM do?

Suppose you didn't have Spring.

Using Hibernate looks something like

```java
SessionFactory sessionFactory = ...

Session session = sessionFactory.openSession();

Transaction tx = session.beginTransaction();

session.save(user);

tx.commit();

session.close();
```

A lot of manual work.

Spring ORM automates all of this.

It manages

- SessionFactory
- EntityManager
- Transactions
- Exception conversion
- Resource cleanup

But the actual SQL generation is still done by Hibernate.

---

# Spring ORM does NOT generate SQL

This is important.

Many beginners think

```
Spring ORM

↓

SQL
```

No.

Actually,

```
Spring ORM

↓

Hibernate

↓

SQL
```

Hibernate generates SQL.

---

# Is Spring Data JPA part of Spring Framework?

No.

This surprises almost everyone.

Spring has multiple projects.

```
Spring Ecosystem

│

├── Spring Framework

├── Spring Boot

├── Spring Data

├── Spring Security

├── Spring Cloud

├── Spring Batch

├── Spring AI

└── ...
```

Notice

Spring Data

is its own project.

---

# Then why is it called Spring Data?

Because it is developed by the same organization.

Just like

```
Google

↓

Chrome

↓

Gmail

↓

Maps

↓

Android
```

Different products.

Same company.

Similarly,

```
Spring

↓

Spring Framework

↓

Spring Data

↓

Spring Boot

↓

Spring Security
```

Different projects.

Same ecosystem.

---

# What is Spring Data?

Spring Data is a family of libraries.

```
Spring Data

│

├── Spring Data JPA

├── Spring Data MongoDB

├── Spring Data Redis

├── Spring Data Cassandra

├── Spring Data Elasticsearch

├── Spring Data Neo4j

└── ...
```

Each one supports a different database technology.

---

# So when we use different databases, do we change Spring Data?

Not exactly.

It depends on the type of database.

## Relational Databases

All of these use

```
Spring Data JPA
```

- MySQL
- PostgreSQL
- Oracle
- SQL Server

You don't change Spring Data JPA.

You only change

- JDBC Driver
- Hibernate Dialect

Example

For MySQL

```xml
mysql-connector-j
```

For PostgreSQL

```xml
postgresql
```

Spring Data JPA remains the same.

---

## Non-relational databases

Then you change the Spring Data module.

Example

MongoDB

↓

```
Spring Data MongoDB
```

Redis

↓

```
Spring Data Redis
```

Cassandra

↓

```
Spring Data Cassandra
```

---

# What database libraries come by default?

When you add

```xml
spring-boot-starter-data-jpa
```

Spring Boot automatically brings many dependencies.

Conceptually,

```
spring-boot-starter-data-jpa

↓

Spring Data JPA

↓

Spring ORM

↓

Spring TX

↓

Spring JDBC

↓

Hibernate

↓

Jakarta Persistence API

↓

HikariCP

↓

Your JDBC Driver (you add this)
```

Notice

You only explicitly add

```
spring-boot-starter-data-jpa
```

Spring Boot brings many others automatically.

---

# Now the most important question

You asked

> Spring ORM configures things, so what does Hibernate actually do?

Excellent question.

Let's follow

```java
userRepository.save(user);
```

step by step.

---

# Step 1

You call

```java
userRepository.save(user);
```

Question

Who wrote

```
save()
```

You didn't.

Spring Data JPA did.

---

# Step 2

Spring Data JPA generated an implementation

Something similar to

```java
entityManager.persist(user);
```

Notice

Spring Data JPA itself didn't save anything.

It delegated.

---

# Step 3

Who owns EntityManager?

Spring ORM manages it.

Spring ORM

- creates it
- configures it
- injects it

Then calls

```java
entityManager.persist(user);
```

---

# Step 4

Who implements EntityManager?

Hibernate.

Hibernate now receives

```java
User
```

---

# Step 5

Hibernate looks at

```java
@Entity
```

```java
@Table
```

```java
@Column
```

annotations.

It understands

```
User

↓

users table

↓

name column

↓

email column
```

---

# Step 6

Hibernate generates SQL

```sql
INSERT INTO users(name,email)

VALUES (?,?)
```

---

# Step 7

Hibernate asks JDBC

```
Execute this SQL.
```

---

# Step 8

JDBC Driver sends SQL

↓

Database

↓

Data stored.

---

# Complete Flow

```
Your Code

↓

userRepository.save(user)

↓

Spring Data JPA

↓

EntityManager.persist(user)

↓

Spring ORM

↓

Hibernate

↓

Generate SQL

↓

JDBC

↓

MySQL Driver

↓

Database
```

Notice

Each layer has one responsibility.

---

# Then what about findById()?

Exactly the same.

```
findById()

↓

Spring Data JPA

↓

EntityManager.find()

↓

Hibernate

↓

Generate SELECT SQL

↓

JDBC

↓

Database

↓

ResultSet

↓

Hibernate

↓

Java Object

↓

Spring Data JPA

↓

Your Service
```

---

# Responsibilities Summary

| Technology | Responsibility |
|------------|----------------|
| Spring Data JPA | Generates repository implementations (`save()`, `findById()`, etc.) |
| Spring ORM | Integrates Hibernate with Spring (EntityManager, transactions, exceptions) |
| Hibernate | Converts Java Objects ↔ SQL, generates SQL, tracks entity state |
| JDBC | Sends SQL to the database |
| JDBC Driver | Talks to the specific database (MySQL, PostgreSQL, Oracle, etc.) |
| Database | Stores and retrieves data |

---

# The Biggest Misconception

Many developers think:

```
Spring Data JPA

↓

Database
```

Actually,

```
Spring Data JPA

↓

Spring ORM

↓

Hibernate

↓

JDBC

↓

Database
```

Spring Data JPA doesn't know how to generate SQL.

Hibernate doesn't know Spring repositories.

Spring ORM doesn't know SQL generation.

Each framework does one job well, and together they provide the seamless experience of calling:

```java
userRepository.save(user);
```

or

```java
userRepository.findById(id);
```

with just a single line of code.
