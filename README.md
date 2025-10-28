# 📚 Bookstore Management System - REST API (Java Spring Boot)

## 🧾 Project Overview
The **Bookstore Management System** is a backend application built using **Java Spring Boot**, designed to efficiently manage books, users, and orders through a set of **RESTful APIs**.  
It provides functionalities for both **customers** and **admins** — enabling users to browse and purchase books while allowing admins to manage inventory and process orders.

---

## 🎯 Project Objective
To develop a **secure, scalable REST API** using Spring Boot for:
- Managing books (CRUD operations)
- Handling user registration and authentication (with JWT)
- Managing and tracking book orders
- Providing admin-level inventory and order control

---

## 🧩 Features

### 🧠 1. Book Management
#### API Endpoints
| Method | Endpoint | Description | Access |
|--------|-----------|--------------|--------|
| GET | `/api/books` | Retrieve all books | Public |
| GET | `/api/books/{id}` | Retrieve details of a specific book | Public |
| POST | `/api/books` | Add a new book | Admin |
| PUT | `/api/books/{id}` | Update book details | Admin |
| DELETE | `/api/books/{id}` | Delete a book | Admin |

#### Book Details
- Title  
- Author(s)  
- Genre  
- ISBN  
- Price  
- Description  
- Stock Quantity  
- Image URL  

---

### 🔐 2. User Authentication
#### API Endpoints
| Method | Endpoint | Description |
|--------|-----------|--------------|
| POST | `/api/register` | Register a new user (Customer/Admin) |
| POST | `/api/login` | Authenticate a user and return JWT token |

#### User Fields
- Name  
- Email  
- Password *(hashed & stored securely)*  
- Role *(Customer / Admin)*  

#### Security
- JWT-based authentication  
- Role-Based Access Control (RBAC) with **Spring Security**

---

### 🛒 3. Order Management
#### API Endpoints
| Method | Endpoint | Description | Access |
|--------|-----------|-------------|--------|
| GET | `/api/orders` | Retrieve all orders | Admin |
| GET | `/api/orders/{id}` | Retrieve specific order details | Admin/Customer |
| POST | `/api/orders` | Place a new order | Customer |
| PUT | `/api/orders/{id}/status` | Update order status | Admin |

#### Order Details
- Customer info (Name, Email)  
- List of ordered books (with quantity & total price)  
- Order Status *(Pending, Shipped, Delivered)*  
- Payment Status *(mock or integrated)*  

---

## 🗄️ 4. Database Integration
- **Database:** MySQL or MongoDB  
- **Entities:** Book, User, Order  
- Relationships:
  - One-to-Many → User ↔ Orders  
  - Many-to-Many → Orders ↔ Books  
- Supports:
  - Search by title/author  
  - Filter by genre  
  - Order history tracking  

---

## ⚙️ 5. Performance & Pagination
- Implemented **pagination** for book and order listings  
- Added **search** functionality (by title or author)  
- Optimized queries for large datasets  

---

## ❗ 6. Error Handling
- Clear, descriptive error messages  
- Standard HTTP codes:
  - ✅ 200 – OK  
  - 🆕 201 – Created  
  - ⚠️ 400 – Bad Request  
  - 🚫 401 – Unauthorized  
  - ❌ 404 – Not Found  

---

## 📘 7. API Documentation
- **Swagger UI** integrated for live API testing  
- Auto-generated documentation for all endpoints  
- Includes:
  - Request/Response samples  
  - Error scenarios  

---

## 🗓️ Project Timeline
| Week | Task |
|------|------|
| Week 1 | Project setup, DB config, and User Authentication |
| Week 2 | Book Management APIs + Pagination/Search |
| Week 3 | Order Management APIs + Inventory linkage |
| Week 4 | Error handling, testing, and documentation |

---

## 📦 Deliverables
✅ Fully functional REST API (Spring Boot)  
✅ Integrated Database (MySQL/MongoDB)  
✅ JWT-secured endpoints  
✅ Swagger Documentation  
✅ Testing with JUnit/Postman  

---

## 🧪 Evaluation Criteria
| Category | Description |
|-----------|--------------|
| Functionality | All API features (Books, Users, Orders) implemented |
| Security | Proper JWT and role-based access |
| Code Quality | Clean, modular, and maintainable code |
| Performance | Efficient handling of pagination and queries |
| Creativity | Optional advanced features (reviews, payments) |

---

## 🛠️ Technologies Used
| Category | Tool |
|-----------|------|
| Language | Java |
| Framework | Spring Boot |
| Database | MySQL / MongoDB |
| Authentication | JWT |
| Security | Spring Security |
| Documentation | Swagger |
| Testing | JUnit, Postman |

--- 

---

## 🚀 How to Run the Project

### 1️⃣ Clone the Repository
```bash
git clone https://github.com/your-username/bookstore-management-api.git
cd bookstore-management-api
```

2️⃣ Configure Database
```
Update application.properties:

spring.datasource.url=jdbc:mysql://localhost:3306/bookstore_db
spring.datasource.username=root
spring.datasource.password=yourpassword
spring.jpa.hibernate.ddl-auto=update
jwt.secret=yourSecretKey
```

3️⃣ Run the Application
```
mvn spring-boot:run
```
4️⃣ Access Swagger UI
```
http://localhost:8080/swagger-ui/index.html
```
📂 Folder Structure
```
bookstore-management-api/
│
├── src/main/java/com/bookstore/
│   ├── controller/
│   ├── model/
│   ├── repository/
│   ├── service/
│   └── security/
│
├── src/main/resources/
│   ├── application.properties
│
├── pom.xml
└── README.md
```
🧑‍💻 Author

Ganpat Kumar  
Java Full-Stack Developer | Backend Specialist  
📧 Email: ganpatkumardev@gmail.com  

🔗 [LinkedIn](www.linkedin.com/in/ganpatkumar1)
[GitHub](https://github.com/GanpatKumargct)

 

🏁 Conclusion

The Bookstore Management System provides a robust backend solution for managing books, users, and orders securely using Spring Boot.
It emphasizes scalability, security, and maintainability — a perfect foundation for real-world e-commerce applications.
