# Xindus Assignment: Wishlist Management Backend
Welcome to the Xindus Assignment repository! This backend application serves as the backend solution for managing wishlists in an e-commerce platform. The application is built using Spring Boot, Spring Security with JWT authentication, and Spring Data JPA.

## Features
- User Authentication: Secure signup and login functionality using Spring Security with JWT authentication.
- Wishlist Management: RESTful API endpoints for managing user wishlists, including creation and deletion of wishlist items.
- Database Integration: Integration with a relational database using Spring Data JPA for storing user information and wishlist items.

## Setup and Usage

### Prerequisites
- Java Development Kit (JDK) version 8 or higher
- Maven
 
### Installation
Step1:- Clone the repository to your local machine:
- git clone https://github.com/moinkhan07/Xindus_Assignment.git

Step2:- Navigate to the project directory:
- cd XindusWishlistManagement

Step3:- Build the project using Maven:
- mvn clean install

### Configuration
Step1:- Database Configuration:
- Open the src/main/resources/application.properties file.
- Configure your database connection settings:
  - spring.datasource.url=jdbc:mysql://localhost:3306/wishlistmanagement
  - spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
  - spring.datasource.username=root
  - spring.datasource.password=root
  
Step2:- Spring Security Configuration:
- Customize security settings, such as JWT token expiration time and secret key, in the SecurityConfig.java file.

### Running the Application
1. Run the application using Maven:
- mvn spring-boot:run

2. The application will start on the default port 8080.

### API Usage
1. Sign Up:
- Open Postman or any HTTP client application.
- Send a POST request to http://localhost:8080/auth/register with JSON body containing user details:
  - {
    - "firstName": "example_firstname",
    - "lastName": "example_lastname",
    - "email": "example_email",
    - "password": "example_password"
  - }

2. Login:
- Send a POST request to http://localhost:8080/auth/login with JSON body containing user credentials:
  - {
    - "email": "example_email",
    - "password": "example_password"
   - }

#### Note: Save the JWT token received in the response.

3. Accessing Other APIs:
- To access other APIs requiring authentication, include the JWT token in the Authorization header of your requests:
   - In Postman, set the Authorization type to "Bearer Token" and paste the JWT token obtained during login.
   - Use the following endpoints for other API functionalities:
     - Wishlist Management: http://localhost:8080/api/wishlists
     - Products: http://localhost:8080/api/products


Thank you for exploring the Xindus Assignment backend repository! We hope this documentation provides clear guidance on setting up, configuring, and using the application.
