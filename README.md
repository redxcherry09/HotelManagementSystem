🏧 Bank Management & ATM System (Java + Swing + MySQL)
📌 Project Overview

The Bank Management System is a professional desktop application designed to digitalize banking workflows. This project manages the complete user lifecycle—from a multi-stage account registration process to secure ATM transactions—all powered by a robust Graphical User Interface (GUI).

🚀 Features

🔐 Secure ATM Authentication – Entry secured via 16-digit Card Number and 4-digit PIN verification.
📝 3-Step Registration – A modular onboarding process for capturing personal, professional (PAN/Aadhar), and account service details.
💳 ATM Operations – Functional Cash Deposit and Withdrawal modules with real-time balance validation.
⚡ Fast Cash – Provides a quick-access interface for withdrawing standard denominations instantly.
🔑 PIN Management – A secure utility to update and sync the user's security PIN across database records.
📊 Transaction History – Generates real-time transaction logs and mini-statements for user transparency.

🛠 Technologies Used

Java (Swing & AWT) – Used for the Desktop GUI and event handling.

MySQL – Used as the relational database for persistent data storage.

JDBC – Facilitates the connection between the Java application and the SQL backend.

NetBeans / IntelliJ IDEA – The primary IDEs used for development.

🧩 Project Structure (16 Components)

login.java – The secure entry point (Card No & PIN input).

Signup.java, Signup2.java, Signup3.java – The multi-frame registration pipeline.

main_Class.java – The central navigation dashboard (ATM Menu).

Deposit.java & Withdrawl.java – Core financial transaction logic.

FastCash.java – Specialized quick-withdrawal module.

Pin.java – Secure credential management utility.

mini.java – Module for fetching and displaying transaction history.

Conn.java – Centralized database connection configuration.

Utility Scripts – java1.java, java2.java, ruby.java (Database testing and setup).

🗄 Database Setup

Create a MySQL database named bankSystem.

Configure the following tables: login (Credentials), bank (Transaction Ledger), and signup / signuptwo / signupthree (User Profiles).

▶️ How to Run

Import the project into your IDE (NetBeans or IntelliJ).

Add mysql-connector-java.jar and jcalendar.jar to your project libraries.

Update your MySQL credentials in the Conn.java file.

Run the login.java file to start the application.

💡 Key Functionalities

💳 Dynamic Balance Calculation
The system scans the transaction ledger to calculate the current balance in real-time, preventing overdrafts and ensuring accurate financial reporting.

🛠 Automated Credential Generation
Upon successful registration, the system algorithmically generates a unique 16-digit Card Number and a 4-digit PIN for the user.

🔗 Data Integrity
All three signup stages are linked via a unique Form Number to ensure data consistency across the database.

🎯 Future Enhancements

📄 PDF Export – Ability to export mini-statements as PDF documents.
📱 OTP Verification – Implementing Two-Factor Authentication for enhanced security.
🎨 UI Optimization – Implementation of a modern Dark Mode interface.

👨‍💻 Author

Name: Ruby Singh

Project Type: Academic / Full Stack Portfolio Project

Technology Stack: Java Swing + MySQL + JDBC

⭐ Conclusion

This Bank Management System is a comprehensive solution simulating real-world ATM scenarios. It demonstrates the practical application of database integration, complex business logic, and modular GUI design in Java.











This Bank Management System is a comprehensive solution simulating real-world ATM scenarios. It demonstrates the practical application of database integration, complex business logic, and modular GUI design in Java.
