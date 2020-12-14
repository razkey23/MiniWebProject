# MiniWebProject
## A. Project Overview
This project is a basic CRUD Java-Spring Boot Web Application. The following technologies were used to develop this maven project

### Project Specifics
We have these specific basic models
#### Models
1. Employees

|Attribute|Description|Properties|
|-|-|-|
|Empid|Employee's ID|Primary Key|
|Last Name| Employee's Last Name||
|First Name|Employee's First Name||
|Job|Employee's Job||
|Mngid|Employee's Manager's ID|Ref. Employee.empid|
|Hiredate| Employee's Hire date||
|Salary|Employee's yearly salary||
|Comm|Employee's yearly Commission||
|Deptid|Employee's Department's ID|Ref. Dept.deptid|

2. Department

|Attribute|Description|Properties|
|-|-|-|
|Deptid| Department's ID|Primary Key|
|DNAME| Department's Name||
|LocId|Department's Location's ID|Ref. Locations.locId|

3. Dept. Locations

|Attribute|Description|Properties|
|-|-|-|
|LocId|Dept. Location's ID|Primary Key|
|Locname| Dept. Location's name||

#### Functionality Demanded

* Display all the Department locations
* Display Departments with a specific LocID
* Display Employees working in specific Department
* Display Employee's Info

All these had to be displayed both in a Web Interface (such as .jsp) and as REST API response in xml format.

### Tools Used
In order to implement the services listed above I used Eclipse IDE in order to create a Spring boot application.

Tools Used:
1. mySQL database
2. Jpa-Hibernate (Database Connection)
3. JSP/Web Servlet 


![Flow Architecture](https://static.javatpoint.com/springboot/images/spring-boot-architecture2.png)
 
 ## B. Installation Guide
 
 In order to install and test the project,all you need is to follow these steps.
 1. Download the above code (mavenspringtest)
 2. Import files into Eclipse
 3. Create a database named demo (No need to create tables) 
 4. Go to mavenspringtest/src/main/resources/application.properties and change spring.datasource.url,
 spring.datasource.username,spring.datasource.password so that you can connect to the database you created
 5. Run mavenspringtest/src/main/java/com/mavespringtest/MavenspringtestApplication.java  as Java Application 
 
 Project now is probably up and running. The tables employees ,deptlocation and department are created in your database. You can manually populate them with data
 via mySQL workbench or via command Line.
 
 ## C. Use-cases
 Assuming that the project is up and running you can do the following
 
 ### Web Interface
 You can visit localhost:8080/location (localhost:8080 could be something different for you depending which  port is utilized by apache tomcat) and navigate through
 all the locations listed in your database. You can see all the departments belonging to a specific location by pressing the button, and then you can see all the employees
 working at a specific department.Finally ,by hovering over the text box "employee's name" info you can see all the info about employees
 
 ### API Endpoints
 API endpoints implemented in mavenspringtest/src/main/java/com/mavespringtest/controller/ApiController.java  
 
 |API Endpoint|Response|
 |-|-|
 |/location|All the locations in database|
 |/departments|All the location|
 |/departments/{locId}|All the departments in Location with LocId|
 |/employees/{deptid}|All the employees working at Department with deptid|
 |/employeesSearch?fName={First Name}&lname={Last Name}| All the employees who have First Name and Last Name|
 |/employeeById?id={Empid}| Employee who has empid|
 
 
 You can access these endpoints either via external Program such as Postman calling the endpoints like this  e.g.  localhost:8080/api/location 
 Or you can use the API Client which is built in the App. 
 
 ### Built-in API Client
 
 You can go to localhost:8080/webservices , there you are presented with an interface similar to postman. You can send the request as explained in the webservices page.
 * Provided that you sent a valid API request * , a text area will pop presenting you with the xml-response from the API endpoints. In case you make a mistake in the request
 you are redirected to an error page ,and you need to get back to localhost:8080/webservices manually to resend a API request.
  API client is implemented in files : 
  * [Web Servlet](https://github.com/razkey23/MiniWebProject/blob/master/mavenspringtest/src/main/java/com/mavespringtest/controller/WebServicesClientController.java)
  * [API Client Interface] (https://github.com/razkey23/MiniWebProject/blob/master/mavenspringtest/src/main/webapp/WEB-INF/jsp/webservices.jsp)
 
 
 




