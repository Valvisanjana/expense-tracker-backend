# expense-tracker-backend
A RESTful Expense Tracker Backend application built using Spring Boot. This application helps users manage their income, expenses, categories, and track financial records securely using JWT authentication.

## Features

* User Registration and Login
* JWT Authentication and Authorization
* Income Management (CRUD Operations)
* Expense Management (CRUD Operations)
* Category Management
* Global Exception Handling
* DTO-based Request and Response Handling
* REST APIs
* MySQL Database Integration

## Tech Stack

* Java 17
* Spring Boot
* Spring Security
* JWT Authentication
* Spring Data JPA
* Hibernate
* MySQL
* Maven

## Project Structure

* Controller Layer
* Service Layer
* Repository Layer
* Entity Layer
* DTO Layer
* Exception Handling Layer
* Security Layer

## API Modules

### User Module

* Register User
* Get User Details

### Authentication Module

* Login
* JWT Token Generation

### Income Module

* Add Income
* Update Income
* Delete Income
* View Income

### Expense Module

* Add Expense
* Update Expense
* Delete Expense
* View Expense

### Category Module

* Create Category
* Update Category
* Delete Category
* View Categories

## Database

Database used: MySQL
Update database configuration in: src/main/resources/application.properties

## How to Run

1. Clone the repository
2. Configure MySQL database in application.properties
3. Create database expense_tracker
4. Run ExpenseTrackerApplication.java
5. Test APIs using Postman

## frontend repository
https://github.com/Valvisanjana/expense-tracker-frontend.git

## Future Enhancements

* Dashboard Analytics
* Monthly Reports

## Author

Sanjana Valavi
Java Full Stack Developer
