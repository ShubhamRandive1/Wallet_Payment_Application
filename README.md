# Wallet_Payment_Application

- An Collabrative Project Consisting Of the 5 Developer Depicting the implementation of the payemnt wallet online transaction platform
- An developement of RESTful API for an Online Payment Wallet application. This API performs all the fundamental CRUD operations of any Online Wallet Banking platform with user validation at every step.
<br>
# ER Diagram
The following Diagram depicts the flow of our Entity Relation Diagram to simplify the work flow.
<br>
<br>
![WhatsApp Image 2022-09-27 at 9 52 51 PM](https://user-images.githubusercontent.com/57911117/192693251-f4deedb6-d884-404c-9529-3970e25a8a5f.jpeg)

<br>
<br>

#Team Member Roles And Responsibilities
<br>
<br>

1) Bivek Rai - Team Lead, Responsible for creating and implementing the ER diagram and flow of the project.

2) Yogesh Saini - Responsible for creating the Repository while making sure of proper implementation Of Controllers

3) Shubham Randive - Responsible For handeling the Exceptions and Creating the Service Layer.

4) Bhanu Prathap Goud - Responsible for The frontent Layer while implementing proper RESTful API naming Conventions.

5) Partha Sarathi - Responsible for Creating the login and logout Session layer with proper validation.

<br>
<br>

#Teach Stacks Implemented
<br>
<br>
- Java
- Spring
- Spring Boot JPA
- Hibernate
- MySQL
- Swagger
- Lambok
- AdvanceJavaScript(ES6+)
- BootStrap 5
- CSS3

<br>
<br>



# Modules

- Login Logout User authentication
- Wallet
- BankAccount
- BeneficiaryDetails
- BillPayment
- Transaction

<br>
<br>

#Features

<br>
<hr>

- User Login authrntication
- validation for the account number
- validation for the current user and user identification
- RESTful API with CURD operations
- Functional Front End For better user experience

<br>
<br>

#Installation & Run

<br>
<br>

```
#changing the server port
server.port=8888

#db specific properties
spring.datasource.url=jdbc:mysql://localhost:3306/sb201db
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
spring.datasource.username=root
spring.datasource.password=root

#ORM s/w specific properties
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true

spring.mvc.pathmatch.matching-strategy = ANT_PATH_MATCHER

```

<br>
<br>

#API Root Endpoint
<br>
<br>
```
https://localhost:8888/
```

```
https://localhost:8888/swagger-ui/#
```
<br>
<br>

