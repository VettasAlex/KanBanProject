# 🗂️KanBanProject – Spring Boot Backend (Work in Progress)

This is a basic Kanban-style backend built with Spring Boot.
It implements a simple structure of Boards → Lists → Tasks with a clean separation between:

- controllers
- services
- repositories
- entities

Persistence is not implemented yet (no database). Repositories currently use placeholder logic until the next development phase.

------------------------------------------------------------

## 📌Current Features (Implemented)

### Entities
- Board
- ListEntity
- Task

### Controllers
- BoardController
  - `GET /boards/{id}`
  - `POST /boards`
  - `POST /boards/{boardId}/lists`

- ListController
  - `GET /lists/{id}`
  - `POST /lists/{listId}/tasks`

- TaskController
  - `GET /tasks/{id}`

### Services
- `BoardService`
- `ListService`
- `TaskService`

Each service contains placeholder logic and delegates to repositories.

### Repositories
- BoardRepository
- ListEntityRepository
- TaskRepository

All repositories currently return null or echo input (no real persistence).

------------------------------------------------------------

## 🧱Architecture

Controller → Service → Repository → Entity

- Controllers handle HTTP requests
- Services contain logic
- Repositories will handle persistence later
- Entities represent Boards, Lists, and Tasks

------------------------------------------------------------

## 📋Current Status

- Application boots successfully
- All endpoints respond (returning placeholder or null data)
- JPA/Postgres removed for now
- Ready for next phase: in-memory storage or real DB

------------------------------------------------------------

## ▶️How to Run

`mvn spring-boot:run`

Server runs (by default) on:
http://localhost:8080

------------------------------------------------------------

## 📶Example Requests

### Create a board
`POST /boards`
Content-Type: application/json

{
  "name": "My Project Board"
}

### Create a list under a board
`POST /boards/1/lists`
Content-Type: application/json

{
  "name": "To Do"
}

### Create a task under a list
`POST /lists/5/tasks`
Content-Type: application/json

{
  "name": "Write report",
  "description": "First draft for Monday"
}

------------------------------------------------------------

## 🎯Next Steps

- Implement in-memory storage
- Add update/delete endpoints (put/patch & remove)
- Add database persistence (PostgreSQL or SQLite)
- Add validation and error handling
