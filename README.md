Food Delivery Service API
This project is a RESTful API for a Food Delivery Service built with Spring Boot. It handles everything from user registration and security to managing restaurants, menus, and orders.

Project Overview
The main goal of this system is to provide a backend for a delivery service where:

Users can browse restaurants and dishes.

Customers can place orders and leave reviews.

Administrators can manage the database and user roles.

Core Features

Authentication & Security: Implementation of Spring Security with three roles: ADMIN, USER, and MANAGER.



User Management: Registration, profile editing, and role-based access control.


Restaurant Management: CRUD operations for restaurants and their menus.

Ordering System: Customers can create orders and track their status.

Reviews: A feedback system for restaurants.

Technical Stack

Framework: Spring Boot 3.x




Database: PostgreSQL



ORM: Spring Data JPA with Hibernate




Migration: Liquibase



Mapping: MapStruct for Entity-DTO conversion



Testing: JUnit 5 and Mockito



Tools: Docker & Docker Compose


Architecture
The application follows a layered architecture to keep the code clean and maintainable:



Controllers: Handle REST requests. No business logic here.



Services: Contain all the business logic and unit tests.



Repositories: Manage database operations.


DTOs: Data Transfer Objects are used for all API requests and responses. We never return entities directly.



Mappers: Automatically convert entities to DTOs using MapStruct.


How to Run the Project
1. Prerequisites
   Docker and Docker Compose installed.

Java 17 or higher (if running without Docker).

2. Launch with Docker
   Clone the repository.

Open the terminal in the project root folder.

Run the following command:

Bash

docker-compose up --build
This will start the PostgreSQL database and the Spring Boot application together.

3. Database Migrations
   Tables are created automatically via Liquibase once the app starts. You can check the migration history in the databasechangelog table.


Testing
To run the unit tests and ensure everything is working correctly:


Bash

./gradlew test
API Documentation
I have included a Postman Collection in the root directory (file: FoodDeliveryService.postman_collection.json). It contains:


Authentication requests.

CRUD operations for all 5+ entities.


Example Request and Response DTOs.