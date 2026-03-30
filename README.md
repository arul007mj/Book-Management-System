# Book-Management-System
A full-stack Java-based web application that allows users to manage books with basic CRUD operations and authentication features.

This project demonstrates backend development using Servlets, JSP, and JDBC, along with a simple frontend using HTML & CSS.

🚀 Features
🔐 User Authentication
Sign up with OTP verification
Login functionality
📖 Book Management
Add new books
Retrieve book details
Update existing records
Delete books
🌐 Web Interface
Clean HTML/CSS UI
Form-based interactions
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
git clone https://github.com/your-username/book-management-system.git
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
   



 
