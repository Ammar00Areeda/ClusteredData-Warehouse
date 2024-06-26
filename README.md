# ClusteredData-Warehouse
The ClusteredData-Warehouse project is designed to manage and analyze foreign exchange (FX) deals for Bloomberg. This system collects and stores detailed information about FX transactions, ensuring data integrity and facilitating comprehensive analysis.

## Overview
The Warehouse project is a Java-based application that utilizes the Spring Boot framework and Maven for dependency management. It also uses Postgres for data management. The project includes various validators to ensure the integrity of the data being

## Software And Tools Required
1. Git [https://github.com/git-guides/install-git](#GIT)
2. Docker [https://docs.docker.com/engine/install/](#DOCKER)
3. java 21 [https://www.oracle.com/java/technologies/javase-jdk11-downloads.html](#JAVA)
4. Apache Maven [https://maven.apache.org/install.html](#MAVEN)
5. IDE (IntelliJ IDEA recommended) [https://www.jetbrains.com/help/idea/installation-guide.html](#IDE)

## Quickstart
1. Clone the repository
2. Open the project in your IDE: IntelliJ IDEA (recommended)
    * If you are using IntelliJ IDEA, make sure the IDE opens project as **Maven** and recognizes the project as a Spring Boot project .
3. Make sure you are in the `ClusteredData-Warehouse` directory
4. Run Docker Compose to start the Postgres database [Docker](#docker)
5. Configure the database connection in `application.properties` file (check the [Database](#database) section below for more info)
6. Run the project (by running the `main` method in `WarehouseApplication.java`)
7. Open http://localhost:8080/ in your browser!

### Database

Postgres can be used as the database for this project. The database connection can be configured in the `application.yml` file, with the appropriate values for the following properties:
- ![image](src/main/resources/images/resources-project-structure.png)
```properties
#Main Database Configuration
#application-dev.yml
spring:
    datasource:
        driver-class-name: org.postgresql.Driver
        url: jdbc:postgresql://${DB_HOST:localhost}:${DB_PORT:5432}/${DB_NAME:fx}
        username: ${DB_USERNAME:fx}
jpa:
    database-platform: org.hibernate.dialect.PostgreSQLDialect
    hibernate:
        ddl-auto: none
```
```properties
#Test Database Configuration
#application-test.yml
spring:
    datasource:
        driver-class-name: org.postgresql.Driver
        url: jdbc:postgresql://${DB_HOST:localhost}:${DB_PORT:5432}/${DB_NAME:fx_test}
        username: ${DB_USERNAME:fx}
jpa:
    database-platform: org.hibernate.dialect.PostgreSQLDialect
    hibernate:
    ddl-auto: create-drop
```
# Workflow
- ![image](src/main/resources/images/project-structure.png)
### Controller
   Post API is used to create a new deal. The controller validates the deal and sends it to the service layer.
### Service
The service layer validates the deal and sends it to the repository layer.
### Repository
The repository layer stores the deal in the database.
### Validator
The validator layer validates the deal before it is stored in the database.
### Model
The model layer defines the structure of the deal.
### Exception
The exception layer handles exceptions that occur during the validation process.
### DTO
The DTO layer defines the data transfer objects used to transfer data between the layers.

### Create Deal request
- ![image](src/main/resources/images/postman.png)
# Docker
to run the project in docker you need to follow these steps:
1. Build the project using the following command:
```bash
mvn clean package -Dmaven.test.skip

```
2. To start the Docker Compose services for the Clustered Data Warehouse project, use the following command:

```bash
docker-compose -f docker-compose.yaml -p warehouse up -d
```
The project will be running on http://localhost:8090/


# Test
to run the tests you need to Run the following command:
- ![image](src/main/resources/images/test.png)
```bash
mvn test
```
# Troubleshooting
1. Connection Issues: Verify database credentials and network settings.
2. Dependency Errors: Check Maven dependencies and versions.
3. Docker Problems: Ensure Docker is properly installed and running.
4. IDE Configuration: Check project settings and configurations in your IDE.