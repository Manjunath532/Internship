# Student Management System - Java 8 

##  Project Overview
A modular, production-grade Student Management System using **Java 8**, **Spring Boot**, **JPA**, and **MySQL**, featuring)

---

### 2. MySQL DB Setup Instructions
- Create a database in MySQL:
`sql
CREATE DATABASE student_db;

- Configure database credentials in `application.properties`:
```properties
spring.datasource.url=jdbc:mysql://localhost:3306/studentdbjava8
spring.datasource.username=root
spring.datasource.password=Manju
spring.jpa.hibernate.ddl-auto=update/Create
spring.jpa.show-sql=true




- Application runs at: `http://localhost:`9999



##  Architecture & Technologies Used

###  Project Structure
```
com.example.demo
│
├── controller       --> REST endpoints
├── model            --> Entity class for Student
├── repository       --> Spring Data JPA interface (DAO Layer)
├── service          --> Service interface
├── service.impl     --> Service implementation
├── console          --> CommandLineRunner Console UI
└── StudentMgmtApplicationjava8.java
```

### 🔧 Technologies
- Java 8 (Optional, Lambdas, Streams)
- Spring Data JPA
- MySQL
- REST APIs



## 🧱 Detailed Project Components

### 1. Project Setup
- Built using Spring Boot and Java 8.
- Directory structure follows a modular layered architecture.

### 2. Student Entity
- Java class mapped to the database using JPA annotations.
- Fields: id, name, email, age, department.
- Annotations like `@Entity`, `@Id`, and `@GeneratedValue` are used.

### 3. Database Configuration
- MySQL database configuration in `application.properties`.
- Hibernate auto-generates tables with `ddl-auto=update`.

### 4. DAO Layer
- Uses `JpaRepository<Student, Integer>` in `StudentRepository.java`.
- Provides out-of-the-box CRUD operations.

### 5. Service Layer
- Business logic layer.
- Interface `StudentService` and its implementation `StudentServiceImpl`.
- Uses Java 8 Optional and map/orElse patterns for clean logic.

### 6. Utility Classes
- Handles operations such as add, list, find, update, delete.

### 7. Logging and Exception Handling
- Uses standard Spring Boot logging.
- `ResponseEntity` used for proper HTTP status codes.
- Handles 404 cases using Optional and orElseGet.

---

## 🎯 API Endpoints
- POST `/api/students` → Add new student
- GET `/api/students` → View all students
- GET `/api/students/{id}` → Get student by ID
- PUT `/api/students/{id}` → Update student
- DELETE `/api/students/{id}` → Delete student

---

## 🧪 Testing
Use Postman 

## 📂 Deliverables
- Complete codebase ( GitHub)
- README (you are reading it)
- Screenshots (Postman)



