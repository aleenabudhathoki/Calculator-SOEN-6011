# Arccos(x) Scientific Calculator

**Version**: 1.0.0  
**Course**: SOEN 6011 – Software Engineering Processes  
**University**: Concordia University  
**Function ID**: F1 – arccos(x)  
**Deliverable**: D3  
**Author**: Alina Budhathoki

---

## 📘 Overview

This project implements the **arccos(x)** function from scratch in Java, using the Maclaurin series for arcsin(x) and the identity:

\[
\arccos(x) = \frac{\pi}{2} - \arcsin(x)
\]

It avoids `Math.acos()` and uses only basic arithmetic operations.  
The application includes a **Java Swing GUI**, follows the **Google Java Style Guide**, and demonstrates best practices in code quality, testing, and accessibility.

---

## 🎯 Features

- **From-scratch implementation** of arccos(x) using Maclaurin series.
- **Java Swing GUI** supporting output in both radians and degrees.
- **Domain validation** to enforce \(-1 \leq x \leq 1\).
- **Input error handling** with clear messages.
- **Accessibility** through `AccessibleContext` labeling.
- **Code style compliance** via Checkstyle (Google Java Style).
- **Static code analysis** with PMD.
- **Unit testing** with JUnit 5.
- **Semantic Versioning** (`v1.0.0`).
- **Version control** with Git & GitHub hosting.

---

## 🛠 Tools & Technologies

| Tool / Library       | Purpose |
|----------------------|---------|
| **Java 17**          | Programming language |
| **Swing**            | GUI framework |
| **Maven**            | Build & dependency management |
| **JUnit 5**          | Unit testing |
| **Checkstyle**       | Code style enforcement |
| **PMD**              | Static code analysis |
| **IntelliJ IDEA**    | IDE & debugger |
| **GitHub**           | Version control hosting |

---

## 🚀 Getting Started

### Prerequisites
- Java 17+
- Git

### Clone the Repository
```bash
git clone https://github.com/your-username/arccos-calculator.git
cd arccos-calculator
