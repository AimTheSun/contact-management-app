## IN PROGRESS

# Contact Manager 

A simple **full-stack** contact management system built with **Spring Boot** for the backend and **React** for the frontend. This application allows users to manage their contacts, storing and retrieving contact information from a **MySQL database**, with a user-friendly front-end interface.

## Features

- Create, read, update, and delete contacts.
- Store contact information such as name, email, phone number, and address.
- RESTful API for integration with other systems.
- A modern React-based front-end for interacting with the backend.

## Tech Stack

- **Backend**: Java, Spring Boot
- **Frontend**: React, JavaScript, Html, Css
- **Database**: MySQL
- **Persistence**: JPA, Hibernate
- **Build Tool**: Maven

## Getting Started

### Prerequisites

- Java 17 or later (for backend)
- MySQL Server
- Maven (for backend)
- Node.js and npm (for frontend)

### Installation

## Backend Setup

1. Clone the repository:

   ```bash
   git clone https://github.com/AimTheSun/contact-management-app.git
   ```

2. Navigate to the backend project folder:

   ```bash
   cd contact-manager/backend
   ```

3. Configure your MySQL database connection in `src/main/resources/application.properties`:

   ```properties
   spring.datasource.url=jdbc:mysql://localhost:3306/contacts_db
   spring.datasource.username=<your-username>
   spring.datasource.password=<your-password>
   ```

4. Build the backend project using Maven:

   ```bash
   mvn clean install
   ```

5. Run the backend application:

   ```bash
   mvn spring-boot:run
   ```

   The backend will be running on `http://localhost:8080`.

## Frontend Setup

1. Navigate to the frontend project folder:

   ```bash
   cd frontend
   ```

2. Install dependencies using npm:

   ```bash
   npm install
   ```

3. Run the frontend application:

   ```bash
   npm start
   ```

   The frontend will be running on `http://localhost:3000`.

## API Endpoints

- `GET /contacts` - Retrieve all contacts
- `POST /contacts` - Create a new contact
- `GET /contacts/{id}` - Retrieve a contact by ID
- `PUT /contacts/{id}` - Update a contact by ID
- `DELETE /contacts/{id}` - Delete a contact by ID

## Project Status

This project is currently under development and is expected to be finished by early February. New features and improvements are being added regularly, so feel free to check back for updates.
