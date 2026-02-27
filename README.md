# 🗂️ KanBanProject – Spring Boot Backend (Work in Progress)

This is a Kanban-style backend built with Spring Boot.  
It implements a simple domain structure of:

Boards → Lists → Tasks

The project follows a clean layered architecture:

- controllers
- services
- repositories
- entities

Persistence is currently disabled intentionally (no database yet).  
The goal of this phase is to solidify backend architecture and API design before integrating a real persistence layer.

---

## 📌 Current Features (Implemented)

### Entities

- Board
- ListEntity
- Task

The domain model represents a classic Kanban structure:

- A Board contains multiple Lists
- A List contains multiple Tasks

---

### Controllers

BoardController

- GET /boards/{id}
- POST /boards
- POST /boards/{boardId}/lists

ListController

- GET /lists/{id}
- POST /lists/{listId}/tasks

TaskController

- GET /tasks/{id}

All endpoints are functional and mapped correctly.

---

### Services

- BoardService
- ListService
- TaskService

Each service:

- Contains business logic
- Delegates to repository layer
- Prepares the structure for future persistence integration

---

### Repositories

- BoardRepository
- ListEntityRepository
- TaskRepository

Repositories are currently placeholder implementations.

They:

- Return null or simple stub data
- Exist to preserve architectural separation
- Are structured to be replaced by real persistence (JPA or in-memory)

---

## 🧱 Architecture

Controller → Service → Repository → Entity

- Controllers handle HTTP requests & responses
- Services contain business logic
- Repositories abstract data access
- Entities represent the domain model

This structure was intentionally implemented before adding a database to ensure clean separation of concerns.

---

## 📋 Current Status

- Application boots successfully
- Endpoints are reachable and mapped correctly
- Layered architecture implemented
- JPA auto-configuration intentionally disabled
- No real persistence yet
- Ready for persistence integration (next phase)

---

## ▶️ How to Run

mvn spring-boot:run

Server runs by default on:

http://localhost:8080

---

## 📶 Example Requests

Create a board

POST /boards  
Content-Type: application/json

{
"name": "My Project Board"
}

---

Create a list under a board

POST /boards/1/lists  
Content-Type: application/json

{
"name": "To Do"
}

---

Create a task under a list

POST /lists/5/tasks  
Content-Type: application/json

{
"name": "Write report",
"description": "First draft for Monday"
}

---

## 🎯 Next Development Phase

Persistence

- Implement in-memory storage (temporary step)  
  OR
- Integrate PostgreSQL using Spring Data JPA

API Improvements

- Add update endpoints (PUT / PATCH)
- Add delete endpoints (DELETE)
- Implement proper HTTP status handling
- Add global exception handling (@ControllerAdvice)
- Add validation (@Valid, @NotBlank, etc.)

Quality Improvements

- Add DTO layer (separate entities from API models)
- Add basic unit & integration tests
- Add Swagger/OpenAPI documentation
- Add Docker configuration (application + database)

---

## 🚀 Project Goal

This project is being built incrementally to:

- Practice clean backend architecture
- Understand Spring Boot layering
- Prepare for real-world backend interviews
- Gradually evolve into a production-ready REST API
