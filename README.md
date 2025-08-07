# 🛒 Shop Ecosystem – Shopease

**Shopease** is a simulated micro-shop management system built with **Java + Spring Boot**. This educational project demonstrates clean software architecture, multiple design patterns, and essential Spring ecosystem features.

---

## 🚀 Features

- ✅ Simulated **CRUD** operations for stores and products (no real database).
- ✅ Use of the **Strategy pattern** to calculate product pricing based on store type.
- ✅ Use of the **Factory pattern** to create different types of stores.
- ✅ Use of the **Singleton pattern** for session management simulation.
- ✅ Basic authentication for protected routes using **Spring Security**.
- ✅ Example of **bad practices (God Object)** to demonstrate high coupling.
- ✅ Use of **Java Reflection** to inspect class fields and annotations at runtime.
- ✅ **Unit tests** with `@SpringBootTest` and `@WebMvcTest` for services and controllers.

---

## 🧱 Architecture

The project follows a **layered architecture**:

```
📁 com.shopease
├── controller      # REST Controllers
├── service         # Business Logic Layer
├── model           # Domain Models (Store, Product)
├── strategy        # Strategy pattern for pricing logic
├── factory         # Factory pattern for store creation
├── singleton       # Singleton session manager
├── config          # Security configurations
└── ShopeaseApplication.java
```

---

## 🛡️ Authentication

- Basic Authentication enabled via Spring Security
- Default credentials:
  - `username`: `admin`
  - `password`: `228zoEyWDg`
- Only `POST` requests require authentication.

---

## 🔧 How to Run

1. Clone the repository:
   ```bash
   git clone https://github.com/oteblink182-tech/shop-ecosystem.git
   cd shop-ecosystem
   ```

2. Run the project with Maven:
   ```bash
   mvn spring-boot:run
   ```

3. Or use your IDE (e.g. VS Code, IntelliJ) to run `ShopeaseApplication.java`.

---

## 📮 Example Endpoints

| Method | Endpoint                                | Description                      |
|--------|------------------------------------------|----------------------------------|
| `POST` | `/stores`                               | Register a new store             |
| `GET`  | `/stores`                                | List all stores                  |
| `POST` | `/stores/{id}/products`                 | Add product to a store           |
| `GET`  | `/stores/{id}/products`                 | List products of a store         |
| `GET`  | `/stores/{storeId}/products/{productId}/price` | Get final price with strategy   |

---

## 🧪 Testing

- Run tests with:
  ```bash
  mvn clean test
  ```
- Includes unit and integration tests using:
  - `@WebMvcTest`
  - `@MockBean`
  - `@SpringBootTest`

---

## 📚 Educational Purpose

This project was built to **demonstrate**:
- Interface usage and low coupling
- Clean code principles
- Core design patterns in practice
- Testable and maintainable architecture
- Proper Spring Boot conventions

---

## 🧠 Author

Developed by **[oteblink182-tech](https://github.com/oteblink182-tech)**  
🛠 Java Developer | ⚙️ Software Engineer | 🧪 Clean Code Enthusiast

---

## 🪪 License

This project is released under the **MIT License**.
