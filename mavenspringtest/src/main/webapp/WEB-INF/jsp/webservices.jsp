<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>

<style>
#tapi {
  font-family: Arial, Helvetica, sans-serif;
  border-collapse: collapse;
  width: 100%;
  margin-top:25px;
}

#tapi td, #customers th {
  border: 1px solid #ddd;
  padding: 5px;
}

#tapi tr:nth-child(even){background-color: #f2f2f2;}

#tapi tr:hover {background-color: #ddd;}

#tapi th {
  padding-top: 8px;
  padding-bottom: 8px;
  text-align: left;
  background-color: #4CAF50;
  color: white;
}
</style>


<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<form id="forma" method="Post" action="webservices">
		<label for="fname">Insert your API request</label>
    	<input type="text" id="apirequest" name="apirequest" placeholder="Your request..">
		<!--<table>
			<tr>
				<th>Insert your API request (Default is GET)</th>
			</tr>
			<tr>
				<td><input type="text" id="apirequest" name="apirequest" size=30 />	</td>
			</tr>
		</table> -->
	</form>
	
	<table id="tapi"> 
	<tr>
		<th>Available Calls</th>
		<th>Returning Data </th>
	</tr>
	<tr>
		<td>location</td>
		<td> Returns all locations</td>
	</tr>
	<tr>
		<td>departments</td>
		<td>Returns all departments</td>
	</tr>
	<tr>
		<td>departments/{Locid}</td>
		<td>Returns all departments in Location with Locid</td>
	</tr>
	<tr>
		<td>employees/{deptID}</td>
		<td>Returns all Employees working at department with deptId </td>
	</tr>
	<tr>
		<td>employeesSearch?fname={FirstName}&lname={LastName}</td>
		<td> Returns all Employees who have first name =FirstnName and last name = LastName</td>
	</tr>
	<tr>
		<td>employeeById?id={empid}</td>
		<td>Returns the employee with empid</td>
	</tr>
	</table>
	
	
	
	
	
	
	
	<%
    String result=(String) request.getAttribute("result");
	if (result !=null) {
	%>
	<h3>API call result in XML</h3>
	<textarea rows="20" cols="40" style="border:none;">
	<c:out value="${result}" />
	</textarea>

	<%  
	}
	%>


</body>
</html>