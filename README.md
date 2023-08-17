# Social Media API

The Social Media API is a RESTful web service that provides functionalities for users to register, log in, create posts, communicate, subscribe to other users, and receive their activity feed.

## Table of Contents

* Features
* Technologies
* Getting Started
* API Endpoints
* Authentication
* Documentation

## Features

1. Authentication and Authorization
   * Users can register by providing their username, email, and password.
   * Users can log in with their credentials.
   * Passwords are securely hashed and JWT is used for authentication.
2. Post Management
   * Users can create new posts with text content and optional images.
   * Users can view posts from other users.
   * Users can update and delete their own posts.
3. User Interaction
   * Users can send friend requests to other users. Once accepted, they become friends. 
   * Users can send messages to their friends (chat functionality not included).
4. Subscriptions and Activity Feed
   * Users' activity feeds display the latest posts from the users they are subscribed to.
   * Activity feeds support pagination and sorting by post creation time.
5. Error Handling
   * Clear and informative error messages are returned for invalid requests or server issues.
   * Data input is validated, and helpful error messages are returned for incorrect formats.

## Technologies

* Programming Language: Java
* Framework: Spring Boot
* Database: MySQL
* Authentication and Authorization: Spring Security
* Documentation: Swagger

## Getting Started
1. Clone this repository **'git clone https://github.com/edilk/Social-Media_API.git'**
2. Configure your database settings in **application.properties**
3. Build and run the project using your preferred IDE or with Maven: **'mvn spring-boot:run'**
4. The API will be accessible at **'http://localhost:8080'**

## API Endpoints 
* **POST /api/register**: Register a new user
* **POST /api/login**: Log in an existing user
* **POST /api/posts**: Create new post
* **GET /api/posts/{postId}**: Get details of a specific post

## Authentication
* JWT (JSON Web Tokens) are used for authentication and authorization.
* Obtain a JWT token by logging in. Include this token in the Authorization header for protected endpoints.

## Documentation
API documentation is available using Swagger. Access it at **'http://localhost:8080/swagger-UI.html'**