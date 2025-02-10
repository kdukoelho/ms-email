
<h1 align="center"> Email Microservice </h1>

![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white)
![Spring](https://img.shields.io/badge/spring-%236DB33F.svg?style=for-the-badge&logo=spring&logoColor=white)
</h1>

<p align="center"> This application send an email when receive in the url  (by default set as http://localhost:8080/send-email) a json file containing the email data (which's includes all yours respectfully fields).
</p>

##  💻  Technologies
The application uses the following frameworks:

- Spring Boot;
- Java Persistence API (JPA);
- Lombok.

## 🚀 Setting up
### Prerequisites
1. You need to install MySQL and open a connection at port 3306 on your localhost, if everything works fines, the application will create a database called "ms-email";
2. Maven as path variable, or you can run the application directly on IDE;
3. Put in the application.properties your email and password to your smtp.

### Cloning
1. Clone this repository on your machine:
```bash
git clone https://github.com/kdukoelho/ms-email
```
2. Install the project dependencies:
```bash
mvn clean install
```
3. Run the application:
```bash
mvn spring-boot:run
```

## 📍Endpoints

| route               | description                                          
|----------------------|-----------------------------------------------------
| <kbd>POST /send-email</kbd>     | Sends the email
<h3 id="get-auth-detail">

**REQUEST**
```json
{
  "ownerRef": "Carlos",
  "emailFrom": "2@gmail.com",
  "emailTo": "1@gmail.com",
  "subject": "Hello",
  "body": "Hello"
}
```
**RESPONSE**
```json
{
  "emailId": "1",
  "ownerRef": "Carlos",
  "emailFrom": "2@gmail.com",
  "emailTo": "1@gmail.com",
  "subject": "Hello",
  "body": "Hello"
  "sentAt": "2024-10-20T14:30:55.008",
  "emailStatus": "SENT",
}
```
