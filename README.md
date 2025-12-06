# Twitter/X API Test Automation Framework

A clean and scalable API test automation framework to validate core Twitter/X API functionalities using **Java**, **Maven**, **Rest-Assured**, and **TestNG**.  
It follows a layered architecture with **Allure reporting** and proper separation of concerns for long-term maintainability.

---

## 🧱 Tech Stack

| Component      | Technology     |
|----------------|----------------|
| Language       | Java 17        |
| Test Framework | TestNG         |
| HTTP Client    | Rest-Assured   |
| Reporting      | Allure         |
| Build Tool     | Maven          |
| Logging        | SLF4J / Logback|

---

## 📂 Project Structure

```bash
src
├─ main
│  ├─ java
│  │  ├─ clients         # API client wrappers (UserClient, TweetClient, etc.)
│  │  ├─ models          # POJO request/response models
│  │  ├─ utils           # ConfigManager, constants, helpers
│  │  └─ listeners       # Custom TestNG / Allure listeners (future)
│  └─ resources
│     └─ config.properties  # Environment & auth config
└─ test
   ├─ java
   │  └─ tests           # TestNG test classes (UserTests, TweetTests, etc.)
   └─ resources          # Test data / JSON payloads (if any)
```
🧪 Example Coverage (Planned / Sample)

Depending on available endpoints and access level, typical test coverage might include:

User APIs

-Get user by ID / usernam

-Validate profile fields

-Validate HTTP status codes and error messages

Tweets APIs

Get tweet by ID

-Post Tweet(since we donot have the premium API needed to post, we are just validating the 403 status code for POST validation)

-User timeline / recent tweets





🧱 Design Principles

-Single Responsibility
Each class handles one responsibility (client, model, test, util), making it easy to extend and maintain.

-Reusability
Clients and models are shared across multiple tests, reducing duplication.

-Configurability
Environment and credentials are externalized via config.properties.

-Observability
SLF4J logging for request/response traces (configurable via Logback).

-Allure for rich HTML reports (steps, attachments, environment, etc.).
