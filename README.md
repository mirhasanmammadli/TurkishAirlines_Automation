# Turkish Airlines – Test Automation Framework

A scalable end-to-end test automation framework built for the Turkish Airlines website using **Java**, **Selenium WebDriver**, **Cucumber BDD**, **TestNG**, and **Jenkins CI/CD**.

---

## Tech Stack

| Tool | Purpose |
|------|---------|
| Java 11 | Core programming language |
| Selenium WebDriver 4 | Browser automation |
| Cucumber BDD | Behavior-driven test scenarios |
| TestNG | Test execution and assertions |
| Maven | Dependency management and build |
| Jenkins | CI/CD pipeline automation |
| WebDriverManager | Automatic browser driver management |
| ExtentReports | HTML test reporting |

---

## Project Structure

```
TurkishAirlines_Automation/
├── src/
│   └── test/
│       ├── java/
│       │   ├── pages/               # Page Object Model classes
│       │   │   ├── HomePage.java
│       │   │   └── SearchResultsPage.java
│       │   ├── stepDefinitions/     # Cucumber step implementations
│       │   │   └── FlightSearchSteps.java
│       │   ├── runners/             # TestNG + Cucumber runner
│       │   │   └── TestRunner.java
│       │   └── utilities/           # Driver and config helpers
│       │       ├── BaseDriver.java
│       │       └── ConfigReader.java
│       └── resources/
│           ├── features/            # Cucumber .feature files
│           │   └── FlightSearch.feature
│           └── config.properties    # Environment config
├── Jenkinsfile                      # Jenkins CI/CD pipeline
├── testng.xml                       # TestNG suite config
└── pom.xml                          # Maven dependencies
```

---

## How to Run

### Prerequisites
- Java 11+
- Maven 3.8+
- Chrome browser installed

### Run all smoke tests
```bash
mvn test -Dcucumber.filter.tags="@smoke"
```

### Run all regression tests
```bash
mvn test -Dcucumber.filter.tags="@regression"
```

### Run full suite
```bash
mvn test
```

---

## CI/CD – Jenkins Pipeline

The `Jenkinsfile` defines a pipeline with the following stages:
1. **Checkout** – Pull latest code from GitHub
2. **Build** – Compile the project
3. **Smoke Tests** – Run `@smoke` tagged scenarios
4. **Regression Tests** – Run `@regression` tagged scenarios
5. **Publish Reports** – Generate and archive HTML reports

---

## Design Patterns

- **Page Object Model (POM)** – Each page is a separate class, keeping tests clean and maintainable
- **BDD with Cucumber** – Test scenarios written in plain English (Gherkin) for business readability
- **Data-Driven Testing** – Scenario Outline + Examples table for multiple data sets
- **Explicit Waits** – WebDriverWait used throughout for reliable element interaction

---

## Author

**Mirhasan Mammadli**  
SDET | Automation Engineer  
Boston, MA
