# Train Ticket Inquiry System

This project, **Train-Ticket-Enquiry-System**, is designed using the **MVC (Model-View-Controller)** architecture. It simulates a real-world train booking application, utilizing **Hibernate ORM** for database management, **Servlets** and **JSP** for request handling, and various other technologies for a seamless user experience.

## Key Features
- **MVC Architecture**: Clear separation between Model, View, and Controller layers.
- **JSP & Servlet Integration**: JSP for the UI, with servlets managing back-end logic.
- **Hibernate ORM**: Maps Java objects to database tables, facilitating database interactions.
- **MySQL Database**: Stores train schedules, booking data, and user info.
- **HTML & CSS**: Modern, responsive interface design.
- **Session Management**: User login sessions are managed securely.
- **Maven**: Manages project dependencies and builds.
- **Tomcat Server**: Deployed on Apache Tomcat for local development and testing.

## Prerequisites
- **Java Development Kit (JDK)** 8 or above
- **Apache Tomcat Server**
- **MySQL Database**
- **Maven**

## Setup & Installation
1. **Clone the Repository**:
   ```bash
   git clone https://github.com/Venumadhavmule/Train-Ticket-Enquiry-System.git
   ```
2. **Import the Project**:
   - Open **Eclipse** IDE and import the cloned project as a Maven project.

3. **Database Setup**:
   - Set up a MySQL database.
   - Update the database configuration in the `hibernate.cfg.xml` file. Replace `your_database_name` and `your_password` as needed:

     ```xml
     <property name="hibernate.connection.url">jdbc:mysql://localhost:3306/your_database_name</property>
     <property name="hibernate.connection.username">root</property>
     <property name="hibernate.connection.password">your_password</property>
     ```

4. **Configure Tomcat in Eclipse**:
   - Go to **Servers** in Eclipse, add a new **Apache Tomcat** server, and link your project to it.

5. **Build the Project**:
   - Right-click on the project, select **Run As** > **Maven Install**.

6. **Run the Application**:
   - Start the Tomcat server in Eclipse.
   - Access the application at `http://localhost:8080/Train-Ticket-Enquiry-System`.

## Usage
After setting up, open the application in your browser. You can log in to start booking train tickets and exploring schedules.
