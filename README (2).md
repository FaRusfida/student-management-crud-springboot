# 🎓 Student Management REST API — Spring Boot

![Java](https://img.shields.io/badge/Java-17%2B-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)
![Spring Boot](https://img.shields.io/badge/Spring_Boot-3.x-6DB33F?style=for-the-badge&logo=spring-boot&logoColor=white)
![MySQL](https://img.shields.io/badge/MySQL-4479A1?style=for-the-badge&logo=mysql&logoColor=white)
![Spring Data JPA](https://img.shields.io/badge/Spring_Data_JPA-6DB33F?style=for-the-badge&logo=spring&logoColor=white)
![Postman](https://img.shields.io/badge/Postman-FF6C37?style=for-the-badge&logo=postman&logoColor=white)
![Maven](https://img.shields.io/badge/Maven-C71A36?style=for-the-badge&logo=apache-maven&logoColor=white)

A **beginner-friendly Student Management REST API** built using **Spring Boot**, **MySQL**, and tested with **Postman**.
Demonstrates how a **backend API communicates with a database** through full **CRUD operations** — Create, Read, Update, and Delete.

---

## 📌 Project Objective

The goal of this project is to learn:

- How **REST APIs** work in real applications
- How **Spring Boot** builds backend services
- How to **connect Spring Boot with a MySQL database**
- How to perform **CRUD operations** on database records
- How to **test APIs** using Postman
- How the **MVC architecture** is structured in a Spring Boot app

---

## 🧠 Technologies Used

| Technology       | Purpose                          |
|------------------|----------------------------------|
| Java 17+         | Core programming language        |
| Spring Boot      | Backend application framework    |
| Spring Data JPA  | Database interaction via ORM     |
| Hibernate        | JPA implementation               |
| MySQL            | Relational database              |
| Maven            | Build tool & dependency manager  |
| Lombok           | Reduces boilerplate Java code    |
| Postman          | API endpoint testing             |

---

## 📂 Project Structure

```
rest_example/
│
├── Controller/
│     └── StudentController.java      ← Handles all incoming HTTP requests
│
├── Service/
│     └── StudentService.java         ← Contains core business logic
│
├── Repository/
│     └── StudentRepository.java      ← Talks to the database via JPA
│
├── Model/
│     └── Student.java                ← Represents the student database table
│
└── RestExampleApplication.java       ← Main entry point of the application
```

### Layer Responsibilities

| Layer      | File                      | Role                                                         |
|------------|---------------------------|--------------------------------------------------------------|
| Model      | `Student.java`            | Defines the student entity and its fields (id, name, course) |
| Repository | `StudentRepository.java`  | Provides built-in DB methods via JpaRepository               |
| Service    | `StudentService.java`     | Handles logic like finding, saving, updating, deleting       |
| Controller | `StudentController.java`  | Maps HTTP requests to the right service method               |

---

## 🗄 Database Setup

**Database used:** MySQL

### Step 1 — Create the Database

Open your MySQL client (MySQL Workbench or terminal) and run the command to create a new database named `studentdb`.

### Step 2 — Configure Database in Spring Boot

Open the `application.properties` file inside `src/main/resources/` and configure the following properties:

| Property                          | Value / Purpose                                         |
|-----------------------------------|---------------------------------------------------------|
| `spring.datasource.url`           | Points to your local MySQL database (`studentdb`)       |
| `spring.datasource.username`      | Your MySQL username (usually `root`)                    |
| `spring.datasource.password`      | Your MySQL password                                     |
| `spring.jpa.hibernate.ddl-auto`   | Set to `update` — auto-creates/updates tables           |
| `spring.jpa.show-sql`             | Set to `true` — prints SQL queries in the console       |
| `server.port`                     | Set to `8080` (default Spring Boot port)                |

> ⚠️ Replace the username and password with your actual MySQL credentials before running.

---

## 🧩 Model Layer — `Student.java`

The **Student** class is the core data model (entity) of this application. It maps directly to a MySQL table named `tbl_students`.

**Fields:**

| Field    | Type   | Description              |
|----------|--------|--------------------------|
| `id`     | int    | Primary key (unique ID)  |
| `name`   | String | Student's full name      |
| `course` | String | Enrolled course name     |

**Key Annotations Used:**

| Annotation            | Purpose                                              |
|-----------------------|------------------------------------------------------|
| `@Entity`             | Marks this class as a JPA-managed database table     |
| `@Table`              | Specifies the actual table name (`tbl_students`)     |
| `@Id`                 | Marks `id` as the primary key                        |
| `@Data`               | Lombok — auto-generates getters, setters, toString   |
| `@NoArgsConstructor`  | Lombok — generates a no-argument constructor         |
| `@AllArgsConstructor` | Lombok — generates a full-argument constructor       |
| `@Builder`            | Lombok — enables builder-pattern object creation     |

---

## 📚 Repository Layer — `StudentRepository.java`

The **StudentRepository** interface extends `JpaRepository`, which gives you all essential database operations **without writing any SQL manually**.

**Built-in methods available automatically:**

| Method              | What it does                          |
|---------------------|---------------------------------------|
| `save(student)`     | Inserts or updates a student record   |
| `findAll()`         | Retrieves all students from the table |
| `findById(id)`      | Finds a student by their ID           |
| `deleteById(id)`    | Deletes a student by their ID         |

> No SQL queries needed — Spring Data JPA handles everything behind the scenes.

---

## ⚙️ Service Layer — `StudentService.java`

The **StudentService** class contains the **business logic** of the application. The controller calls the service, and the service calls the repository.

**Methods defined:**

| Method                       | Description                                                    |
|------------------------------|----------------------------------------------------------------|
| `getAllStudents()`            | Fetches and returns the full list of students                  |
| `saveStudent(student)`       | Saves a new student to the database                           |
| `getStudentById(id)`         | Fetches a student by ID — returns `null` if not found         |
| `updateStudent(id, student)` | Finds existing student, updates name & course, re-saves it    |
| `deleteStudentById(id)`      | Removes the student with the given ID from the database        |

**Key Annotations:**

| Annotation    | Purpose                                                   |
|---------------|-----------------------------------------------------------|
| `@Service`    | Marks this class as a Spring-managed service bean         |
| `@Autowired`  | Injects the `StudentRepository` dependency automatically  |

---

## 🌐 Controller Layer — `StudentController.java`

The **StudentController** is the entry point for all HTTP requests. It maps each HTTP method and URL to the correct service method and returns the response as JSON.

**Key Annotations:**

| Annotation         | Purpose                                                      |
|--------------------|--------------------------------------------------------------|
| `@RestController`  | Marks this class as a REST controller (returns JSON)         |
| `@RequestMapping`  | Sets base URL as `/api/students` for all endpoints           |
| `@Autowired`       | Injects the `StudentService` dependency automatically        |
| `@GetMapping`      | Maps HTTP GET requests to a method                           |
| `@PostMapping`     | Maps HTTP POST requests to a method                          |
| `@PutMapping`      | Maps HTTP PUT requests to a method                           |
| `@DeleteMapping`   | Maps HTTP DELETE requests to a method                        |
| `@PathVariable`    | Extracts the `{id}` value directly from the URL              |
| `@RequestBody`     | Reads and deserializes the JSON body from the request        |

---

## 🔗 API Endpoints Reference

**Base URL:**
```
http://localhost:8080/api/students
```

| Method   | Endpoint                        | Description            | Request Body Needed? |
|----------|---------------------------------|------------------------|----------------------|
| `GET`    | `/api/students`                 | Get all students       | ❌ No                |
| `GET`    | `/api/students/{id}`            | Get student by ID      | ❌ No                |
| `POST`   | `/api/students`                 | Create new student     | ✅ Yes               |
| `PUT`    | `/api/students/update/{id}`     | Update student by ID   | ✅ Yes               |
| `DELETE` | `/api/students/{id}`            | Delete student by ID   | ❌ No                |

---

## 🧪 Testing with Postman

### 1️⃣ Create Student — `POST /api/students`

- Set method to **POST**
- URL: `http://localhost:8080/api/students`
- Go to **Body → raw → JSON**
- Send a JSON object with `id`, `name`, and `course`

**Example request body:**
```json
{
  "id": 1,
  "name": "Rahul",
  "course": "CSE"
}
```

---

### 2️⃣ Get All Students — `GET /api/students`

- Set method to **GET**
- URL: `http://localhost:8080/api/students`
- No body needed — just hit **Send**

**Example response:**
```json
[
  { "id": 1, "name": "Rahul",  "course": "CSE" },
  { "id": 2, "name": "Sarayu", "course": "DS"  }
]
```

---

### 3️⃣ Get Student by ID — `GET /api/students/{id}`

- Set method to **GET**
- URL: `http://localhost:8080/api/students/1`
- Replace `1` with the actual student ID you want to fetch

---

### 4️⃣ Update Student — `PUT /api/students/update/{id}`

- Set method to **PUT**
- URL: `http://localhost:8080/api/students/update/1`
- Go to **Body → raw → JSON**
- Send updated `name` and `course` fields

**Example request body:**
```json
{
  "name": "Rahul Updated",
  "course": "AI"
}
```

---

### 5️⃣ Delete Student — `DELETE /api/students/{id}`

- Set method to **DELETE**
- URL: `http://localhost:8080/api/students/1`
- No body needed — just hit **Send**

---

## 🔄 CRUD Flow Summary

| CRUD Operation | HTTP Method | What Happens                                      |
|----------------|-------------|---------------------------------------------------|
| **Create**     | POST        | New student record inserted into the database     |
| **Read**       | GET         | Student data fetched and returned as JSON         |
| **Update**     | PUT         | Existing student's fields modified and re-saved   |
| **Delete**     | DELETE      | Student record permanently removed from DB        |

---

## ▶️ How to Run the Project

### Prerequisites

Ensure the following are installed before running:

| Tool           | Purpose                    | Verify With          |
|----------------|----------------------------|----------------------|
| Java 17+       | Runs the Spring Boot app   | `java -version`      |
| Maven          | Builds and resolves deps   | `mvn -version`       |
| MySQL          | Stores student data        | `mysql -version`     |
| IntelliJ IDEA  | IDE to open & run project  | —                    |
| Postman        | Tests API endpoints        | —                    |

---

### Step 1 — Clone the Repository

```bash
git clone https://github.com/yourusername/student-crud-api.git
```

Or download as ZIP: click **Code → Download ZIP → Extract the folder**.

---

### Step 2 — Open in IntelliJ IDEA

1. Open **IntelliJ IDEA**
2. Click **File → Open** → select the project folder → click **OK**
3. Wait for **Maven** to automatically download all dependencies

> IntelliJ auto-detects it as a Spring Boot project. If prompted, trust the project.

---

### Step 3 — Set Up MySQL

1. Open **MySQL Workbench** or your terminal
2. Create the `studentdb` database
3. Update `application.properties` with your MySQL username and password

---

### Step 4 — Run the Application

1. Open `RestExampleApplication.java`
2. Click the **▶ Run** button, or right-click → **Run RestExampleApplication**

**Success message you'll see in the console:**
```
Tomcat started on port(s): 8080
Started RestExampleApplication in X.XXX seconds
```

Your API is now live at `http://localhost:8080`.

---

### Step 5 — Test Using Postman

Open Postman and test each API endpoint as described in the Testing section above.

---

## 📊 Database Table Preview

**Table name:** `tbl_students` *(auto-created by Hibernate on first run)*

| id | name   | course |
|----|--------|--------|
| 1  | Rahul  | CSE    |
| 2  | Sarayu | DS     |
| 3  | Arjun  | AI     |

> Hibernate creates this table automatically because `ddl-auto=update` is set in `application.properties`.

---

## 📸 Screenshots

### Postman — HTTP Methods Overview
![Postman Methods](images/postman-methods.png)

### GET — All Students
![Get All Students](images/get-students.png)

### POST — Create Student
![Create Student](images/create-student.png)

### PUT — Update Student
![Update Student](images/update-student.png)

### DELETE — Delete Student
![Delete Student](images/delete-student.png)

> 📁 Place your Postman screenshots inside an `images/` folder at the project root for them to display here.

---

## ⚠️ Common Errors & Fixes

| Error                             | Likely Cause                       | Fix                                                          |
|-----------------------------------|------------------------------------|--------------------------------------------------------------|
| Port 8080 already in use          | Another app occupying the port     | Set `server.port=8081` in `application.properties`           |
| Access denied for MySQL user      | Wrong username or password         | Double-check credentials in `application.properties`         |
| Maven dependencies not loading    | Incomplete Maven sync              | Right-click project → **Maven → Reload Project**             |
| 404 Not Found on endpoint         | Wrong URL or HTTP method           | Verify the endpoint URL and selected HTTP method in Postman  |
| Application fails to start        | Wrong Java version                 | Ensure Java 17+ is installed — run `java -version`           |
| Table not auto-created in MySQL   | `ddl-auto` not set correctly       | Set `spring.jpa.hibernate.ddl-auto=update` in properties     |

---

## 🎯 Learning Outcomes

By completing this project, you will understand:

- ✅ What a **REST API** is and how it processes HTTP requests
- ✅ How **Spring Boot** sets up a fully working backend server
- ✅ How **CRUD operations** map to HTTP methods (GET, POST, PUT, DELETE)
- ✅ How **Spring Data JPA** connects Java objects to database tables
- ✅ How the **MVC architecture** separates Controller, Service, and Repository layers
- ✅ How **Lombok** eliminates repetitive boilerplate Java code
- ✅ How **Hibernate** auto-manages database table creation
- ✅ How to **test and debug APIs** using Postman

---

## 🔮 Future Improvements

- [ ] Add input validation using `@Valid` and `@NotBlank`
- [ ] Add global exception handling with `@ControllerAdvice` and custom error messages
- [ ] Add **Swagger / OpenAPI** documentation for auto-generated API docs
- [ ] Add **pagination and sorting** for the Get All Students endpoint
- [ ] Add **JWT-based authentication and authorization**
- [ ] Write **JUnit unit tests** for the service layer
- [ ] Dockerize the application for easy deployment

---

## 👨‍💻 Author

**Your Name**
B.E. CSE (AI & ML) — Chandigarh University

[![GitHub](https://img.shields.io/badge/GitHub-yourusername-181717?style=flat&logo=github)](https://github.com/yourusername)

---

> ⭐ If this project helped you learn Spring Boot REST APIs, give it a star on GitHub!
