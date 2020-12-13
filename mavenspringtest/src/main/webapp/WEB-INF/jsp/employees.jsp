<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.List"%>

<!DOCTYPE html>
<html>
<style>

.dropbtn {
  background-color: #4CAF50;
  color: white;
  padding: 16px;
  font-size: 16px;
  border: none;
}

/* The container <div> - needed to position the dropdown content */
.dropdown {
  position: relative;
  display: inline-block;
}

/* Dropdown Content (Hidden by Default) */
.dropdown-content {
  display: none;
  position: absolute;
  background-color: #f1f1f1;
  min-width: 160px;
  box-shadow: 0px 8px 16px 0px rgba(0,0,0,0.2);
  z-index: 1;
}

/* Links inside the dropdown */
.dropdown-content a {
  color: black;
  padding: 12px 18px;
  text-decoration: none;
  display: block;
}

.dropdown-content table{
  color: black;
  display: block;
 
}
.dropdown-content table tr{
	width: 200px;
	height:35px; 
}

.padding-table-columns td
{
    padding:0 200px 0 0; /* Only right padding*/
}



/* Change color of dropdown links on hover */
.dropdown-content a:hover {background-color: #ddd;}

/* Show the dropdown menu on hover */
.dropdown:hover .dropdown-content {display: block;}

/* Change the background color of the dropdown button when the dropdown content is shown */
.dropdown:hover .dropbtn {background-color: #3e8e41;}





</style>
<head><%@ page isELIgnored="false" %>
<meta charset="ISO-8859-1">
<title>GOT HERE</title>
</head>
<body> 
<h1>List Of Employees</h1>

<form  method="Get" action="/location/${locid}">
    	<a>
 		<button name="Back">Back To Departments</button>
   		</a>
</form>
<form  method="Get" action="/location/back">
    	<a>
 		<button name="Back">Back To Locations</button>
   		</a>
</form>

	
<table style="width:1000px; border: 1px solid black">
	<tr>
		<th align="center">Employee Id</th>
		<th align= "center">First Name</th>
		<th align= "center">Last Name</th>
	</tr>
    <c:forEach items="${listEmployees}" var="employee">
        <tr>
        	<td align="center"><c:out value="${employee.getEmpid()}"/></td>
            <td align="center"><c:out value="${employee.getFirstName()}"/></td>
            <td align="center"><c:out value="${employee.getLastName()}"/></td>  
			<td align="center">
				<div class="dropdown">
  					<button class="dropbtn">Employee Info</button>
  					<div class="dropdown-content"> 
  						<table>
  							<tr>
  								<td align="center">Department Id:</td>
  								<td> <c:out value="${employee.getDeptidd()}"/></td>
  							</tr>
  							<tr>
  								<td align="center">Job:</td>
  								<td> <c:out value="${employee.getJob()}"/></td>
  							</tr>
  							<tr>
  								<td align="center">Manager: </td>
  								<td> <c:out value="${employee.getMngid()}"/></td>
  							</tr>
  							<tr>
  								<td align="center">Salary:</td>
  								<td> <c:out value="${employee.getSalary()}"/></td>
  							</tr>
  							<tr>
  								<td align="center">Commission:</td>
  								<td> <c:out value="${employee.getComm()}"/></td>
  							</tr>
  							<tr>
  								<td align="center">Hire Date:</td>
  								<td > <c:out value="${employee.getHireDate()}"/></td>
  							</tr>
  						</table>
  					</div>
				</div>
			</td>
            
        </tr>
    </c:forEach>
</table>
</body>
</html>