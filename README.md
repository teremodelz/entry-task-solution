# Entry Task Solution - Product Catalog API

A REST API for product catalog management system built with Spring Boot and Liquibase.

## Tech Stack

- Java 21
- Spring Boot 3.x
- Liquibase
- PostgreSQL
- Maven

## Prerequisites

- Java 21 or higher
- Maven
- PostgreSQL

## Database Setup

1. Install PostgreSQL
2. Create a database:
```sql
CREATE DATABASE entry-task;
```

3. Update `src/main/resources/application.properties` with your credentials:
```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/entry-task
spring.datasource.username=postgres
spring.datasource.password=your_password
```
Please note that my basic port is different than the one set by PostGRE installation. Make sure you have everything accustomed to your settings before turning on the project.

## Running the Application
```bash
mvn spring-boot:run
```

The application will start on `http://localhost:8080`.
Liquibase will automatically create the required tables on startup.
Due to lack of informations whether we should update the whole object or whether we update only few parameters i've decided to create PATCH endpoint instead of PUT which allows us 
to update the whole object and only few things saving the rest of them like they were.

## Endpoints 
### Products

| Method | Endpoint | Description |
|--------|----------|-------------|
| GET | /api/products | Get all products |
| POST | /api/products | Create a product |
| PATCH | /api/products/{id} | Update a product |
| DELETE | /api/products/{id} | Delete a product |
