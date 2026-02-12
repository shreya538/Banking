--Banking Transaction System

This is a console-based Banking Application developed using Core Java and JDBC (Oracle Database).

--The project allows:
-Checking account balance
- Transferring money between two accounts
- Validating account numbers
- Handling insufficient balance using custom exception
  
This project follows a layered architecture:
-Bean Layer
-DAO Layer
-Service Layer
-Utility Layer
-Main Class

-- Technologies Used

-Java (JDK 21)
-JDBC
-Oracle Database (XE)
-OJDBC Driver
-Eclipse IDE

-- Project Structure
com.wipro.bank
│
├── bean
│   └── TransferBean.java
│
├── dao
│   └── BankDAO.java
│
├── service
│   └── BankService.java
│
├── util
│   ├── DBUtil.java
│   └── InsufficientFundsException.java
│
└── main
    └── BankMain.java
