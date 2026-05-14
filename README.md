# 🚚 DeliverIQ — Graph-Based Route Optimization


A full-stack optimization platform demonstrating graph algorithms and system architecture. Finds shortest delivery routes using Dijkstra's algorithm and A* heuristic search with an interactive web interface.

---

# 📖 Overview

### The Problem

Logistics companies handle thousands of deliveries daily. Inefficient routing wastes:

* fuel
* time
* operational cost

Finding optimal paths through weighted graphs becomes increasingly complex as delivery networks grow.

### The Solution

DeliverIQ combines:

* graph algorithms
* backend optimization services
* interactive graph visualization
* full-stack architecture

to simulate how real-world delivery optimization systems work.

### Real-World Inspiration

Companies like:

* Amazon
* Swiggy
* Zomato
* Uber

continuously solve routing and shortest-path problems internally. DeliverIQ demonstrates the engineering concepts behind these systems.

---

# ✨ Features

## Core Capabilities

* **Dijkstra's Algorithm** — O((V+E) log V) shortest-path computation
* **A* Heuristic Search** — Guided pathfinding using Euclidean distance
* **Interactive Graph Editor** — Add nodes, connect edges, assign weights visually
* **Route Visualization** — Highlight shortest paths dynamically
* **Real-Time Optimization** — Execute algorithms instantly on user-created graphs
* **Multi-Algorithm Support** — Compare Dijkstra and A* approaches

---

## Architecture Highlights

* **4-Layer Backend Design**

  * Controllers
  * Services
  * Repositories
  * Entities

* **REST API Architecture**

  * Stateless JSON communication
  * Frontend ↔ Backend integration

* **Hibernate/JPA ORM**

  * Database abstraction
  * Entity-based persistence

* **Dependency Injection**

  * Spring-managed service composition

* **CORS Configuration**

  * Cross-origin frontend communication

---

# 📸 Demo

> Add screenshots or GIFs here to visually showcase the system.

## Graph Editor

```md id="5v7vvo"
![Graph Editor](./screenshots/graph-editor.png)
```

## Route Optimization

```md id="fj18ic"
![Route Optimization](./screenshots/route-optimization.png)
```

## Multi-Delivery Routing

```md id="5cb3f9"
![Multi Delivery](./screenshots/multi-delivery.png)
```

---

# 🏗️ System Architecture

```text id="m6x8bz"
┌─────────────────────────────────┐
│   Frontend (React)              │
│ ├─ Graph Editor (React Flow)   │
│ ├─ Algorithm Controls          │
│ └─ Route Display               │
└──────────┬──────────────────────┘
           │ HTTP/JSON (Axios)
           ▼
┌─────────────────────────────────┐
│   Backend (Spring Boot)         │
│ ├─ REST Controllers            │
│ ├─ Algorithm Services          │
│ ├─ Data Repositories           │
│ └─ Entity Models               │
└──────────┬──────────────────────┘
           │ JPA/Hibernate
           ▼
┌─────────────────────────────────┐
│   Database (MySQL)              │
│ ├─ graphs table                │
│ ├─ nodes table                 │
│ └─ edges table                 │
└─────────────────────────────────┘
```

### Design Pattern

DeliverIQ follows layered MVC architecture with clear separation between:

* presentation layer
* business logic
* data access

This improves:

* maintainability
* scalability
* readability
* testing

---

# 🧠 Algorithms

## Dijkstra's Shortest-Path Algorithm

A greedy shortest-path algorithm that explores the nearest unvisited node first.

### Key Properties

* **Time Complexity:** O((V+E) log V)
* **Space Complexity:** O(V)
* **Guarantee:** Always finds optimal path for non-negative weights

### Use Cases

* network routing
* shortest delivery paths
* weighted graph traversal

---

## A* Heuristic Search

A* improves upon Dijkstra by using heuristic guidance toward the destination.

### Key Properties

* Uses Euclidean distance heuristic
* Reduces unnecessary exploration
* Typically faster on spatial graphs
* Maintains optimality with admissible heuristics

### Use Cases

* GPS navigation
* delivery optimization
* spatial routing systems

---

# 🛠️ Tech Stack

| Layer       | Technology                                | Purpose                                    |
| ----------- | ----------------------------------------- | ------------------------------------------ |
| Frontend    | React 18, React Flow, Axios, Tailwind CSS | UI, graph visualization, API communication |
| Backend     | Spring Boot 3.5.4, Java 17                | REST APIs, business logic                  |
| Database    | MySQL 8.0, Hibernate/JPA                  | Persistence layer                          |
| Build Tools | Maven, npm                                | Dependency management                      |

---

# 🚀 Getting Started

## Prerequisites

### Backend

* Java 17+
* Maven 3.8+
* MySQL 8.0+

### Frontend

* Node.js 16+
* npm 8+

---

# Backend Setup

```bash id="pqpy0l"
# Clone repository
git clone https://github.com/pavanpyatla/DeliverIQ-Route-Optimizer.git

# Navigate to backend
cd DeliverIQ-Route-Optimizer/backend

# Create MySQL database
mysql -u root -p -e "CREATE DATABASE deliveriq_db;"

# Configure database connection
# Edit: src/main/resources/application.properties

# Run backend
./mvnw spring-boot:run
```

Backend runs on:

```text id="4f6e4t"
http://localhost:8081
```

---

# Frontend Setup

```bash id="57nr4l"
cd ../deliveriq-frontend

npm install

npm start
```

Frontend runs on:

```text id="mnj1c3"
http://localhost:3000
```

---

# 📡 API Reference

## POST `/api/dijkstra`

Computes shortest path using Dijkstra's algorithm.

### Example Request

```json id="0ozf0y"
{
  "startNode": 1,
  "endNode": 7,
  "edges": [
    {
      "fromNode": 1,
      "toNode": 2,
      "weight": 4.5
    },
    {
      "fromNode": 1,
      "toNode": 3,
      "weight": 2.0
    }
  ]
}
```

### Example Response

```json id="0eq8ta"
{
  "path": [1, 3, 7],
  "totalCost": 7.0,
  "edgesVisited": 3
}
```

---

## POST `/api/astar`

Computes shortest path using A* heuristic search.

### Additional Input

A* also accepts:

* node coordinates
* latitude/longitude values

for heuristic estimation.

---

# 📂 Project Structure

```text id="pmkn9e"
DeliverIQ-Route-Optimizer/
│
├── backend/
│   ├── src/main/java/com/deliveriq/
│   │   ├── BackendApplication.java
│   │   ├── controller/
│   │   │   └── AlgorithmController.java
│   │   ├── service/
│   │   │   ├── DijkstraService.java
│   │   │   └── AStarService.java
│   │   ├── repository/
│   │   │   ├── GraphRepository.java
│   │   │   ├── NodeRepository.java
│   │   │   └── EdgeRepository.java
│   │   └── model/
│   │       ├── Node.java
│   │       ├── Edge.java
│   │       └── Graph.java
│   │
│   ├── src/main/resources/
│   │   └── application.properties
│   └── pom.xml
│
├── deliveriq-frontend/
│   ├── src/
│   │   ├── App.js
│   │   ├── GraphEditor.js
│   │   ├── index.js
│   │   ├── App.css
│   │   └── index.css
│   │
│   ├── public/
│   ├── package.json
│   └── package-lock.json
│
├── .gitignore
└── README.md
```

---

# 🔄 How It Works

1. User creates graph visually
2. Frontend sends graph data via Axios
3. Spring Boot API receives request
4. Dijkstra or A* executes on backend
5. Shortest path returned as JSON
6. React Flow visualizes optimized route

---

# 📊 Algorithm Complexity

| Metric           | Dijkstra       | A*             |
| ---------------- | -------------- | -------------- |
| Time Complexity  | O((V+E) log V) | O((V+E) log V) |
| Space Complexity | O(V)           | O(V)           |
| Optimality       | ✅              | ✅              |
| Typical Speedup  | Baseline       | 1.3–1.5x       |

Both algorithms support real-time routing scenarios efficiently.

---

# 🎓 Learning Value

This project demonstrates:

* graph algorithms
* shortest-path optimization
* REST API architecture
* Spring Boot backend engineering
* React frontend integration
* database persistence
* system design fundamentals

---

# 🔮 Future Improvements

## Advanced Routing

* Time-window constraints
* Multi-vehicle coordination
* Vehicle capacity optimization
* Real-time traffic integration

## Algorithm Extensions

* Traveling Salesman Problem (TSP)
* Genetic Algorithms
* Ant Colony Optimization
* Machine Learning route prediction

## Production Features

* Authentication
* Deployment
* Route analytics
* Mobile integration

---

# 🤝 Contributing

Contributions are welcome:

* algorithm improvements
* UI enhancements
* performance optimization
* testing
* documentation

---

# 📚 Resources

* Dijkstra's Algorithm
* A* Search Algorithm
* Spring Boot Documentation
* React Documentation
* React Flow Documentation

---

# 📄 License

MIT License — see `LICENSE`.

---

# 👤 Author

**Pavan Pyatla**

* GitHub: https://github.com/pavanpyatla

---

<div align="center">

⭐ If you found this project interesting, consider starring the repository!

Built with focus on algorithms, architecture, and engineering fundamentals.

</div>
