
---

# 📄 docs/JVM_Report.md

```md
# JVM Report – MediTrack Project

This document explains the internal working of the Java Virtual Machine (JVM) in simple terms.

---

## 1. What is JVM?

JVM (Java Virtual Machine) is an engine that runs Java programs.  
It allows Java programs to be platform-independent.

Java Code → Bytecode → JVM → OS

---

## 2. Class Loader

The **Class Loader** loads `.class` files into memory.

### Types of Class Loaders:
1. **Bootstrap Class Loader**
   - Loads core Java classes (java.lang, java.util)
2. **Platform Class Loader**
   - Loads platform-specific modules
3. **Application Class Loader**
   - Loads user-defined classes (our MediTrack classes)

---

## 3. Runtime Data Areas

### Heap
- Stores **objects and instance variables**
- Shared across threads
- Garbage collected automatically

Example:
```java
Patient p = new Patient(...);
Object p is stored in Heap.

Stack

Stores method calls and local variables

Each thread has its own stack

LIFO structure

Example:

addPatient();
Method execution happens in Stack.

Method Area

Stores:

Class metadata

Static variables

Method bytecode

PC Register

Stores the address of the current instruction being executed by the thread.

4. Execution Engine

The Execution Engine executes bytecode using:

Interpreter

JIT Compiler

5. Interpreter vs JIT Compiler
Interpreter

Reads bytecode line by line

Slower execution

Used initially

JIT (Just-In-Time Compiler)

Converts bytecode to native machine code

Faster execution

Used for frequently executed code

✔ JVM uses both for performance optimization.

6. Write Once, Run Anywhere (WORA)

Java programs compile into bytecode, not machine code.

Same bytecode runs on:

Windows

Linux

macOS

JVM handles OS-specific execution

This makes Java platform-independent.