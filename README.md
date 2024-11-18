This is the backend service for the Mini Banking Application. It is built using Spring Boot and provides RESTful APIs for managing users, accounts, and transactions. 
The backend includes JWT-based authentication and uses a PostgreSQL database for data storage.

Features
User Management:
Register, login, and manage user information.
Account Management:
Create, update, delete, and retrieve account details.
Filter accounts by number or name.
Transaction Management:
Initiate money transfers between accounts.
Retrieve transaction history for a specific account.
Authentication:
Secure endpoints with JWT tokens.
API Documentation:
Swagger integration for API exploration and testing.

Tools and Technologies
Spring Boot: Backend framework.
PostgreSQL: Database management system.
JWT (JSON Web Token): For authentication.
Swagger: API documentation and testing.
ModelMapper: For object mapping.
Lombok: Reduces boilerplate code for Java models.

Prerequisites
Java: Version 17 or above.
Maven: Build tool for the project.
PostgreSQL: Version 17.

API Endpoints
User Management
Register User: POST /api/users/register
Login User: POST /api/users/login
Account Management
Create Account: POST /api/accounts
Search Accounts: GET /api/accounts
Query parameters: number, name
Update Account: PUT /api/accounts/{id}
Delete Account: DELETE /api/accounts/{id}
View Account Details: GET /api/accounts/{id}
Transaction Management
Initiate Transfer: POST /api/transactions/transfer
View Transaction History: GET /api/transactions/account/{accountId}
