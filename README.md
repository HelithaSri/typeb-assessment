# Hello World API - TypeB Assessment

A simple REST API built using Java, Spring Boot, and Gradle.

## How to Run the Application

**Prerequisites:** Java and Gradle Wrapper.

Run the application:

```bash
./gradlew bootRun
```

For Windows:

```bash
gradlew.bat bootRun
```

Test the endpoint:

```http
GET http://localhost:8080/hello-world?name=Alice
```

## How to Run the Tests

Run the unit tests using:

```bash
./gradlew clean test
```

For Windows:

```bash
gradlew.bat clean test
```

Test reports are available at `build/reports/tests/test/index.html`.

## Assumptions

- `"Hello Alice"` is a fixed response for all valid names.
- Names starting with A–M (case-insensitive) are considered valid.
- Names starting with N–Z are considered invalid.
- Only the first character of the name is validated.
- Leading and trailing whitespace is ignored.
- Missing, empty, and whitespace-only names are invalid.
- Names starting with numbers or special characters are invalid.