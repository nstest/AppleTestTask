# AppleTestTask

1. Clone the repository
2. Download and install Apache Tomcat server. This application was developed using Tomcat 8.0
3. Download and install MySQL 
4. Create a database 'testtask' with table 'customer' as below

+------------+-------------+------+-----+---------+-------+

| Field      | Type        | Null | Key | Default | Extra |

+------------+-------------+------+-----+---------+-------+

| first_name | varchar(30) | NO   |     | NULL    |       |

| last_name  | varchar(30) | NO   |     | NULL    |       |

| birth_date | date        | NO   |     | NULL    |       |

| phone      | varchar(20) | NO   |     | NULL    |       |

| email      | varchar(60) | NO   |     | NULL    |       |

+------------+-------------+------+-----+---------+-------+

Problem Description:
This is a simple web application that keeps customer information(FirstName, LastName, Date of Birth, Phone Number, Email). FirstName, LastName, Date of Birth are mandatory. Can't have 2 customers with the same first, last names and DOB. Supports a simple merge logic. If a customer being added has an existing record with the same first, last names and DOB, then the existing record is updated with the new phone number and email. The fields are updated with the new values only if the original ones are empty.

What has been done

i. Add a new customer
     If customer already exists in the database then phone and email will be updated. If customer do not exist then details will be added to the DB.
     
ii. Update existing customer
    Customer details(phone and email) will be updated if the customer exist in the DB. If not a message "Customer do not exist in the database" will be displayed
    
iii. Remove a customer
    Customer will be removed from the database if available else a proper message will be displayed.
    
iv. Display all customers

Please note that some of the basic client side validations are not done in the application. For ex: No validation on Date of Birth, Phone Number fields. 

This is Dynamic Web Project which makes use of JSP, Servlet, MySQL. Some of the advantages of using these technologies are listed below
All the major web servers and application servers support servlets, so a servlet-based solution doesn't tie you to one specific vendor. 
Servlets are developed in Java and can therefore take advantage of all other Java technologies, such as JDBC for database access, JNDI for directory access, RMI for remote resource access, etc.
Servlets are server side components, so it inherits the security provided by the web server. Servlets are also benefited with Java Security Manager.

