# HealthcareSystem
# E-Healthcare & Doctor Appointment System

A desktop management application developed as a 2nd Year Computer Studies programming project. This system is designed to streamline clinic workflows, manage patient and doctor records, and handle appointment scheduling through a clean user interface.

---

## 🛠️ Tech Stack & Technologies Used
* **Programming Language**: Java (JDK 8 or higher)
* **GUI Framework**: Java Swing (NetBeans GUI Builder)
* **Database**: MySQL Relational Database
* **Database Connector**: JDBC Driver (`mysql-connector-j`)
* **Project Management**: Apache Maven

---

## 🌟 Core Features
* **Admin Login Authentication**: A secure login screen (`LoginFrame.java`) that verifies credentials using the MySQL `Users` table before granting access.
* **Unified Tabbed Interface**: Built using `JTabbedPane` inside `MainDashboard.java` to manage all operations in one window without opening multiple screens:
  1. **Manage Doctors Tab**: Add and view doctor profiles and specializations.
  2. **Manage Patients Tab**: Input and store patient information (Name, Age, Gender, Phone).
  3. **Book Appointments Tab**: Schedule appointments between patients and available doctors.
* **Real-time JTable Updates**: Data grid rows refresh instantly from the MySQL database whenever a new record is added.

---

## 📁 Key Source Files & Structural Roles
* `DBConnection.java` / `DatabaseConnector.java`: Establishes the connection link between Java Swing and the local MySQL server.
* `Person.java`: An abstract superclass that implements core OOP principles like Abstraction and Encapsulation.
* `Patient.java`: A subclass that inherits from `Person.java` to handle patient-specific attributes.
* `Doctor.java`: A subclass that ensures clean data separation and maps doctor scheduling constraints.
* `LoginFrame.java` & `.form`: The initial graphical interface for administrative authentication.
* `MainDashboard.java` & `.form`: The central hub holding the tabbed management panel.

---

## 💻 How to Run the Project Locally

1. **Clone the Repository**
```bash
   git clone [https://github.com/AdithRassdeen/HealthcareSystem.git](https://github.com/AdithRassdeen/HealthcareSystem.git)
