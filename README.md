# 📚 YBS316 Object-Oriented Programming (OOP) Project

## 📦 Basic Stock Tracking System (BSTS)

This project is a simple, console-based Java application developed for the YBS316 Object-Oriented Programming course. 
Its main goal is to simulate basic inventory management while serving as a practical demonstration of core OOP principles and required Java features. 
The application allows a Stock Manager to add items, update stock, and filter products, using in-memory data storage for simplicity.

---

### 💻 Implementation of Mandatory Technical Requirements

The project design strictly adheres to all assignment requirements by showcasing active usage of the following concepts:

1.  **Inheritance:** Implemented through the `Product` (abstract base class) and its subclasses (`Book` and `ElectronicItem`).
2.  **Interface:** The `IStockable` interface defines a contract for all stockable items, forcing implementation of methods like `updateStock()`.
3.  **Polymorphism:** Objects of different product types are managed uniformly using the `IStockable` reference type (e.g., calling `displayDetails()` on any item).
4.  **Generic Class/Method:** The central `StockManager<T>` class is generic, constrained to manage only types that implement `IStockable`.
5.  **Generic Collections:** **Two distinct collection types** are utilized:
    * **`List<T>` (ArrayList):** Used for primary inventory storage.
    * **`Set<String>` (HashSet):** Used to efficiently enforce the **uniqueness of product names** during item insertion.
6.  **Lambda Functions:** Used with the `Predicate<IStockable>` functional interface in the search functionality to allow for dynamic, concise filtering of items (e.g., by price range).
