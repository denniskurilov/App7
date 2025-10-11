# App7
## Spring Boot REST API (Entity + JPARepository + Service + RestController)

### Overview
**App7** is a Spring Boot application that provides a REST API for managing data in the `EMPLOYEE` table stored in an **Oracle Autonomous Database**.  
It follows a multi-layered architecture that uses **Spring Data JPA** with **JPARepository** for data access and persistence.

---

### Technology Stack
- Java 17
- Spring Boot
- Maven
- Oracle Autonomous Database (OCI)
- Spring Web
- Spring Data JPA

---

### Architecture
The project follows a clear layered structure:  
Controller -> Service -> Repository -> Database

---

### Main Components
- **Entity** — represents the `Employee` data model
- **Repository** — extends `JpaRepository` and provides CRUD operations
- **Service** — contains business logic
- **RestController** — exposes REST endpoints for CRUD operations

---

### REST API Endpoints

| Method | Endpoint | Description                  |
|--------|-----------|------------------------------|
| `GET` | `/employees` | Retrieve all employees       |
| `POST` | `/employees` | Create a new employee        |
| `GET` | `/employees/{id}` | Retrieve an employee by ID   |
| `PUT` | `/employees/{id}` | Update an existing employee  |
| `PATCH` | `/employees/{id}`     | Partially update an employee |
| `DELETE` | `/employees/{id}` | Delete an employee           |


