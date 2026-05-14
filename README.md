# 🚚 DeliverIQ — Smart Route Optimization Platform

DeliverIQ is a full-stack logistics route optimization platform built using React and Spring Boot.

The system allows users to:

- Create weighted delivery graphs visually
- Add delivery locations dynamically
- Run Dijkstra and A* algorithms
- Optimize multi-delivery routes
- Visualize shortest delivery paths interactively

---

# 🚀 Features

## Frontend
- React.js
- React Flow graph editor
- Dynamic node creation
- Weighted edge connections
- Interactive shortest-path visualization

## Backend
- Spring Boot REST APIs
- Dijkstra Algorithm
- A* Algorithm
- Multi-delivery route processing
- Path reconstruction

---

# 🧠 Algorithms Used

## Dijkstra Algorithm
Used for shortest-path optimization in weighted graphs.

## A* Algorithm
Used for heuristic-based pathfinding optimization.

---

# 🏗️ Tech Stack

## Frontend
- React.js
- React Flow
- Axios
- Tailwind CSS

## Backend
- Spring Boot
- Java
- MySQL

---

# 🚀 Project Architecture

Frontend (React Flow Graph Editor)
        ↓
REST API Calls
        ↓
Spring Boot Backend
        ↓
Dijkstra / A* Algorithms
        ↓
Optimized Delivery Paths

---

# 🚚 Real-World Inspiration

DeliverIQ is inspired by logistics and delivery systems used in:

- Amazon
- Swiggy
- Zomato
- Uber Delivery

The project focuses on solving real-world multi-delivery routing problems.

---

# ▶️ How To Run

## Backend

```bash
cd backend
./mvnw spring-boot:run
