# Small Api Bank

> Small API Rest for a bank.

[![](https://img.shields.io/badge/linkedin-Sergio%20Contreras-blue)](https://www.linkedin.com/in/sergiocontrerasmartin/)

## Contents

- API Rest with Spring Boot
- Hexagonal Architecture
- Domain-Driven Design
- Data Base in memory H2

---

## Project structure

    src
    ├── adapter
    │   └── rest
    │       └── Controllers
    ├── config
    ├── domain
    │   ├── dto
    │   ├── model
    │   └── service
    └── port
        ├── Service interfaces
        └── Repositories

## Services 
| Type | Path | Description |
|---------|------|--------|
| POST       | /signup    |  Enroll user in Bank system     |
|  POST      | /authenticate    | Obtain JWT. The client will then send this JWT with its request to a REST API.       
|   POST     | /wallet |   Create a wallet for a user     ||
| GET       | /wallet/{address}|   Get wallet balance     ||
|  POST      | /deposit|   Make a deposit in user wallet     |
|  POST      | /transfer|   Make a transfer between wallets    |


### Building and running

To build the application run this command in the project directory:
```
mvn package
```
To start the application run this command:
```
mvn spring-boot:run
```
The endpoints can be accessed on:
```
http://localhost:8080/
