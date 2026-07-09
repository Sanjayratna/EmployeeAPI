# Employee Management REST API

A Spring Boot REST API for managing employee records. This project demonstrates CRUD operations, Spring Data JPA, MySQL integration, Flyway database migrations, validation, logging, and unit testing.

---

## Technologies Used

- Java 21
- Spring Boot 3
- Spring Web
- Spring Data JPA
- MySQL
- Flyway
- Maven
- JUnit 5
- Mockito
- SLF4J / Logback
- Lombok

---

## Features

- Create Employee
- Get All Employees
- Get Employee by ID
- Update Employee
- Delete Employee
- DTO Validation
- Service Layer
- Repository Layer
- MySQL Database
- Flyway Database Migrations
- Sample Database Seed Data
- Unit Testing using JUnit & Mockito
- Logging using SLF4J

---

## REST API Endpoints

| Method | Endpoint | Description |
|---------|----------|-------------|
| GET | /employees | Get all employees |
| GET | /employees/{id} | Get employee by ID |
| POST | /employees | Create employee |
| PUT | /employees/{id} | Update employee |
| DELETE | /employees/{id} | Delete employee |

---

## Database Configuration

Update the following properties before running the application:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/employee_db
spring.datasource.username=your_username
spring.datasource.password=your_password
```

---

## Flyway Migrations

Migration files are located in:

```
src/main/resources/db/migration
```

They automatically:

- Create the Employee table
- Insert sample employee data

---

## Running the Project

Clone the repository:

```bash
git clone https://github.com/Sanjayratna/EmployeeAPI.git
```

Move into the project:

```bash
cd EmployeeAPI
```

Run the application:

```bash
./mvnw spring-boot:run
```

---

## Testing

Run all unit tests:

```bash
./mvnw test
```

---

## Project Structure

```
src
 ├── controller
 ├── dto
 ├── service
 ├── repository
 ├── resources
 │     └── db
 │          └── migration
 └── test
```

---

## Author

Sanjay Ratna