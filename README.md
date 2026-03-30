# Book-Management-System
A full-stack Java-based web application that allows users to manage books with basic CRUD operations and authentication features.

This project demonstrates backend development using Servlets, JSP, and JDBC, along with a simple frontend using HTML & CSS.

🚀 Features

🔐 User Authentication

 * User Signup
 * Login functionality
 *OTP verification

📖 Book Management

 *Add new books
 *View book records
 *Update book details
 *Delete books
 
🌐 Web Interface

 *Simple and functional UI using HTML & CSS



🛠️ Tech Stack

Backend
Java Servlets
JSP
JDBC
Maven

Frontend

HTML
CSS

Database

MySQL (or any JDBC-supported DB)

📂 Project Structure
Book_ManagementSystem/

│── src/main/java/

│   ├── Homepage/

│   │   ├── Insertservlet.java
│   │   ├── Updateservlet.java
│   │   ├── Deleteservlet.java
│   │   └── Retrivesrvlet.java

│   ├── Signin_signup/

│   │   ├── Signupservlet.java
│   │   ├── Signinservlet.java
│   │   └── Otpservlet.java
│

│── src/main/webapp/

│   ├── *.html
│   ├── *.css
│   └── index.jsp
│

│── pom.xml

⚙️ Setup Instructions

1. Clone Repository
git clone https://github.com/arul007mj/book-management-system.git
2. Import Project
Open Eclipse / IntelliJ
Import as Maven Project
3. Configure Database
Create a MySQL database
Update database credentials in your JDBC connection code
4. Build Project
mvn clean install
5. Run Application
Deploy the project on Apache Tomcat Server
   



 
