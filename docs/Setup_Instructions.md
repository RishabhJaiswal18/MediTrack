# MediTrack – Java Environment Setup Instructions

This document explains how to set up the Java environment required to run the MediTrack Core Java project.

---

## 1. Java Installation (JDK)

### Step 1: Download JDK
- Download **Java JDK 17** from:
  - https://www.oracle.com/java/technologies/downloads/
  OR
  - https://adoptium.net/

### Step 2: Install JDK
- Follow the installer steps for your operating system (Windows / macOS / Linux).
- Make note of the installation path (example: `C:\Program Files\Java\jdk-17`).

---

## 2. Setting JAVA_HOME

### Windows
1. Open **System Properties → Advanced → Environment Variables**
2. Add a new **System Variable**:
   - Name: `JAVA_HOME`
   - Value: Path to JDK (e.g. `C:\Program Files\Java\jdk-17`)
3. Edit **Path** variable and add:
	%JAVA_HOME%\bin


### macOS / Linux
Add this to `.bashrc` or `.zshrc`:
```bash
export JAVA_HOME=/path/to/jdk
export PATH=$JAVA_HOME/bin:$PATH```

## 3. Verify Java Installation
javac -version
java -version

## 4. IDE Setup
Recommended IDEs

IntelliJ IDEA

Eclipse

Steps

Open IDE

Create a Java Project

Set Project SDK to Java 17

Import the meditrack project folder

Ensure base package:

com.airtribe.meditrack

## 5. Running the Application

From terminal:

javac MediTrack.java
java MediTrack


OR run MediTrack.java directly from the IDE.


