# Liverpool Automation Challenge

Automation project developed using **Selenium WebDriver**, **TestNG**, **Page Object Model (POM)**, **Allure Reports**, and **GitHub Actions**.

---

# Requirements

* Java 17+
* Maven 3.9+
* Google Chrome
* Allure CLI (optional, for local report generation)
* Operating System:
- Windows 10/11
- Linux (GitHub Actions)

---

# Installation

Clone the repository:

```bash
git clone https://github.com/leonljgl/PruebaHITSS
```

Move into the project directory:

```bash
cd proyectoAutomation-HITSS
```

Install dependencies and execute the tests:

```bash
mvn clean test
```

---

# Running in headed mode

By default, the project runs in headed mode:

```bash
mvn clean test
```

A Chrome browser window will open during execution.

---

# Running in headless mode

To execute without opening the browser window:

```bash
mvn clean test -Dheadless=true
```

This is the same configuration used in GitHub Actions.

---

# Allure Report

Generate the report:

```bash
allure generate allure-results --clean -o allure-report
```

Open the report:

```bash
allure serve allure-results
```

---

# Continuous Integration

The project includes a GitHub Actions workflow that:

* Installs dependencies
* Executes tests in headless mode
* Generates an Allure HTML report
* Uploads the report as a workflow artifact

---

# GitHub Actions

Passing workflow:

https://github.com/leonljgl/PruebaHITSS/actions/runs/27527456364

---

# Project Structure

```
src/
.github/
pom.xml
README.md
TEST_STRATEGY.md
```
