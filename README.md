---Banking Transaction System

This is a console-based Banking Application developed using Core Java and JDBC (Oracle Database).

--The project allows:
- Checking account balance
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
<img width="794" height="166" alt="image" src="https://github.com/user-attachments/assets/dec69a2d-f9b2-46ad-b140-44a394b720a7" />
<img width="655" height="122" alt="image" src="https://github.com/user-attachments/assets/9da20052-1105-490f-8815-55b271feaeef" />

